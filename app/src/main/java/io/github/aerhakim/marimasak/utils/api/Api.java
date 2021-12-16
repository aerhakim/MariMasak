package io.github.aerhakim.marimasak.utils.api;

import io.github.aerhakim.marimasak.models.GetCategory;
import io.github.aerhakim.marimasak.models.GetDetailCategory;
import io.github.aerhakim.marimasak.models.GetRecipe;
import io.github.aerhakim.marimasak.models.GetSearch;
import io.github.aerhakim.marimasak.models.ResultsResponse;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("recipes")
    Call<GetRecipe> recipe();

    @GET("categorys/recipes")
    Call<GetCategory> categories();


    @GET("recipe/{key}")
    Call<ResultsResponse> results(
            @Path("key") String key
    );

    @GET("categorys/recipes/{key}")
    Call<GetDetailCategory> detailcategory(
            @Path("key") String key
    );

    @GET("search")
    Call<GetSearch> search(
            @Query("q") String q
    );


}
