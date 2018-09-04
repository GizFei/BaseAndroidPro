package com.example.helloworld3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Giz on 2018/7/13.
 */
public class DisplayMessageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");
        TextView textView = (TextView)findViewById(R.id.tvShow);
        textView.setText(message);
    }
}
