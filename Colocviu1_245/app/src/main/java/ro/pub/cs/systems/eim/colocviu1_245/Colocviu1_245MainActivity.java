package ro.pub.cs.systems.eim.colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Colocviu1_245MainActivity extends AppCompatActivity {
    Button add_button, compute_button;
    GenericButtonListener genericButtonListener = new GenericButtonListener();
    EditText editText;
    TextView textView;
    ArrayList<Integer> list = new ArrayList<Integer>();
    private class GenericButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.add_button:
                    String num = editText.getText().toString();
                    if (!num.equals("")) {
                        if (textView.getText().toString().equals("")) {
                            textView.setText(num);
                        } else {
                            textView.setText(textView.getText().toString() + " + " + num);
                        }
                        list.add(Integer.valueOf(num));
                    }
                    break;
                case R.id.compute_button:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_245SecondaryActivity.class);
                    intent.putIntegerArrayListExtra(Constants.INT_ARRAY, list);
                    startActivityForResult(intent, Constants.SECONDARY_REQ);
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);

        add_button = (Button) findViewById(R.id.add_button);
        compute_button = (Button) findViewById(R.id.compute_button);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.next_term);

        textView.setText("");
        editText.setText("");

        add_button.setOnClickListener(genericButtonListener);
        compute_button.setOnClickListener(genericButtonListener);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case Constants.SECONDARY_REQ:
                if (resultCode == Constants.OK) {
                    if (intent != null && intent.getExtras().containsKey(Constants.SUM)) {
                        Toast.makeText(this, "Sum is: " + intent.getExtras().get(Constants.SUM),
                                Toast.LENGTH_SHORT).show();

                    }
                }
        }
    }
}
