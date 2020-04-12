package ro.pub.cs.systems.eim.colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Colocviu1_245SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Intent toSend = new Intent();
        int sum = 0;
        if (intent != null && intent.getExtras().containsKey(Constants.INT_ARRAY)) {

            List<Integer> list = intent.getIntegerArrayListExtra(Constants.INT_ARRAY);
            for (int i = 0; i < list.size(); i ++) {
                sum += list.get(i);

            }
        }
        toSend.putExtra(Constants.SUM, sum);
        setResult(Constants.OK, toSend);
        finish();
    }
}
