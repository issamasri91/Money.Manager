package com.issamelasri.moneymanager.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.issamelasri.moneymanager.ExamplDialog;
import com.issamelasri.moneymanager.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;


    public HomeFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final TextView textView2 = root.findViewById(R.id.text_home_two);
        final Button aboutBtn = root.findViewById(R.id.buttonf);
        aboutBtn.setOnClickListener(this);
        return root;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonf:
                //what to put here
                FragmentManager fm = getFragmentManager();
                assert fm != null;
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.nav_host_fragment, new ExamplDialog(), "fragment_screen");
                ft.commit();
                break;
        }

    }

}