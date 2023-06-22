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
        PronounsAdapter adapter = new PronounsAdapter(captions, ids,this);

        recycler.setAdapter(adapter);

        //================================
        //using shared prefrence to do night mode
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String KEY_NIGHT_MODE = "night_mode";

        Switch switchCompat = findViewById(R.id.switch1);

        isNightModeEnabled = sharedPreferences.getBoolean(KEY_NIGHT_MODE, false);
        switchCompat.setChecked(isNightModeEnabled);

        if (isNightModeEnabled ){
            //switchCompat.setChecked(true);
            setNightMode(isNightModeEnabled);
        }

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isNightModeEnabled){
                    editor.putBoolean(KEY_NIGHT_MODE,false);
                } else {
                    editor.putBoolean(KEY_NIGHT_MODE,true);
                }
                isNightModeEnabled = sharedPreferences.getBoolean(KEY_NIGHT_MODE, false);
                setNightMode(isNightModeEnabled);
                editor.apply();
            }
        });

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(FirstActivity.this,MainActivity.class);
        intent.putExtra("name" ,Pronouns.pronouns[position].getName());

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
        recreate(); // Recreate the activity to apply the new mode
    }

}