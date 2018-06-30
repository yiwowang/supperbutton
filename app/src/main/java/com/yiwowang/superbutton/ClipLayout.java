package com.yiwowang.superbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * 布局会对内容进行裁剪，支持圆形和圆角矩形
 * 解决想裁剪某些View的问题
 * Created by sunguowei on 2018/6/30.
 */

public class ClipLayout extends FrameLayout {
    public static final int SHAPE_TYPE_NONE = -1;
    public static final int SHAPE_TYPE_RECTANGLE = 0;
    public static final int SHAPE_TYPE_OVAL = 1;
    private int mShapeType;
    private int mLeftTopRadius;
    private int mLeftBottomRadius;
    private int mRightTopRadius;
    private int mRightBottomRadius;
    private int mRadius;

    private Path mPath;

    private int mWidth;
    private int mHeight;


    public ClipLayout(@NonNull Context context) {
        this(context, null);
    }

    public ClipLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        setBackgroundDrawable(new ColorDrawable(0x33ff0000));
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ClipLayout);
        mShapeType = a.getInt(R.styleable.ClipLayout_shapeType, SHAPE_TYPE_NONE);
        mLeftBottomRadius = a.getDimensionPixelSize(R.styleable.ClipLayout_leftBottomRadius, 0);
        mLeftTopRadius = a.getDimensionPixelSize(R.styleable.ClipLayout_leftTopRadius, 0);
        mRightTopRadius = a.getDimensionPixelSize(R.styleable.ClipLayout_rightTopRadius, 0);
        mRightBottomRadius = a.getDimensionPixelSize(R.styleable.ClipLayout_rightBottomRadius, 0);
        mRadius = a.getDimensionPixelSize(R.styleable.ClipLayout_radius, 0);
        mPath = new Path();
        mPath.setFillType(Path.FillType.EVEN_ODD);
    }

    private void checkPathChanged() {
        if (getWidth() == mWidth && getHeight() == mHeight) {
            return;
        }

        mWidth = getWidth();
        mHeight = getHeight();

        mPath.reset();
        switch (mShapeType) {
            case SHAPE_TYPE_RECTANGLE:
                if (mRadius > 0 || mLeftTopRadius > 0 || mRightTopRadius > 0 || mRightBottomRadius > 0 || mLeftBottomRadius > 0) {
                    if (mRadius > 0) {
                        mPath.addRoundRect(new RectF(0, 0, mWidth, mHeight), mRadius, mRadius, Path.Direction.CW);
                    } else {
                        mPath.addRoundRect(new RectF(0, 0, mWidth, mHeight),
                                new float[]{mLeftTopRadius, mLeftTopRadius, mRightTopRadius, mRightTopRadius, mRightBottomRadius, mRightBottomRadius, mLeftBottomRadius, mLeftBottomRadius},
                                Path.Direction.CW);
                    }
                } else {
                    mShapeType = SHAPE_TYPE_NONE;
                }
                break;
            case SHAPE_TYPE_OVAL:
                mPath.addOval(new RectF(0, 0, mWidth, mHeight), Path.Direction.CW);
                break;
            default:
                break;
        }


    }

    @Override
    public void draw(Canvas canvas) {

        if (mShapeType != SHAPE_TYPE_NONE) {
            int saveCount = canvas.save();

            checkPathChanged();
            canvas.clipPath(mPath);
            super.draw(canvas);

            canvas.restoreToCount(saveCount);
        } else {
            super.draw(canvas);
        }


    }
}
