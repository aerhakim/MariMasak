package io.github.aerhakim.marimasak.utils.api;




import io.github.aerhakim.marimasak.models.GetCategory;
import io.github.aerhakim.marimasak.models.GetRecipe;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("recipe")
    Call<GetRecipe> recipe();

    @GET("categories")
    Call<GetCategory> categories();
//
//    @GET("search?q=")
//    Call<GetSearch> search();


}
