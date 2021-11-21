package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Salut";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer v = 54;
        Integer n = v / 9 - 2;
        Log.i(TAG, "n = "+n);
        Integer f = factorilelle(n);
        Log.i(TAG, n.toString() + " != " + +f);

    }

    private int factorilelle(Integer n) {
        Integer r;
        if(n > 1) {
            Integer fnm1 = factorilelle(n-1);
            r = n * fnm1;
        } else {
            r = 1;
        }
        return r;
    }
}