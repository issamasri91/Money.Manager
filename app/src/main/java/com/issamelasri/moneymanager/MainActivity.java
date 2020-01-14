package com.issamelasri.moneymanager;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.net.DatagramPacket;

public class MainActivity extends AppCompatActivity {
    public TextView name;
    public Button signOut;
    public TextView mail;
    public ImageView photoUrl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoUrl = findViewById(R.id.imageView3);
        mail =findViewById(R.id.userMail);
        name = findViewById(R.id.userName);
        signOut = findViewById(R.id.logout);
        signOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            finish();
            Toast.makeText(MainActivity.this, "sign out", Toast.LENGTH_LONG).show();

        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {


            name.setText(user.getDisplayName());
            mail.setText(user.getEmail());



        }

    }
    public void btnNext(View v){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        Bundle b = new Bundle();
        b.putString("username",name.getText().toString());
        b.putString("usermail",mail.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
    }


}