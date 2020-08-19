package com.kyrodevs.example;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleView extends View {
    private static final String TAG = "BubbleView";

    private int mWidth = 0;
    private int mHeight = 0;
    private int mIconWidth = 24; // Fixed Value must change later
    private int mBorder = 8; // Fixed Value must change later
    private int padL = 0, padR = 0, padT = 0, padB = 0;
    private Rect textBounds = new Rect();

    private List<String> linesOfString = new ArrayList<String>();
    private Path icon = new Path();
    private Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public BubbleView(Context context) {
        super(context);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(Color.BLACK);

        mBgPaint.setStyle(Paint.Style.FILL);
        mBgPaint.setColor(Color.LTGRAY);

        icon.lineTo(0, 0);
        icon.lineTo(mIconWidth + mBorder, 0);
        icon.lineTo(mIconWidth + mBorder, mIconWidth + mBorder);
        icon.close();
    }

    public BubbleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidth += padL + padR;
        mHeight += padT + padB -  mTextPaint.descent()/2;
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(icon, mBgPaint);
        canvas.drawRoundRect(mIconWidth, 0, getWidth(), getHeight(),
                mBorder, mBorder, mBgPaint);
        int  y = textBounds.height() + padT;
        for (String line: linesOfString) {
            canvas.drawText(line, padL + mIconWidth, y, mTextPaint);
            y += mTextPaint.descent() - mTextPaint.ascent();
        }
    }

    public void setText(String s) {
        linesOfString.addAll(Arrays.asList(s.split("\n")));
        for (String line: linesOfString) {
            mTextPaint.getTextBounds(line, 0, line.length(), textBounds);
            mWidth = Math.max(mWidth, textBounds.width());
            mHeight += mTextPaint.descent() - mTextPaint.ascent();
        }
        invalidate();
    }
    public void setTextSize(int spToPx) {
        mTextPaint.setTextSize(spToPx);
    }
    public void setPadding(int l, int t, int r, int b) {
        this.padL = l; this.padT = t;
        this.padB = b; this.padR = r;
    }
    public void setBackgroundColor(int color) {
        mBgPaint.setColor(color);
        invalidate();
    }
    public void setTextColor(int color) {
        mTextPaint.setColor(color);
        invalidate();
    }
}
