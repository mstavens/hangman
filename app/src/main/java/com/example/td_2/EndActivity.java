package com.example.td_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {
    private Button mButton;
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
        // Widjet pou afiche rezilta fen jwèt al

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
