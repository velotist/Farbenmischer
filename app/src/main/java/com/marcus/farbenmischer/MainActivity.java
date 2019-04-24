package com.marcus.farbenmischer;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int x = 0, y = 0, z = 0;

    Button btnRed;
    Button btnYellow;
    Button btnBlue;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer soundGreet = MediaPlayer.create(this,R.raw.leandergreet);
        soundGreet.start();
        try{
            Thread.sleep(4000);
        }catch(InterruptedException ignored){}

        btnRed = findViewById(R.id.btnRed_id);
        btnYellow = findViewById(R.id.btnYellow_id);
        btnBlue = findViewById(R.id.btnBlue_id);
        txtResult = findViewById(R.id.txtResult_id);

        btnRed.setOnClickListener(redClickListener);
        btnYellow.setOnClickListener(yellowClickListener);
        btnBlue.setOnClickListener(blueClickListener);
    }

    private final View.OnClickListener redClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String farbe = "Rot";
            x = 1;
            playColor(farbe);
            btnRed.setEnabled(false);
            resultOfMixingColors();
        }
    };

    private final View.OnClickListener yellowClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String farbe = "Gelb";
            playColor(farbe);
            y = 1;
            btnYellow.setEnabled(false);
            resultOfMixingColors();
        }
    };

    private final View.OnClickListener blueClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String farbe = "Blau";
            playColor(farbe);
            z = 1;
            btnBlue.setEnabled(false);
            resultOfMixingColors();
        }
    };

    private void resultOfMixingColors() {
    // x = Rot y = Gelb z = Blau
        // wenn Rot und Gelb gedrückt wurden
        if(x == 1 && y == 1) {
            // Gib die mp3 zur Farbe Orange aus und setze die Hintergrundfarbe des Ergebnisbuttons auf Orange
            String farbe = "Orange";
            findViewById(R.id.txtResult_id).setBackgroundColor(Color.parseColor("#FF8C00"));
            playColor(farbe);
        }
    // wenn Rot und Blau gedrückt wurden
        if(x == 1 && z == 1) {
            String farbe = "Lila";
            findViewById(R.id.txtResult_id).setBackgroundColor(Color.parseColor("#8A2BE2"));
            playColor(farbe);
        }
    // wenn Gelb und Blau gedrückt wurden
        if(y == 1 && z == 1) {
            String farbe = "Gruen";
            findViewById(R.id.txtResult_id).setBackgroundColor(Color.parseColor("#00FF00"));
            playColor(farbe);
        } else {

        }
    }

// Methode zum Ausgeben des passenden mp3-Stückes für die gedrückte Farbe bzw. des Farbergebnisses
    private void playColor(String farbe) {
        switch(farbe) {
            case "Rot":
                final MediaPlayer soundRot = MediaPlayer.create(this, R.raw.rot);
                while(soundRot.isPlaying()) {
                    soundRot.start();
                }
                soundRot.release();
                break;
            case "Gelb":
                final MediaPlayer soundGelb = MediaPlayer.create(this,R.raw.gelb);
                while(soundGelb.isPlaying()) {
                    soundGelb.start();
                }
                soundGelb.release();
                break;
            case "Blau":
                final MediaPlayer soundBlau = MediaPlayer.create(this,R.raw.blau);
                while(soundBlau.isPlaying()) {
                    soundBlau.start();
                }
                soundBlau.release();
                break;
            case "Gruen":
                final MediaPlayer soundGreen = MediaPlayer.create(this,R.raw.gruen);
                while(soundGreen.isPlaying()) {
                    soundGreen.start();
                }
                soundGreen.release();
                btnBlue.setEnabled(true);
                z = 0;
                btnYellow.setEnabled(true);
                y = 0;
                break;
            case "Orange":
                final MediaPlayer soundOrange = MediaPlayer.create(this,R.raw.orange);
                while(soundOrange.isPlaying()) {
                    soundOrange.start();
                }
                soundOrange.release();
                btnRed.setEnabled(true);
                x = 0;
                btnYellow.setEnabled(true);
                y = 0;
                break;
            case "Lila":
                final MediaPlayer soundLila = MediaPlayer.create(this,R.raw.lila);
                while(soundLila.isPlaying()) {
                    soundLila.start();
                }
                soundLila.release();
                btnBlue.setEnabled(true);
                z = 0;
                btnRed.setEnabled(true);
                x = 0;
                break;
            default:
                break;
        }
    }
}
