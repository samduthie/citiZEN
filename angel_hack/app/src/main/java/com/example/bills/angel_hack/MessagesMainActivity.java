package com.example.bills.angel_hack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MessagesMainActivity extends AppCompatActivity {

    public MessagesMainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_main);

        TextView textView = (TextView) findViewById(R.id.editText2);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String[] test = {"one", "two", "three", "four"};
                int length = test.length;
                LinearLayout layout = new LinearLayout(getApplicationContext());
                setContentView(layout);
                layout.setOrientation(LinearLayout.HORIZONTAL);

                for(int i = 0; i<length; i++) {
                    TextView messages = new TextView(getApplicationContext());
                    messages.setText(test[i]);
                    layout.addView(messages);
                }
            }
        });
    }


}
