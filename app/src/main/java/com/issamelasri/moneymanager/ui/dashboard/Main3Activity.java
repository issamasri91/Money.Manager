package com.issamelasri.moneymanager.ui.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.material.textfield.TextInputEditText;
import com.issamelasri.moneymanager.R;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {
    PieChart pieChart;
    int[] colorClassAray = new int[]{Color.LTGRAY, Color.YELLOW, Color.BLUE};
    @BindView(R.id.pieCh)
    PieChart pieCh;
    @BindView(R.id.text1)
    TextInputEditText text1;
    @BindView(R.id.text2)
    TextInputEditText text2;
    @BindView(R.id.buttonSub)
    Button buttonSub;
    int one, two, three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        pieChart = findViewById(R.id.pieCh);
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                piechart();
            }
        });
    }

    public ArrayList<PieEntry> datavals() {

        ArrayList<PieEntry> vals = new ArrayList<>();
        vals.add(new PieEntry(one = Integer.parseInt(Objects.requireNonNull(text1.getText()).toString()), "incomes"));
        vals.add(new PieEntry(two = Integer.parseInt(Objects.requireNonNull(text2.getText()).toString()), "Expenses"));
        return vals;
    }

    public void piechart() {
        PieDataSet pieDataSet = new PieDataSet(datavals(), "");
        pieDataSet.setColors(colorClassAray);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
        pieChart.setDrawEntryLabels(true);
        pieChart.setUsePercentValues(false);
        pieChart.setCenterText("Monthly");
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setCenterTextSize(20);
        pieChart.setCenterTextRadiusPercent(80);
        pieChart.setEntryLabelTextSize(15);
        pieChart.setContentDescription("hello");

    }

}