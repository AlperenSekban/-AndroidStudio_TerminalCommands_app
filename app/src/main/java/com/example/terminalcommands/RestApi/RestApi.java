package com.example.terminalcommands.RestApi;

import com.example.terminalcommands.Models.Categories;
import com.example.terminalcommands.Models.CategoryInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {
    @GET("/api/categories?language=TR")
    Call<List<Categories>> bringCategories();
    @GET("/api/categories/{categoryId}/commands")
    Call<List<CategoryInfo>> bringCategoryInfo(@Path("categoryId") String categoryId);
}
