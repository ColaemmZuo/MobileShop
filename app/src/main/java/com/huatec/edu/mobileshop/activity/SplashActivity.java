package com.huatec.edu.mobileshop.activity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.common.BaseActivity;

public class SplashActivity extends BaseActivity {
    ImageView splash_loading_item;
    @Override
    public int getContentViewId() {
        return R.layout.activity_splash;
    }
    @Override
    protected void initView(){
        super.initView();
        splash_loading_item=(ImageView)findViewById(R.id.splash_loading_item);

       Animation translate = AnimationUtils.loadAnimation(this,R.anim.splash_loading);

       translate.setAnimationListener(new Animation.AnimationListener() {
           @Override
           public void onAnimationStart(Animation animation) {

           }

           @Override
           public void onAnimationEnd(Animation animation) {

               startActivity(new Intent(SplashActivity.this,AdActivity.class));
               overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
               finish();
           }

           @Override
           public void onAnimationRepeat(Animation animation) {

           }
       });
       splash_loading_item.setAnimation(translate);
    }
}
