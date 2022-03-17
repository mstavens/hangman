package com.example.td_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {
    private Button mButton;
    //widget pou afiche stati jwè a nan fen jwèt la
    TextView mresultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Bundle extras = getIntent().getExtras();
        String resulta = extras.getString("my_array");
        mresultText = (TextView) findViewById(R.id.end_game_message);
        mresultText.setText(resulta);

        mButton = (Button) findViewById(R.id.replay_game);

            //Redireksyon nan paj pou redemare jwèt la
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
