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

public class ChickenMenu extends AppCompatActivity {



    ImageButton Addchickenburger , Removechickenburger  ,  AddTinder , RemoveTinder , AddtoCartChick;

    EditText chickenburgercounter , Tinderscounter;

    Button tobeef,todrinks,tocart,sett;

    int  chickenburger=0 , Tinder = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_menu);





        sett = findViewById(R.id.setings);

        sett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), tets.class);

                startActivity(startIntent);
            }
        });





        tocart=findViewById(R.id.tocart);


        tocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent(getApplicationContext(), fishmenu.class);

                startActivity(startIntent);

                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
            }
        });




        //Chicken burger
        chickenburgercounter=findViewById(R.id.ChickenBurgerCounter);
        Addchickenburger=findViewById(R.id.AddChickenBurger);
        Removechickenburger=findViewById(R.id.RemoveChickenBurger);


        tobeef=findViewById(R.id.tobeef);

        tobeef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                Intent startIntent = new Intent(getApplicationContext(), Meatmenu.class);

                startActivity(startIntent);

                overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
            }
        });




        todrinks=findViewById(R.id.todrinks);


        todrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent startIntent = new Intent(getApplicationContext(), Drinksmenu.class);

                startActivity(startIntent);


                overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
            }
        });



        chickenburgercounter.setText(Integer.toString(chickenburger));




        Addchickenburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chickenburger++;
                chickenburgercounter.setText(Integer.toString(chickenburger));



            }
        });

        Removechickenburger.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(chickenburger == 0){
                    Toast.makeText(ChickenMenu.this, "cant remove as item is at 0", Toast.LENGTH_SHORT).show();
                }else {

                    chickenburger--;
                    chickenburgercounter.setText(Integer.toString(chickenburger));
                }
            }
        });

//---------------------------------------------------------------------




        //Tinders


        Tinderscounter=findViewById(R.id.TindersCounter);
        AddTinder=findViewById(R.id.AddTinders);
        RemoveTinder=findViewById(R.id.removeTinders);


        Tinderscounter.setText(Integer.toString(Tinder));




        AddTinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tinder++;
                Tinderscounter.setText(Integer.toString(Tinder));



            }
        });

        RemoveTinder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(Tinder == 0){
                    Toast.makeText(ChickenMenu.this, "cant remove as item is at 0", Toast.LENGTH_SHORT).show();
                }else {

                    Tinder--;
                    Tinderscounter.setText(Integer.toString(Tinder));
                }
            }
        });

//---------------------------------------------------------------------------

        AddtoCartChick=findViewById(R.id.addtoCartchick);

        AddtoCartChick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chickenburger==0 && Tinder ==0){
                    Toast.makeText(ChickenMenu.this,"Please add items " , Toast.LENGTH_SHORT).show();
                }
                else {
                    cart myCart = cart.getCart();

                    myCart.addChickenLittle(chickenburger);
                    myCart.addGrandChicken(Tinder);


                    Toast.makeText(ChickenMenu.this, "Items are added to the cart", Toast.LENGTH_SHORT).show();


                    chickenburger = 0;
                    Tinder = 0;

                    Tinderscounter.setText(Integer.toString(chickenburger));
                    chickenburgercounter.setText(Integer.toString(Tinder));
                }

            }
        });


    }
}
