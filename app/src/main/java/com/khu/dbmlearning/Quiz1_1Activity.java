package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz1_1Activity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS_QUIZ1 = "sharedPrefsQuiz1";
    public static final String KEY_HIGHSCORE_QUIZ1 = "keyHighscoreQuiz1";

    private TextView textViewHighscoreQuiz1;

    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Quiz 1");

        textViewHighscoreQuiz1 = findViewById(R.id.text_view_highscore_quiz1);
        loadHighscoreQuiz1();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button buttonStartQuiz = findViewById(R.id.button_start_quiz_quiz1);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz1();
            }
        });
    }

    private void startQuiz1() {
        Intent intent = new Intent(Quiz1_1Activity.this, Quiz1Activity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int scoreQuiz1 = data.getIntExtra(Quiz1Activity.EXTRA_SCORE_QUIZ1, 0);
                if (scoreQuiz1 > highscore) {
                    updateHighscoreEvent1(scoreQuiz1);
                }
            }
        }
    }

    private void loadHighscoreQuiz1() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_QUIZ1, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE_QUIZ1, 0);
        textViewHighscoreQuiz1.setText("Highscore: " + highscore);
    }

    private void updateHighscoreEvent1(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscoreQuiz1.setText("Highscore: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_QUIZ1, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE_QUIZ1, highscore);
        editor.apply();
    }
}
