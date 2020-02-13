package com.issamelasri.moneymanager;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


public class Main2Activity extends AppCompatActivity {

    long time;
    private AppBarConfiguration mAppBarConfiguration;
    int date;
    int amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intentTwo = getIntent();
        date = intentTwo.getIntExtra(AddActivity.DATE_TEXT, 0);
        amount = intentTwo.getIntExtra(AddActivity.AMOUNT_TEXT, 0);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            openAddActivity();
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //i call here username to nav-header
        View headerView = navigationView.getHeaderView(0);
        TextView username = headerView.findViewById(R.id.userName2);
        assert user != null;
        username.setText(user.getDisplayName());
        TextView useremail = headerView.findViewById(R.id.textViewUser);
        useremail.setText(user.getEmail());
        CircleImageView imageprofile = headerView.findViewById(R.id.PictureProfile);
        try {
            String PhotoUrl = Objects.requireNonNull(user.getPhotoUrl()).toString();
            Picasso.get()
                    .load(PhotoUrl)
                    .fit()
                    .noFade()
                    .into(imageprofile);
        } catch (Exception ignored) {
        }

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_share,
                R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            super.onBackPressed();
            Toast.makeText(Main2Activity.this, "sign out", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();


    }
    @Override
    public void onBackPressed() {
        if (time + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(Main2Activity.this, "Press to exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }

    public void openAddActivity() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}