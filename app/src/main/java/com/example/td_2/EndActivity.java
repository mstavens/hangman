package com.example.td_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EndActivity extends AppCompatActivity {
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

            mButton = (Button) findViewById(R.id.replay_game);

            View.OnClickListener bClick = new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent gameIntent = new Intent(EndActivity.this,
                            MainActivity.class);

                    startActivity(gameIntent);
                }
            };

            mButton.setOnClickListener(bClick);
        }



    }
