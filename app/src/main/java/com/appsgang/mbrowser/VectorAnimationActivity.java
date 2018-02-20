package com.appsgang.mbrowser;

import android.animation.Animator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class VectorAnimationActivity extends AppCompatActivity {


    //AppCompatImageView imageView;
    LottieAnimationView pinJumpAnimation;
    boolean state = true;
    AddressBarView addressBarView;

    AppCompatImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_animation);

        imageView = (AppCompatImageView) findViewById(R.id.play);
        addressBarView = (AddressBarView) findViewById(R.id.addressBar);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatImageView image = (AppCompatImageView) view;
                Drawable drawable = image.getDrawable();
                Animatable animatable = (Animatable) drawable;
                if (!animatable.isRunning()) {
                    animatable.start();
                    addressBarView.startAnimate();
                }


                Log.d("manob", "Clicked!");
            }
        });

        pinJumpAnimation = (LottieAnimationView) findViewById(R.id.animation_view);
        pinJumpAnimation.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("manob", "animation started.");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("manob", "animation end.");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


        pinJumpAnimation.loop(true);
        pinJumpAnimation.playAnimation();
        pinJumpAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //addressBarView.startAnimate();

                if (state) {
                    pinJumpAnimation.loop(false);
                    state = false;
                } else {
                    pinJumpAnimation.loop(true);
                    pinJumpAnimation.playAnimation();
                    state = true;
                }
            }
        });

    }
}
