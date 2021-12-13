package com.example.td6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
//B9it hna
public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.MyViewHolder> {

    private ArrayList<Repo> repos;

    public RepoAdapter(ArrayList<Repo> repos) {
        this.repos = repos;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView reponame;
        private TextView url;

        public MyViewHolder(final View view) {
            super(view);
            reponame = view.findViewById(R.id.fullName);
            url = view.findViewById(R.id.htmlUrl);
        }
    }

    @NonNull
    @Override
    public RepoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.repos, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoAdapter.MyViewHolder holder, int position) {
        String repoName = repos.get(position).getFullName();
        holder.reponame.setText(repoName);

        String htmlGit = repos.get(position).getHtml_url();
        holder.url.setText(htmlGit);

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }
}
