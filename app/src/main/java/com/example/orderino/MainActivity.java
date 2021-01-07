package com.example.orderino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button i;
    ImageButton lol;
    ImageButton lol2;
    ImageButton lol3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            lol= findViewById(R.id.goMenu);
            lol2=findViewById(R.id.Login);
            lol3=findViewById(R.id.Regbutton);


           // Animation anime= AnimationUtils.loadAnimation(MainActivity.this,R.anim.blink_anim);
        Animation anime2= AnimationUtils.loadAnimation(MainActivity.this,R.anim.bounce);
           // lol.startAnimation(anime);

            lol.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {


                    Intent startIntent = new Intent(getApplicationContext(), ChickenMenu.class);

                    startActivity(startIntent);

                }

                                   }


            );

//        lol2.startAnimation(anime2);
//
//            lol2.setOnClickListener(new View.OnClickListener() {
//
//
//                                        @Override
//                                        public void onClick(View v) {
//
//
//                                            Intent startIntent = new Intent(getApplicationContext(), Login.class);
//
//                                            startActivity(startIntent);
//
//                                        }
//
//                                    }
//
//
//
//            );



        lol3.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        Intent startIntent = new Intent(getApplicationContext(), Reg.class);

                                        startActivity(startIntent);

                                    }
                                }


        );

        i= findViewById(R.id.sett);

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent(getApplicationContext(), tets.class);

                startActivity(startIntent);

            }
        });


    }
}

