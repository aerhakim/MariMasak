package io.github.aerhakim.marimasak.utils.api;

import io.github.aerhakim.marimasak.models.GetCategory;
import io.github.aerhakim.marimasak.models.GetDetail;
import io.github.aerhakim.marimasak.models.GetRecipe;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("recipes")
    Call<GetRecipe> recipe();

    @GET("categorys/recipes")
    Call<GetCategory> categories();

    @GET("recipe/{key}/")
    Call<GetDetail> detail(
            @Path("key") String key);



}
