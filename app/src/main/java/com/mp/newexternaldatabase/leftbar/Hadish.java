package com.mp.newexternaldatabase.leftbar;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mp.newexternaldatabase.MainActivity;
import com.mp.newexternaldatabase.R;
import com.mp.newexternaldatabase.hadishAll.FatihaSurah;
import com.mp.newexternaldatabase.hadishAll.FillSurah;


public class Hadish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadish);

    }


    public void btnFateha(View view) {
        Intent intent = new Intent(Hadish.this, FatihaSurah.class);
        startActivity(intent);
    }

    public void btnFill(View view) {
        Intent intent = new Intent(Hadish.this, FillSurah.class);
        startActivity(intent);
    }

    public void btnKuraish(View view) {
    }
}
