package com.pengyuu.androidstockchart;

import android.content.Context;

import com.github.mikephil.charting.data.CandleEntry;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据解析的示例，数据来自于R.raw.his_data的json
 * Created by guoziwei on 2017/11/23.
 */

public class DataUtil {
    public static List<CandleEntry> getHisData(Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.his_data);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String json = writer.toString();
        final List<Model> list = new Gson().fromJson(json, new TypeToken<List<Model>>() {}.getType());
        List<CandleEntry> candleEntries = new ArrayList<>(100);
        for (int i = 0; i < list.size(); i++) {
            CandleEntry data = new CandleEntry(i,list.get(i).getHigh(),list.get(i).getLow(),list.get(i).getOpen(),list.get(i).getClose());
            candleEntries.add(data);
        }
        return candleEntries;
    }
}
