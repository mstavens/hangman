package com.example.td_android_1;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button myStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myStartButton = findViewById(R.id.start_game);

        myStartButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent = new Intent(this, GameActivity.class);
                startActivity(intent);
            }

//            view.onClick({
//                Intent intent = new Intent(this, GameActivity.class);
//                startActivity(intent);
//            });


        });




//        myStartButton.setOnKeyListener();
    }
}