package com.issamelasri.moneymanager.ui.home;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.issamelasri.moneymanager.ui.data.PostsClient;
import com.issamelasri.moneymanager.ui.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeViewModel extends ViewModel {

    MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>();

    public void getPosts() {
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });
    }

}