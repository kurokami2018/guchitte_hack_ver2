
package com.example.kurokami.guchitte_hacku_ver2;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.*;
import java.util.Calendar;
import java.util.Random;
import java.lang.*;
import android.content.res.*;
import android.graphics.drawable.*;


public class MainActivity extends AppCompatActivity {
    SharedPreferences spf;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spf = getSharedPreferences("data", Context.MODE_PRIVATE);
        count=getGruCounter(getThisMonth(),spf);

        backgroundChange();

        //forBeginner();//アプリを初回起動の時だけ出てくる説明画像を表示する
        int month = getThisMonth(); //月を取得
        int lastMonth = spf.getInt("lastMonth_data", 0);//前回のログインした月取り出す

        if((lastMonth!=month)&&((month==1) || (lastMonth==0)))deleteMonthLog(spf);

        SharedPreferences.Editor e = spf.edit();
        e.putInt("lastMonth_data", month);//キーをnew_monthとしてmonthをプレファレンスに保存
        e.commit();//保存実行

    }
    //onResume
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        backgroundChange();

        //呟きを入力・消えるview
        ImageButton button = (ImageButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                TextView textView = (TextView) findViewById(R.id.textView);
                //AlphaAnimation fadein_image = new AlphaAnimation(0.0f, 1.0f);
                //fadein_image.setDuration(1000);
                InputMessage.inputMessage(editText,textView);
                MixLeave();
                int month = getThisMonth(); //月を取得
                addGruCounter(month,spf);
                backgroundChange();
                count=(count+1)%60;

                //MixLeave();
            }
        });

        //月間ページに移動
        ImageButton monthButton = (ImageButton) findViewById(R.id.b_mon);
        monthButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent(MainActivity.this,com.example.kurokami.guchitte_hacku_ver2.Monthly.class);
                //intent.setClassName("com.example.kurokami.guchitte_hacku_ver2", "Monthly");
                int[] data = makeArray(spf);
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });
        //deleteMonthLog( spf );
    }


    /*
    void forBeginner() {
        boolean before = AppLaunchChecker.hasStartedFromLauncher(this);
        if (before == false) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(com.example.kurokami.guchitte_hacku_ver2.R.drawable.exp);
            setContentView(imageView);
            //ファイル名わかったら書き換えること

            //タップされたら画面を閉じるみたいな機能をつけて完了のはず
        }
    }
    */

    void deleteMonthLog(SharedPreferences spf){//ArrayListの中身だけ消去する
        SharedPreferences.Editor e = spf.edit();
        e.remove("1");e.remove("2");e.remove("3");e.remove("4");e.remove("5");e.remove("6");
        e.remove("7");e.remove("8");e.remove("9");e.remove("10");e.remove("11");e.remove("12");
        e.commit();
    }
    int getThisMonth(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1; //月を取得
        return month;
    }
    void addGruCounter(int month,SharedPreferences spf){//gruCounterに++するメソッド引数なし、リターンもなし
        SharedPreferences.Editor e = spf.edit();
        String strMonth=String.valueOf(month);
        int gruCounter = spf.getInt(strMonth, 0);
        if(gruCounter<=60)gruCounter++;
        e.putInt(strMonth,gruCounter);e.commit();
        if(gruCounter%30==0) {
            Intent intent = new Intent(MainActivity.this,com.example.kurokami.guchitte_hacku_ver2.GifPlayer_MakeBottle.class);
            startActivity(intent);
        }

    }
    int getGruCounter(int month,SharedPreferences spf){//gruCounterを獲得するメソッド
        String strMonth=String.valueOf(month);
        return spf.getInt(strMonth, 0);

    }

    //愚痴カウンタに応じて背景画面の変更をします
    void backgroundChange(){
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.main);
        if(count%30<10)layout.setBackgroundResource(R.drawable.back_1_r);
        if(count%30>=10 && count%30<=20)layout.setBackgroundResource(R.drawable.back_2_r);
        if(count%30>20)layout.setBackgroundResource(R.drawable.back_3_r);
    }

    void MixLeave(){
        Random rnd = new Random();  int rand;
        AlphaAnimation fadein_image = new AlphaAnimation(0.0f, 1.0f);
        fadein_image.setDuration(1000);

        for(int i=0; i<20; i++){
            rand = rnd.nextInt(20)+1;
            int id = getResources().getIdentifier("leaf_" + (i + 1), "id", getPackageName());
            ImageView img = (ImageView) findViewById( id );
            int imageId = getResources().getIdentifier("leaf_" + rand, "drawable", getPackageName());
            img.setImageResource(imageId);
            img.startAnimation(fadein_image);
            DelGrumble.DelGrumble(img);

        }
    }

    /*
    //葉っぱのエフェクト効果設定
    void leaf(){
        AlphaAnimation fadein_image = new AlphaAnimation(0.0f, 1.0f);
        fadein_image.setDuration(1000);

        ImageView img2 = (ImageView) findViewById(R.id.leaf_2);
        img2.setImageResource(R.drawable.leaf_2);
        img2.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img2);

        ImageView img3 = (ImageView) findViewById(R.id.leaf_3);
        img3.setImageResource(R.drawable.leaf_3);
        img3.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img3);

        ImageView img4 = (ImageView) findViewById(R.id.leaf_4);
        img4.setImageResource(R.drawable.leaf_4);
        img4.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img4);

        ImageView img5 = (ImageView) findViewById(R.id.leaf_5);
        img5.setImageResource(R.drawable.leaf_5);
        img5.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img5);

        ImageView img6 = (ImageView) findViewById(R.id.leaf_6);
        img6.setImageResource(R.drawable.leaf_6);
        img6.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img6);

        ImageView img7 = (ImageView) findViewById(R.id.leaf_7);
        img7.setImageResource(R.drawable.leaf_7);
        img7.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img7);

        ImageView img8 = (ImageView) findViewById(R.id.leaf_8);
        img8.setImageResource(R.drawable.leaf_8);
        img8.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img8);

        ImageView img9 = (ImageView) findViewById(R.id.leaf_9);
        img9.setImageResource(R.drawable.leaf_9);
        img9.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img9);

        ImageView img10 = (ImageView) findViewById(R.id.leaf_10);
        img10.setImageResource(R.drawable.leaf_10);
        img10.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img10);

        ImageView img11 = (ImageView) findViewById(R.id.leaf_11);
        img11.setImageResource(R.drawable.leaf_11);
        img11.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img11);

        ImageView img12 = (ImageView) findViewById(R.id.leaf_12);
        img12.setImageResource(R.drawable.leaf_12);
        img12.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img12);

        ImageView img13 = (ImageView) findViewById(R.id.leaf_13);
        img13.setImageResource(R.drawable.leaf_13);
        img13.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img13);

        ImageView img14 = (ImageView) findViewById(R.id.leaf_14);
        img14.setImageResource(R.drawable.leaf_14);
        img14.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img14);

        ImageView img15 = (ImageView) findViewById(R.id.leaf_15);
        img15.setImageResource(R.drawable.leaf_15);
        img15.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img15);

        ImageView img16 = (ImageView) findViewById(R.id.leaf_16);
        img16.setImageResource(R.drawable.leaf_16);
        img16.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img16);

        ImageView img17 = (ImageView) findViewById(R.id.leaf_17);
        img17.setImageResource(R.drawable.leaf_17);
        img17.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img17);

        ImageView img18 = (ImageView) findViewById(R.id.leaf_18);
        img18.setImageResource(R.drawable.leaf_18);
        img18.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img18);

        ImageView img19 = (ImageView) findViewById(R.id.leaf_19);
        img19.setImageResource(R.drawable.leaf_19);
        img19.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img19);

        ImageView img20 = (ImageView) findViewById(R.id.leaf_20);
        img20.setImageResource(R.drawable.leaf_20);
        img20.startAnimation(fadein_image);
        DelGrumble.DelGrumble(img20);

    }
    */

    int[] makeArray(SharedPreferences spf){
        int jan = spf.getInt("1", 0);
        int feb = spf.getInt("2", 0);
        int mar = spf.getInt("3", 0);
        int apr = spf.getInt("4", 0);
        int may = spf.getInt("5", 0);
        int jun = spf.getInt("6", 0);
        int jul = spf.getInt("7", 0);
        int aug = spf.getInt("8", 0);
        int sep = spf.getInt("9", 0);
        int oct = spf.getInt("10", 0);
        int nov = spf.getInt("11", 0);
        int dec = spf.getInt("12", 0);
        int[] data = {jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec};
        return data;

    }

}

