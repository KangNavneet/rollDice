package com.navneetkang.dice_rolling;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg,timesDiceRoll;
    RadioButton dice4,dice6,dice8,dice10,dice12,dice20,diceCustom;
    int[] diceRoll;
    ImageView diceImage,diceImageTwice;
    int random,rollTimes;
    EditText customDice;
    Button customDiceRollBtn,rollDice;
    MediaPlayer mp;
    TextView diceOne,diceTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dice4=findViewById(R.id.dice4);
        dice6=findViewById(R.id.dice6);
        dice8=findViewById(R.id.dice8);
        dice10=findViewById(R.id.dice10);
        dice12=findViewById(R.id.dice12);
        dice20=findViewById(R.id.dice20);
        diceImage=findViewById(R.id.showDiceImage);
        diceImageTwice=findViewById(R.id.showDiceImageTwice);
        rg=findViewById(R.id.diceSelect);
        customDice=findViewById(R.id.customiseDice);
        diceCustom=findViewById(R.id.diceCustom);
        customDiceRollBtn=findViewById(R.id.rollCustomDice);
        rollDice=findViewById(R.id.rollDice);
        timesDiceRoll=findViewById(R.id.timesDiceRoll);
        diceOne=findViewById(R.id.diceOne);
        diceTwo=findViewById(R.id.diceTwo);




        diceRoll= new int[]{R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6, R.drawable.dice7, R.drawable.dice8, R.drawable.dice9, R.drawable.dice10,

                R.drawable.dice11, R.drawable.dice12, R.drawable.dice13, R.drawable.dice14, R.drawable.dice15, R.drawable.dice16, R.drawable.dice17, R.drawable.dice18, R.drawable.dice19, R.drawable.dice20,
                R.drawable.dice21, R.drawable.dice22, R.drawable.dice23, R.drawable.dice24, R.drawable.dice25

        };


        customDiceRollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    int value=Integer.parseInt(customDice.getText().toString());

                    if(value<=25)
                    {
                        timesDiceRoll();
                        random=(int)(Math.floor(Math.random() * value) + 1)  ;

                        diceImage.setImageResource(diceRoll[random-1]);
                        diceOne.setText(random+"");


                        if(rollTimes==2)
                        {
                            diceImageTwice.setVisibility(View.VISIBLE);
                            diceTwo.setVisibility(View.VISIBLE);

                            random=(int)(Math.floor(Math.random() * value) + 1)  ;
                            diceImageTwice.setImageResource(diceRoll[random-1]);
                            diceTwo.setText(random+"");

                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Number Of Sides Must Be Equal To 25 Or Less",Toast.LENGTH_SHORT).show();

                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Enter Number of Sides in Integer Format",Toast.LENGTH_SHORT).show();
                }




            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                customDiceRollBtn.setVisibility(View.GONE);
                customDice.setVisibility(View.GONE);
                rollDice.setVisibility(View.VISIBLE);
            }
        });







    }


    public void buttonClick()
    {
        mp=MediaPlayer.create(getApplicationContext(),R.raw.button_press);
        mp.start();
    }
     public void timesDiceRoll()
     {
         int dice=timesDiceRoll.getCheckedRadioButtonId();
         switch(dice)
         {
             case R.id.once:
                 rollTimes=1;
                 break;
             case R.id.twice:
                 rollTimes=2;
                 break;

         }
     }


    public void rollDice(View view) {
        buttonClick();
        timesDiceRoll();
        int dice=rg.getCheckedRadioButtonId();
        switch(dice)
        {

            case R.id.dice4:

                diceImageTwice.setVisibility(View.GONE);
                diceTwo.setVisibility(View.GONE);
                random=(int)(Math.floor(Math.random() * 4) + 1)  ;
               // Toast.makeText(getApplicationContext(),random+"",Toast.LENGTH_SHORT).show();
                diceImage.setImageResource(diceRoll[random-1]);
                diceOne.setText(random+"");
                if(rollTimes==2)
                {
                    diceImageTwice.setVisibility(View.VISIBLE);
                    diceTwo.setVisibility(View.VISIBLE);
                    random=(int)(Math.floor(Math.random() * 4) + 1)  ;
                    diceImageTwice.setImageResource(diceRoll[random-1]);
                    diceTwo.setText(random+"");

                }

                break;


            case R.id.dice6:
                diceImageTwice.setVisibility(View.GONE);
                diceTwo.setVisibility(View.GONE);

                random=(int)(Math.floor(Math.random() * 6) + 1)  ;
                diceImage.setImageResource(diceRoll[random-1]);
                diceOne.setText(random+"");

                if(rollTimes==2)
                {
                    diceImageTwice.setVisibility(View.VISIBLE);
                    diceTwo.setVisibility(View.VISIBLE);
                    random=(int)(Math.floor(Math.random() * 6) + 1)  ;
                    diceImageTwice.setImageResource(diceRoll[random-1]);
                    diceTwo.setText(random+"");

                }
                break;


            case R.id.dice8:
                diceImageTwice.setVisibility(View.GONE);
                diceTwo.setVisibility(View.GONE);
                //Toast.makeText(getApplicationContext(),"Dice 8",Toast.LENGTH_SHORT).show();
                random=(int)(Math.floor(Math.random() * 8) + 1)  ;
                //Toast.makeText(getApplicationContext(),random+"",Toast.LENGTH_SHORT).show();
                diceImage.setImageResource(diceRoll[random-1]);
                diceOne.setText(random+"");


                if(rollTimes==2)
                {
                    diceImageTwice.setVisibility(View.VISIBLE);
                    diceTwo.setVisibility(View.VISIBLE);
                    random=(int)(Math.floor(Math.random() * 8) + 1)  ;
                    diceImageTwice.setImageResource(diceRoll[random-1]);
                    diceTwo.setText(random+"");

                }
                break;

            case R.id.dice10:
                diceImageTwice.setVisibility(View.GONE);
                diceTwo.setVisibility(View.GONE);
                //Toast.makeText(getApplicationContext(),"Dice 10",Toast.LENGTH_SHORT).show();
                random=(int)(Math.floor(Math.random() * 10) + 1)  ;
                //Toast.makeText(getApplicationContext(),random+"",Toast.LENGTH_SHORT).show();
                diceImage.setImageResource(diceRoll[random-1]);
                diceOne.setText(random+"");



                if(rollTimes==2)
                {
                    diceImageTwice.setVisibility(View.VISIBLE);
                    diceTwo.setVisibility(View.VISIBLE);
                    random=(int)(Math.floor(Math.random() * 10) + 1)  ;
                    diceImageTwice.setImageResource(diceRoll[random-1]);
                    diceTwo.setText(random+"");

                }
                break;

            case R.id.dice12:
                diceImageTwice.setVisibility(View.GONE);
                diceTwo.setVisibility(View.GONE);
                random=(int)(Math.floor(Math.random() * 12) + 1)  ;
                diceImage.setImageResource(diceRoll[random-1]);
                diceOne.setText(random+"");


                if(rollTimes==2)
                {
                    diceImageTwice.setVisibility(View.VISIBLE);
                    diceTwo.setVisibility(View.VISIBLE);
                    random=(int)(Math.floor(Math.random() * 12) + 1)  ;
                    diceImageTwice.setImageResource(diceRoll[random-1]);
                    diceTwo.setText(random+"");

                }
                break;

            case R.id.dice20:
                diceImageTwice.setVisibility(View.GONE);
                diceTwo.setVisibility(View.GONE);
                random=(int)(Math.floor(Math.random() * 20) + 1)  ;
                diceImage.setImageResource(diceRoll[random-1]);
                diceOne.setText(random+"");

                if(rollTimes==2)
                {
                    diceImageTwice.setVisibility(View.VISIBLE);
                    diceTwo.setVisibility(View.VISIBLE);
                    random=(int)(Math.floor(Math.random() * 20) + 1)  ;
                    diceImageTwice.setImageResource(diceRoll[random-1]);
                    diceTwo.setText(random+"");

                }
                break;

            case R.id.diceCustom:
                diceImageTwice.setVisibility(View.GONE);
                diceTwo.setVisibility(View.GONE);
                customDice.setVisibility(View.VISIBLE);
                customDiceRollBtn.setVisibility(View.VISIBLE);
                rollDice.setVisibility(View.GONE);


        }


    }
}