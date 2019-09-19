package com.mp.newexternaldatabase.hadishAll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.mp.newexternaldatabase.R;

public class FatihaSurah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatiha_surah);

        TextView btFateha;
        btFateha = findViewById(R.id.fatehaShow);

        String fateha = "শুরু করছি আল্লাহর নামে যিনি পরম করুণাময়, অতি দয়ালু।"+
                "যাবতীয় প্রশংসা আল্লাহ তা’আলার যিনি সকল সৃষ্টি জগতের পালনকর্তা।"+
                "যিনি নিতান্ত মেহেরবান ও দয়ালু।"+
                "যিনি বিচার দিনের মালিক।"+
                "আমরা একমাত্র তোমারই ইবাদত করি এবং শুধুমাত্র তোমারই সাহায্য প্রার্থনা করি।"+
                "আমাদেরকে সরল পথ দেখাও,"+
                "সে সমস্ত লোকের পথ, যাদেরকে তুমি নেয়ামত দান করেছ। তাদের পথ নয়,"+
                "যাদের প্রতি তোমার গজব নাযিল হয়েছে এবং যারা পথভ্রষ্ট হয়েছে।";
        btFateha.setText(fateha);
    }

}
