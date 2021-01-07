package com.example.orderino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Restock extends AppCompatActivity {
    TextView Counterbeef;
    TextView Chickencounter,FishCounter,Drinkscounter, chickenPrice, beefPrice, vegPrice, drinksPrice;
    int beefStock=0,Chickenstock=0,FishStock=0,DrinksStock=0;
    ImageButton restockmeat ;
    ImageButton restockChicken,Fishrestock,DrinksRestock,MenuRestock;



    Button sett;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_stcok);


        Counterbeef =findViewById(R.id.Counterbeef);
        restockmeat=findViewById(R.id.restockmeat);
        Counterbeef.setText(Integer.toString(beefStock));


        Chickencounter =findViewById(R.id.Chickencounter);
        restockChicken=findViewById(R.id.restockChicken);
        Chickencounter.setText(Integer.toString(Chickenstock));




        FishCounter =findViewById(R.id.FishCounter);
        Fishrestock=findViewById(R.id.Fishrestock);
        FishCounter.setText(Integer.toString(FishStock));


        Drinkscounter =findViewById(R.id.Drinkscounter);
        DrinksRestock=findViewById(R.id.DrinksRestock);
        Drinkscounter.setText(Integer.toString(DrinksStock));




        chickenPrice= findViewById(R.id.chickinPrice);
        beefPrice= findViewById(R.id.beefPrice);
        vegPrice= findViewById(R.id.vegPrice);
        drinksPrice = findViewById(R.id.drinksPrice);



        stock myStock = stock.getStock();


        Chickencounter.setText(myStock.chickenStock+" out of 100");
        chickenPrice.setText(myStock.chickenPrice() + " sar");

        Counterbeef.setText(myStock.beefStock+" out of 100");
        beefPrice.setText(myStock.beefPrice() + " sar");

        FishCounter.setText(myStock.vegitableStock+" out of 100");
        vegPrice.setText(myStock.vegitablesPrice() + " sar");

        Drinkscounter.setText(myStock.drinksStock+" out of 100");
        drinksPrice.setText(myStock.drinksPrice() + " sar");

















        restockmeat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                stock myStock = stock.getStock();
                if(myStock.beefStock == 100){
                    Toast.makeText(Restock.this,"Beef is Fully stocked",Toast.LENGTH_SHORT).show();
                }else {
                    myStock.restockBeef();
                    Counterbeef.setText(myStock.beefStock+" out of 100");
                    beefPrice.setText(myStock.beefPrice() + " sar");
                }


        }}

        );

        restockChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stock myStock = stock.getStock();
                if(myStock.chickenStock == 100){
                    Toast.makeText(Restock.this,"Chicken is Fully stocked",Toast.LENGTH_SHORT).show();
                }else {
                    myStock.restockChicken();
                    Chickencounter.setText(myStock.chickenStock+" out of 100");
                    chickenPrice.setText(myStock.chickenPrice() + " sar");
                }



            }
        });


        Fishrestock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stock myStock = stock.getStock();
                if(myStock.vegitableStock == 100){
                    Toast.makeText(Restock.this,"Vegetables are Fully stocked",Toast.LENGTH_SHORT).show();
                }else {
                    myStock.restockVegitables();
                    FishCounter.setText(myStock.vegitableStock+" out of 100");
                    vegPrice.setText(myStock.vegitablesPrice() + " sar");
                }



            }
        });



        DrinksRestock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stock myStock = stock.getStock();
                if(myStock.drinksStock == 100){
                    Toast.makeText(Restock.this,"Drinks are Fully stocked",Toast.LENGTH_SHORT).show();
                }else {
                    myStock.restockDrinks();
                    Drinkscounter.setText(myStock.drinksStock+" out of 100");
                    drinksPrice.setText(myStock.drinksPrice() + " sar");
                }



            }
        });



        sett=findViewById(R.id.sett);
        sett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), tets.class);

                startActivity(startIntent);
            }
        });






    }


}
class stock{

    private static stock myStock = null;

    private stock(){}

    public static stock getStock(){

        if(myStock == null){
            myStock = new stock();
        }
        return myStock;
    }

    int chickenStock = 100;
    int beefStock = 100;
    int vegitableStock = 100;
    int drinksStock = 100;

    public void restockChicken(){chickenStock = 100;}
    public void restockBeef(){beefStock = 100;}
    public void restockVegitables(){vegitableStock = 100;}
    public void restockDrinks(){drinksStock = 100;}

    public int chickenPrice(){return((100 - chickenStock) * 3);}
    public int beefPrice(){return((100 - beefStock) * 4);}
    public int vegitablesPrice(){return((100 - vegitableStock) * 1);}
    public int drinksPrice(){return((100 - drinksStock) * 2);}

    public void addChickenLittle(int n){
        chickenStock = chickenStock - n;
        vegitableStock = vegitableStock - n;
    }
    public void addGrandChicken(int n){
        chickenStock = chickenStock - (n * 2);
        vegitableStock = vegitableStock - (n * 2);
    }
    public void addLittleCheesar(int n){
        beefStock = beefStock - n;
        vegitableStock = vegitableStock - n;
    }
    public void addHeartAttack(int n){
        beefStock = beefStock - (n * 2);
        vegitableStock = vegitableStock - (n * 2);
    }
    public void addFries(int n){
        vegitableStock = vegitableStock - n;
    }
    public void addGrandFries(int n){
        vegitableStock = vegitableStock - (n * 2);
    }
    public void addDrink(int n){
        drinksStock = drinksStock - n;
    }
    public void addGrandDrink(int n){
        drinksStock = drinksStock - (n * 2);
    }

}


