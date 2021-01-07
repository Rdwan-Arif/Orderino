package com.example.orderino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Meatmenu extends AppCompatActivity {


    ImageButton Addmeantburger , Removemeatburger  ,  AddSteakSandwich , RemoveSteakSandwich , AddtoCart;

    EditText meatburgercounter , SteakSandwhichcounter;

    int  beefburger=0 , SteakSandwich = 0;

    Button tochicken,todrinks,tocart,meatset;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meatmenu);

        meatset = findViewById(R.id.settings);

        meatset.setOnClickListener(new View.OnClickListener() {
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




    //beef burger
        meatburgercounter=findViewById(R.id.meatburgercounter);
        Addmeantburger=findViewById(R.id.Addmeantburger);
        Removemeatburger=findViewById(R.id.Removemeatburger);


        meatburgercounter.setText(Integer.toString(beefburger));





        tochicken=findViewById(R.id.tochicken);


        tochicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent startIntent = new Intent(getApplicationContext(), ChickenMenu.class);

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

                overridePendingTransition(R.anim.righttoleft,R.anim.lefttoright);
            }
        });





        Addmeantburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beefburger++;
                meatburgercounter.setText(Integer.toString(beefburger));



            }
        });

        Removemeatburger.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(beefburger == 0){
                    Toast.makeText(Meatmenu.this, "cant remove as item is at 0", Toast.LENGTH_SHORT).show();
                }else {

                    beefburger--;
                    meatburgercounter.setText(Integer.toString(beefburger));
                }
            }
        });


//---------------------------------------------------------------------


        //Steak Sandwhich


        SteakSandwhichcounter=findViewById(R.id.SteakSandwhichcounter);
        AddSteakSandwich=findViewById(R.id.AddSteakSandwich);
        RemoveSteakSandwich=findViewById(R.id.RemoveSteakSandwich);


        SteakSandwhichcounter.setText(Integer.toString(SteakSandwich));




        AddSteakSandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SteakSandwich++;
                SteakSandwhichcounter.setText(Integer.toString(SteakSandwich));



            }
        });

        RemoveSteakSandwich.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(SteakSandwich == 0){
                    Toast.makeText(Meatmenu.this, "cant remove as item is at 0", Toast.LENGTH_SHORT).show();
                }else {

                    SteakSandwich--;
                    SteakSandwhichcounter.setText(Integer.toString(SteakSandwich));
                }
            }
        });

//---------------------------------------------------------------------------
        //cart

        AddtoCart=findViewById(R.id.AddtoCart);

        AddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beefburger==0 && SteakSandwich ==0){
                    Toast.makeText(Meatmenu.this,"Please add items " , Toast.LENGTH_SHORT).show();
                }
                else {
                    cart myCart = cart.getCart();

                    myCart.addLittleCheesar(beefburger);
                    myCart.addHeartAttack(SteakSandwich);


                    Toast.makeText(Meatmenu.this, "Items are added to the cart", Toast.LENGTH_SHORT).show();


                    SteakSandwich = 0;
                    beefburger = 0;

                    SteakSandwhichcounter.setText(Integer.toString(SteakSandwich));
                    meatburgercounter.setText(Integer.toString(beefburger));

                }
            }
        });





    }
}
