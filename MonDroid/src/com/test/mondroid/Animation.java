package com.test.saeed;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Animation extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animation);
		
        final ImageView drawableImageView = (ImageView) findViewById(R.id.drawable_image_view);
        drawableImageView.setBackgroundResource(R.animator.drawable);
        drawableImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				AnimationDrawable animationDrawable = (AnimationDrawable) drawableImageView.getBackground();
				animationDrawable.start();
			}
		});
        
        final ImageView tweenImageView = (ImageView) findViewById(R.id.tween_image_view);
        tweenImageView.setImageResource(R.drawable.tween);
        tweenImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				android.view.animation.Animation animation = AnimationUtils.loadAnimation(Animation.this, R.anim.tween);
				tweenImageView.startAnimation(animation);
			}
		});
	}
}
