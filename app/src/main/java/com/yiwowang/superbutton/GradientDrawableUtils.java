package com.yiwowang.superbutton;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

/**
 * 创建不同状态的GradientDrawable
 * Created by sunguowei on 2018/5/13.
 */

public class GradientDrawableUtils {
    /**
     * 正常
     */
    public static int INDEX_NORMAL = 0;
    /**
     * 按下
     */
    public static int INDEX_PRESSED = 1;
    /**
     * 无效
     */
    public static int INDEX_DISABLE = 2;
    /**
     * 选中
     */
    public static int INDEX_SELECTED = 3;


    public final static int[][] SUPPER_BUTTON_ATTARS = new int[][]{
            {
                    R.styleable.SupperButton_normalSolidColor,
                    R.styleable.SupperButton_normalStrokeColor,
                    R.styleable.SupperButton_normalStrokeWidth,
                    R.styleable.SupperButton_normalStrokeDashWidth,
                    R.styleable.SupperButton_normalStrokeDashGap,
                    R.styleable.SupperButton_normalRadius,
                    R.styleable.SupperButton_normalTopLeftRadius,
                    R.styleable.SupperButton_normalTopRightRadius,
                    R.styleable.SupperButton_normalBottomLeftRadius,
                    R.styleable.SupperButton_normalBottomRightRadius,
                    R.styleable.SupperButton_normalGradientStartColor,
                    R.styleable.SupperButton_normalGradientEndColor,
                    R.styleable.SupperButton_normalGradientCenterColor,
                    R.styleable.SupperButton_normalGradientUseLevel,
                    R.styleable.SupperButton_normalGradientAngle,
                    R.styleable.SupperButton_normalGradientRadius,
                    R.styleable.SupperButton_normalGradientOrientation,
                    R.styleable.SupperButton_normalGradientType,
                    R.styleable.SupperButton_normalShapeType
            },
            {
                    R.styleable.SupperButton_pressedSolidColor,
                    R.styleable.SupperButton_pressedStrokeColor,
                    R.styleable.SupperButton_pressedStrokeWidth,
                    R.styleable.SupperButton_pressedStrokeDashWidth,
                    R.styleable.SupperButton_pressedStrokeDashGap,
                    R.styleable.SupperButton_pressedRadius,
                    R.styleable.SupperButton_pressedTopLeftRadius,
                    R.styleable.SupperButton_pressedTopRightRadius,
                    R.styleable.SupperButton_pressedBottomLeftRadius,
                    R.styleable.SupperButton_pressedBottomRightRadius,
                    R.styleable.SupperButton_pressedGradientStartColor,
                    R.styleable.SupperButton_pressedGradientEndColor,
                    R.styleable.SupperButton_pressedGradientCenterColor,
                    R.styleable.SupperButton_pressedGradientUseLevel,
                    R.styleable.SupperButton_pressedGradientAngle,
                    R.styleable.SupperButton_pressedGradientRadius,
                    R.styleable.SupperButton_pressedGradientOrientation,
                    R.styleable.SupperButton_pressedGradientType,
                    R.styleable.SupperButton_pressedShapeType
            },
            {
                    R.styleable.SupperButton_disableSolidColor,
                    R.styleable.SupperButton_disableStrokeColor,
                    R.styleable.SupperButton_disableStrokeWidth,
                    R.styleable.SupperButton_disableStrokeDashWidth,
                    R.styleable.SupperButton_disableStrokeDashGap,
                    R.styleable.SupperButton_disableRadius,
                    R.styleable.SupperButton_disableTopLeftRadius,
                    R.styleable.SupperButton_disableTopRightRadius,
                    R.styleable.SupperButton_disableBottomLeftRadius,
                    R.styleable.SupperButton_disableBottomRightRadius,
                    R.styleable.SupperButton_disableGradientStartColor,
                    R.styleable.SupperButton_disableGradientEndColor,
                    R.styleable.SupperButton_disableGradientCenterColor,
                    R.styleable.SupperButton_disableGradientUseLevel,
                    R.styleable.SupperButton_disableGradientAngle,
                    R.styleable.SupperButton_disableGradientRadius,
                    R.styleable.SupperButton_disableGradientOrientation,
                    R.styleable.SupperButton_disableGradientType,
                    R.styleable.SupperButton_disableShapeType
            },
            {
                    R.styleable.SupperButton_selectedSolidColor,
                    R.styleable.SupperButton_selectedStrokeColor,
                    R.styleable.SupperButton_selectedStrokeWidth,
                    R.styleable.SupperButton_selectedStrokeDashWidth,
                    R.styleable.SupperButton_selectedStrokeDashGap,
                    R.styleable.SupperButton_selectedRadius,
                    R.styleable.SupperButton_selectedTopLeftRadius,
                    R.styleable.SupperButton_selectedTopRightRadius,
                    R.styleable.SupperButton_selectedBottomLeftRadius,
                    R.styleable.SupperButton_selectedBottomRightRadius,
                    R.styleable.SupperButton_selectedGradientStartColor,
                    R.styleable.SupperButton_selectedGradientEndColor,
                    R.styleable.SupperButton_selectedGradientCenterColor,
                    R.styleable.SupperButton_selectedGradientUseLevel,
                    R.styleable.SupperButton_selectedGradientAngle,
                    R.styleable.SupperButton_selectedGradientRadius,
                    R.styleable.SupperButton_selectedGradientOrientation,
                    R.styleable.SupperButton_selectedGradientType,
                    R.styleable.SupperButton_selectedShapeType
            }


    };
    public final static int[][] SUPPER_LAYOUT_ATTARS = new int[][]{
            {
                    R.styleable.SupperLayout_normalSolidColor,
                    R.styleable.SupperLayout_normalStrokeColor,
                    R.styleable.SupperLayout_normalStrokeWidth,
                    R.styleable.SupperLayout_normalStrokeDashWidth,
                    R.styleable.SupperLayout_normalStrokeDashGap,
                    R.styleable.SupperLayout_normalRadius,
                    R.styleable.SupperLayout_normalTopLeftRadius,
                    R.styleable.SupperLayout_normalTopRightRadius,
                    R.styleable.SupperLayout_normalBottomLeftRadius,
                    R.styleable.SupperLayout_normalBottomRightRadius,
                    R.styleable.SupperLayout_normalGradientStartColor,
                    R.styleable.SupperLayout_normalGradientEndColor,
                    R.styleable.SupperLayout_normalGradientCenterColor,
                    R.styleable.SupperLayout_normalGradientUseLevel,
                    R.styleable.SupperLayout_normalGradientAngle,
                    R.styleable.SupperLayout_normalGradientRadius,
                    R.styleable.SupperLayout_normalGradientOrientation,
                    R.styleable.SupperLayout_normalGradientType,
                    R.styleable.SupperLayout_normalShapeType
            },
            {
                    R.styleable.SupperLayout_pressedSolidColor,
                    R.styleable.SupperLayout_pressedStrokeColor,
                    R.styleable.SupperLayout_pressedStrokeWidth,
                    R.styleable.SupperLayout_pressedStrokeDashWidth,
                    R.styleable.SupperLayout_pressedStrokeDashGap,
                    R.styleable.SupperLayout_pressedRadius,
                    R.styleable.SupperLayout_pressedTopLeftRadius,
                    R.styleable.SupperLayout_pressedTopRightRadius,
                    R.styleable.SupperLayout_pressedBottomLeftRadius,
                    R.styleable.SupperLayout_pressedBottomRightRadius,
                    R.styleable.SupperLayout_pressedGradientStartColor,
                    R.styleable.SupperLayout_pressedGradientEndColor,
                    R.styleable.SupperLayout_pressedGradientCenterColor,
                    R.styleable.SupperLayout_pressedGradientUseLevel,
                    R.styleable.SupperLayout_pressedGradientAngle,
                    R.styleable.SupperLayout_pressedGradientRadius,
                    R.styleable.SupperLayout_pressedGradientOrientation,
                    R.styleable.SupperLayout_pressedGradientType,
                    R.styleable.SupperLayout_pressedShapeType
            },
            {
                    R.styleable.SupperLayout_disableSolidColor,
                    R.styleable.SupperLayout_disableStrokeColor,
                    R.styleable.SupperLayout_disableStrokeWidth,
                    R.styleable.SupperLayout_disableStrokeDashWidth,
                    R.styleable.SupperLayout_disableStrokeDashGap,
                    R.styleable.SupperLayout_disableRadius,
                    R.styleable.SupperLayout_disableTopLeftRadius,
                    R.styleable.SupperLayout_disableTopRightRadius,
                    R.styleable.SupperLayout_disableBottomLeftRadius,
                    R.styleable.SupperLayout_disableBottomRightRadius,
                    R.styleable.SupperLayout_disableGradientStartColor,
                    R.styleable.SupperLayout_disableGradientEndColor,
                    R.styleable.SupperLayout_disableGradientCenterColor,
                    R.styleable.SupperLayout_disableGradientUseLevel,
                    R.styleable.SupperLayout_disableGradientAngle,
                    R.styleable.SupperLayout_disableGradientRadius,
                    R.styleable.SupperLayout_disableGradientOrientation,
                    R.styleable.SupperLayout_disableGradientType,
                    R.styleable.SupperLayout_disableShapeType
            },
            {
                    R.styleable.SupperLayout_selectedSolidColor,
                    R.styleable.SupperLayout_selectedStrokeColor,
                    R.styleable.SupperLayout_selectedStrokeWidth,
                    R.styleable.SupperLayout_selectedStrokeDashWidth,
                    R.styleable.SupperLayout_selectedStrokeDashGap,
                    R.styleable.SupperLayout_selectedRadius,
                    R.styleable.SupperLayout_selectedTopLeftRadius,
                    R.styleable.SupperLayout_selectedTopRightRadius,
                    R.styleable.SupperLayout_selectedBottomLeftRadius,
                    R.styleable.SupperLayout_selectedBottomRightRadius,
                    R.styleable.SupperLayout_selectedGradientStartColor,
                    R.styleable.SupperLayout_selectedGradientEndColor,
                    R.styleable.SupperLayout_selectedGradientCenterColor,
                    R.styleable.SupperLayout_selectedGradientUseLevel,
                    R.styleable.SupperLayout_selectedGradientAngle,
                    R.styleable.SupperLayout_selectedGradientRadius,
                    R.styleable.SupperLayout_selectedGradientOrientation,
                    R.styleable.SupperLayout_selectedGradientType,
                    R.styleable.SupperLayout_selectedShapeType
            }

    };

    /**
     * 创建drawable
     *
     * @param index drawable状态类型，例如正常、按下态
     * @param a     自定义view参数
     * @return
     */
    public static GradientDrawable create(int index, TypedArray a, int[][] attrs) {
        boolean hasValue = false;
        for (int key : attrs[index]) {
            if (a.hasValue(key)) {
                hasValue = true;
                break;
            }
        }
        if (!hasValue) {
            return null;
        }
        int solidColor = a.getColor(attrs[index][0], Color.TRANSPARENT);
        int strokeColor = a.getColor(attrs[index][1], Color.TRANSPARENT);
        int strokeWidth = (int) a.getDimension(attrs[index][2], 0);
        int strokeDashWidth = (int) a.getDimension(attrs[index][3], 0);
        int strokeDashGap = (int) a.getDimension(attrs[index][4], 0);


        int radius = (int) a.getDimension(attrs[index][5], 0);
        int topLeftRadius = (int) a.getDimension(attrs[index][6], 0);
        int topRightRadius = (int) a.getDimension(attrs[index][7], 0);
        int bottomLeftRadius = (int) a.getDimension(attrs[index][8], 0);
        int bottomRightRadius = (int) a.getDimension(attrs[index][9], 0);

        int gradientStartColor = a.getColor(attrs[index][10], Color.TRANSPARENT);
        int gradientEndColor = a.getColor(attrs[index][11], Color.TRANSPARENT);
        int gradientCenterColor = a.getColor(attrs[index][12], Color.TRANSPARENT);
        boolean gradientUseLevel = a.getBoolean(attrs[index][13], false);

        int gradientAngle = (int) a.getDimension(attrs[index][14], 0);
        int gradientRadius = (int) a.getDimension(attrs[index][15], 0);
        int gradientOrientation = a.getInt(attrs[index][16], -1);
        int gradientType = a.getInt(attrs[index][17], -1);
        int shapeType = a.getInt(attrs[index][18], -1);

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(strokeWidth, strokeColor, strokeDashWidth,
                strokeDashGap);
        // 如果设定的有Orientation 就默认为是渐变色的Button，否则就是纯色的Button
        if (gradientOrientation != -1) {
            gradientDrawable
                    .setOrientation(getOrientation(gradientOrientation));
            gradientDrawable.setColors(new int[]{gradientStartColor,
                    gradientCenterColor, gradientEndColor});
        } else {
            gradientDrawable.setColor(solidColor);
        }

        if (shapeType != -1) {
            gradientDrawable.setShape(shapeType);
        }
        //是否为圆形
        if (shapeType != GradientDrawable.OVAL) {
            // 如果设定的有Corner Radius就认为是4个角一样的Button， 否则就是4个不一样的角 Button
            if (radius != 0) {
                gradientDrawable.setCornerRadius(radius);
            } else {
                //1、2两个参数表示左上角，3、4表示右上角，5、6表示右下角，7、8表示左下角
                gradientDrawable.setCornerRadii(new float[]{topLeftRadius,
                        topLeftRadius, topRightRadius, topRightRadius,
                        bottomRightRadius, bottomRightRadius, bottomLeftRadius,
                        bottomLeftRadius});
            }
        }

        if (gradientUseLevel)
            gradientDrawable.setUseLevel(gradientUseLevel);
        if (gradientType != -1)
            gradientDrawable.setGradientType(gradientType);
        gradientDrawable.setGradientRadius(gradientRadius);
        return gradientDrawable;
    }


    private static GradientDrawable.Orientation getOrientation(int gradientOrientation) {
        GradientDrawable.Orientation orientation = null;
        switch (gradientOrientation) {
            case 0:
                orientation = GradientDrawable.Orientation.BL_TR;
                break;
            case 1:
                orientation = GradientDrawable.Orientation.BOTTOM_TOP;
                break;
            case 2:
                orientation = GradientDrawable.Orientation.BR_TL;
                break;
            case 3:
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                break;
            case 4:
                orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                break;
            case 5:
                orientation = GradientDrawable.Orientation.TL_BR;
                break;
            case 6:
                orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                break;
            case 7:
                orientation = GradientDrawable.Orientation.TR_BL;
                break;
        }
        return orientation;
    }
}
