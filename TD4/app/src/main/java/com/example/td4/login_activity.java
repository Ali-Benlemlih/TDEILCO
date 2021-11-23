package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());


        Button login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewsActivity();
            }
        });
    }


    public void openNewsActivity() {
        String login = getLogin();
        NewsListApplication app = (NewsListApplication) getApplicationContext();
        app.setLogin(login);
        Intent intent = new Intent(this, news_activity.class);
        intent.putExtra("login", login);
        startActivity(intent);
        finish();
    }

    public String getLogin() {
        EditText usernameEditText = (EditText) findViewById(R.id.userNameText);
        String username = usernameEditText.getText().toString();
        return username;
    }

}