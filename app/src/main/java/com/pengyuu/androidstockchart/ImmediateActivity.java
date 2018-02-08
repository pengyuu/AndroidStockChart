package com.pengyuu.androidstockchart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.pengyuu.androidstockchart.bean.DataParse;
import com.pengyuu.androidstockchart.utils.ConstantTest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ImmediateActivity extends AppCompatActivity {
    //分时图
    private LineChart chartImmediate;

    //数据
    private DataParse mData;

    //x轴时间
    private List<String> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immediate);

        initView();
        getOffLineData();
        setData();
    }

    private void initView() {
        chartImmediate = findViewById(R.id.chart_immediate);
        chartImmediate.setDrawBorders(true);//显示边框
        chartImmediate.setScaleEnabled(false);

        XAxis xAxis = chartImmediate.getXAxis();//得到X轴
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//值：BOTTOM,BOTH_SIDED,BOTTOM_INSIDE,TOP,TOP_INSIDE

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mList.get((int) value); //mList为存有月份的集合
            }
        });
    }

    private void setData() {
        mList = new ArrayList<>();
        mList.add("9:30");
        mList.add("10:30");
        mList.add("11:30/13:00");
        mList.add("14:00");
        mList.add("15:00");
        //设置数据
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            entries.add(new Entry(i, (float) (Math.random()) * 80));
        }
        //一个LineDataSet就是一条线
        LineDataSet lineDataSet = new LineDataSet(entries, "温度");
        LineData data = new LineData(lineDataSet);
        chartImmediate.setData(data);
    }

    private void getOffLineData() {
           /*方便测试，加入假数据*/
        mData = new DataParse();
        JSONObject object = null;
        try {
            object = new JSONObject(ConstantTest.MINUTESURL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mData.parseMinutes(object);
    }
}
