package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class FirstActivity extends AppCompatActivity implements  RecycleViewInterface {
    boolean isNightModeEnabled;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        RecyclerView recycler = findViewById(R.id.pronouns_recyclerView);

        String[] captions = new String[Pronouns.pronouns.length];
        int[] ids = new int[Pronouns.pronouns.length];

        for(int i = 0; i<captions.length;i++){
            captions[i] = Pronouns.pronouns[i].getName();
            ids[i] = Pronouns.pronouns[i].getImageID();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        PronounsAdapter adapter = new PronounsAdapter(this,captions, ids,this);

        recycler.setAdapter(adapter);


        //================================
        //using shared preference to do night mode
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String KEY_NIGHT_MODE = "night_mode";

        Switch switchCompat = findViewById(R.id.switch1);

        isNightModeEnabled = sharedPreferences.getBoolean(KEY_NIGHT_MODE, false);
        switchCompat.setChecked(isNightModeEnabled);

        if (isNightModeEnabled){
            switchCompat.setChecked(true);
            setNightMode(isNightModeEnabled);
        }

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isNightModeEnabled){
                    setNightMode(false);
                    editor = sharedPreferences.edit();
                    editor.putBoolean(KEY_NIGHT_MODE,false);

                } else {
                    setNightMode(true);
                    editor = sharedPreferences.edit();
                    editor.putBoolean(KEY_NIGHT_MODE,true);
                }
                editor.apply();
            }
        });

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(FirstActivity.this,MainActivity.class);
       // intent.putExtra("name" ,Pronouns.pronouns[position].getName());

        startActivity(intent);
    }

    private void setNightMode(boolean isNightModeEnabled) {
        if (isNightModeEnabled) {
            // Apply night mode styles
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            // Apply day mode styles
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}