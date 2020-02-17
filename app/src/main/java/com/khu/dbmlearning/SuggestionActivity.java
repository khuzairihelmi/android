package com.khu.dbmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SuggestionActivity extends AppCompatActivity {

    EditText etTo,etSubject,etMessage;
    TextView tvinfo;
    Button btnSend;


    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvinfo = findViewById(R.id.tvinfo);
        etTo = findViewById(R.id.et_to);
        etMessage = findViewById(R.id.et_message);
        etSubject = findViewById(R.id.et_subject);
        btnSend = (Button)findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto: khuzairihelmi99@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT,etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
                startActivity(intent);
            }
        });
    }
}
