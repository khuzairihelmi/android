package com.khu.dbmlearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Quiz3DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz3.db";
    private static final int DATABASE_VERSION = +1;

    private SQLiteDatabase db;

    Quiz3DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +

                QuizContract.QuestionsTableQUIZ3.TABLE_NAME_QUIZ3 + " ( " +

                QuizContract.QuestionsTableQUIZ3._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                QuizContract.QuestionsTableQUIZ3.COLUMN_QUESTION_QUIZ3 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION1_QUIZ3 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION2_QUIZ3 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION3_QUIZ3 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION4_QUIZ3 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ3.COLUMN_ANSWER_NR_QUIZ3 + " INTEGER" +

                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionTableQUIZ3();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTableQUIZ3.TABLE_NAME_QUIZ3);

        onCreate(db);
    }

    /*=========================================== fillQuestion =========================================================*/

    private void fillQuestionTableQUIZ3()
    {
        Question q1 = new Question("Which of the following is the Data Manipulation Language statement?\n" +
                "i. \tCREATE\n" +
                "ii.\tALTER\n" +
                "iii.\tINSERT\n" +
                "iv.\tSELECT\n", "A. i ", "B. iii", "C. i and ii ","D. iii and iv", 4);
        addQuestionQUIZ3(q1);

        Question q2 = new Question("What does SQL stand for?", "A. Structured Question Language", "B. Structured Query Language", "C. Structured Queue Language","D. Strong Query Language", 2);
        addQuestionQUIZ3(q2);

        Question q3 = new Question("Which one is NOT in the group function provided by SQL?", "A. MAX ", "B. COUNT", "C. TOTAL","D. AVG", 3);
        addQuestionQUIZ3(q3);

        Question q4 = new Question("Identify the query to ELIMINATE a table from a database.", "A. REMOVE TABLE SUBJECT", "B. DELETE TABLE SUBJECT", "C. UPDATE TABLE SUBJECT","D. DROP TABLE SUBJECT", 4);
        addQuestionQUIZ3(q4);

        Question q5 = new Question("Identify the FALSE statement while using LIKE comparison operator.",  "A. WHERE customerName LIKE ‘ad%’;", "B. WHERE customerName LIKE ‘%ad’;", "C. WHERE customerName LIKE ‘_ad%’;","D. WHERE customerName LIKE  = ‘ad%’;", 4);
        addQuestionQUIZ3(q5);

    }

    /*====================================== addQuestion =========================================================== */

    private void addQuestionQUIZ3(Question question)
    {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTableQUIZ3.COLUMN_QUESTION_QUIZ3, question.getQuestion());
        cv.put(QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION1_QUIZ3, question.getOption1());
        cv.put(QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION2_QUIZ3, question.getOption2());
        cv.put(QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION3_QUIZ3, question.getOption3());
        cv.put(QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION4_QUIZ3, question.getOption4());
        cv.put(QuizContract.QuestionsTableQUIZ3.COLUMN_ANSWER_NR_QUIZ3, question.getAnswerNr());

        db.insert(QuizContract.QuestionsTableQUIZ3.TABLE_NAME_QUIZ3, null, cv);

    }

    /*================================= getAllQuestion ========================================================== */

    List<Question> getAllQuestionQUIZ3()
    {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTableQUIZ1.TABLE_NAME_QUIZ1,null);

        if (c.moveToFirst())
        {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ3.COLUMN_QUESTION_QUIZ3)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION1_QUIZ3)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION2_QUIZ3)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION3_QUIZ3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ3.COLUMN_OPTION4_QUIZ3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTableQUIZ3.COLUMN_ANSWER_NR_QUIZ3)));
                questionList.add(question);
            }
            while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}