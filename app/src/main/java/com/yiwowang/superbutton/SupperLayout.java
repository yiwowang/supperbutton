package com.yiwowang.superbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * 自定义shape布局
 * Created by sunguowei on 2018/6/30.
 */

public class SupperLayout extends FrameLayout {
    private float mPressedAlpha;

    public SupperLayout(@NonNull Context context) {
        this(context, null);
    }

    public SupperLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SupperLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.SupperLayout);
        // 设定背景
        setBackground(SelectorUtils.getBackgroundSelector(a, true));
        // 按下透明度
        mPressedAlpha = a.getFloat(R.styleable.SupperLayout_pressedAlpha, -1);
        a.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        SelectorUtils.onTouchEventPressAlpha(this, mPressedAlpha, event);
        return super.onTouchEvent(event);
    }

}
