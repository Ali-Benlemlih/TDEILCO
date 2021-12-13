package com.example.td6;

import com.google.gson.annotations.SerializedName;

public class Repo {
    private int id;
    private String name;
    @SerializedName("full_name")
    private String fullName;
    private String html_url;

    public Repo(int id, String name, String fullName, String html_url) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.html_url = html_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
