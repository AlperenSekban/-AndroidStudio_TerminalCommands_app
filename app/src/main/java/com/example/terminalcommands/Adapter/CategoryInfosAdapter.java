package com.example.terminalcommands.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.terminalcommands.Models.CategoryInfo;
import com.example.terminalcommands.R;

import java.util.List;

public class CategoryInfosAdapter extends RecyclerView.Adapter<CategoryInfosAdapter.Definations> {

    Context context;
    List<CategoryInfo> list;

    public CategoryInfosAdapter(Context context, List<CategoryInfo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Definations onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_informations_catagory_layout, parent, false);
        return new Definations(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Definations holder, int position) {
        Log.i("asdfg",list.get(position).getText());
        holder.categoryText.setText(list.get(position).getText());
        holder.categoryDetail.setText(list.get(position).getDetail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Definations extends RecyclerView.ViewHolder {
        final TextView categoryText;
        final TextView categoryDetail;

        public Definations(@NonNull View itemView) {
            super(itemView);
            categoryText = itemView.findViewById(R.id.recyclerview_informations_category_layout_text_textView);
            categoryDetail=itemView.findViewById(R.id.recyclerview_informations_category_layout_detail_textView);

        }
    }
}
