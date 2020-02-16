package com.issamelasri.moneymanager.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class HomeViewModel extends ViewModel {


    private MutableLiveData<String> date;
    // Create a LiveData with a String
    public HomeViewModel() {

        date = new MutableLiveData<>();
        date.setValue("hello");

    }
    public LiveData<String> getText() {

        return date;
    }

    public void getAmount() {
        date.postValue("ahjak");

    }
}