package com.haydenpunchescamels.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class settingspage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }
    public void homebuttonclicked2(View v) {
        startActivity(new Intent(getApplicationContext(), homescreen.class));
    }
}
