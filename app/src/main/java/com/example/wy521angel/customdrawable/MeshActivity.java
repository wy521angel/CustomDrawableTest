package com.example.wy521angel.customdrawable;

import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MeshActivity extends AppCompatActivity {

    private static final String TAG = "MeshActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesh);

        View testCustomMeshDrawable = findViewById(R.id.test_custom_mesh_drawable);
        MeshDrawable meshDrawable = new MeshDrawable();
        testCustomMeshDrawable.setBackgroundDrawable(meshDrawable);
    }
}
