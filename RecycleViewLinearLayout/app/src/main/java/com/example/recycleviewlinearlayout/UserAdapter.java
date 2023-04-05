package com.example.recycleviewlinearlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context mConText;
    private List<User> mlist;

    public UserAdapter(Context mConText) {
        this.mConText = mConText;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<User> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mlist.get(position);
        if (user == null) {
            return;
        }
        holder.crImage.setImageResource(user.getResourceImage());
        holder.tv_name.setText(user.getName());
        holder.tv_age.setText(user.getAge());
    }

    @Override
    public int getItemCount() {
        if (mlist != null) {
            return mlist.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView crImage;
        private TextView tv_name;
        private TextView tv_age;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            crImage = itemView.findViewById(R.id.profile_image);
            tv_name = itemView.findViewById(R.id.tv_Name);
            tv_age = itemView.findViewById(R.id.tv_Age);

        }
    }
}


