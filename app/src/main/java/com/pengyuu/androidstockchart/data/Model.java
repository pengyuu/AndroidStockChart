package com.pengyuu.androidstockchart.data;

import com.github.mikephil.charting.data.CandleEntry;

/**
 * Created by dell on 2017/11/23.
 */

public class Model extends CandleEntry {
    private double mClose;
    private double mHigh;
    private double mLow;
    private double mOpen;
    private int mVol;
    private String sDate;

    /**
     * Constructor.
     *
     * @param x       The value on the x-axis
     * @param shadowH The (shadow) high value
     * @param shadowL The (shadow) low value
     * @param mOpen    The mOpen value
     * @param mClose   The mClose value
     */
    public Model(float x, float shadowH, float shadowL, float mOpen, float mClose) {
        super(x, shadowH, shadowL, mOpen, mClose);
    }

    public double getmClose() {
        return mClose;
    }

    public void setmClose(double mClose) {
        this.mClose = mClose;
    }

    public double getmHigh() {
        return mHigh;
    }

    public void setmHigh(double mHigh) {
        this.mHigh = mHigh;
    }

    public double getmLow() {
        return mLow;
    }

    public void setmLow(double mLow) {
        this.mLow = mLow;
    }

    public double getmOpen() {
        return mOpen;
    }

    public void setmOpen(double mOpen) {
        this.mOpen = mOpen;
    }

    public int getmVol() {
        return mVol;
    }

    public void setmVol(int mVol) {
        this.mVol = mVol;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    @Override
    public String toString() {
        return "Model{" +
                "mClose=" + mClose +
                ", mHigh=" + mHigh +
                ", mLow=" + mLow +
                ", mOpen=" + mOpen +
                ", mVol=" + mVol +
                ", sDate='" + sDate + '\'' +
                '}';
    }
}
