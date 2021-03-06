package com.example.td6.services;

import com.example.td6.Repo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService {
    public static final String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    Call<ArrayList<Repo>> listRepos(@Path("user") String user);


    @GET("/search/repositories")
    Call<ArrayList<Repo>> searchRepos(@Query("q") String query);

    @POST("/search/repositories")
    Call<ArrayList<Repo>> searchRepo(@Field("q") String query);

}
