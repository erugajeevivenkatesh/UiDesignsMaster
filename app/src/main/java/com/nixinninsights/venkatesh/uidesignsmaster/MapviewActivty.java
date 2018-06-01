package com.nixinninsights.venkatesh.uidesignsmaster;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MapviewActivty extends AppCompatActivity {

    public ArgbEvaluator argbEvaluator;
    FrameLayout relativeLayout;


    CardView animationfforcard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapview_activty);
        relativeLayout = findViewById(R.id.rootFrame);
        animationfforcard = findViewById(R.id.animation);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            //startRevealAnimation();
        }
    }
    void startRevealAnimation() {



        int cx = (relativeLayout.getLeft() + relativeLayout.getRight()) / 2;
        int cy = (relativeLayout.getTop() + relativeLayout.getBottom()) / 2;
        float radius = Math.max(animationfforcard.getWidth(), animationfforcard.getHeight()) * 2.0f;

        if (animationfforcard.getVisibility() == View.INVISIBLE) {
            animationfforcard.setVisibility(View.VISIBLE);
            ViewAnimationUtils.createCircularReveal(animationfforcard, cx, cy, 0, radius).start();
        } else {
            Animator reveal = ViewAnimationUtils.createCircularReveal(
                    animationfforcard, cx, cy, radius, 0);
            reveal.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    animationfforcard.setVisibility(View.INVISIBLE);
                }
            });
            reveal.start();
        }
    }

}
