package com.issamelasri.moneymanager.ui.home;


import android.renderscript.Element;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class HomeViewModel extends ViewModel {
    private MutableLiveData<Integer> typeMutableLiveData = new MutableLiveData<>();
    private AddActivity addActivity = new AddActivity();
    private int b;
    private MutableLiveData<Integer> c;
    private MutableLiveData<Element.DataType> data;
    private String myVariable; //maintainer variable

    public HomeViewModel() {
    }

    public LiveData<Integer> getText() {

        return typeMutableLiveData;
    }

    public LiveData<Integer> getT() {

        return c;
    }


    private void loadData(MutableLiveData<Element.DataType> data, String input) {
    }

}