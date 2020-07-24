package com.example.terminalcommands;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.terminalcommands.Adapter.CategoriesAdapter;
import com.example.terminalcommands.Models.Categories;
import com.example.terminalcommands.RestApi.ManagerAll;
import com.example.terminalcommands.ui.home.AdapterOnClick;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesFragment extends Fragment  implements AdapterOnClick {

    View view;
    List<Categories> categoriesList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CategoriesAdapter adp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categories, container, false);

        definations();
        response();


        return view;
    }

    private void definations() {
        recyclerView = view.findViewById(R.id.fragment_home_categories_recyclerview);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        categoriesList = new ArrayList<>();
    }

    private void response() {
        Call<List<Categories>> categoriesService = ManagerAll.getInstance().bringCategories("/api/categories?language=TR");


        final ProgressDialog progressDialog=new ProgressDialog(getContext());
        progressDialog.setTitle("Bilgiler Ekranı");
        progressDialog.setMessage("İçerik Yükleniyor, Lütfen Bekleyiniz...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        categoriesService.enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {

                if (response.isSuccessful()) {
                    categoriesList = response.body();
                    adp = new CategoriesAdapter((getContext()), categoriesList, CategoriesFragment.this);
                    recyclerView.setAdapter(adp);

                }
                progressDialog.cancel();

            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {

            }
        });

    }
    @Override
    public void onClick(int position) {
        Information_Category_Fragment informationCategoryFragment=new Information_Category_Fragment();
        Bundle bundle =new Bundle();
        bundle.putString("id",categoriesList.get(position).getId());
        informationCategoryFragment.setArguments(bundle);


        ((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_home_frameLayout, informationCategoryFragment,"informationCategory")
                .addToBackStack(null)
                .commit();

    }
}