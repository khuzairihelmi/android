package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Chapter5_1Activity extends AppCompatActivity {

    PDFView pdfView;

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter5_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String getItem = getIntent().getStringExtra("pdfFileName");

        if (getItem.equals("Transaction and ACID")){
            pdfView = (PDFView)findViewById(R.id.pdfView);
            pdfView.fromAsset("chapter5_database_transaction.pdf").load();
            getSupportActionBar().setTitle("Transaction and ACID");
        }
    }
}