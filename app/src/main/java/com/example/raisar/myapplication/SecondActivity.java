package com.example.raisar.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button bStartFirsActivity = (Button) findViewById(R.id.buttonFirsActivity);
        bStartFirsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startFirstActivityIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(startFirstActivityIntent);
                finish();
            }
        });
    }
}
