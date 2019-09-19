package com.mp.newexternaldatabase.hadishAll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mp.newexternaldatabase.R;

public class FillSurah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_surah);

        TextView btFill;
        btFill = findViewById(R.id.fillShow);
        String fill = "আপনি কি দেখেননি আপনার পালনকর্তা হস্তীবাহিনীর সাথে কিরূপ ব্যবহার করেছেন?"+
                "তিনি কি তাদের চক্রান্ত নস্যাৎ করে দেননি?"+
                "তিনি তাদের উপর প্রেরণ করেছেন ঝাঁকে ঝাঁকে পাখী,"+
                "যারা তাদের উপর পাথরের কংকর নিক্ষেপ করছিল।"+
                "অতঃপর তিনি তাদেরকে ভক্ষিত তৃণসদৃশ করে দেন।";
        btFill.setText(fill);
    }
}
