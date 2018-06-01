package com.nixinninsights.venkatesh.uidesignsmaster;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.transition.Transition;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.Gravity.LEFT;

public class Loginwithphone extends AppCompatActivity {
    ImageView ivback,ivflag;
    FrameLayout rootview;
    EditText etphone;
    LinearLayout lenerlayout;
    TextView tvcode,tvmoving;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginwithphone);
        assigningIdofimages();
        setupWindowAnimations();
    }

   public  void ReturnTransistion(View view)
    {
        super.onBackPressed();
    }
    public void assigningIdofimages()
    {
        ivback=findViewById(R.id.ivback);
        ivflag=findViewById(R.id.ivFlag);
        rootview=findViewById(R.id.rootFrame);
        etphone=findViewById(R.id.etPhoneNo);
        lenerlayout=findViewById(R.id.llphone);
        tvmoving=findViewById(R.id.tvMoving);
        tvcode=findViewById(R.id.tvCode);


    }
    private void setupWindowAnimations() {

        ChangeBounds enterTransition = new ChangeBounds();
        enterTransition.setDuration(1000);
        enterTransition.setInterpolator(new DecelerateInterpolator(4));
        enterTransition.addListener(enterTransitionListener);
        getWindow().setSharedElementEnterTransition(enterTransition);
        ChangeBounds returnTransition = new ChangeBounds();
        returnTransition.setDuration(1000);
        returnTransition.addListener(returnTransitionListener);
        getWindow().setSharedElementReturnTransition(returnTransition);
        Slide exitSlide = new Slide(LEFT);
        exitSlide.setDuration(700);
        exitSlide.addListener(exitTransitionListener);
        exitSlide.addTarget(R.id.llphone);
        exitSlide.setInterpolator(new DecelerateInterpolator());
        getWindow().setExitTransition(exitSlide);

        Slide reenterSlide = new Slide(LEFT);
        reenterSlide.setDuration(700);
        reenterSlide.addListener(reenterTransitionListener);
        reenterSlide.setInterpolator(new DecelerateInterpolator(2));
        reenterSlide.addTarget(R.id.llphone);
        getWindow().setReenterTransition(reenterSlide);

    }

    Transition.TransitionListener enterTransitionListener = new Transition.TransitionListener() {
        @Override
        public void onTransitionStart(Transition transition) {
            ivback.setImageAlpha(0);
        }

        @Override
        public void onTransitionEnd(Transition transition) {

            ivback.setImageAlpha(255);
            Animation animation = AnimationUtils.loadAnimation(Loginwithphone.this, R.anim.slide_right);
            ivback.startAnimation(animation);
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


    Transition.TransitionListener returnTransitionListener = new Transition.TransitionListener() {
        @Override
        public void onTransitionStart(Transition transition) {

            InputMethodManager imm = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(etphone.getWindowToken(), 0);
            tvmoving.setText(null);
            tvmoving.setHint(getString(R.string.enter_no));
            ivflag.setImageAlpha(0);
            tvcode.setAlpha(0);
            etphone.setVisibility(View.GONE);
            etphone.setCursorVisible(false);
            etphone.setBackground(null);
            Animation animation = AnimationUtils.loadAnimation(Loginwithphone.this, R.anim.slide_left);
            ivback.startAnimation(animation);
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

    Transition.TransitionListener exitTransitionListener = new Transition.TransitionListener() {
        @Override
        public void onTransitionStart(Transition transition) {

            rootview.setAlpha(1f);

            lenerlayout.setBackgroundColor(Color.parseColor("#EFEFEF"));
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


    Transition.TransitionListener reenterTransitionListener = new Transition.TransitionListener() {
        @Override
        public void onTransitionStart(Transition transition) {


        }

        @Override
        public void onTransitionEnd(Transition transition) {

            lenerlayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            etphone.setCursorVisible(true);
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

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


    public void CheckingMobile(View view) {
        Intent  intent=new Intent(getApplicationContext(),PasswordActivity.class);

        ActivityOptionsCompat options=ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        startActivity(intent, options.toBundle());
    }

}
