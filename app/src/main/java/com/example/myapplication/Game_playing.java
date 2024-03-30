package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Random;

public class Game_playing extends AppCompatActivity {
    TextView firstHint,result;//progressiveHint;
    EditText userInput;
    CardView firstCard,secondCard;
    Animation start,end,resultAnimation;
    Button Enter,backButton,restart;


    Random rand = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_playing);

        game1();




        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game_playing.this, MainActivity.class);
                startActivity(intent);
            }
        });

















    }
    public void game(){
        firstHint = findViewById(R.id.hint1);
        result = findViewById(R.id.result);
        //progressiveHint = findViewById(R.id.hint);
        userInput = findViewById(R.id.userInput);
        firstCard = findViewById(R.id.cardView);
        secondCard = findViewById(R.id.cardView3);
        backButton = findViewById(R.id.backButton);
        Enter = findViewById(R.id.Enter);
        restart = findViewById(R.id.restartbutton);
        start = AnimationUtils.loadAnimation(this, R.anim.new_game);
        end = AnimationUtils.loadAnimation(this,R.anim.end);
        resultAnimation=AnimationUtils.loadAnimation(this,R.anim.resultanimation);

        int randomNumber = rand.nextInt(100);


        firstCard.startAnimation(start);
        secondCard.startAnimation(start);


        game.game obj = new game.game();








        int[] tries = {2};

        int[] input= new int[1];
        firstHint.setText(obj.hint(randomNumber));

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    input[0] = Integer.parseInt(userInput.getText().toString());
                    //int i = 2;
                    if(input[0]==randomNumber){

                        result.setText("Boom! Nailed it! You've hit the jackpot with that guess! Awesome job!");
                        result.setAnimation(resultAnimation);
                        firstHint.setText("Hehe.. You Won");
                        firstHint.startAnimation(start);
                    }
                    else if(input[0]!=randomNumber && tries[0]==4){
                        result.setText(obj.hint(randomNumber,tries[0],input[0]));
                        result.setAnimation(resultAnimation);
                        firstHint.setText("We are Out Of Moves");
                        firstHint.startAnimation(start);
                    }
                    else {
                        firstHint.setAnimation(end);
                        userInput.setText(null);


                        firstHint.setText(obj.hint(randomNumber, tries[0], input[0]));
                        tries[0]++;

                        firstHint.startAnimation(start);
                    }






                }
                catch (Exception e) {
                    Toast.makeText(Game_playing.this, "Enter A Valid Input", Toast.LENGTH_SHORT).show();
                }





            }
        });

    }

    public void game1(View view){

        result.setText(null);

        userInput.setText(null);
        game();
    }
    public void game1(){

        game();
        Enter.setAnimation(start);
        backButton.setAnimation(start);
        restart.setAnimation(start);
    }




}