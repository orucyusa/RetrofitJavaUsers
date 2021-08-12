package com.yusaoruc.UsersRetrofit.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yusaoruc.UsersRetrofit.R;
import com.yusaoruc.UsersRetrofit.model.UsersModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {

    private ArrayList<UsersModel> usersModelsL;
    View view;

    private String [] colors ={"#a3ff00","#ff00aa","#b4a7d6","#8ee5ee"};

    public RecyclerViewAdapter(ArrayList<UsersModel> usersModels){
        this.usersModelsL=usersModels;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.row_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RowHolder holder, int position) {
        holder.bind(usersModelsL.get(position),colors,position);
    }

    @Override
    public int getItemCount() {
        return usersModelsL.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        TextView textid;
        TextView textname;
        TextView textuserName;
        TextView textemail;
        TextView textphone;


        public RowHolder(@NonNull View itemView) {
            super(itemView);
            textid = itemView.findViewById(R.id.text_id);
            textname=itemView.findViewById(R.id.text_name);
            textuserName=itemView.findViewById(R.id.text_userName);
            textemail=itemView.findViewById(R.id.text_email);
            textphone=itemView.findViewById(R.id.text_phone);
        }

        public void bind(UsersModel userModel, String [] colors, Integer position) {
            itemView.setBackgroundColor(Color.parseColor(colors[position % 4]));

            textid=itemView.findViewById(R.id.text_id);
            textname=itemView.findViewById(R.id.text_name);
            textuserName=itemView.findViewById(R.id.text_userName);
            textemail=itemView.findViewById(R.id.text_email);
            textphone=itemView.findViewById(R.id.text_phone);

            textid.setText("id : "+String.valueOf(userModel.id));
            textname.setText("Name : "+userModel.name);
            textuserName.setText("User Name : "+userModel.username);
            textemail.setText("Email : "+userModel.email);
            textphone.setText("Phone : "+userModel.phone);
        }
    }
}
