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

public class noteChapter2Activity extends AppCompatActivity {

    ListView pdflistView;

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_chapter2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chapter 2");

        pdflistView = (ListView)findViewById(R.id.PDFList);
        pdflistView = (ListView)findViewById(R.id.PDFList);

        String[] pdfFiles = {"Introduction to Database and RDBMS","Primary Key And Foreign Key","Terminology Relational Model","Relational Scheme","Intergrity Rules","Join Operational Of Algebra"};

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

                Intent start = new Intent(getApplicationContext(), Chapter2_1Activity.class);
                start.putExtra("pdfFileName",item);
                startActivity(start);
            }
        });
    }
}



