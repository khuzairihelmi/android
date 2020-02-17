package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Chapter2_1Activity extends AppCompatActivity {

    PDFView pdfView;

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String getItem = getIntent().getStringExtra("pdfFileName");

        if (getItem.equals("Introduction to Database and RDBMS")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("intro.pdf").load();
            getSupportActionBar().setTitle("Introduction to Database and RDBMS");
        }

        if (getItem.equals("Primary Key And Foreign Key")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("pk&fk.pdf").load();
            getSupportActionBar().setTitle("Primary Key And Foreign Key");
        }


        if (getItem.equals("Terminology Relational Model")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("terminology.pdf").load();
            getSupportActionBar().setTitle("Terminology Relational Model");
        }

        if (getItem.equals("Relational Scheme")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("scheme.pdf").load();
            getSupportActionBar().setTitle("Relational Scheme");
        }

        if (getItem.equals("Intergrity Rules")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("intergrity.pdf").load();
            getSupportActionBar().setTitle("Intergrity Rules");
        }

        if (getItem.equals("Join Operational Of Algebra")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("CHAPTER_2(RELATIONAL_ALGEBRA).pdf").load();
            getSupportActionBar().setTitle("Join Operational Of Algebra");
        }
    }
}
