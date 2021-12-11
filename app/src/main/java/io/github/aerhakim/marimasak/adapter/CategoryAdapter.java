package io.github.aerhakim.marimasak.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.activity.DetailResepActivity;
import io.github.aerhakim.marimasak.models.Category;



public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<Category> categoryList;
    Context context;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.categoryId.setText(categoryList.get(position).getCategoryId());
        holder.categoryName.setText(categoryList.get(position).getCategoryName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailResepActivity.class);
                mIntent.putExtra("id", categoryList.get(position).getCategoryId());
                mIntent.putExtra("servings", categoryList.get(position).getCategoryName());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView categoryId,categoryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryId=itemView.findViewById(R.id.tv_id_cat);
            categoryName=itemView.findViewById(R.id.tv_nama_Cat);
        }
    }
}
