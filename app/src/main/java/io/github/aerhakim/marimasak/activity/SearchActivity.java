package io.github.aerhakim.marimasak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.adapter.SearchAdapter;
import io.github.aerhakim.marimasak.models.GetSearch;
import io.github.aerhakim.marimasak.models.Search;
import io.github.aerhakim.marimasak.utils.api.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    SearchView searchView;
    RecyclerView recyclerView;
    List<Search> searchList;
    ShimmerFrameLayout shimmerFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        setContentView(R.layout.activity_search);
        shimmerFrameLayout = findViewById(R.id.shimmerLayout);
        searchView = findViewById(R.id.search_bar);
        searchView.requestFocus();
        recyclerView=findViewById(R.id.rv_detail_category);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false));

        //Intent kembali ke MainActivity
        LinearLayout ivBack=findViewById(R.id.batal);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);

            }
        });

        search();
    }

    public void search(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String q) {
                Call<GetSearch> call= Config.getInstance().getApi().search(q);
                call.enqueue(new Callback<GetSearch>() {
                    @Override
                    public void onResponse(Call<GetSearch> call, Response<GetSearch> response) {

                        if(response.isSuccessful()){
                            searchList = response.body().getSearchList();
                            recyclerView.setAdapter(new SearchAdapter(SearchActivity.this, searchList));
                            shimmerFrameLayout.startShimmer();
                            shimmerFrameLayout.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.VISIBLE);
                        }

                    }

                    @Override
                    public void onFailure(Call<GetSearch> call, Throwable t) {
                        Log.d("Hasil", t.getMessage());
                    }
                });
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();

    }
}