package com.hetapp.ultimatefrisbeerules;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG="MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButtonClick(View view){
        switch(view.getId()){
            case R.id.b_rules:
                startActivity(new Intent(this,RulesActivity.class));
                break;
            case R.id.b_short_rules:
                startActivity(new Intent(this,ShortRulesActivity.class));
                break;
            case R.id.b_vocabulary:
                startActivity(new Intent(this,VocabularyActivity.class));
                break;
        }
    }
}
