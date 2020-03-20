package com.issamelasri.moneymanager.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.issamelasri.moneymanager.R;
import com.issamelasri.moneymanager.databinding.ActivityAddBinding;
import com.issamelasri.moneymanager.ui.pojo.PostModel;

import java.util.Objects;


public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    final static String REQ_CODE_POSTS = "posts";
    public final String DATE_USER = "dateUser";
    public final String TYPE_USER = "typeUser";
    public final String AMOUNT_USER = "amountUser";
    Button saveButton;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private ActivityAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar();
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sp.edit();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    String date = binding.etDate.getText().toString();
                    String type = binding.etType.getText().toString();
                    int amount = Integer.parseInt(binding.etAmount.getText().toString());
                    saveData();
                    PostModel postModel = new PostModel(date, amount, type);
                    Intent intent = new Intent();
                    intent.putExtra(REQ_CODE_POSTS, postModel);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    public void saveData() {
        String date = binding.etDate.getText().toString();
        String type = binding.etType.getText().toString();
        int amount = Integer.parseInt(binding.etAmount.getText().toString());
        editor.putString(DATE_USER, date);
        editor.putString(TYPE_USER, type);
        editor.putInt(AMOUNT_USER, amount);
        editor.apply();
    }

    public void restoreData() {
        String date, type;
        int amount;
        date = sp.getString(DATE_USER, "null");
        type = sp.getString(TYPE_USER, "null");
        amount = sp.getInt(AMOUNT_USER, 0);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveData();
    }


    private boolean validateFields() {
        int yourDesiredLength = 1;
        if (Objects.requireNonNull(binding.etDate.getText()).length() < yourDesiredLength) {
            binding.etDate.setError("Your Input is Invalid");
            return false;
        } else if (Objects.requireNonNull(binding.etAmount.getText()).length() < yourDesiredLength) {
            binding.etAmount.setError("Your Input is Invalid");
            return false;
        } else if (Objects.requireNonNull(binding.etType.getText()).length() < yourDesiredLength) {
            binding.etType.setError("Your Input is Invalid");
            return false;
        }
        {
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
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // String string = "Select type of transaction";
        // Toast.makeText(parent.getContext(), string, Toast.LENGTH_SHORT).show();

    }
    /*
    public void loadData() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sp.getInt(TEXT, -1);
        Toast.makeText(this, "loadData"+text, Toast.LENGTH_LONG).show();
    }

    public void updateViews() {
      textView.setText(""+text);
        Toast.makeText(this, "updateViews"+text, Toast.LENGTH_LONG).show();

    }
*/

}
