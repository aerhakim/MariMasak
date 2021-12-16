package io.github.aerhakim.marimasak.database.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.activity.DetailResepActivity;
import io.github.aerhakim.marimasak.database.Resep;

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ViewAdapter> {
    private List<Resep> list;
    private Context context;
    private Dialog dialog;

    public interface Dialog {
        void onClick(int position);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public ResepAdapter(Context context, List<Resep> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cover_favourite_item, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.recipeKey.setText(list.get(position).kunci);
        holder.resicePortion.setText(list.get(position).portion);
        holder.recipeTitle.setText(list.get(position).title);
        holder.recipeTimes.setText(list.get(position).times);
        holder.recipeDifficulty.setText(list.get(position).dificulty);
        Glide.with(holder.itemView.getContext())
                .load(list.get(position).thumb)
                .apply(new RequestOptions().override(200, 300))
                .into(holder.recipeThumb);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailResepActivity.class);
                mIntent.putExtra("kunci", list.get(position).kunci);
                mIntent.putExtra("thumb", list.get(position).thumb);
                mIntent.putExtra("title", list.get(position).title);
                mIntent.putExtra("times", list.get(position).times);
                mIntent.putExtra("portion", list.get(position).portion);
                mIntent.putExtra("dificulty", list.get(position).dificulty);
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView recipeKey,resicePortion, recipeTitle, recipeTimes, recipeDifficulty;
        ImageView recipeThumb;
        LinearLayout recipeDelete;

        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            recipeKey=itemView.findViewById(R.id.tv_id);
            resicePortion=itemView.findViewById(R.id.tv_porsi);
            recipeTitle=itemView.findViewById(R.id.tv_judul);
            recipeTimes=itemView.findViewById(R.id.tv_waktu);
            recipeDifficulty=itemView.findViewById(R.id.tv_kesulitan);
            recipeThumb=itemView.findViewById(R.id.iv_cover);
            recipeDelete=itemView.findViewById(R.id.iv_delete);

            recipeDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }

}
