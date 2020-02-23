package com.issamelasri.moneymanager.ui.send;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.issamelasri.moneymanager.ui.dashboard.Main3Activity;

public class SendViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private Main3Activity main3Activity;

    public SendViewModel() {
        mText = new MutableLiveData<>();
        main3Activity = new Main3Activity();
        mText.setValue("hiho");
    }

    public LiveData<String> getText() {
        return mText;
    }

}