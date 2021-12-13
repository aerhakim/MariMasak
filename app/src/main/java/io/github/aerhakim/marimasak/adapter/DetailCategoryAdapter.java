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
import io.github.aerhakim.marimasak.models.DetailCategory;
import io.github.aerhakim.marimasak.models.Recipe;


public class DetailCategoryAdapter extends RecyclerView.Adapter<DetailCategoryAdapter.ViewHolder> {

    List<DetailCategory> detailCategoryList;
    Context context;

    public DetailCategoryAdapter(Context context, List<DetailCategory> detailCategoryList) {
        this.context = context;
        this.detailCategoryList = detailCategoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cover_category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.recipeKey.setText(detailCategoryList.get(position).getKey());
        holder.resicePortion.setText(detailCategoryList.get(position).getPortion());
        holder.recipeTitle.setText(detailCategoryList.get(position).getTitle());
        holder.recipeTimes.setText(detailCategoryList.get(position).getTimes());
        holder.recipeDifficulty.setText(detailCategoryList.get(position).getDificulty());
        Glide.with(holder.itemView.getContext())
                .load(detailCategoryList.get(position).getThumb())
                .apply(new RequestOptions().override(200, 300))
                .into(holder.recipeThumb);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailResepActivity.class);
                mIntent.putExtra("key", detailCategoryList.get(position).getKey());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return detailCategoryList.size();
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
