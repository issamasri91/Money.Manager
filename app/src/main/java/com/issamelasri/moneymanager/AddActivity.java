package com.issamelasri.moneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.issamelasri.moneymanager.ui.dashboard.Main3Activity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.textAmount)
    EditText textAmount;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.textDate)
    EditText textDate;
    @BindView(R.id.buttonSubmit)
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Add transaction");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.transaction, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        buttonSubmit.setOnClickListener(v -> openHomeFragment());
    }

    public void openHomeFragment() {
        Intent i = new Intent(this, Main3Activity.class);
        i.putExtra("amount", textAmount.getText().toString());
        i.putExtra("date", textDate.getText().toString());
        Bundle mBundle = new Bundle();
        if (validateFields()) {
            // Then Submit
            mBundle.putString("amount", textAmount.getText().toString());
            mBundle.putString("date", textDate.getText().toString());
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        String string = "Select type of transaction";
        Toast.makeText(parent.getContext(), string, Toast.LENGTH_SHORT).show();

    }
}
