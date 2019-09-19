package com.mp.newexternaldatabase.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.mp.newexternaldatabase.MainActivity;
import com.mp.newexternaldatabase.R;

public class Setting extends AppCompatActivity {


    MainActivity mainActivity = new MainActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

//        Button btn;
//        btn = findViewById(R.id.)
    }

    public void onClickFindCity(View view) {


        //Get a reference to the TextView
        TextView brands =  findViewById(R.id.brands);
        //Get a reference to the Spinner
        Spinner spinnerCity = findViewById(R.id.spinnerCity);
        //Get the selected item in the Spinner
        String cityType = String.valueOf(spinnerCity.getSelectedItem());


        if(cityType.compareTo("dhaka")==0 | cityType.compareTo("kushtia")==0){
            mainActivity.showCity(cityType);
            brands.setText(cityType+" selected!");
        }

    }
}


