package com.issamelasri.moneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.issamelasri.moneymanager.ui.dashboard.Main3Activity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.buttonSubmit)
    Button buttonSubmit;
    @BindView(R.id.textInputLayout2)
    TextInputLayout textInputLayout2;
    @BindView(R.id.textInputLayout)
    TextInputLayout textInputLayout;
    @BindView(R.id.textDate)
    TextInputEditText textDate;
    @BindView(R.id.textAmount)
    TextInputEditText textAmount;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Add transaction");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.transaction, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        buttonSubmit.setOnClickListener(v -> openHomeFragment());
    }

    public void openHomeFragment() {
        Intent i = new Intent(this, Main3Activity.class);
        i.putExtra("amount", textAmount.getText().toString());
        i.putExtra("date", textDate.getText().toString());
        i.putExtra("type", type);
        Bundle mBundle = new Bundle();
        if (validateFields()) {
            // Then Submit
            mBundle.putString("amount", textAmount.getText().toString());
            mBundle.putString("date", textDate.getText().toString());
            mBundle.putString("type", type);
            i.putExtras(mBundle);
            startActivity(i);
        }
    }

    private boolean validateFields() {
        int yourDesiredLength = 1;
        if (textDate.getText().length() < yourDesiredLength) {
            textDate.setError("Your Input is Invalid");
            return false;
        } else if (textAmount.getText().length() < yourDesiredLength) {
            textAmount.setError("Your Input is Invalid");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu3, menu);
        MenuItem item = menu.findItem(R.id.spinner2);
        Spinner spinner2 = (Spinner) item.getActionView();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.transaction, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        type = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), type, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        String string = "Select type of transaction";
        Toast.makeText(parent.getContext(), string, Toast.LENGTH_SHORT).show();

    }
}
