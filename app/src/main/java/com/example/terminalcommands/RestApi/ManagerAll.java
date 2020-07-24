package com.example.terminalcommands.RestApi;

import com.example.terminalcommands.Models.Categories;
import com.example.terminalcommands.Models.CategoryInfo;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourgetInstance=new ManagerAll();

    public static synchronized ManagerAll getInstance(){return ourgetInstance;}

    public Call<List<Categories>> bringCategories(String url){
        Call<List<Categories>> categoriesList=getRestApiClient().bringCategories();
        return categoriesList;
    }
    public Call<List<CategoryInfo>> bringInfromations(String url){
        Call<List<CategoryInfo>> categoryInfo=getRestApiClient().bringCategoryInfo(url);
        return  categoryInfo;
    }
}
