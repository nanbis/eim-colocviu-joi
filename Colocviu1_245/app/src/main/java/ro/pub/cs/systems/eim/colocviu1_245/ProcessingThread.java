package ro.pub.cs.systems.eim.colocviu1_245;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

class ProcessingThread extends Thread {
    private final Context context;
    int sum;

    public ProcessingThread(Context context, int sum) {
        this.context = context;
        this.sum = sum;
    }

    @Override
    public void run() {
        try {
            sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendMessage(sum);
    }

    private void sendMessage(int sum) {
        Intent intent = new Intent();
        intent.setAction(Constants.BROADCAST);
        intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA,
                new Date(System.currentTimeMillis()) + " " + sum);
        Log.println(Log.ASSERT, "TAG: " , intent.getExtras().get(Constants.BROADCAST_RECEIVER_EXTRA).toString());
        context.sendBroadcast(intent);
    }
}
