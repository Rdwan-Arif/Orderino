package com.example.orderino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    EditText Username,Password;

    ImageButton loginmenu;
    Button l;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        loginmenu= findViewById(R.id.gotoMenu2);


        Username =findViewById(R.id.Username);
        Password= findViewById(R.id.Password);









        loginmenu.setOnClickListener(new View.OnClickListener() {


                                         @Override
                                         public void onClick(View v) {



                if(Username.getText().toString().equalsIgnoreCase("admin")&&Password.getText().toString().equalsIgnoreCase("admin")){

                    Intent startIntent = new Intent(getApplicationContext(), Restock.class);

                    startActivity(startIntent);
                    Toast.makeText(Login.this,"Sign in is successfully done :D",Toast.LENGTH_SHORT).show();

                    Username.setText("");
                    Password.setText("");


                }else{

                    Toast.makeText(Login.this,"Error: User name or password is wrong",Toast.LENGTH_SHORT).show();

                }







            }
        }
        );




        l = findViewById(R.id.set);

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), tets.class);

                startActivity(startIntent);
            }
        });

    }
}

