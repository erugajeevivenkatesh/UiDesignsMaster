package com.nixinninsights.venkatesh.uidesignsmaster;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.util.DisplayMetrics;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    LinearLayout linearlayoutphone;
    TextView tvmoving,tvphone,tvcode;
    ImageView uber,ivback,ivflag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginmaster);
        asssigningIdvalues();
        setupWindowAnimations();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        uber.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (0.65 * height)));
        ivback.setImageAlpha(0);
    }

    public void asssigningIdvalues()
    {
        linearlayoutphone=findViewById(R.id.llphone);
        tvcode=findViewById(R.id.tvCode);
        tvmoving=findViewById(R.id.tvMoving);
        tvphone=findViewById(R.id.tvPhoneNo);
        uber=findViewById(R.id.ivUberLogo);
        ivflag=findViewById(R.id.ivFlag);
        ivback=findViewById(R.id.ivback);
    }

    private void setupWindowAnimations() {

        ChangeBounds exitTransition = new ChangeBounds();
        exitTransition.setDuration(1000);
        exitTransition.addListener(exitListener);
        getWindow().setSharedElementExitTransition(exitTransition);

        ChangeBounds reenterTransition = new ChangeBounds();
        reenterTransition.setDuration(1000);
        reenterTransition.addListener(reenterListener);
        reenterTransition.setInterpolator(new DecelerateInterpolator(4));
        getWindow().setSharedElementReenterTransition(reenterTransition);

    }
    Transition.TransitionListener exitListener=new Transition.TransitionListener() {
        @Override
        public void onTransitionStart(Transition transition) {

        }

        @Override
        public void onTransitionEnd(Transition transition) {

        }

        @Override
        public void onTransitionCancel(Transition transition) {

        }

        @Override
        public void onTransitionPause(Transition transition) {

        }

        @Override
        public void onTransitionResume(Transition transition) {

        }
    };
    Transition.TransitionListener reenterListener=new Transition.TransitionListener() {
        @Override
        public void onTransitionStart(Transition transition) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(tvmoving, "alpha", 0f, 1f));
            animatorSet.setDuration(800);
            animatorSet.start();
        }

        @Override
        public void onTransitionEnd(Transition transition) {

        }

        @Override
        public void onTransitionCancel(Transition transition) {

        }

        @Override
        public void onTransitionPause(Transition transition) {

        }

        @Override
        public void onTransitionResume(Transition transition) {

            tvmoving.setAlpha(1);
        }
    };


    public  void starttranstionofactiviity(View view)
    {
        starttransistion();
    }
    void starttransistion()
    {

        Intent intent=new Intent(getApplicationContext(),Loginwithphone.class);
        Pair<View, String> p1 = Pair.create((View) ivback, getString(R.string.transition_arrow));
           Pair<View, String> p2 = Pair.create((View) ivflag, getString(R.string.transition_ivFlag));
        Pair<View, String> p3 = Pair.create((View) tvcode, getString(R.string.transition_tvCode));
        Pair<View, String> p4 = Pair.create((View) tvphone, getString(R.string.transition_tvPhoneNo));
        Pair<View, String> p5 = Pair.create((View) linearlayoutphone, getString(R.string.transition_llPhone));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,p5);
        startActivity(intent, options.toBundle());
       // startActivity(intent);
    }
}
