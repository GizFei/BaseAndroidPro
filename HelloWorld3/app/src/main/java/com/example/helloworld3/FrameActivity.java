package com.example.helloworld3;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import java.util.Timer;
import java.util.TimerTask;

public class FrameActivity extends AppCompatActivity {

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
    */

    FrameLayout frame = null;
    // 自定义一个用于定时更新UI界面的handler类对象
    Handler handler = new Handler() {
        int i = 0;
        @Override
        public void handleMessage(Message msg){
            // 判断信息是否为本应用发出的
            if(msg.what == 0x123){
                ChangeImage(i);
                i++;
                if(i==8)
                    i=0;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        frame = (FrameLayout)findViewById(R.id.myFrame);
        // 定义一个定时器对象，定时发送信息给handler
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // 发送一条信息来通知系统改变前景图片
                handler.sendEmptyMessage(0x123);
            }
        },0,200);
    }
    void ChangeImage(int i){
        Drawable a = getResources().getDrawable(R.drawable.m1);
        Drawable b = getResources().getDrawable(R.drawable.m2);
        Drawable c = getResources().getDrawable(R.drawable.m3);
        Drawable d = getResources().getDrawable(R.drawable.m4);
        Drawable e = getResources().getDrawable(R.drawable.m5);
        Drawable f = getResources().getDrawable(R.drawable.m6);
        Drawable g = getResources().getDrawable(R.drawable.m7);
        Drawable h = getResources().getDrawable(R.drawable.m8);
        switch (i){
            case 0:
                frame.setForeground(a);
                break;
            case 1:
                frame.setForeground(b);
                break;
            case 2:
                frame.setForeground(c);
                break;
            case 3:
                frame.setForeground(d);
                break;
            case 4:
                frame.setForeground(e);
                break;
            case 5:
                frame.setForeground(f);
                break;
            case 6:
                frame.setForeground(g);
                break;
            case 7:
                frame.setForeground(h);
                break;
        }
    }

}
