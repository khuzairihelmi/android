package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class noteChapter1Activity extends AppCompatActivity {

    ListView pdflistView;

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_chapter1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chapter 1");

        pdflistView = (ListView)findViewById(R.id.PDFList);

        String[] pdfFiles = {"Understand Database","Evolution of Database","Database Development Process","Properties of Database","Database Management System (DBMS)"
        ,"Data Model","Three Scheme Architecture of DBMS"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,pdfFiles){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView myText =  (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };

        pdflistView.setAdapter(adapter);

        pdflistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String item = pdflistView.getItemAtPosition(i).toString();

                Intent start = new Intent(getApplicationContext(), Chapter1_1Activity.class);
                start.putExtra("pdfFileName",item);
                startActivity(start);
            }
        });
    }
}