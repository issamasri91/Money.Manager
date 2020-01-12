package com.issamelasri.moneymanager;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    public TextView name;
    public Button signOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        }

    }
    public void btnNext(View v){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }


}