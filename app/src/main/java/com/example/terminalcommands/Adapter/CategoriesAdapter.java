package com.example.terminalcommands.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.terminalcommands.ui.home.AdapterOnClick;
import com.example.terminalcommands.Models.Categories;
import com.example.terminalcommands.R;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.Definations> {

    Context context;
    List<Categories> list;
    AdapterOnClick adapterOnClick;

    public CategoriesAdapter(Context context, List<Categories> list, AdapterOnClick adapterOnClick) {
        this.context = context;
        this.list = list;
        this.adapterOnClick = adapterOnClick;
    }

    @NonNull
    @Override
    public Definations onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_categories_layout, parent, false);

        return new Definations(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Definations holder, int position) {
        holder.categoryName.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Definations extends RecyclerView.ViewHolder {
        final TextView categoryName;

        public Definations(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.recyclerview_categories_layout_category_textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapterOnClick.onClick(getAdapterPosition());
                }
            });
        }
    }

}
