package com.example.orderino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Drinksmenu extends AppCompatActivity {

    ImageButton Addcola , removecola  , Addpepsi, Removepepsi, addtoCart4,addfries,removefries,addbigfries,removebigfries;

    EditText Colacounter , Pepsicounter,friescounter,bigfriescounter;



    int Cola =0 , pepsi = 0,fries=0, bigfries=0;




    Button tobeef,tochicken,tocart,settings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinksmenu);



        settings = findViewById(R.id.drinkset);

        settings.setOnClickListener(new View.OnClickListener() {
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



        bigfriescounter=findViewById(R.id.bigfriescounter);
        addbigfries=findViewById(R.id.addbigfries);

        removebigfries=findViewById(R.id.removebigfries);


        bigfriescounter.setText(Integer.toString(bigfries));




        addbigfries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigfries++;
                bigfriescounter.setText(Integer.toString(bigfries));



            }
        });

        removebigfries.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(bigfries == 0){
                    Toast.makeText(Drinksmenu.this, "cant remove as item is at 0", Toast.LENGTH_SHORT).show();
                }else {

                    bigfries--;
                    bigfriescounter.setText(Integer.toString(bigfries));
                }
            }
        });


        //====================================================
        friescounter=findViewById(R.id.friescounter);
        addfries=findViewById(R.id.addfries);

        removefries=findViewById(R.id.removefries);


        friescounter.setText(Integer.toString(fries));




        addfries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fries++;
                friescounter.setText(Integer.toString(fries));



            }
        });

        removefries.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(fries == 0){
                    Toast.makeText(Drinksmenu.this, "cant remove as item is at 0", Toast.LENGTH_SHORT).show();
                }else {

                    fries--;
                    friescounter.setText(Integer.toString(fries));
                }
            }
        });


//=========================================================================









        tobeef=findViewById(R.id.tobeef);

        tobeef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent(getApplicationContext(), Meatmenu.class);

                startActivity(startIntent);
                overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
            }
        });







        tochicken=findViewById(R.id.tochicken);


        tochicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent startIntent = new Intent(getApplicationContext(), ChickenMenu.class);

                startActivity(startIntent);
                overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
            }
        });














        //beef burger
            Colacounter=findViewById(R.id.colacounter);
            Addcola=findViewById(R.id.Addcola);

            removecola=findViewById(R.id.Removecola);


            Colacounter.setText(Integer.toString(Cola));




            Addcola.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cola++;
                    Colacounter.setText(Integer.toString(Cola));



                }
            });

            removecola.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(Cola == 0){
                        Toast.makeText(Drinksmenu.this, "cant remove as item is at 0", Toast.LENGTH_SHORT).show();
                    }else {

                        Cola--;
                        Colacounter.setText(Integer.toString(Cola));
                    }
                }
            });


//---------------------------------------------------------------------


            //Steak Sandwhich


            Pepsicounter =findViewById(R.id.pepsicounter);
            Addpepsi =findViewById(R.id.addpepsi);
            Removepepsi =findViewById(R.id.removepepsi);


            Pepsicounter.setText(Integer.toString(pepsi));




            Addpepsi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pepsi++;
                    Pepsicounter.setText(Integer.toString(pepsi));



                }
            });

            Removepepsi.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(pepsi == 0){
                        Toast.makeText(Drinksmenu.this, "cant remove as item is at 0", Toast.LENGTH_SHORT).show();
                    }else {

                        pepsi--;
                        Pepsicounter.setText(Integer.toString(pepsi));
                    }
                }
            });

//---------------------------------------------------------------------------
            //cart

            addtoCart4 =findViewById(R.id.addtoCart4);

            addtoCart4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Cola ==0 && pepsi ==0 && fries ==0 && bigfries==0){
                        Toast.makeText(Drinksmenu.this,"Please add items " , Toast.LENGTH_SHORT).show();
                    }
                    else {

                        cart myCart = cart.getCart();

                        myCart.addFries(fries);
                        myCart.addDrink(pepsi);
                        myCart.addGrandDrink(Cola);
                        myCart.addGrandFries(bigfries);

                        Toast.makeText(Drinksmenu.this, "Items are added to the cart", Toast.LENGTH_SHORT).show();


                        pepsi = 0;
                        Cola = 0;
                        fries=0;
                        bigfries=0;

                        Pepsicounter.setText(Integer.toString(pepsi));
                        Colacounter.setText(Integer.toString(Cola));
                        friescounter.setText(Integer.toString(fries));
                        bigfriescounter.setText(Integer.toString(bigfries));


                    }

                }
            });





        }


    }


