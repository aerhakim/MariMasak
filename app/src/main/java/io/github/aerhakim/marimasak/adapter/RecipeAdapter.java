package io.github.aerhakim.marimasak.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.activity.DetailResepActivity;
import io.github.aerhakim.marimasak.models.Recipe;



public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    List<Recipe> recipeList;
    Context context;

    public RecipeAdapter(Context context, List<Recipe> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cover_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.recipeId.setText(recipeList.get(position).getId());
        holder.resiceServings.setText(recipeList.get(position).getServings());
        holder.recipeTitle.setText(recipeList.get(position).getTitle());
        holder.recipeTime.setText(recipeList.get(position).getTime());
        holder.recipeDifficulty.setText(recipeList.get(position).getDifficulty());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailResepActivity.class);
                mIntent.putExtra("id", recipeList.get(position).getId());
                mIntent.putExtra("servings", recipeList.get(position).getServings());
                mIntent.putExtra("title", recipeList.get(position).getTitle());
                mIntent.putExtra("time", recipeList.get(position).getTime());
                mIntent.putExtra("difficulty", recipeList.get(position).getDifficulty());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView recipeId,resiceServings, recipeTitle, recipeTime, recipeDifficulty;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeId=itemView.findViewById(R.id.tv_id);
            resiceServings=itemView.findViewById(R.id.tv_porsi);
            recipeTitle=itemView.findViewById(R.id.tv_judul);
            recipeTime=itemView.findViewById(R.id.tv_waktu);
            recipeDifficulty=itemView.findViewById(R.id.tv_kesulitan);
        }
    }
}
