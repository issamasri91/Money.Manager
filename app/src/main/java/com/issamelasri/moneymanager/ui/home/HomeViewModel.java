package com.issamelasri.moneymanager.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> date;
    // Create a LiveData with a String
    private MutableLiveData<String> currentName;
    public HomeViewModel() {

        date = new MutableLiveData<>();
        date.setValue("");

    }

    public LiveData<String> getText() {
        return date;
    }

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }
}