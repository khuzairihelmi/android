package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz3_3Activity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS_QUIZ3 = "sharedPrefsQuiz3";
    public static final String KEY_HIGHSCORE_QUIZ3 = "keyHighscoreQuiz3";

    private TextView textViewHighscoreQuiz3;

    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3_3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Quiz 3");

        textViewHighscoreQuiz3 = findViewById(R.id.text_view_highscore_quiz3);
        loadHighscoreQuiz3();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button buttonStartQuiz = findViewById(R.id.button_start_quiz_quiz3);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz3();
            }
        });
    }

    private void startQuiz3() {
        Intent intent = new Intent(Quiz3_3Activity.this, Quiz3Activity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int scoreQuiz3 = data.getIntExtra(Quiz3Activity.EXTRA_SCORE_QUIZ3, 0);
                if (scoreQuiz3 > highscore) {
                    updateHighscoreEvent1(scoreQuiz3);
                }
            }
        }
    }

    private void loadHighscoreQuiz3() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_QUIZ3, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE_QUIZ3, 0);
        textViewHighscoreQuiz3.setText("Highscore: " + highscore);
    }

    private void updateHighscoreEvent1(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscoreQuiz3.setText("Highscore: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_QUIZ3, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE_QUIZ3, highscore);
        editor.apply();
    }
}
