package com.hetapp.ultimatefrisbeerules;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruseck on 22.09.15.
 */
public class VocabularyActivity extends AppCompatActivity {


    ListView lv;
    final String ITEM="item";
    final String TEXT="text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_rules);

        lv=(ListView)findViewById(R.id.lv);

        String[]from={ITEM,TEXT};
        int[]to={R.id.tv_item,R.id.tv_text};

        ArrayList<Map<String,Object>> data=new ArrayList<Map<String, Object>>();
        Map m;
        String[]item=getResources().getStringArray(R.array.voc_worlds);
        String[]text=getResources().getStringArray(R.array.voc_definitions);
        for(int i=0;i<item.length;i++) {
            m=new HashMap<String,Object>();
            m.put(ITEM,item[i]);
            m.put(TEXT,text[i]);
            data.add(m);
        }
        SimpleAdapter adapter=new SimpleAdapter(this,data,R.layout.my_item_short_rules,from,to);
        lv.setAdapter(adapter);
    }


}
