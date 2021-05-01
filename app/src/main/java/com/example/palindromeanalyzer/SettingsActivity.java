package com.example.palindromeanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    RadioGroup rdgrppict;
    ImageView imgvbkgrnd;
    int rdbtnchsd;
    MediaPlayer palindromic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        rdgrppict = (RadioGroup) findViewById(R.id.radioGroupPicture);
        imgvbkgrnd = (ImageView) findViewById(R.id.imageViewBackground);
        Switch playloopm = (Switch) findViewById(R.id.switchMusic);
        palindromic = MediaPlayer.create(this, R.raw.music);
        rdgrppict.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdBtnCathedral:
                        imgvbkgrnd.setImageResource(R.drawable.image1);
                        break;
                    case R.id.rdBtnCrystal:
                        imgvbkgrnd.setImageResource(R.drawable.image2);
                        break;
                    case R.id.rdBtnBridge:
                        imgvbkgrnd.setImageResource(R.drawable.image3);
                        break;
                }
            }
        });
        playloopm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    palindromic.start();
                else
                    palindromic.stop();
                palindromic.setLooping(isChecked);
            }
        });
    }

    public void goToAnalyzer (View btngta) {
        rdbtnchsd = rdgrppict.getCheckedRadioButtonId();
        Intent gotoAnalyzerActivity = new Intent();
        gotoAnalyzerActivity.setClass(this, AnalyzerActivity.class);
        gotoAnalyzerActivity.putExtra("rdBtnId", rdbtnchsd);
        startActivity(gotoAnalyzerActivity);
    }

}
