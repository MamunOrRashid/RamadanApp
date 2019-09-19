package com.mp.newexternaldatabase.leftbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mp.newexternaldatabase.DatabaseAccess;
import com.mp.newexternaldatabase.R;

public class MonthDetails extends AppCompatActivity {

    TextView tvDate_16;
    TextView tvDate_17;

    TextView tvSaheri_16, tvIftar_16;
    TextView tvSaheri_17, tvIftar_17;

    TextView tvFajor_16, tvJohor_16, tvAsor_16, tvMagrib_16, tvAsha_16;
    TextView tvFajor_17, tvJohor_17, tvAsor_17, tvMagrib_17, tvAsha_17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_details);

        tvDate_16 = findViewById(R.id.tvDate_16);
        tvDate_17 = findViewById(R.id.tvDate_17);
        tvSaheri_16 = findViewById(R.id.tvSaheri_16);
        tvSaheri_17 = findViewById(R.id.tvSaheri_17);
        tvIftar_16 = findViewById(R.id.tvIftar_16);
        tvIftar_17 = findViewById(R.id.tvIftar_17);
        tvFajor_16 = findViewById(R.id.tvFajor_16);
        tvFajor_17 = findViewById(R.id.tvFajor_17);
        tvJohor_16 = findViewById(R.id.tvJohor_16);
        tvJohor_17 = findViewById(R.id.tvJohor_17);
        tvAsor_16 = findViewById(R.id.tvAsor_16);
        tvAsor_17 = findViewById(R.id.tvAsor_17);
        tvMagrib_16 = findViewById(R.id.tvMagrib_16);
        tvMagrib_17 = findViewById(R.id.tvMagrib_17);
        tvAsha_16 = findViewById(R.id.tvAsha_16);
        tvAsha_17 = findViewById(R.id.tvAsha_17);


        showSaheriTime();
    }

    private void showSaheriTime() {
        //create the instance of database access class and open database connection
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        for (int i = 9; i <=10; i++) {

            if (i == 9) {
                String time = databaseAccess.getTime(i + "");
                System.out.println("4=Output:............."+time);
                String temp = "";
                int index = -1;
                for (int j = 0; j < time.length(); j++) {
                    if (time.charAt(j) != ',') {
                         temp += time.charAt(j);
                        ///temp.concat(time.charAt(j)+"");
                    } else if (time.charAt(j) == ',') {
                        index++;
                    }
                    if (time.charAt(j) == ',' && index == 0) {
                        tvDate_16.setText("Date:"+temp);
                    } else if (time.charAt(j) == ',' && index == 1) {
                        tvSaheri_16.setText("Saheri:"+temp);
                    } else if (time.charAt(j) == ',' && index == 2) {
                        tvIftar_16.setText("Iftar:"+temp);
                    } else if (time.charAt(j) == ',' && index == 3) {
                        tvFajor_16.setText("Fajar:"+temp);
                    } else if (time.charAt(j) == ',' && index == 4) {
                        tvJohor_16.setText("Johor:"+temp);
                    } else if (time.charAt(j) == ',' && index == 5) {
                        tvAsor_16.setText("Asor:"+temp);
                    } else if (time.charAt(j) == ',' && index == 6) {
                        tvMagrib_16.setText("Mag"+temp);
                    } else if (time.charAt(j) == ',' && index == 7) {
                        tvAsha_16.setText("Asha"+temp);
                    }if(time.charAt(j) == ','){
                        temp = "";
                    }
                    //tvDate_16.setText("");
                }
                //tvResult.setText(temp);
            } else if (i == 10) {
                String time = databaseAccess.getTime(i + "");
                System.out.println("5=Output:............."+time);
                String temp = "";
                int index = -1;
                for (int j = 0; j < time.length(); j++) {
                    if (time.charAt(j) != ',') {
                        temp += time.charAt(j);
                    } else if (time.charAt(j) == ',') {
                        index++;
                    }
                    if (time.charAt(j) == ',' && index == 0) {
                        tvDate_17.setText("Date"+temp);
                    } else if (time.charAt(j) == ',' && index == 1) {
                        tvSaheri_17.setText("Saheri:"+temp);
                    } else if (time.charAt(j) == ',' && index == 2) {
                        tvIftar_17.setText("Iftar:"+temp);
                    } else if (time.charAt(j) == ',' && index == 3) {
                        tvFajor_17.setText("Fajar:"+temp);
                    } else if (time.charAt(j) == ',' && index == 4) {
                        tvJohor_17.setText("Johor:"+temp);
                    } else if (time.charAt(j) == ',' && index == 5) {
                        tvAsor_17.setText("Asor:"+temp);
                    } else if (time.charAt(j) == ',' && index == 6) {
                        tvMagrib_17.setText("Mag:"+temp);
                    } else if (time.charAt(j) == ',' && index == 7) {
                        tvAsha_17.setText("Asha"+temp);
                    }if(time.charAt(j) == ','){
                        temp = "";
                    }
                    //tvDate_16.setText("");
                }
            }

        }


        databaseAccess.close();
    }
}
