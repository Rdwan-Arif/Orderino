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

public class fishmenu extends AppCompatActivity {

    ImageButton AddFishburger , RemoveFishburger  ,  Addfishandchips , Removefishandchips , addtoCart3;

    EditText Fishburgercounter , fishandchipscounter;

    int Fishburger =0 , fishandchips = 0;
TextView t;
Button r,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishmenu);


        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent startIntent = new Intent(getApplicationContext(), ChickenMenu.class);

                startActivity(startIntent);

            }
        });


        t = findViewById(R.id.fin);


        final cart myCart = cart.getCart();

         final String printout = myCart.display();



        t.setText(printout);

        r = findViewById(R.id.Res);



        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCart.reset();



                String printout = null;


                t.setText(null);

            }
        });


        addtoCart3=findViewById(R.id.addtoCart3);

        addtoCart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart myCart = cart.getCart();

                if(true){

                if(printout.isEmpty()){

                    Toast.makeText(fishmenu.this,"please add items",Toast.LENGTH_SHORT).show();
                }


                if(!printout.isEmpty()){


                    if(myCart.cheakStock().equalsIgnoreCase("all ok")){
                        myCart.reset();

                    Intent startIntent = new Intent(getApplicationContext(), Endscreen.class);

                        t.setText(printout);
                    startActivity(startIntent);

                }else{
                        Toast.makeText(fishmenu.this,myCart.cheakStock(),Toast.LENGTH_SHORT).show();
                    }}
            }}
        });







    }
}

class cart{

    private static cart myCart = null;

    private cart(){}

    public static cart getCart(){

        if(myCart == null){
            myCart = new cart();
        }
        return myCart;
    }


    int chickenLittle = 0;
    int grandChicken = 0;

    int littleCheesar = 0;
    int heartAttack = 0;

    int fries = 0;
    int grandFries = 0;
    int drink = 0;
    int grandDrink = 0;

    public void reset(){
        chickenLittle = 0;
        grandChicken = 0;
        littleCheesar = 0;
        heartAttack = 0;
        fries = 0;
        grandFries = 0;
        drink = 0;
        grandDrink = 0;
    }

    public void addChickenLittle(int n){
        chickenLittle = chickenLittle + n;
    }
    public void addGrandChicken(int n){
        grandChicken = grandChicken + n;
    }
    public void addLittleCheesar(int n){
        littleCheesar = littleCheesar + n;
    }
    public void addHeartAttack(int n){
        heartAttack = heartAttack + n;
    }
    public void addFries(int n){
        fries = fries + n;
    }
    public void addGrandFries(int n){
        grandChicken = grandChicken + n;
    }
    public void addDrink(int n){
        drink = drink + n;
    }
    public void addGrandDrink(int n){
        grandDrink = grandDrink + n;
    }

    public String display(){

        String bill = "";

        if(chickenLittle > 0){
            String cl = (chickenLittle + "x   Chicken Little            "+ (chickenLittle* 12)+"  sar\n");
            bill = bill + cl;
        }if(grandChicken > 0){
            String gc = (grandChicken +  "x   Grand Chicken          "+ (grandChicken* 16)+"  sar\n");
            bill = bill + gc;
        }if(littleCheesar > 0){
            String lc = (littleCheesar + "x   Little Cheesar            "+ (littleCheesar* 17)+"  sar\n");
            bill = bill + lc;
        }if(heartAttack > 0){
            String ha = (heartAttack +   "x   Heart Attack             "+ (heartAttack* 25)+"  sar\n");
            bill = bill + ha;
        }if(fries > 0){
            String f = (fries +          "x   Fries                           "+ (fries* 5)+"  sar\n");
            bill = bill + f;
        }if(grandFries > 0){
            String gf = (grandFries +    "x   Grand Fries               "+ (grandFries* 8)+"  sar\n");
            bill = bill + gf;
        }if(drink > 0){
            String d = (drink +          "x   Drink                          "+ (drink* 3)+"  sar\n");
            bill = bill + d;
        }if(grandDrink > 0){
            String gd = (grandDrink +    "x   Grand Drink               "+ (grandDrink* 6)+"  sar\n");
            bill = bill + gd;
        }

        int totalNum = (chickenLittle* 12) + (grandChicken* 16) + (littleCheesar* 17) + (heartAttack* 25) + (fries* 5) + (grandFries* 8) + (drink* 3) + (grandDrink* 6);

        if(totalNum > 0) {
            String line = "______________________________________\n";
            bill = bill + line;
            String total = " Total :                            " + totalNum + "  sar";
            bill = bill + total;
        }else{bill = bill  ;}

        return bill;
    }


    public String cheakStock(){
        boolean available = true;

        stock myStock = stock.getStock();

        int c = chickenLittle + (2 * grandChicken);
        int b = littleCheesar + (2 * heartAttack);
        int v = chickenLittle + (2 * grandChicken) + littleCheesar + (2 * heartAttack) + fries + (2 * grandFries);
        int d = drink + grandDrink;

        if(c > myStock.chickenStock && v > myStock.vegitableStock){
            return "we apologize we have run out of Chicken and Vegetables";
        }
        if(c > myStock.beefStock && v > myStock.vegitableStock){
            return "we apologize we have run out of Beef and Vegetables";
        }
        if(c > myStock.chickenStock){
            return "we apologize we have run out of Chicken";
        }
        if(b > myStock.beefStock){
            return "we apologize we have run out of Beef";
        }
        if(v > myStock.vegitableStock){
            return "we apologize we have run out of Vegetables";
        }
        if(d > myStock.drinksStock){
            return "we apologize we have run out of Drinks";
        }else{

            myStock.addChickenLittle(chickenLittle);
            myStock.addGrandChicken(grandChicken);
            myStock.addLittleCheesar(littleCheesar);
            myStock.addHeartAttack(heartAttack);
            myStock.addFries(fries);
            myStock.addGrandFries(grandFries);
            myStock.addDrink(drink);
            myStock.addGrandDrink(grandDrink);
            return "all ok";
        }


        }





}


