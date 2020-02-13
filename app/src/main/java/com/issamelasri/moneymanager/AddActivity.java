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

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String AMOUNT_TEXT = "com.issamelasri.moneymanager.AMOUNT_TEXT";
    public static final String DATE_TEXT = "com.issamelasri.moneymanager.DATE_TEXT";

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

        int amount = Integer.parseInt(textAmount.getText().toString());
        int date = Integer.parseInt(textDate.getText().toString());
        Intent intentTwo = new Intent(this, Main2Activity.class);
        intentTwo.putExtra("AMOUNT_TEXT", amount);
        intentTwo.putExtra("DATE_TEXT", date);
        startActivity(intentTwo);
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
