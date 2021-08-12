package com.yusaoruc.UsersRetrofit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yusaoruc.UsersRetrofit.R;
import com.yusaoruc.UsersRetrofit.service.UsersAPI;
import com.yusaoruc.UsersRetrofit.adapter.RecyclerViewAdapter;
import com.yusaoruc.UsersRetrofit.model.UsersModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<UsersModel> usersModelArrayList;
    private String BASE_URL="https://jsonplaceholder.typicode.com/";
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    Retrofit retrofit;
    Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recyclerView);

        gson = new GsonBuilder().setLenient().create();

        retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        getData();
    }
    public void getData(){
        UsersAPI userAPI = retrofit.create(UsersAPI.class);

        Call<List<UsersModel>> call = userAPI.getData();

        call.enqueue(new Callback<List<UsersModel>>() {
            @Override
            public void onResponse(Call<List<UsersModel>> call, Response<List<UsersModel>> response) {
                    if(response.isSuccessful()){
                        List<UsersModel> responseList= response.body();
                        usersModelArrayList = new ArrayList<>(responseList);

                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerViewAdapter = new RecyclerViewAdapter(usersModelArrayList);
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }
            }

            @Override
            public void onFailure(Call<List<UsersModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}