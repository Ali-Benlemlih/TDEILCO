package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.td6.services.GithubService;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListRepo extends AppCompatActivity {
    Intent intent;

    private ArrayList<Repo> reposList;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repo);


        intent = getIntent();
        recyclerView = findViewById(R.id.listRepos);
        this.reposList = new ArrayList<>();

        GetRepos();
        //searchRepositories();

    }

    public void GetRepos() {

        GithubService githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);
        System.out.println("----------------------------------------");
        System.out.println( intent.getStringExtra("RepoName"));
        githubService.listRepos(intent.getStringExtra("RepoName")).enqueue(new Callback<ArrayList<Repo>>() {
            @Override
            public void onResponse(Call<ArrayList<Repo>> call, Response<ArrayList<Repo>> response) {
                setReposInfo(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<Repo>> call, Throwable t) {

            }

        });
    }

    public void searchRepositories() {
        GithubService githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);
        System.out.println("wselt");

        githubService.searchRepos(intent.getStringExtra("RepoName")).enqueue(new Callback<ArrayList<Repo>>() {

            @Override
            public void onResponse(Call<ArrayList<Repo>> call, Response<ArrayList<Repo>> response) {
                System.out.println(response.body());
                setReposInfo(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Repo>> call, Throwable t) {
                System.out.println("Error");
            }

        });

    }

    public void setReposInfo(ArrayList<Repo> repos) {
        this.reposList = repos;
       // this.reposList.add(new Repo(1, "Ali", "Benlemlih", "Http"));
        setAdapter();

    }


    public void setAdapter() {
        RepoAdapter adapter = new RepoAdapter(this.reposList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }
}