package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Quiz2Activity extends AppCompatActivity {

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public static final String EXTRA_SCORE_QUIZ2 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 20000;
    private TextView textViewQuestion, textViewScoreQuiz2, textViewQuestionCount,textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button buttonConfirmNext;
    private ColorStateList textColorDefaultRb, textColorDefaultCd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;
    private int scoreQuiz2;
    private boolean answered;
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        getSupportActionBar().setTitle("Quiz 2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textViewQuestion = findViewById(R.id.text_view_question_Quiz2);
        textViewScoreQuiz2 = findViewById(R.id.text_view_score_Quiz2);
        textViewQuestionCount = findViewById(R.id.text_view_question_count_Quiz2);
        textViewCountDown = findViewById(R.id.text_view_countdown_Quiz2);
        rbGroup = findViewById(R.id.radio_group_Quiz2);

        rb1 = findViewById(R.id.radio_button1_Quiz2);
        rb2 = findViewById(R.id.radio_button2_Quiz2);
        rb3 = findViewById(R.id.radio_button3_Quiz2);
        rb4 = findViewById(R.id.radio_button4_Quiz2);

        buttonConfirmNext = findViewById(R.id.button_confirm_next_Quiz2);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        Quiz2DBHelper dbHelper = new Quiz2DBHelper(this);
        questionList = dbHelper.getAllQuestionQUIZ2();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered)
                {
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked() )
                    {
                        checkAnswer();
                    }
                    else
                    {
                        Toast.makeText(Quiz2Activity.this, "Please select an answer...", Toast.LENGTH_SHORT).show();
                    }
                } else
                {
                    showNextQuestion();
                }
            }
        });

    }

    private void showNextQuestion()
    {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal)
        {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question:  "+ questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else
        {
            finishQuiz();
        }
    }

    private void startCountDown()
    {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished)
            {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish()
            {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText()
    {
        int minutes = (int) (timeLeftInMillis / 1000 ) / 60;
        int seconds = (int) (timeLeftInMillis / 1000 ) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 10000)
        {
            textViewCountDown.setTextColor(Color.RED);
        }
        else
        {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }


    private void checkAnswer()
    {
        answered = true;

        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) +1;

        if(answerNr == currentQuestion.getAnswerNr())
        {
            scoreQuiz2++;
            textViewScoreQuiz2.setText("Score: "+scoreQuiz2);
        }
        showSolution();
    }

    private void showSolution()
    {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr())
        {
            case 1:
                rb1.setTextColor(Color.BLUE);
                textViewQuestion.setText("\n\n   Answer A is correct.");
                break;

            case 2:
                rb2.setTextColor(Color.BLUE);
                textViewQuestion.setText("\n\n   Answer B is correct.");
                break;

            case 3:
                rb3.setTextColor(Color.BLUE);
                textViewQuestion.setText("\n\n   Answer C is correct.");
                break;

            case 4:
                rb4.setTextColor(Color.BLUE);
                textViewQuestion.setText("\n\n   Answer D is correct.");
                break;
        }

        if (questionCounter < questionCountTotal)
        {
            buttonConfirmNext.setText("Next");
        }
        else
        {
            buttonConfirmNext.setText("Finish");
        }
    }

    private void finishQuiz()
    {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE_QUIZ2, scoreQuiz2);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        if (backPressedTime + 2000 > System.currentTimeMillis())
        {
            finishQuiz();
        }
        else
        {
            Toast.makeText(this,"Press back again to finish...",Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null)
        {
            countDownTimer.cancel();
        }
    }
}