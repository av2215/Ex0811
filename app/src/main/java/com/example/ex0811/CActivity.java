package com.example.ex0811;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CActivity extends AppCompatActivity {
    TextView tv;
    Intent i2;
    double number2;
    boolean maybenum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        tv=findViewById(R.id.tv);

        i2=getIntent();
        maybenum=i2.getBooleanExtra("mayben",false);
        number2=i2.getDoubleExtra("h",0);
        if(maybenum)
        {
            tv.setText(number2+ "");
        }
    }

    public void goback(View view)
    {
        finish();
    }
}