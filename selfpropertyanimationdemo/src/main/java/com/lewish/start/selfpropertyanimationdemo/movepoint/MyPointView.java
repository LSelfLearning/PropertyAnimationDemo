package com.lewish.start.selfpropertyanimationdemo.movepoint;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/11/15 14:48.
 */

public class MyPointView extends View {
    private Point currentPoint;
    private float radius = 50f;
    private Paint paint;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        paint.setColor(Color.parseColor(color));
        postInvalidate();
    }

    public MyPointView(Context context) {
        this(context,null);
    }

    public MyPointView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(currentPoint == null) {
            currentPoint = new Point(radius,radius);
            drawCanvas(canvas);
            startAnimation();
        }else{
            drawCanvas(canvas);
        }
    }

    private void drawCanvas(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x,y,radius,paint);
    }
    private void startAnimation(){
        Point endPoint = new Point(getWidth()-radius,getHeight()-radius);
        ValueAnimator moveAnim = ValueAnimator.ofObject(new PointEvaluator(), currentPoint, endPoint);
        moveAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                postInvalidate();
            }
        });

        ObjectAnimator colorAnim = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(), "#0000FF", "#FF0000");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(moveAnim).with(colorAnim);
        animatorSet.setDuration(5000);
        animatorSet.start();
    }
}
