package com.example.recycleviewcardview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context mContext;
    private List<User> mlist;

    public UserAdapter(Context mContext) {// truyền vào biến môi trường
        this.mContext = mContext;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<User> list ){
            this.mlist= list;
            notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if(mlist !=null){
            return mlist.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mlist.get(position);
        if(user==null){
            return ;
        }
        holder.imageView.setImageResource(user.getResourceImage());
        holder.tvName.setText(user.getName());
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView tvName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.iv_sv);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
