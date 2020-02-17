package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Chapter3_1Activity extends AppCompatActivity {

    PDFView pdfView;

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter3_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String getItem = getIntent().getStringExtra("pdfFileName");

        if (getItem.equals("Normalization")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("CHAPTER3-NORMALIZATION(Part 2).pdf").load();
            getSupportActionBar().setTitle("Normalization");
        }

        if (getItem.equals("Entity Relationship Diagram (ERD)")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("CHAPTER3-ERD(Part 1).pdf").load();
            getSupportActionBar().setTitle("Entity Relationship Diagram (ERD)");
        }
    }
}