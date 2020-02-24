package com.issamelasri.moneymanager.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.issamelasri.moneymanager.R;
import com.issamelasri.moneymanager.ui.pojo.PostModel;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private ArrayList<PostModel> moviesList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.psot_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.body.setText(moviesList.get(position).getBody());
        holder.title.setText(moviesList.get(position).getTitle());
        holder.userid.setText(moviesList.get(position).getUserId() + "");
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setList(ArrayList<PostModel> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView title, body, userid;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleText);
            body = itemView.findViewById(R.id.bodyText);
            userid = itemView.findViewById(R.id.idText);


        }
    }
}
