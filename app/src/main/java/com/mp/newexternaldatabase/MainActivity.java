package com.mp.newexternaldatabase;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

import com.mp.newexternaldatabase.leftbar.Article;
import com.mp.newexternaldatabase.leftbar.Doa;
import com.mp.newexternaldatabase.leftbar.Hadish;
import com.mp.newexternaldatabase.leftbar.MonthDetails;
import com.mp.newexternaldatabase.leftbar.Share;
import com.mp.newexternaldatabase.leftbar.Tosbih;
import com.mp.newexternaldatabase.setting.Setting;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    String cityName="";

    Button btnIftar, btnSaheri;
    TextView tvfajar, tvjohor, tvasor, tvmagrib, tvasha;

    BoomMenuButton bmb;
    ArrayList<Integer> imageIDList;
    ArrayList<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvfajar = findViewById(R.id.tvMainFajar);
        tvjohor = findViewById(R.id.tvMainJohor);
        tvasor = findViewById(R.id.tvMainAsor);
        tvmagrib = findViewById(R.id.tvMainMagrib);
        tvasha = findViewById(R.id.tvMainAsha);


        //boom menu setup
        bmb = findViewById(R.id.boom);
        imageIDList = new ArrayList<>();
        titleList = new ArrayList<>();
        setInitialData();

        bmb.setButtonEnum(ButtonEnum.Ham);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_6_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_6);
        boomPositionGo();

        btnIftar = findViewById(R.id.buttonIftar);
        btnSaheri = findViewById(R.id.buttonSaheri);

        showDate();
        accessData();


        btnIftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, 10);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, 20);
                startActivity(intent);
            }
        });
        btnSaheri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, 10);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, 20);
                startActivity(intent);
            }
        });

    }

    private void accessData() {

        System.out.println("City Name:......................."+cityName);

        Calendar calender = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDateandTime = sdf.format(new Date());
        System.out.println("Current Time:............." + currentDateandTime);
        String dayNumber = "" + currentDateandTime.charAt(0) + currentDateandTime.charAt(1);

        //create the instance of database access class and open database connection
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        String saheri = "";
        String iftar = "";
        String fajar = "";
        String johor = "";
        String asor = "";
        String magrib = "";
        String asha = "";

        String fromDatabaseDayNumber="";

        for (int i = 9; i <= 10; i++) {



            String tt = databaseAccess.getTime(i + "");
            System.out.println("4,4=Output:" + tt);
            fromDatabaseDayNumber ="" + tt.charAt(0)+tt.charAt(1);

            System.out.println("fromdatabaseDayNumber: " + fromDatabaseDayNumber);
            System.out.println("dayNumber: " + dayNumber);

            if (fromDatabaseDayNumber.compareTo(dayNumber) == 0) {
                System.out.println("yessss i am in...");
                saheri =""+ tt.charAt(3) + tt.charAt(4) + tt.charAt(5) + tt.charAt(6) + tt.charAt(7);
                iftar =""+ tt.charAt(9) + tt.charAt(10) + tt.charAt(11) + tt.charAt(12) + tt.charAt(13);
                fajar =""+ tt.charAt(15) + tt.charAt(16) + tt.charAt(17) + tt.charAt(18) + tt.charAt(19);
                johor =""+ tt.charAt(21) + tt.charAt(22) + tt.charAt(23) + tt.charAt(24) + tt.charAt(25);
                asor =""+ tt.charAt(27) + tt.charAt(28) + tt.charAt(29) + tt.charAt(30) + tt.charAt(31);
                magrib =""+ tt.charAt(33) + tt.charAt(34) + tt.charAt(35) + tt.charAt(36) + tt.charAt(37);
                asha =""+ tt.charAt(39) + tt.charAt(40) + tt.charAt(41) + tt.charAt(42) + tt.charAt(43);
                break;
            }
        }


        btnSaheri.setText("Saheri" + "\n" + saheri+" AM");
        btnIftar.setText("Iftar" + "\n" + iftar+" PM");

          tvfajar.setText("Fajar : "+fajar+" AM");
          tvjohor.setText("Johor : "+johor+" PM");
           tvasor.setText("Asor  : "+asor+" PM");
         tvmagrib.setText("Magrib: "+magrib+" PM");
           tvasha.setText("Asha  : "+asha+" PM");

        databaseAccess.close();
    }



    private void showDate() {
        TextView tv;
        tv = findViewById(R.id.tvMainActivityDate);
        Calendar calender = Calendar.getInstance();
        //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDateandTime = DateFormat.getDateInstance().format(calender.getTime());
        currentDateandTime += '\n' + "DHAKA, BANGLADESH";
        tv.setText(currentDateandTime);

    }


    private void boomPositionGo() {
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {

            HamButton.Builder builder = new HamButton.Builder()
                    .normalImageRes(imageIDList.get(i))
                    .normalText(titleList.get(i))
                    .subNormalText("Click to watch some magic!")
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            if (index == 0) {
                                Intent intent = new Intent(MainActivity.this, MonthDetails.class);
                                startActivity(intent);
                            } else if (index == 1) {
                                Intent intent = new Intent(MainActivity.this, Hadish.class);
                                startActivity(intent);
                            } else if (index == 2) {
                                Intent intent = new Intent(MainActivity.this, Tosbih.class);
                                startActivity(intent);
                            } else if (index == 3) {
                                Intent intent = new Intent(MainActivity.this, Article.class);
                                startActivity(intent);
                            } else if (index == 4) {
                                Intent intent = new Intent(MainActivity.this, Doa.class);
                                startActivity(intent);
                            } else if (index == 5) {
                                Intent intent = new Intent(MainActivity.this, Share.class);
                                startActivity(intent);
                            }

                        }
                    });
            bmb.addBuilder(builder);
        }
    }

    private void setInitialData() {

        imageIDList.add(R.drawable.ic_app_of_ramadan_24dp);
        //imageIDList.add(R.drawable.ic_alarm_black_24dp);
        // imageIDList.add(R.drawable.ic_speaker_black_24dp);
        imageIDList.add(R.drawable.ic_quranandhadis_collections_bookmark_black_24dp);
        imageIDList.add(R.drawable.ic_tosbih_extension_black_24dp);
        imageIDList.add(R.drawable.ic_article_insert_drive_file_black_24dp);
        imageIDList.add(R.drawable.ic_doa_assignment_turned_in_black_24dp);
        imageIDList.add(R.drawable.ic_share_black_24dp);
        // imageIDList.add(R.drawable.ic_send_black_24dp);


        titleList.add("পূর্ণাঙ্গ সূচী");
        //titleList.add("অডিও কুরআন");
        titleList.add("কুরআন ও হাদিস");
        titleList.add("তসবীহ");
        titleList.add("আর্টিকেল ও মাসয়ালা");
        titleList.add("প্রয়োজনীয় দোয়া");
        titleList.add("Share");
        // titleList.add("Send");
    }

    public void showCity(String name){
        cityName = name;

    }
    public void showSetting(View view) {
        Intent intent = new Intent(MainActivity.this, Setting.class);
        startActivity(intent);
    }

}
