package com.example.wy521angel.customdrawable;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (getIntent().getIntExtra("flag", 0)) {
            case 1:
                setContentView(R.layout.activity_ring_progress);
                break;
            default:
        }


    }
}
