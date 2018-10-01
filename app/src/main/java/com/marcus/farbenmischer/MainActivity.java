package com.marcus.farbenmischer;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.GREEN;

public class MainActivity extends AppCompatActivity {

    private int x=0;
    private int y=0;
    private int z=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer soundGreet = MediaPlayer.create(this,R.raw.leandergreet);
        soundGreet.start();
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ignored){}

        Button btnRed = findViewById(R.id.btnRed_id);
        Button btnYellow = findViewById(R.id.btnYellow_id);
        Button btnBlue = findViewById(R.id.btnBlue_id);

        btnRed.setOnClickListener(redClickListener);
        btnYellow.setOnClickListener(yellowClickListener);
        btnBlue.setOnClickListener(blueClickListener);
    }

    private final View.OnClickListener redClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String farbe = "Rot";
            playColor(farbe);
            try{
                Thread.sleep(3000);
            }catch(InterruptedException ignored){}

            x++;
            if(x==2) x=1;
            ergebnisFarbeMischen();
        }
    };

    private final View.OnClickListener yellowClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String farbe = "Gelb";
            playColor(farbe);
            try{
                Thread.sleep(3000);
            }catch(InterruptedException ignored){}

            y++;
            if(y==2) y=1;
            ergebnisFarbeMischen();
        }
    };

    private final View.OnClickListener blueClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String farbe = "Blau";
            playColor(farbe);
            try{
                Thread.sleep(3000);
            }catch(InterruptedException ignored){}

            z++;
            if(z==2) z=1;
            ergebnisFarbeMischen();
        }
    };

    private void ergebnisFarbeMischen() {
    // x = Rot y = Gelb z = Blau
        // wenn Rot und Gelb gedrückt wurden
        if(x==1 && y==1) {
            // Gib die mp3 zur Farbe Orange aus und setze die Hintergrundfarbe des Ergebnisbuttons auf Orange
            String farbe = "Orange";
            findViewById(R.id.btnResult_id).setBackgroundColor(Color.parseColor("#FF8C00"));
            playColor(farbe);
            x=0;
            y=0;
            z=0;
        }
    // wenn Rot und Blau gedrückt wurden
        if(x==1 && z==1) {
            String farbe = "Lila";
            findViewById(R.id.btnResult_id).setBackgroundColor(Color.parseColor("#8A2BE2"));
            playColor(farbe);
            x=0;
            y=0;
            z=0;
        }
    // wenn Gelb und Blau gedrückt wurden
        if(y==1 && z==1) {
            String farbe = "Gruen";
            findViewById(R.id.btnResult_id).setBackgroundColor(GREEN);
            playColor(farbe);
            x=0;
            y=0;
            z=0;
        }
    }

// Methode zum Ausgeben des passenden mp3-Stückes für die gedrückte Farbe bzw. des Farbergebnisses
    private void playColor(String farbe) {
        switch(farbe) {
            case "Rot":
                final MediaPlayer soundRot = MediaPlayer.create(this, R.raw.rot);
                soundRot.start();
                break;
            case "Gelb":
                final MediaPlayer soundGelb = MediaPlayer.create(this,R.raw.gelb);
                soundGelb.start();
                break;
            case "Blau":
                final MediaPlayer soundBlau = MediaPlayer.create(this,R.raw.blau);
                soundBlau.start();
                break;
            case "Gruen":
                final MediaPlayer soundGreen = MediaPlayer.create(this,R.raw.gruen);
                soundGreen.start();
                break;
            case "Orange":
                final MediaPlayer soundOrange = MediaPlayer.create(this,R.raw.orange);
                soundOrange.start();
                break;
            case "Lila":
                final MediaPlayer soundLila = MediaPlayer.create(this,R.raw.lila);
                soundLila.start();
                break;
            default:
                break;
        }
    }
}
