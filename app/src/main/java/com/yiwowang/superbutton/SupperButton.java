package com.yiwowang.superbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * 多功能样式按钮
 * 主要为了避免创建过多的shape类型的xml文件
 * <p>
 * Created by sunguowei on 2018/5/13.
 */

public class SupperButton extends TextView {
    // 按下透明度
    private float mPressedAlpha = -1;

    public SupperButton(Context context) {
        this(context, null);
    }

    public SupperButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SupperButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.SupperButton);
        // 设定背景
        setBackground(SelectorUtils.getBackgroundSelector(a, false));
        // 设定文字颜色
        setTextColor(SelectorUtils.getTextColorSelector(a, getCurrentTextColor()));
        // 按下透明度
        mPressedAlpha = a.getFloat(R.styleable.SupperButton_pressedAlpha, -1);
        a.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        SelectorUtils.onTouchEventPressAlpha(this, mPressedAlpha, event);
        return super.onTouchEvent(event);
    }

}