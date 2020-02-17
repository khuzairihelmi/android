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

public class noteChapter3Activity extends AppCompatActivity {
    ListView pdflistView;

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_chapter3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chapter 3");

        pdflistView = (ListView)findViewById(R.id.PDFList);
        pdflistView = (ListView)findViewById(R.id.PDFList);

        String[] pdfFiles = {"Normalization","Entity Relationship Diagram (ERD)"};

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

                Intent start = new Intent(getApplicationContext(), Chapter3_1Activity.class);
                start.putExtra("pdfFileName",item);
                startActivity(start);
            }
        });






    }
}
