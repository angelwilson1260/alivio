package com.cyboss.alivio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewsActivity extends AppCompatActivity {
Button add,nview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        add=(Button)findViewById(R.id.add);
        nview=(Button) findViewById(R.id.view);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NewsActivity.this,UploadActivity.class);
                startActivity(i);
            }
        });
        nview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NewsActivity.this,ItemsActivity.class);
                startActivity(i);
            }
        });
    }
}
