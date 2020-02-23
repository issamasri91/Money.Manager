package com.issamelasri.moneymanager.ui.dashboard;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.issamelasri.moneymanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Dashboard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        infoThree();


    }

    public void infoThree() {
        Bundle extras = getIntent().getExtras();
        String userName;
        String pass;
        String spinner;
        if (extras != null) {
            userName = extras.getString("amount");
            textView1.setText(userName);
            pass = extras.getString("date");
            textView2.setText(pass);
            spinner = extras.getString("type");
            textView3.setText(spinner);
            // and get whatever type user account id is
        }

    }

}