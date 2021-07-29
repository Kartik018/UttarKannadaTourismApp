package com.example.tourismapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.scwang.wave.MultiWaveHeader;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.tourismapp.R.anim;
import static com.example.tourismapp.R.id;
import static com.example.tourismapp.R.layout;

public class MainActivity extends AppCompatActivity
{
    ImageView img1;
    TextView text;
    ProgressBar progressBar;
    Boolean doubleBackToExitPressedOnce;
    int count;
    Timer timer;
    Animation top,bottom;
    MultiWaveHeader waveHeader,waveFooter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(layout.activity_main);

        text=(TextView)findViewById(R.id.textView);
        img1=(ImageView)findViewById(id.imageView2);
        waveHeader=findViewById(id.wave_header);
        waveFooter=findViewById(id.wave_footer);
        progressBar=findViewById(id.pgbar);

        timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                count++;
                progressBar.setProgress(count);
                if (count==50){
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,50);

        waveHeader.setVelocity(1);
        waveFooter.setVelocity(1);
        waveHeader.isRunning();
        waveHeader.setGradientAngle(45);
        waveHeader.setWaveHeight(40);
        waveHeader.setStartColor(Color.RED);
        waveHeader.setCloseColor(Color.CYAN);

        waveFooter.setVelocity(1);
        waveFooter.setProgress(1);
        waveFooter.isRunning();
        waveFooter.setGradientAngle(45);
        waveFooter.setWaveHeight(40);
        waveFooter.setStartColor(Color.MAGENTA);
        waveFooter.setCloseColor(Color.YELLOW);

        top= AnimationUtils.loadAnimation(getApplicationContext(), anim.maintextanimation);
        bottom= AnimationUtils.loadAnimation(getApplicationContext(),anim.subtextanimation);

        img1.setAnimation(top);
        text.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                finish();
            }
        }, 2500);

    }
}