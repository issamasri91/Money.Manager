package com.issamelasri.moneymanager.ui.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.issamelasri.moneymanager.R;


public class Main3Activity extends AppCompatActivity {
    PieChart pieChart;
    int[] colorClassAray = new int[]{Color.LTGRAY, Color.YELLOW, Color.BLUE};
    Button buttonSub;
    int one, two, three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        pieChart = findViewById(R.id.pieCh);

    }

   /* public ArrayList<PieEntry> datavals() {

        ArrayList<PieEntry> vals = new ArrayList<>();
        vals.add(new PieEntry(one = Integer.parseInt(Objects.requireNonNull(text1.getText()).toString()), "incomes"));
        vals.add(new PieEntry(two = Integer.parseInt(Objects.requireNonNull(text2.getText()).toString()), "Expenses"));
        return vals;
    }
*/
   /* public void piechart() {
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
*/
}