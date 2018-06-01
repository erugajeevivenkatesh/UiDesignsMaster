package com.nixinninsights.venkatesh.uidesignsmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import static android.view.Gravity.RIGHT;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passwordfragment);
        setupactivityanimations();
    }

    public void backperssed(View view) {
        super.onBackPressed();
    }

    public void SignInAccouunt(View view) {
        startActivity(new Intent(getApplicationContext(),MapviewActivty.class));
    }
    void setupactivityanimations()
    {

        Slide enterSlide = new Slide(RIGHT);
        enterSlide.setDuration(700);
        enterSlide.addTarget(R.id.llphone);
        enterSlide.setInterpolator(new DecelerateInterpolator(2));
        getWindow().setEnterTransition(enterSlide);

        Slide returnSlide = new Slide(RIGHT);
        returnSlide.setDuration(700);
        returnSlide.addTarget(R.id.llphone);
        returnSlide.setInterpolator(new DecelerateInterpolator());
        getWindow().setReturnTransition(returnSlide);

    }
}
