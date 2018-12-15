package com.example.kurokami.guchitte_hacku_ver2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageButton;
import android.view.View;

public class Parry extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parry);

        ImageButton imageButton = (ImageButton) findViewById(R.id.image_button);
        final AnimationDrawable animationDrawable = (AnimationDrawable) imageButton.getDrawable();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animationDrawable.start();
            }
        });


    }
}
