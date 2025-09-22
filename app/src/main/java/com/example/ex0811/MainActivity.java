package com.example.ex0811;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etn;
    double finish;
    double number;
    boolean maybeNumber;
    boolean fR;
    int act; // 1: '-' | 2: '+' | 3: '/' | 4: '*'
    Intent i1;
    boolean fAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fR = false;
        i1 = new Intent(this,CActivity.class);
        act = 0;
        fAns = false;
        maybeNumber = false;
        etn = findViewById(R.id.etn);
    }

    public void credit(View view) {
        i1.putExtra("h",finish);
        i1.putExtra("mayben",fAns);
        startActivity(i1);
    }

    public void reset(View view) {
        etn.setText("");
        maybeNumber = false;
        act = 0;
    }

    public void worth(View view) {
        if(!etn.getText().toString().equals("")) {
            fAns = true;
            if (act != 0)
            {
                if (fR)
                {
                    finish = mathematica(finish,act,number);
                }
                else
                {
                    finish = mathematica(finish,act,Double.parseDouble(etn.getText().toString()));
                }
            }
            else
            {
                finish = Double.parseDouble(etn.getText().toString());
            }
            fR = true;
            maybeNumber = false;
            etn.setText(finish+"");
        }
    }

    public void hisur(View view) {
        if(!etn.getText().toString().equals("")) {
            number = Double.parseDouble(etn.getText().toString());
            fR = false;
            if (!maybeNumber) {
                act = 1;
                finish = Double.parseDouble(etn.getText().toString());
                maybeNumber = true;
                etn.setText("");
            }
            else
            {
                finish = mathematica(finish,act,Double.parseDouble(etn.getText().toString()));
                act = 1;
                etn.setText("");
            }
        }
    }

    public void hibur(View view) {
        if(!etn.getText().toString().equals("")) {
            number = Double.parseDouble(etn.getText().toString());
            fR = false;
            if (!maybeNumber) {
                act = 2;
                finish = Double.parseDouble(etn.getText().toString());
                maybeNumber = true;
                etn.setText("");
            }
            else
            {
                finish = mathematica(finish,act,Double.parseDouble(etn.getText().toString()));
                act = 2;
                etn.setText("");
            }
        }
    }

    public void hiluk(View view) {
        if(!etn.getText().toString().equals("")) {
            number = Double.parseDouble(etn.getText().toString());
            fR = false;
            if (!maybeNumber) {
                act = 3;
                finish = Double.parseDouble(etn.getText().toString());
                maybeNumber = true;
                etn.setText("");
            }
            else
            {
                finish = mathematica(finish,act,Double.parseDouble(etn.getText().toString()));
                act = 3;
                etn.setText("");
            }
        }
    }

    public void kefel(View view) {
        if(!etn.getText().toString().equals("")) {
            number = Double.parseDouble(etn.getText().toString());
            fR = false;
            if (!maybeNumber) {
                act = 4;
                finish = Double.parseDouble(etn.getText().toString());
                maybeNumber = true;
                etn.setText("");
            }
            else
            {
                finish = mathematica(finish,act,Double.parseDouble(etn.getText().toString()));
                act = 4;
                etn.setText("");
            }
        }
    }



    private static double mathematica(double finish, int act, double number)
    {
        switch(act)
        {
            case 1:
                return finish-number;
            case 2:
                return finish+number;
            case 3:
                return finish/number;
            default:
                return finish*number;
        }
    }

}

