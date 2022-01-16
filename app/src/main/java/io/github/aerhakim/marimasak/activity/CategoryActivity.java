package io.github.aerhakim.marimasak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.adapter.DetailCategoryAdapter;
import io.github.aerhakim.marimasak.adapter.RecipeAdapter;
import io.github.aerhakim.marimasak.database.AppDatabase;
import io.github.aerhakim.marimasak.models.Category;
import io.github.aerhakim.marimasak.models.DetailCategory;
import io.github.aerhakim.marimasak.models.GetDetailCategory;
import io.github.aerhakim.marimasak.models.GetRecipe;
import io.github.aerhakim.marimasak.utils.api.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView tvInfo, namaCat;
    String key;
    String name;
    SwipeRefreshLayout refreshLayout;
    List<DetailCategory> detailCategoryList;
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        shimmerFrameLayout = findViewById(R.id.shimmerLayout);
        key = getIntent().getStringExtra("key");
        name = getIntent().getStringExtra("name");
        tvInfo = findViewById(R.id.tvInfo);
        namaCat = findViewById(R.id.namaCat);
        refreshLayout = findViewById(R.id.swipe_refresh_layout_main);
        tvInfo.setText("Dibawah ini adalah 10 list resep pilihan dari kategori " + name);
        namaCat.setText(name);
        //rv trending recipe
        recyclerView = findViewById(R.id.rv_detail_category);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(CategoryActivity.this, LinearLayoutManager.VERTICAL, false));
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false); //cegah refresh icon muncul terus
                loadData();
            }
        });
        loadData();
        //Intent kembali ke MainActivity
        Toolbar ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
        //Intent ke Search Activity
        CardView searchBar = findViewById(R.id.search_bar);
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SearchActivity.class);
                startActivity(i);
            }
        });
    }

    public void loadData() {
        Call<GetDetailCategory> call = Config.getInstance().getApi().detailcategory(key);
        call.enqueue(new Callback<GetDetailCategory>() {
            @Override
            public void onResponse(Call<GetDetailCategory> call, Response<GetDetailCategory> response) {

                if (response.isSuccessful()) {
                    detailCategoryList = response.body().getDetailCategoryList();
                    recyclerView.setAdapter(new DetailCategoryAdapter(CategoryActivity.this, detailCategoryList));
                    shimmerFrameLayout.startShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<GetDetailCategory> call, Throwable t) {
                Log.d("Hasil", t.getMessage());
            }
        });
    }

    @Override
    public void onResume() {
        shimmerFrameLayout.startShimmer();
        super.onResume();
    }

    @Override
    public void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }
    @Override
    public void onBackPressed() {
        finish();
    }

}