package com.lewish.start.selfpropertyanimationdemo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvTarget;
    private Button mBtnAlpha;
    private Button mBtnRotation;
    private Button mBtnTranslate;
    private Button mBtnScale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);

        mIvTarget = (ImageView)findViewById(R.id.iv_target);

        mBtnAlpha = (Button) findViewById(R.id.btn_alpha);
        mBtnRotation = (Button) findViewById(R.id.btn_rotation);
        mBtnTranslate = (Button) findViewById(R.id.btn_translate);
        mBtnScale = (Button) findViewById(R.id.btn_scale);

        mBtnAlpha.setOnClickListener(this);
        mBtnRotation.setOnClickListener(this);
        mBtnTranslate.setOnClickListener(this);
        mBtnScale.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha :
                runAlphaAnim(mIvTarget);
                break;
            case R.id.btn_rotation :
                runRotateAnim(mIvTarget);
                break;
            case R.id.btn_translate :
                runTranslateAnim(mIvTarget);
                break;
            case R.id.btn_scale :
                runScaleAnim(mIvTarget);
                break;
        }
    }

    private void runScaleAnim(final ImageView mIvTarget) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 2f);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                mIvTarget.setScaleX(animatedValue);
                mIvTarget.setScaleY(animatedValue);
            }
        });
        valueAnimator.start();
    }

    private void runTranslateAnim(final ImageView mIvTarget) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(mIvTarget.getTranslationX(), +300f);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                mIvTarget.setTranslationX(animatedValue);
            }
        });
        valueAnimator.start();
    }

    private void runRotateAnim(final ImageView mIvTarget) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 360f);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                mIvTarget.setRotation(animatedValue);
            }
        });
        valueAnimator.start();
    }

    private void runAlphaAnim(final ImageView mIvTarget) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                mIvTarget.setAlpha(animatedValue);
            }
        });
        valueAnimator.start();
    }
}
