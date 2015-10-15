package com.hetapp.ultimatefrisbeerules;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruseck on 22.09.15.
 */
public class RulesActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
    SimpleAdapter adapter;
    final String ITEM = "item";
    final String TEXT = "text";
    int[] rulesRes = { R.array.rules0, R.array.rules1, R.array.rules2, R.array.rules3,
            R.array.rules4, R.array.rules5, R.array.rules6, R.array.rules7, R.array.rules8,
            R.array.rules9, R.array.rules10, R.array.rules11, R.array.rules12, R.array.rules13,
            R.array.rules14, R.array.rules15, R.array.rules16, R.array.rules17, R.array.rules18,
            R.array.rules19, R.array.rules20 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        lv = (ListView) findViewById(R.id.lv);

        String[] from = {ITEM, TEXT};
        int[] to = {R.id.tv_item, R.id.tv_text};

        String[] text = getResources().getStringArray(R.array.title);
        for (int i = 0; i < text.length; i++) {
            Map m = new HashMap<String, Object>();
            if (i != 0)
                m.put(ITEM, i + ". ");
            m.put(TEXT, text[i]);
            data.add(m);
        }

        adapter = new SimpleAdapter(this, data, R.layout.my_item_rules_title, from, to);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("ml", "click " + position);
                startActivity(new Intent(getApplicationContext(),ChapterRulesActivity.class).putExtra("chapter",position));
            }
        });
    }

}
