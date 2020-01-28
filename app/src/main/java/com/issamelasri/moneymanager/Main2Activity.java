package com.issamelasri.moneymanager;

import android.content.SharedPreferences;
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
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


public class Main2Activity extends AppCompatActivity {

    long time;
    TextView click_me;
    String monthYearStr;
    SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy", Locale.getDefault());
    SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {

            Snackbar.make(view, "Saved data", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
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
                R.id.nav_gallery,
                R.id.nav_slideshow,
                R.id.nav_tools,
                R.id.nav_share,
                R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        click_me = findViewById(R.id.click_me);
        click_me.setOnClickListener(v -> {
            PickerMonth pickerDialog = new PickerMonth();
            pickerDialog.setListener((datePicker, year, month, i2) -> {
                monthYearStr = year + "-" + (month + 1) + "-" + i2;
                click_me.setText(formatMonthYear(monthYearStr));

            });
            pickerDialog.show(getSupportFragmentManager(), "MonthYearPickerDialog");

        });

    }

    String formatMonthYear(String str) {
        Date date = null;
        try {
            date = input.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        return sdf.format(date);

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

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh
                = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("date", "");
        click_me.setText(s1);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();
        myEdit.putString("date", click_me.getText().toString());
        myEdit.apply();
    }

}