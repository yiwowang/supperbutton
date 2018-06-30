package com.yiwowang.superbutton.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yiwowang.superbutton.R;

/**
 * 布局裁剪内容演示demo，解决想裁剪某些view问题，
 * 例如可以实现fresco播放gif圆角，只需要将fresco控件放入此布局内即可
 * Created by sunguowei on 2018/6/30.
 */

public class ClipLayoutActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_layout);
    }
}
