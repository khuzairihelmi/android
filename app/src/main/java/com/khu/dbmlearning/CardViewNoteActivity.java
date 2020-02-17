package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CardViewNoteActivity extends AppCompatActivity {

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_note);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Notes");
    }

    public void chapter1(View view) {
        startActivity(new Intent(this, noteChapter1Activity.class));
    }

    public void chapter2(View view) {
        startActivity(new Intent(this, noteChapter2Activity.class));
    }

    public void chapter3(View view) {
        startActivity(new Intent(this, noteChapter3Activity.class));
    }

    public void chapter4(View view) {
        startActivity(new Intent(this, noteChapter4Activity.class));
    }

    public void chapter5(View view) {
        startActivity(new Intent(this, noteChapter5Activity.class));
    }
}
