package ro.pub.cs.systems.eim.colocviu1_245;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Colocviu1_245Service extends Service {
    private ProcessingThread thread = null;
    public Colocviu1_245Service() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int sum = intent.getIntExtra(Constants.SUM, -1);
        thread = new ProcessingThread(this, sum);
        thread.start();
        return Service.START_REDELIVER_INTENT;
    }

        @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        thread.interrupt();
    }
}
