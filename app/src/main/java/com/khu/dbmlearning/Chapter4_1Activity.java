package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Chapter4_1Activity extends AppCompatActivity {

    PDFView pdfView;

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter4_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String getItem = getIntent().getStringExtra("pdfFileName");

        if (getItem.equals("MySQL and SQL commands")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("MySQL(Command).pdf").load();
            getSupportActionBar().setTitle("MySQL and SQL commands");
        }

        if (getItem.equals("Aggregate Function")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("Aggregate.pdf").load();
            getSupportActionBar().setTitle("Aggregate Function");
        }

        if (getItem.equals("Advance Commands")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("advance.pdf").load();
            getSupportActionBar().setTitle("Advance Commands");
        }
    }
}