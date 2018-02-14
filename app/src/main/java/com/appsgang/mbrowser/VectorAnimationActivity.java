package com.appsgang.mbrowser;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;

public class VectorAnimationActivity extends AppCompatActivity {


    AppCompatImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_animation);

        imageView = (AppCompatImageView) findViewById(R.id.play);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatImageView image = (AppCompatImageView) view;
                Drawable drawable = image.getDrawable();
                Animatable animatable = (Animatable) drawable;
                if (!animatable.isRunning()) {
                    animatable.start();
                }


                Log.d("manob", "Clicked!");
            }
        });
    }
}
