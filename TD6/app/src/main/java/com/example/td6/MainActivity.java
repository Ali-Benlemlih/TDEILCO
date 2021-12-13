package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.td6.services.GithubService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button search = findViewById(R.id.search);
        EditText repoName = findViewById(R.id.repoNameTextView);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListRepo.class);
                intent.putExtra("RepoName", repoName.getText().toString());
                startActivity(intent);
            }
        });

        /*GithubService githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);

        githubService.listRepos("adrienBusin").enqueue(new Callback<ArrayList<Repo>>() {
            @Override
            public void onResponse(Call<ArrayList<Repo>> call, Response<ArrayList<Repo>> response) {
                afficherRepos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Repo>> call, Throwable t) {
               Error();
            }
        });*/
    }
    /*

    public void afficherRepos(List<Repo> repos) {
        Toast.makeText(this," nombre de dépots: " + repos.size(), Toast.LENGTH_SHORT).show();
    }

    public void Error() {
        Toast.makeText(this, "Repo introuvable", Toast.LENGTH_SHORT).show();
    }

     */
}