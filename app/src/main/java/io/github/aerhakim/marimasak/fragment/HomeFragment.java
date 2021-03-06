package io.github.aerhakim.marimasak.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;


import io.github.aerhakim.marimasak.R;
import io.github.aerhakim.marimasak.activity.SearchActivity;
import io.github.aerhakim.marimasak.adapter.CategoryAdapter;
import io.github.aerhakim.marimasak.adapter.RecipeAdapter;
import io.github.aerhakim.marimasak.models.Category;
import io.github.aerhakim.marimasak.models.GetCategory;
import io.github.aerhakim.marimasak.models.GetRecipe;
import io.github.aerhakim.marimasak.models.Recipe;
import io.github.aerhakim.marimasak.utils.api.Config;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements View.OnClickListener {
    RecyclerView recyclerView, recyclerView2;
    List<Category> categoryList;
    List<Recipe> recipeList;
    ShimmerFrameLayout shimmerFrameLayout1, shimmerFrameLayout2;
    SwipeRefreshLayout refreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate( R.layout.fragment_home, container, false);
        shimmerFrameLayout1 = view.findViewById(R.id.shimmerLayout1);
        shimmerFrameLayout2 = view.findViewById(R.id.shimmerLayout2);
        refreshLayout = view.findViewById(R.id.swipe_refresh_layout_main);
        //rv trending recipe
        recyclerView=view.findViewById(R.id.rv_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        //rv trending category
        recyclerView2=view.findViewById(R.id.rv_cat);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false); //cegah refresh icon muncul terus
                getData();

            }
        });

        getData();
        return view;
    }


    public void getData(){

        Call<GetCategory> call2= Config.getInstance().getApi().categories();
        call2.enqueue(new Callback<GetCategory>() {
            @Override
            public void onResponse(Call<GetCategory> call, Response<GetCategory> response) {

                if(response.isSuccessful()){



                    categoryList = response.body().getCategoryList();
                    recyclerView2.setAdapter(new CategoryAdapter(getActivity(), categoryList));
                    shimmerFrameLayout2.startShimmer();
                    shimmerFrameLayout2.setVisibility(View.GONE);
                    recyclerView2.setVisibility(View.VISIBLE);

                }
                else{
                    shimmerFrameLayout2.startShimmer();
                    Toast.makeText(getActivity(), response.body().getError(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<GetCategory> call, Throwable t) {
            }
        });


        Call<GetRecipe> call= Config.getInstance().getApi().recipe();
        call.enqueue(new Callback<GetRecipe>() {
            @Override
            public void onResponse(Call<GetRecipe> call, Response<GetRecipe> response) {

                if(response.isSuccessful()){

                    recipeList =response.body().getRecipeList();
                    recyclerView.setAdapter(new RecipeAdapter(getActivity(), recipeList));
                    shimmerFrameLayout1.startShimmer();
                    shimmerFrameLayout1.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                }
                else{
                    shimmerFrameLayout1.startShimmer();
                    Toast.makeText(getActivity(), response.body().getError(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<GetRecipe> call, Throwable t) {
                Log.d("Hasil", t.getMessage());
            }
        });
    }
    @Override
    public void onResume() {
        shimmerFrameLayout1.startShimmer();
        shimmerFrameLayout2.startShimmer();
        getData();
        super.onResume();
    }

    @Override
    public void onPause() {
        shimmerFrameLayout1.stopShimmer();
        shimmerFrameLayout2.stopShimmer();
        super.onPause();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CardView newBlockButton = (CardView) getActivity().findViewById(
                R.id.search_bar);
        newBlockButton.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.search_bar) {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
        }
    }
}