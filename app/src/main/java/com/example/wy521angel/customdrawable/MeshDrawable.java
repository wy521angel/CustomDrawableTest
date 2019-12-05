package com.example.wy521angel.customdrawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 网格的Drawable
 */
public class MeshDrawable extends Drawable {
    private static final int INTERVAL = (int) Utils.dp2px(80);//网格两条线之间的距离

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        paint.setColor(Color.RED);
        paint.setStrokeWidth(Utils.dp2px(2));
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        //绘制规则 i是横坐标 j是纵坐标
        for (int i = 0; i < getBounds().right; i += INTERVAL) {
            for (int j = 0; j < getBounds().bottom; j += INTERVAL) {
                canvas.drawLine(getBounds().left, j, getBounds().right, j, paint);
                canvas.drawLine(i, getBounds().top, i, getBounds().bottom, paint);
            }
        }
    }

    @Override
    public void setAlpha(int alpha) {
        //设置透明度
        paint.setAlpha(alpha);
    }

    @Override
    public int getAlpha() {
        return paint.getAlpha();
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return paint.getAlpha() == 0 ? PixelFormat.TRANSLUCENT ://完全透明
                paint.getAlpha() == 0xff ? PixelFormat.OPAQUE ://完全不透明
                        PixelFormat.TRANSLUCENT;//部分透明
    }
}
