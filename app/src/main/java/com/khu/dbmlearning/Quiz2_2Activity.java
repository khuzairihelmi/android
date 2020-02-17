package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz2_2Activity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS_QUIZ2 = "sharedPrefsQuiz2";
    public static final String KEY_HIGHSCORE_QUIZ2 = "keyHighscoreQuiz2";

    private TextView textViewHighscoreQuiz2;

    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2_2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Quiz 2");

        textViewHighscoreQuiz2 = findViewById(R.id.text_view_highscore_quiz2);
        loadHighscoreQuiz2();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button buttonStartQuiz = findViewById(R.id.button_start_quiz_quiz2);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz2();
            }
        });
    }

    private void startQuiz2() {
        Intent intent = new Intent(Quiz2_2Activity.this, Quiz2Activity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int scoreQuiz2 = data.getIntExtra(Quiz2Activity.EXTRA_SCORE_QUIZ2, 0);
                if (scoreQuiz2 > highscore) {
                    updateHighscoreEvent1(scoreQuiz2);
                }
            }
        }
    }

    private void loadHighscoreQuiz2() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_QUIZ2, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE_QUIZ2, 0);
        textViewHighscoreQuiz2.setText("Highscore: " + highscore);
    }

    private void updateHighscoreEvent1(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscoreQuiz2.setText("Highscore: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_QUIZ2, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE_QUIZ2, highscore);
        editor.apply();
    }
}
