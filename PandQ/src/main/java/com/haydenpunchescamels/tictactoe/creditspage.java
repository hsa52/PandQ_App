package com.haydenpunchescamels.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class creditspage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);
    }
    public void homebuttonclicked3(View v) {
        startActivity(new Intent(getApplicationContext(), homescreen.class));
    }
}