package com.khu.dbmlearning;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toolbar;

import pl.droidsonroids.gif.GifImageView;

public class ExerciseDoneActivity extends AppCompatActivity{

    TextView textTitle;
    GifImageView thumbup;
    Animation smalltobig;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_done);

        toolbar = findViewById(R.id.toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Exercise");

        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        textTitle = (TextView) findViewById(R.id.textTitle);

        thumbup = (GifImageView) findViewById(R.id.gif);
        thumbup.startAnimation(smalltobig);

        textTitle.setTypeface(typeface);
    }
}
