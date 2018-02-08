package com.pengyuu.androidstockchart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * K线图
     *
     * @param view
     */
    public void onCandleClick(View view) {
        startActivity(new Intent(MainActivity.this, CandleStickChartActivity.class));
    }

    /**
     * 分时图
     *
     * @param view
     */
    public void onImmediateClick(View view) {
        startActivity(new Intent(MainActivity.this, ImmediateActivity.class));
    }
}
