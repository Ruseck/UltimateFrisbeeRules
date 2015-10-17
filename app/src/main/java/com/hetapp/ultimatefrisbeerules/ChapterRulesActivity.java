package com.hetapp.ultimatefrisbeerules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruseck on 22.09.15.
 */
public class ChapterRulesActivity extends AppCompatActivity {

    ExpandableListView elv;

    ArrayList<Map<String, Object>> groupData;
    ArrayList<Map<String, Object>> childDataItem;
    ArrayList<ArrayList<Map<String, Object>>> childData;
    Map<String, Object> m;
    final String ITEM = "item";
    final String TEXT = "text";
    int[] rulesRes = {R.array.rules0, R.array.rules1, R.array.rules2, R.array.rules3,
            R.array.rules4, R.array.rules5, R.array.rules6, R.array.rules7, R.array.rules8,
            R.array.rules9, R.array.rules10, R.array.rules11, R.array.rules12, R.array.rules13,
            R.array.rules14, R.array.rules15, R.array.rules16, R.array.rules17, R.array.rules18,
            R.array.rules19, R.array.rules20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_rules);
        setTitle(getResources().getStringArray(R.array.title)[getIntent().getIntExtra("chapter", 0)]);
        groupData = new ArrayList<Map<String, Object>>();
        for (String group : getResources().getStringArray(rulesRes[getIntent().getIntExtra("chapter",0)])) {
            m = new HashMap<String, Object>();
            m.put("groupName", group);
             m.put("groupExtra",R.drawable.group_close_ic);
            groupData.add(m);
        }
        String groupFrom[] = new String[]{"groupName"};
        int groupTo[] = new int[]{R.id.textView};

        childData = new ArrayList<ArrayList<Map<String, Object>>>();
        childDataItem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < getResources().getStringArray(rulesRes[getIntent().getIntExtra("chapter",0)]).length; i++) {
            childData.add(childDataItem);
        }
        String childFrom[] = new String[]{"itemName"};
        int childTo[] = new int[]{R.id.textView};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                R.layout.expandable_list_item,
                groupFrom,
                groupTo,
                childData,
                R.layout.expandable_list_item_child,
                childFrom,
                childTo);

        elv = (ExpandableListView) findViewById(R.id.elv);
        elv.setAdapter(adapter);

    }

}

