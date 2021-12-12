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
import io.github.aerhakim.marimasak.activity.CategoryActivity;
import io.github.aerhakim.marimasak.activity.DetailResepActivity;
import io.github.aerhakim.marimasak.models.Detail;
import io.github.aerhakim.marimasak.models.Recipe;


public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    List<Detail> detailList;
    Context context;

    public DetailAdapter(List<Detail> detailList) {
        detailList = detailList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rv_detail,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.detailJudul.setText(detailList.get(position).getTitle());
        holder.detailWaktu.setText(detailList.get(position).getTimes());
        holder.detailKesulitan.setText(detailList.get(position).getDificulty());
        holder.detailPorsi.setText(detailList.get(position).getServings());
        holder.detailDeskripsi.setText(detailList.get(position).getDesc());
        Glide.with(holder.itemView.getContext())
                .load(detailList.get(position).getThumb())
                .apply(new RequestOptions().override(200, 300))
                .into(holder.detailGambar);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailResepActivity.class);
                mIntent.putExtra("title", detailList.get(position).getTitle());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView detailJudul ,detailWaktu, detailKesulitan, detailPorsi, detailDeskripsi;
        ImageView detailGambar;

        public ViewHolder(View itemView) {
            super(itemView);
            detailJudul=itemView.findViewById(R.id.tv_judul);
            detailWaktu=itemView.findViewById(R.id.tv_waktu);
            detailKesulitan=itemView.findViewById(R.id.tv_kesulitan);
            detailPorsi=itemView.findViewById(R.id.tv_porsi);
            detailDeskripsi=itemView.findViewById(R.id.tv_deskripsi);
            detailGambar=itemView.findViewById(R.id.iv_cover);
        }

    }
}

//package io.github.aerhakim.marimasak.adapter;
//
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;
//
//
//import java.util.List;
//
//import io.github.aerhakim.marimasak.R;
//import io.github.aerhakim.marimasak.models.Detail;
//
//public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder>{
//    List<Detail> detailList;
//
//    public DetailAdapter(List<Detail> detailList) {
//        detailList = detailList;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
//        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_detail, parent, false);
//        MyViewHolder mViewHolder = new MyViewHolder(mView);
//        return mViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder (MyViewHolder holder,final int position){
//        holder.detailJudul.setText(detailList.get(position).getTitle());
//        holder.detailWaktu.setText(detailList.get(position).getTimes());
//        holder.detailKesulitan.setText(detailList.get(position).getDificulty());
//        holder.detailPorsi.setText(detailList.get(position).getServings());
//        holder.detailDeskripsi.setText(detailList.get(position).getDesc());
//        Glide.with(holder.itemView.getContext())
//                .load(detailList.get(position).getThumb())
//                .apply(new RequestOptions().override(200, 300))
//                .into(holder.detailGambar);
//    }
//
//    @Override
//    public int getItemCount () {
//        return detailList.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView detailJudul ,detailWaktu, detailKesulitan, detailPorsi, detailDeskripsi;
//        ImageView detailGambar;
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            detailJudul=itemView.findViewById(R.id.tv_judul);
//            detailWaktu=itemView.findViewById(R.id.tv_waktu);
//            detailKesulitan=itemView.findViewById(R.id.tv_kesulitan);
//            detailPorsi=itemView.findViewById(R.id.tv_porsi);
//            detailDeskripsi=itemView.findViewById(R.id.tv_deskripsi);
//            detailGambar=itemView.findViewById(R.id.iv_detail);
//        }
//    }
//}
