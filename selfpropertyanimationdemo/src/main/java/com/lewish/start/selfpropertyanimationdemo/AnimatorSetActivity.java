package com.lewish.start.selfpropertyanimationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimatorSetActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvTarget;
    private Button mBtnAnimset;
    private Button mBtnMethod2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);

        mIvTarget = (ImageView)findViewById(R.id.iv_target);
        mBtnAnimset = (Button)findViewById(R.id.btn_animset);
        mBtnMethod2 = (Button)findViewById(R.id.btn_method2);

        mBtnAnimset.setOnClickListener(this);
        mBtnMethod2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btn_animset:
                runAnimSet(mIvTarget);
                break;
            case  R.id.btn_method2:
                runMethod2(mIvTarget);
                break;
        }
    }

    /**
     * 实现组合动画功能主要需要借助AnimatorSet这个类，这个类提供了一个play()方法，如果我们向这个方法中传入一个Animator对象(ValueAnimator或ObjectAnimator)将会返回一个AnimatorSet.Builder的实例，AnimatorSet.Builder中包括以下四个方法：
     after(Animator anim)   将现有动画插入到传入的动画之后执行
     after(long delay)   将现有动画延迟指定毫秒后执行
     before(Animator anim)   将现有动画插入到传入的动画之前执行
     with(Animator anim)   将现有动画和传入的动画同时执行
     * @param target
     */
    private void runAnimSet(View target){
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(target, "alpha", 0f, 1f);
        ObjectAnimator translationXAnim = ObjectAnimator.ofFloat(target, "translationX", target.getTranslationX(), +300f);
        ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(target, "scaleX", 0f, 2f);
        ObjectAnimator sacleYAnim = ObjectAnimator.ofFloat(target, "scaleY", 0f, 2f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alphaAnim).with(translationXAnim).with(scaleXAnim).with(sacleYAnim);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }
    private void runMethod2(final View target){
        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(target, "haha", 0f,1f)//
                .setDuration(3000);//
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                float cVal = (Float) animation.getAnimatedValue();
                target.setAlpha(cVal);
                target.setScaleX(cVal);
                target.setScaleY(cVal);
            }
        });
    }
}
