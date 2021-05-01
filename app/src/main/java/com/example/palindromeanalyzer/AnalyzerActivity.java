package com.example.palindromeanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AnalyzerActivity extends AppCompatActivity {

    EditText txtentrd;
    TextView resultOk;
    TextView resultWrong;
    TextView msgAgain;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyzer);

        Intent caller =getIntent();
        int rdbtnid = caller.getIntExtra("rdBtnId", R.id.rdBtnCathedral);
        LinearLayout linearlayout = (LinearLayout) findViewById(R.id.llayout);
        switch (rdbtnid) {
            case R.id.rdBtnCrystal:
                linearlayout.setBackgroundResource(R.drawable.image2);
                break;
            case R.id.rdBtnBridge:
                linearlayout.setBackgroundResource(R.drawable.image3);
                break;
            default:
                linearlayout.setBackgroundResource(R.drawable.image1);
                break;
        }
    }

    public void evalTrial (View btnet) {
        txtentrd = (EditText) findViewById(R.id.editTextTrial);
        resultOk = (TextView) findViewById(R.id.textViewResultOk);
        resultWrong = (TextView) findViewById(R.id.textViewResultNok);
        msgAgain = (TextView) findViewById(R.id.textViewAgain);
        btnOk = (Button) findViewById(R.id.buttonOk);
        String strngtoeval = txtentrd.getText().toString().toUpperCase().trim();
        if (!strngtoeval.equals("")) {
            char[] chartoeval = strngtoeval.toCharArray();
            char[] charbare = new char[strngtoeval.length()];
            int j = 0;
            for (int i = 0; i < strngtoeval.length(); i++)
                if (("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(chartoeval[i], 0) != -1) || ("0123456789".indexOf(chartoeval[i], 0) != -1))
                    charbare[j++] = chartoeval[i];
            int i = 0;
            int thehalf = (j - j % 2) / 2;
            while ((int) charbare[i] == (int) charbare[j - 1 - i] && i < thehalf)
                i++;
            if (i == thehalf) {
                Toast.makeText(this, R.string.txtVResultOk, Toast.LENGTH_SHORT).show();
                resultOk.setVisibility(View.VISIBLE);
            }
            else {
                Toast.makeText(this, R.string.txtVResultNok, Toast.LENGTH_SHORT).show();
                resultWrong.setVisibility(View.VISIBLE);
            }
            msgAgain.setVisibility(View.VISIBLE);
            btnOk.setVisibility(View.VISIBLE);
        }
    }

    public void tryAgain (View btnok) {
        Button btnOk = (Button) findViewById(R.id.buttonOk);
        txtentrd.setText("");
        resultOk.setVisibility(View.INVISIBLE);
        resultWrong.setVisibility(View.INVISIBLE);
        msgAgain.setVisibility(View.INVISIBLE);
        btnOk.setVisibility(View.INVISIBLE);
    }

}
