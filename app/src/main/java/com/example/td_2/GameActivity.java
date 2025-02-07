package com.example.td_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private String[] words = {
            "Rutshelle", "Fatima", "Bedjine",
            "Shassy"
    };

    // kantite chans itilizatè a
    private int chans = 5;

    // mo kap chwazi otomatik la
    private String chosenWord;

    private int firstletter = 0;

    // Widjet pou afiche chans yo
    TextView mChansText;

    TextView m20pourcent;
    // Widget pou achite karaktè kache yo
    TextView mHidText;

    // table mo kache yo
    private char[] moKache;
    private static Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mChansText = (TextView) findViewById(R.id.chansTv);
        mChansText.setText(chans + " chans");

        mHidText = (TextView) findViewById(R.id.hiddenWord);

        // get the random word
        chosenWord = getRandomWord();

        // init the array with the chosenWord length.
        moKache = new char[chosenWord.length()];

        // Create underscores based on that length
        for(int i=0; i< chosenWord.length(); i++){
            moKache[i] = '_';
        }

        //Kalkil 20% endis
        int longueur= moKache.length;
        Double ongueur= (longueur * 0.2);
        longueur = ongueur.intValue();

        //Afichaj endis la
        m20pourcent= (TextView) findViewById(R.id.preview);
        String prevWord=chosenWord.substring(0,longueur);
        m20pourcent.setText("Endis: "+prevWord);

        // Set the string to Widget
        mHidText.setText(getDisplayText());
    }

    public String getDisplayText(){
        // Create a new string based on the <moKache>, array of characters
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < moKache.length; i++){
            sb.append(moKache[i] + " ");
        }

        return sb.toString();
    }

    // return a random digit between 0 and words length
    public String getRandomWord(){
        return words[random.nextInt(words.length)];
    }

    public void onTapLetter(View theView) {
        // get the tap letter
        Button mButton = (Button) theView;
        String letter = mButton.getText().toString();

        System.out.println(chosenWord);
        System.out.println(letter);

            if (firstletter==0) //Test sou premye lèt la
            {
               // The following condition will fail sometimes, because of the case. Make sure your convert both <chosenWord> and <letter> to lower or uppercase.
                if (chosenWord.contains(letter)) {
                    firstletter=1;
                    // get the index
                    int index = chosenWord.indexOf(letter);

                    // Tanke endèks la >= 0, sa vle di gen lèt la nan <chosenWord> la toujou
                    while (index >= 0) {
                        // This is just a hack to convert the string to char, since moKache is an array of characters
                        moKache[index] = letter.charAt(0); // chartAt(0) to take the first character from the letter.

                        index = chosenWord.indexOf(letter, index + 1); // DO NOT forget to specify the fromIndex to avoid infinite loop
                    }
                    System.out.println(moKache);

                } else {
                    // Minus the total of tries
                    chans -= 1;
                    mChansText.setText(chans + " chans");
                    // Display a short message
                    Toast.makeText(this, "Lèt ou tape a, pa nan mo a", Toast.LENGTH_SHORT).show();

                }
            }else{// Test sou lot lèt yo

                //Tout lot lèt ap pase an miniskil pou test yo ka fèt
                if (chosenWord.contains(letter.toLowerCase())) {

                    // get the index
                    int index = chosenWord.indexOf(letter.toLowerCase());

                    // Tanke endèks la >= 0, sa vle di gen lèt la nan <chosenWord> la toujou
                    while (index >= 1) {
                        // This is just a hack to convert the string to char, since moKache is an array of characters
                        moKache[index] = letter.toLowerCase().charAt(0); // chartAt(0) to take the first character from the letter.

                        index = chosenWord.indexOf(letter.toLowerCase(), index + 1); // DO NOT forget to specify the fromIndex to avoid infinite loop
                    }
                    System.out.println(moKache);

                } else {
                    // Minus the total of tries
                    chans -= 1;
                    mChansText.setText(chans + " chans");
                    // Display a short message
                    Toast.makeText(this, "Lèt ou tape a, pa nan mo a", Toast.LENGTH_SHORT).show();

                }
            }
            // Finally, display the new text.
            mHidText.setText(getDisplayText());

            //Lè itlizatè a pa ret chans anko
        if(chans==0){
            String result = "GAME OVER!!";
            Intent gameIntent = new Intent(GameActivity.this,
                    EndActivity.class);
            gameIntent.putExtra("my_array", result);
            startActivity(gameIntent);
        }

        //Verifikasyon ki pou defini lè itilizatè a fin rantre tt bon mo a, e dil ke li genyen
        String egaliteTest=new String(moKache);

        if (chosenWord.equals(egaliteTest) ){
            String result = "YOU WIN!!!";
            Intent gameIntent = new Intent(GameActivity.this,
                    EndActivity.class);
            gameIntent.putExtra("my_array", result);
            startActivity(gameIntent);
        }
        }



}