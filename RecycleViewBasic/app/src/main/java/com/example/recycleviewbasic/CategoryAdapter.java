package com.example.recycleviewbasic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.cateViewHolder> {

    private List<Category> mlist;
    private Context mcontext;

    private RecyclerView rcvCate;
    private CategoryAdapter categoryadapter;


    public CategoryAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Category> list){
        this.mlist=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public cateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcategory,parent,false);
        return new cateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cateViewHolder holder, int position) {
            Category category = mlist.get(position);
            if(category== null){
                return;
            }
            holder.nameCate.setText(category.getNameCate());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mcontext, RecyclerView.HORIZONTAL,false);
            rcvCate.setLayoutManager(linearLayoutManager);
            categoryadapter= new CategoryAdapter(mcontext);
            rcvCate.setAdapter(categoryadapter);
    }

    @Override
    public int getItemCount() {
        if(mlist!=null) {
            return mlist.size();
        }
        return 0;
    }

    public class cateViewHolder extends RecyclerView.ViewHolder {
        private TextView nameCate;
        private List<Book> books;

        public cateViewHolder(@NonNull View itemView) {
            super(itemView);

            nameCate= itemView.findViewById(R.id.tv_cate);
            books= itemView.findViewById(R.id.rcv_cate);

        }
    }
}
