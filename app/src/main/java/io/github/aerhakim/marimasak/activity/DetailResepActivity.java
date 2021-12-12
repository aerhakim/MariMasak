package io.github.aerhakim.marimasak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.adapter.DetailAdapter;
import io.github.aerhakim.marimasak.adapter.RecipeAdapter;
import io.github.aerhakim.marimasak.models.Detail;
import io.github.aerhakim.marimasak.models.GetDetail;
import io.github.aerhakim.marimasak.models.GetRecipe;
import io.github.aerhakim.marimasak.models.Recipe;
import io.github.aerhakim.marimasak.utils.api.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailResepActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Detail> detailList;
    TextView link;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);
        recyclerView=findViewById(R.id.rv_detail_main);
        key = getIntent().getStringExtra("key");
        link = findViewById(R.id.link);
        link.setText("https://www.masakapahariini.com/"+key);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(DetailResepActivity.this, LinearLayoutManager.VERTICAL, false));
        Call<GetDetail> call= Config.getInstance().getApi().detail(key);
        call.enqueue(new Callback<GetDetail>() {
            @Override
            public void onResponse(Call<GetDetail> call, Response<GetDetail> response) {

                if(response.isSuccessful()){

                    List<Detail> detailList = response.body().getDetailList();
                    recyclerView.setAdapter(new DetailAdapter(detailList));

                }
                else{
                    Toast.makeText(DetailResepActivity.this, response.body().getError(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<GetDetail> call, Throwable t) {
            }
        });

    }

}

//package io.github.aerhakim.marimasak.activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.TextView;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//import java.util.List;
//
//import io.github.aerhakim.marimasak.R;
//import io.github.aerhakim.marimasak.adapter.DetailAdapter;
//import io.github.aerhakim.marimasak.models.Detail;
//import io.github.aerhakim.marimasak.models.GetDetail;
//import io.github.aerhakim.marimasak.models.GetRecipe;
//import io.github.aerhakim.marimasak.utils.api.Api;
//import io.github.aerhakim.marimasak.utils.api.ApiClient;
//import io.github.aerhakim.marimasak.utils.api.Config;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class DetailResepActivity extends AppCompatActivity {
//
//    Api mApiInterface;
//    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
//    public static DetailResepActivity ma;
//    String key;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail_resep);
//        key = getIntent().getStringExtra("key");
//        mRecyclerView = (RecyclerView) findViewById(R.id.rv_detail_main);
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mApiInterface = ApiClient.getClient().create(Api.class);
//        ma=this;
//        refresh();
//    }
//
//
//
//    public void refresh() {
//        Call<GetDetail> HerosCall = mApiInterface.detail(key);
//        HerosCall.enqueue(new Callback<GetDetail>() {
//            @Override
//            public void onResponse(Call<GetDetail> call, Response<GetDetail>
//                    response) {
//                List<Detail> detailList = response.body().getDetailList();
//                mAdapter = new DetailAdapter(detailList);
//                mRecyclerView.setAdapter(mAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<GetDetail> call, Throwable t) {
//            }
//        });
//    }
//}