package com.issamelasri.moneymanager.ui.home;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.issamelasri.moneymanager.ui.pojo.PostModel;

import java.util.List;


public class HomeViewModel extends ViewModel {

    MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Integer> typemutableLiveData = new MutableLiveData<Integer>();


    public void getType() {
        PostModel postModel = new PostModel();
        typemutableLiveData.setValue(postModel.getExpenses());

    }

}
