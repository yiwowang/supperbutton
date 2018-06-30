package com.yiwowang.superbutton.demo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yiwowang.superbutton.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 跳转到自定义shape演示demo
        findViewById(R.id.shape_button_demo_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShapeButtonActivity.class));
            }
        });
        // 跳转到裁剪布局demo
        findViewById(R.id.clip_layout_demo_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ClipLayoutActivity.class));
            }
        });
    }
}
