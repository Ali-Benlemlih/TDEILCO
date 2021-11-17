package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.button1);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                EditText editText1 = (EditText) findViewById(R.id.editText1);
                if(editText1.getText().toString().trim().length() > 0 ) {

                int faceDes = Integer.parseInt( editText1.getText().toString());
                    if(faceDes > 0) {
                        int value1 = getRandomValue(faceDes);
                        int value2 = getRandomValue(faceDes);

                        TextView text1 = (TextView) findViewById(R.id.text1);
                        text1.setText(String.valueOf(value1));

                        TextView text2 = (TextView) findViewById(R.id.text2);
                        text2.setText(String.valueOf(value2));
                    }
                    else {
                        Toast toast = Toast.makeText(MainActivity.this, "Veuillez entrer un nombre supérieur à 0", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }

                else {
                    Toast toast = Toast.makeText(MainActivity.this, "Veuillez entrer le nombre de face des Dés", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });


    }

    // Fonction qui permete de génerer un nombre aléatoire entre 1 et 6

    public int getRandomValue(int faceDes) {
       // Random random = new Random();
       // int value = random.nextInt(((6 - 1)+1)+1) +1 ;
        int value = ThreadLocalRandom.current().nextInt(1,faceDes+1) ;
        return value;
    }
}