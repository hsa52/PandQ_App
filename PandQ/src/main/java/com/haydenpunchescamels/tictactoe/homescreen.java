package com.haydenpunchescamels.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
    }
    public void playbuttonclicked(View v) {
        startActivity(new Intent(getApplicationContext(), startthegame.class));
    }
    public void settingsbuttonclicked(View v) {
        startActivity(new Intent(getApplicationContext(), settingspage.class));
    }
    public void creditsbuttonclicked(View v) {
        startActivity(new Intent(getApplicationContext(), creditspage.class));
    }

}

