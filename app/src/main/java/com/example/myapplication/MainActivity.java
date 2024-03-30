package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    Button new_game, exit;
    TextView title;
    Animation start,end,titleanimation;
    LottieAnimationView bg;
    MediaPlayer bgMusic; //= new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bg = findViewById(R.id.lottiebg);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            bg.enableMergePathsForKitKatAndAbove(true);
        }

        bgMusic = MediaPlayer.create(this,R.raw.melody2);
        bgMusic.start();
        bgMusic.setLooping(true);


        new_game = findViewById(R.id.new_game);
        exit = findViewById(R.id.exit);
        title = findViewById(R.id.Title);

        titleanimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.titleanimation);
        title.startAnimation(titleanimation);



        start = AnimationUtils.loadAnimation(this, R.anim.new_game);
        new_game.startAnimation(start);
        exit.startAnimation(start);


        new_game.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Opening Activity", Toast.LENGTH_SHORT).show();
                end =  AnimationUtils.loadAnimation(MainActivity.this, R.anim.end);

                new_game.startAnimation(end);
                exit.startAnimation(end);
                Intent intent = new Intent(MainActivity.this, Game_playing.class);
                startActivity(intent);

                //Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });




    }




}
