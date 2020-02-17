package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CardViewQuizActivity extends AppCompatActivity {

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_quiz);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Quiz");
    }

    public void Quiz1(View view) {
        startActivity(new Intent(this, Quiz1_1Activity.class));
    }

    public void Quiz2(View view) {
        startActivity(new Intent(this, Quiz2_2Activity.class));
    }

    public void Quiz3(View view) {
        startActivity(new Intent(this, Quiz3_3Activity.class));
    }
}
