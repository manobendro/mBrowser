package com.appsgang.mbrowser;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by manobbiswas on 2/14/18.
 */

public class AddressBarView extends View {

    Context mContext;
    AnimatedVectorDrawable drawable;

    public AddressBarView(Context context) {
        super(context);
        this.mContext = context;
    }

    public AddressBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public AddressBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    public AddressBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int top = 0;
        int left = 0;

        int width = 40;
        int height = 40;


        drawable = (AnimatedVectorDrawable) mContext.getResources().getDrawable(R.drawable.play_to_pause, null);


        drawable.setBounds(left, top, left + width, top + height);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xff0fffff);
        canvas.drawRoundRect(0, 0, 40, 40, 3, 3, paint);
        drawable.draw(canvas);

    }

    public void startAnimate() {
        drawable.start();
    }
}
