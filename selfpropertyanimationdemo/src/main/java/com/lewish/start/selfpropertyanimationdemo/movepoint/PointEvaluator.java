package com.lewish.start.selfpropertyanimationdemo.movepoint;

import android.animation.TypeEvaluator;

/**
 * Created by Administrator on 2016/11/15 14:46.
 */

public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        float startX = startValue.getX();
        float startY = startValue.getY();

        float endX = endValue.getX();
        float endY = endValue.getY();

        float x = startX + (endX - startX)*fraction;
        float y = startY + (endY - startY)*fraction;

        return new Point(x,y);
    }
}
