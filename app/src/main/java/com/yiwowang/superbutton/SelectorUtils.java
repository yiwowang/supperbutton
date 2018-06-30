package com.yiwowang.superbutton;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;

/**
 * 按下态处理工具
 * Created by sunguowei on 2018/6/30.
 */

public class SelectorUtils {

    /**
     * 根据属性创建背景selector
     *
     * @param a
     * @param isLayout 是否为布局
     * @return
     */
    public static Drawable getBackgroundSelector(TypedArray a, boolean isLayout) {
        int[][] attrs = isLayout ? GradientDrawableUtils.SUPPER_LAYOUT_ATTARS : GradientDrawableUtils.SUPPER_BUTTON_ATTARS;
        // 正常态
        GradientDrawable normalDrawable = GradientDrawableUtils.create(GradientDrawableUtils.INDEX_NORMAL, a, attrs);
        // 按下态
        GradientDrawable pressedDrawable = GradientDrawableUtils.create(GradientDrawableUtils.INDEX_PRESSED, a, attrs);
        // 无效态
        GradientDrawable disableDrawable = GradientDrawableUtils.create(GradientDrawableUtils.INDEX_DISABLE, a, attrs);
        // 选中态
        GradientDrawable selectedDrawable = GradientDrawableUtils.create(GradientDrawableUtils.INDEX_SELECTED, a, attrs);
        if (normalDrawable == null && pressedDrawable == null
                && disableDrawable == null && selectedDrawable == null) {
            return null;
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
        return stateListDrawable;
    }

    /**
     * 根据属性获取字体颜色selector
     *
     * @param a
     * @param defaultColor 默认颜色
     * @return
     */
    public static ColorStateList getTextColorSelector(TypedArray a, int defaultColor) {
        // 设定文字颜色
        int normalColor;
        int pressedColor;
        int disableColor;
        int selectedColor;

        if (a.hasValue(R.styleable.SupperButton_normalTextColor)) {
            normalColor = a.getColor(R.styleable.SupperButton_normalTextColor, Color.TRANSPARENT);
        } else {
            normalColor = defaultColor;
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
        return colorStateList;
    }

    /**
     * 处理按下事件改变透明度
     *
     * @param view
     * @param pressedAlpha
     * @param event
     */
    public static void onTouchEventPressAlpha(View view, float pressedAlpha, MotionEvent event) {
        // 按下透明度调整
        if (pressedAlpha >= 0) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    view.setAlpha(pressedAlpha);
                    break;
                case MotionEvent.ACTION_UP:
                    view.setAlpha(1);
                    break;
                default:
                    break;
            }
        }
    }
}
