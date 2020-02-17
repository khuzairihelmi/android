package com.khu.dbmlearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Quiz2DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz2.db";
    private static final int DATABASE_VERSION = +1;

    private SQLiteDatabase db;

    Quiz2DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +

                QuizContract.QuestionsTableQUIZ2.TABLE_NAME_QUIZ2 + " ( " +

                QuizContract.QuestionsTableQUIZ2._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                QuizContract.QuestionsTableQUIZ2.COLUMN_QUESTION_QUIZ2 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION1_QUIZ2 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION2_QUIZ2 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION3_QUIZ2 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION4_QUIZ2 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ2.COLUMN_ANSWER_NR_QUIZ2 + " INTEGER" +

                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionTableQUIZ2();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTableQUIZ2.TABLE_NAME_QUIZ2);

        onCreate(db);
    }

    /*=========================================== fillQuestion =========================================================*/

    private void fillQuestionTableQUIZ2()
    {
        Question q1 = new Question("Pick entities from the following:\n" +
                "i) vendor\n" +
                "ii) student\n" +
                "iii) tattends\n" +
                "iv) km/hour", "A. i, ii, iii ", "B. i, ii, iv.", "C. i and ii ","D. iii and iv", 3);
        addQuestionQUIZ2(q1);

        Question q2 = new Question("The ______________in a table is the column that makes each record different from all others.", "A. Unique Key ", "B. Primary Key ", "C. Candidate Key ","D. Foreign Key", 2);
        addQuestionQUIZ2(q2);

        Question q3 = new Question("Which attribute need NOT be physically stored within the database?", "A. Derived", "B. Composite", "C. Multi-Valued","D. Single-Valued", 1);
        addQuestionQUIZ2(q3);

        Question q4 = new Question("Many-to-One relationship represents “all companies operate four departments in their organization.", "A. True", "B. False", null,null, 1);
        addQuestionQUIZ2(q4);

        Question q5 = new Question("Domain is a set of allowable values for one or more attributes.",  "A. True", "B. False", null,null, 1);
        addQuestionQUIZ2(q5);

    }

    /*====================================== addQuestion =========================================================== */

    private void addQuestionQUIZ2(Question question)
    {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTableQUIZ2.COLUMN_QUESTION_QUIZ2, question.getQuestion());
        cv.put(QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION1_QUIZ2, question.getOption1());
        cv.put(QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION2_QUIZ2, question.getOption2());
        cv.put(QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION3_QUIZ2, question.getOption3());
        cv.put(QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION4_QUIZ2, question.getOption4());
        cv.put(QuizContract.QuestionsTableQUIZ2.COLUMN_ANSWER_NR_QUIZ2, question.getAnswerNr());

        db.insert(QuizContract.QuestionsTableQUIZ2.TABLE_NAME_QUIZ2, null, cv);

    }

    /*================================= getAllQuestion ========================================================== */

    List<Question> getAllQuestionQUIZ2()
    {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTableQUIZ1.TABLE_NAME_QUIZ1,null);

        if (c.moveToFirst())
        {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ2.COLUMN_QUESTION_QUIZ2)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION1_QUIZ2)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION2_QUIZ2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION3_QUIZ2)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ2.COLUMN_OPTION4_QUIZ2)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTableQUIZ2.COLUMN_ANSWER_NR_QUIZ2)));
                questionList.add(question);
            }
            while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}