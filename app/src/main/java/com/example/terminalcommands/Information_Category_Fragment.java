package com.example.terminalcommands;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.terminalcommands.Adapter.CategoryInfosAdapter;
import com.example.terminalcommands.Models.CategoryInfo;
import com.example.terminalcommands.R;
import com.example.terminalcommands.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Information_Category_Fragment extends Fragment {

    View view;
    List<CategoryInfo> categoryInfos;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CategoryInfosAdapter adp;
    String url;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_information__category, container, false);
        definations();
        response();


        return view;
    }

    private void response() {
        Call<List<CategoryInfo>> categoriesService = ManagerAll.getInstance().bringInfromations(url);
        final ProgressDialog progressDialog=new ProgressDialog(getContext());
        progressDialog.setTitle("İçeriğe Erişiliyor");
        progressDialog.setMessage("İçerik Yükleniyor, Lütfen Bekleyiniz...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        categoriesService.enqueue(new Callback<List<CategoryInfo>>() {
            @Override
            public void onResponse(Call<List<CategoryInfo>> call, Response<List<CategoryInfo>> response) {
                if (response.isSuccessful()) {

                    Log.i("sadf","sucss");
                    categoryInfos = response.body();
                    adp = new CategoryInfosAdapter(getContext(), categoryInfos);
                    recyclerView.setAdapter(adp);
                }

                progressDialog.cancel();
            }

            @Override
            public void onFailure(Call<List<CategoryInfo>> call, Throwable t) {

            }
        });
    }

    private void definations() {

        url = getArguments().getString("id");
        categoryInfos = new ArrayList<>();
        recyclerView = view.findViewById(R.id.fragment_informations_category_recyclerview);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }
}