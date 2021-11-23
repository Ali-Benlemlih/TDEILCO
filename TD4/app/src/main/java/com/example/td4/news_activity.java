package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class news_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());

        //String username = getParameter();
        //setTitle(username);
        NewsListApplication newsListApplication = (NewsListApplication) getApplicationContext();
        setTitle(newsListApplication.getLogin());

        Button newsButton = (Button) findViewById(R.id.newsButton);

        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://news.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    public String getParameter() {
        Intent intent = getIntent();
        String login = null;
        if(intent.hasExtra("login")) {
            login = intent.getStringExtra("login");
        }
        return login;
    }
}