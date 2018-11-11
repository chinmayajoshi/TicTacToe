package com.example.chinmaya.mytictactoe;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity  {

    Button bp,br,ba,be;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        bp = (Button) findViewById(R.id.bplay);
        br = (Button) findViewById(R.id.brules);
        ba = (Button) findViewById(R.id.baboutus);
        be = (Button) findViewById(R.id.bexit);

        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MenuActivity.this, GameActivity.class);
                startActivity(a);
                finish();
            }
        });

        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder exit = new AlertDialog.Builder(MenuActivity.this);
                exit.setMessage("Are you sure you want to exit?")
                        .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                }).setNegativeButton("Stay", null).show();

            }
        });

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String r = "RULES:\n\n" +
                        " Simple game of cross and zeros\n" +
                        " Player-1 will play 'X' -> RED color\n" +
                        " Player-2 will play 'Y' -> BLUE color\n" +
                        " First to connect 3 of their sigils WIN!";
                AlertDialog.Builder rulz = new AlertDialog.Builder(MenuActivity.this);
                rulz.setMessage(r).setPositiveButton("OK", null).show();
            }
        });

        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               AlertDialog.Builder msg = new AlertDialog.Builder(MenuActivity.this);
               msg.setMessage("Developer: \n\n CHINMAYA JOSHI").setPositiveButton("OK",null).show();
            }
        });

    }
}
