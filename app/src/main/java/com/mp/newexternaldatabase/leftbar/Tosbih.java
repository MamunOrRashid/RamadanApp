package com.mp.newexternaldatabase.leftbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mp.newexternaldatabase.R;

public class Tosbih extends AppCompatActivity {
    int count=0;
    TextView TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tosbih);

        TV = findViewById(R.id.tvCount);
    }

    public void btntasbih(View view) {
        count++;

        //TV.setText(count);

    }
}
