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

        holder.recipeKey.setText(recipeList.get(position).getKey());
        holder.resicePortion.setText(recipeList.get(position).getPortion());
        holder.recipeTitle.setText(recipeList.get(position).getTitle());
        holder.recipeTimes.setText(recipeList.get(position).getTimes());
        holder.recipeDifficulty.setText(recipeList.get(position).getDificulty());
        Glide.with(holder.itemView.getContext())
                .load(recipeList.get(position).getThumb())
                .apply(new RequestOptions().override(200, 300))
                .into(holder.recipeThumb);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailResepActivity.class);
                mIntent.putExtra("kunci", recipeList.get(position).getKey());
                mIntent.putExtra("thumb", recipeList.get(position).getThumb());
                mIntent.putExtra("title", recipeList.get(position).getTitle());
                mIntent.putExtra("times", recipeList.get(position).getTimes());
                mIntent.putExtra("portion", recipeList.get(position).getPortion());
                mIntent.putExtra("dificulty", recipeList.get(position).getDificulty());
                view.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView recipeKey,resicePortion, recipeTitle, recipeTimes, recipeDifficulty;
        ImageView recipeThumb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeKey=itemView.findViewById(R.id.tv_id);
            resicePortion=itemView.findViewById(R.id.tv_porsi);
            recipeTitle=itemView.findViewById(R.id.tv_judul);
            recipeTimes=itemView.findViewById(R.id.tv_waktu);
            recipeDifficulty=itemView.findViewById(R.id.tv_kesulitan);
            recipeThumb=itemView.findViewById(R.id.iv_cover);
        }
    }
}
