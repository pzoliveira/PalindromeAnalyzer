package com.example.palindromeanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMeaning (View btnm) {
        WebView wvmeaning = (WebView) findViewById(R.id.webViewMean);
        wvmeaning.setWebViewClient(new WebViewClient());
        wvmeaning.setVisibility(View.VISIBLE);
        wvmeaning.loadUrl("https://en.wikipedia.org/wiki/Palindrome");
    }

    public void goToSettings (View btngts) {
        Intent gotoSettingsActivity = new Intent();
        gotoSettingsActivity.setClass(this, SettingsActivity.class);
        startActivity(gotoSettingsActivity);
        finish();
    }

}
