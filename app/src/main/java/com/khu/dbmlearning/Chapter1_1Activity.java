package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Chapter1_1Activity extends AppCompatActivity {

    PDFView pdfView;

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String getItem = getIntent().getStringExtra("pdfFileName");

        if (getItem.equals("Understand Database")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("CHAPTER1_UNDERSTAND.pdf").load();
            getSupportActionBar().setTitle("Understand Database");
        }

        if (getItem.equals("Evolution of Database")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("CHAPTER1_EVOLUTION.pdf").load();
            getSupportActionBar().setTitle("Evolution of Database");
        }


        if (getItem.equals("Database Development Process")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("CHAPTER1_DEVELOPMENT.pdf").load();
            getSupportActionBar().setTitle("Database Development Process");
        }

        if (getItem.equals("Properties of Database")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("CHAPTER1_PROPERTIES.pdf").load();
            getSupportActionBar().setTitle("Properties of Database");
        }

        if (getItem.equals("Database Management System (DBMS)")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("CHAPTER1_DBMS.pdf").load();
            getSupportActionBar().setTitle("Database Management System (DBMS)");
        }

        if (getItem.equals("Data Model")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("CHAPTER1_DataModel.pdf").load();
            getSupportActionBar().setTitle("Data Model");
        }

        if (getItem.equals("Three Scheme Architecture of DBMS")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("CHAPTER1_3Shame.pdf").load();
            getSupportActionBar().setTitle("Three Scheme Architecture of DBMS");
        }
    }
}
