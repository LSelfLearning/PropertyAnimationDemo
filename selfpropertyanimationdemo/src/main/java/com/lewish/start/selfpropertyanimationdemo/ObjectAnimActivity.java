package com.lewish.start.selfpropertyanimationdemo;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ObjectAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvTarget;
    private Button mBtnAlpha;
    private Button mBtnRotation;
    private Button mBtnTranslate;
    private Button mBtnScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);

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
    private void runAlphaAnim(View target){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(target, "alpha", 1f, 0f, 1f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }
    private void runRotateAnim(View target){
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotationX", 0f, 360f);
        animator.setDuration(5000);
        animator.start();
    }
    private void runTranslateAnim(View target){
        float curTranslationX = target.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "translationX", curTranslationX, -500f, curTranslationX);
        animator.setDuration(5000);
        animator.start();
    }
    private void runScaleAnim(View target){
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "scaleY", 1f, 3f, 1f);
        animator.setDuration(5000);
        animator.start();
    }
}
