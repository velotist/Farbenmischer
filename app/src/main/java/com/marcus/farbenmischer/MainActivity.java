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
        soundGreet.release();

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
            x = 1;
            btnRed.setEnabled(false);
            resultOfMixingColors();
        }
    };

    private final View.OnClickListener yellowClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            y = 1;
            btnYellow.setEnabled(false);
            resultOfMixingColors();
        }
    };

    private final View.OnClickListener blueClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
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
            String mixedColor = "orange";
            //findViewById(R.id.txtResult_id).setBackgroundColor(Color.parseColor("#FF8C00"));
            playColor(mixedColor);
        }
    // wenn Rot und Blau gedrückt wurden
        else if(x == 1 && z == 1) {
            String mixedColor = "violet";
            //findViewById(R.id.txtResult_id).setBackgroundColor(Color.parseColor("#8A2BE2"));
            playColor(mixedColor);
        }
    // wenn Gelb und Blau gedrückt wurden
        else if(y == 1 && z == 1) {
            String mixedColor = "green";
            //findViewById(R.id.txtResult_id).setBackgroundColor(Color.parseColor("#00FF00"));
            playColor(mixedColor);
        } else return;
    }

    // Methode zum Ausgeben des passenden mp3-Stückes für die gedrückte Farbe bzw. des Farbergebnisses
    private void playColor(String color) {
        switch(color) {
            case "green":
                findViewById(R.id.txtResult_id).setBackgroundColor(Color.parseColor("#00FF00"));
                final MediaPlayer soundGreen = MediaPlayer.create(this,R.raw.gruen);
                soundGreen.start();
                while(soundGreen.isPlaying()) {
                    btnBlue.setEnabled(true);
                    z = 0;
                    btnYellow.setEnabled(true);
                    y = 0;
                }
                soundGreen.release();
                break;
            case "orange":
                findViewById(R.id.txtResult_id).setBackgroundColor(Color.parseColor("#FF8C00"));
                final MediaPlayer soundOrange = MediaPlayer.create(this,R.raw.orange);
                soundOrange.start();
                while(soundOrange.isPlaying()) {
                    btnRed.setEnabled(true);
                    x = 0;
                    btnYellow.setEnabled(true);
                    y = 0;
                }
                soundOrange.release();
                break;
            case "violet":
                findViewById(R.id.txtResult_id).setBackgroundColor(Color.parseColor("#8A2BE2"));
                final MediaPlayer soundViolet = MediaPlayer.create(this,R.raw.lila);
                soundViolet.start();
                while(soundViolet.isPlaying()) {
                    btnBlue.setEnabled(true);
                    z = 0;
                    btnRed.setEnabled(true);
                    x = 0;
                }
                soundViolet.release();
                break;
            default:
                break;
        }
    }
}
