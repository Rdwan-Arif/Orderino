package com.example.orderino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Endscreen extends AppCompatActivity {

    TextView num;
Button fin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endscreen);


        num=findViewById(R.id.number);


        int i=(int)Math.abs(Math.random()*100);


        num.setText(Integer.toString(i));



        fin = findViewById(R.id.fin);


        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(startIntent);
            }
        });
    }
}
