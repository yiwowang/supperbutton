package com.yiwowang.superbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
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

    public SupperButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SupperButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public SupperButton(Context context) {
        super(context);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.SupperButton);
        // 设定背景
        setBackgroundSelector(a);
        // 设定文字颜色
        setTextColorSelector(a);
        // 按下透明度
        mPressedAlpha = a.getFloat(R.styleable.SupperButton_pressedAlpha, -1);
        a.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 按下透明度调整
        if (mPressedAlpha >= 0) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    setAlpha(mPressedAlpha);
                    break;
                case MotionEvent.ACTION_UP:
                    setAlpha(1);
                    break;
                default:
                    break;
            }
        }
        return super.onTouchEvent(event);
    }

    /**
     * 设定背景
     *
     * @param a
     */
    private void setBackgroundSelector(TypedArray a) {
        // 正常态
        GradientDrawable normalDrawable = GradientDrawableUtils.create(GradientDrawableUtils.INDEX_NORMAL, a);
        // 按下态
        GradientDrawable pressedDrawable = GradientDrawableUtils.create(GradientDrawableUtils.INDEX_PRESSED, a);
        // 无效态
        GradientDrawable disableDrawable = GradientDrawableUtils.create(GradientDrawableUtils.INDEX_DISABLE, a);
        // 选中态
        GradientDrawable selectedDrawable = GradientDrawableUtils.create(GradientDrawableUtils.INDEX_SELECTED, a);
        if (normalDrawable == null && pressedDrawable == null
                && disableDrawable == null && selectedDrawable == null) {
            return;
        }
        // 将各种状态成一个StateListDrawable
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (normalDrawable != null) {
            stateListDrawable.addState(new int[]{
                    -android.R.attr.state_pressed,
                    android.R.attr.state_enabled,
                    -android.R.attr.state_selected}, normalDrawable);
        }
        if (pressedDrawable == null) {
            pressedDrawable = normalDrawable;
        }
        if (pressedDrawable != null) {
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawable);
        }
        if (disableDrawable == null) {
            disableDrawable = normalDrawable;
        }
        if (disableDrawable != null) {
            stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, disableDrawable);
        }
        if (selectedDrawable == null) {
            selectedDrawable = normalDrawable;
        }
        if (selectedDrawable != null) {
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selectedDrawable);
        }
        // 设定为控件背景
        setBackground(stateListDrawable);
    }

    /**
     * 设定文字颜色
     *
     * @param a
     */
    private void setTextColorSelector(TypedArray a) {
        // 设定文字颜色
        int normalColor;
        int pressedColor;
        int disableColor;
        int selectedColor;

        if (a.hasValue(R.styleable.SupperButton_normalTextColor)) {
            normalColor = a.getColor(R.styleable.SupperButton_normalTextColor, Color.TRANSPARENT);
        } else {
            normalColor = getCurrentTextColor();
        }
        if (a.hasValue(R.styleable.SupperButton_pressedTextColor)) {
            pressedColor = a.getColor(R.styleable.SupperButton_pressedTextColor, Color.TRANSPARENT);
        } else {
            pressedColor = normalColor;
        }
        if (a.hasValue(R.styleable.SupperButton_disableTextColor)) {
            disableColor = a.getColor(R.styleable.SupperButton_disableTextColor, Color.TRANSPARENT);
        } else {
            disableColor = normalColor;
        }
        if (a.hasValue(R.styleable.SupperButton_selectedTextColor)) {
            selectedColor = a.getColor(R.styleable.SupperButton_selectedTextColor, Color.TRANSPARENT);
        } else {
            selectedColor = normalColor;
        }
        ColorStateList colorStateList = new ColorStateList(new int[][]{
                {
                        -android.R.attr.state_pressed,
                        android.R.attr.state_enabled,
                        -android.R.attr.state_selected
                },
                {
                        android.R.attr.state_pressed
                },
                {
                        -android.R.attr.state_enabled
                },
                {
                        -android.R.attr.state_selected
                }

        }, new int[]{normalColor, pressedColor, disableColor, selectedColor});
        setTextColor(colorStateList);
    }

}