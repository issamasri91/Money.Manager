package com.issamelasri.moneymanager;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public class NavagationHeader extends AppCompatActivity {

    public TextView usern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main2);
        usern = findViewById(R.id.textViewUser);
 FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
 if (user != null)
    usern.setText(user.getDisplayName());




    }


}
