package com.pengyuu.androidstockchart;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.pengyuu.androidstockchart.utils.DataUtil;

import java.util.List;

public class CandleStickChartActivity extends AppCompatActivity implements OnChartGestureListener, OnChartValueSelectedListener {
    private CandleStickChart viewCandle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candle_stick_chart);

        initView();
        setData();
    }

    private void setData() {
        List<CandleEntry> yVals1 = DataUtil.getHisData(this);

        CandleDataSet set1 = new CandleDataSet(yVals1, "Data Set");

        set1.setDrawIcons(false);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
//        set1.setColor(Color.rgb(80, 80, 80));
        set1.setShadowColor(Color.DKGRAY);
        set1.setShadowWidth(0.7f);
        set1.setDecreasingColor(Color.RED);
        set1.setDecreasingPaintStyle(Paint.Style.FILL);
        set1.setIncreasingColor(Color.rgb(122, 242, 84));
        set1.setIncreasingPaintStyle(Paint.Style.STROKE);
        set1.setNeutralColor(Color.BLUE);
        //set1.setHighlightLineWidth(1f);

        CandleData data = new CandleData(set1);

        viewCandle.setData(data);
        viewCandle.invalidate();
    }

    private void initView() {
        viewCandle = findViewById(R.id.view_candle);
        viewCandle.setScaleYEnabled(false);//y轴禁止缩放
        viewCandle.setScaleXEnabled(true);//x轴可以缩放
        viewCandle.setDrawBorders(true);//是否绘制边线
        viewCandle.setBorderWidth(1);//边线宽度，单位dp
        viewCandle.setBorderColor(0x000000);//边线颜色
        viewCandle.setMaxVisibleValueCount(50);
        viewCandle.setDragEnabled(true);//启用图表拖拽事件
        viewCandle.setDescription(new Description());//图表的描述信息
        viewCandle.setNoDataText("无数据");//无数据是描述
        viewCandle.setDrawGridBackground(false);
        viewCandle.setGridBackgroundColor(0x000000);
        viewCandle.setOnChartGestureListener(this);
        viewCandle.setAutoScaleMinMaxEnabled(true);

        viewCandle.setOnChartValueSelectedListener(this);
        viewCandle.setTouchEnabled(true);
        viewCandle.setDragEnabled(true);
        viewCandle.setScaleEnabled(true);
        viewCandle.setPinchZoom(false);
        XAxis xAxis = viewCandle.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);

        YAxis leftAxis = viewCandle.getAxisLeft();
//        leftAxis.setEnabled(false);
        leftAxis.setLabelCount(7, false);
        leftAxis.setDrawGridLines(true);
        leftAxis.setDrawAxisLine(true);

        YAxis rightAxis = viewCandle.getAxisRight();
        rightAxis.setEnabled(true);
        viewCandle.getLegend().setEnabled(true);

    }

    /**
     * Callbacks when a touch-gesture has started on the chart (ACTION_DOWN)
     *
     * @param me
     * @param lastPerformedGesture
     */
    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    /**
     * Callbacks when a touch-gesture has ended on the chart (ACTION_UP, ACTION_CANCEL)
     *
     * @param me
     * @param lastPerformedGesture
     */
    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    /**
     * Callbacks when the chart is longpressed.
     *
     * @param me
     */
    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    /**
     * Callbacks when the chart is double-tapped.
     *
     * @param me
     */
    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    /**
     * Callbacks when the chart is single-tapped.
     *
     * @param me
     */
    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    /**
     * Callbacks then a fling gesture is made on the chart.
     *
     * @param me1
     * @param me2
     * @param velocityX
     * @param velocityY
     */
    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    /**
     * Callbacks when the chart is scaled / zoomed via pinch zoom gesture.
     *
     * @param me
     * @param scaleX scalefactor on the x-axis
     * @param scaleY scalefactor on the y-axis
     */
    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    /**
     * Callbacks when the chart is moved / translated via drag gesture.
     *
     * @param me
     * @param dX translation distance on the x-axis
     * @param dY translation distance on the y-axis
     */
    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    /**
     * Called when a value has been selected inside the chart.
     *
     * @param e The selected Entry
     * @param h The corresponding highlight object that contains information
     */
    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    /**
     * Called when nothing has been selected or an "un-select" has been made.
     */
    @Override
    public void onNothingSelected() {

    }
}
