package com.yiwowang.superbutton.demo;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.yiwowang.superbutton.R;

/**
 * 布局裁剪内容演示demo，解决想裁剪某些view问题，
 * 例如可以实现fresco播放gif圆角，只需要将fresco控件放入此布局内即可
 * Created by sunguowei on 2018/6/30.
 */

public class ClipLayoutActivity extends Activity {
    private static final String[] PERMISSIONS = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_layout);

        // fresco需要存储权限
        if (Build.VERSION.SDK_INT > 26 && checkPermission()) {
            requestPermissions(PERMISSIONS, 0);
            return;
        }
        // 初始化gif动画
        initGif();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()) {
            initGif();
        }
    }

    private void initGif() {
        SimpleDraweeView image = findViewById(R.id.gif_view);
        playGif(image, "http://storage.slide.news.sina.com.cn/slidenews/77_ori/2018_20/74766_823041_827212.gif");
    }

    public void playGif(SimpleDraweeView draweeView, String url) {
        final PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setUri(url)
                .setOldController(draweeView.getController())
                .setAutoPlayAnimations(true) //自动播放gif动画
                .build();
        draweeView.setController(controller);
    }


    @TargetApi(Build.VERSION_CODES.M)
    private boolean checkPermission() {
        for (String permission : PERMISSIONS) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
