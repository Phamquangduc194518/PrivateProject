package com.example.recycleviewbasic;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    private Context mcontext;
    private List<Book> mlist;

    public BookAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void setData(List<Book> list){
        this.mlist=list;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itembook,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = mlist.get(position);
            if(book== null){
                return;
            }
            holder.image.setImageResource(book.getImagae());
            holder.name.setText(book.getName());
    }

    @Override
    public int getItemCount() {
        if(mlist!=null){
            return mlist.size();
        }
        return 0;
    }


    public class BookViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.img_book);
            name=itemView.findViewById(R.id.tv_name);

        }
    }
}
