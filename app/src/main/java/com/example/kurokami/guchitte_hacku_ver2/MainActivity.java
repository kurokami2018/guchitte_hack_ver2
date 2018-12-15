
package com.example.kurokami.guchitte_hacku_ver2;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;
import android.util.Log;
import java.lang.*;



public class MainActivity extends AppCompatActivity {
    SharedPreferences spf;
    int gruCounter;
    int limitedCounter;
    int resetFlag=0;//新年じゃないのがデフォルト


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spf = getSharedPreferences("data", Context.MODE_PRIVATE);
        gruCounter=getGruCounter(getThisMonth(),spf);
        limitedCounter=spf.getInt( "limitedCounter",0 );

        backgroundChange();

        //forBeginner();//アプリを初回起動の時だけ出てくる説明画像を表示する
        int month = getThisMonth(); //月を取得
        int lastMonth = spf.getInt("lastMonth_data", 0);//前回のログインした月取り出す
        if((lastMonth!=month)&&((month==1) || (lastMonth==0))){
            deleteMonthLog(spf);
            resetFlag=1;
        }

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
                String str = editText.getText().toString();
                NaturalLanguageProcessing ai = new NaturalLanguageProcessing();
                ai.setInput( str );
                ai.execute();
                Log.d("onClick","変数 ai.input は「" + ai.input + "」");
                //Log.d("onClick","変数 ai.res は「" + ai.res + "」");
                Log.d("NaturalLanguageProcessing","get.res() は「" + ai.getRes() + "」");
                InputMessage.inputMessage(editText,textView);
                MixLeave();
                int month = getThisMonth(); //月を取得
                addGruCounter(month,spf);
                backgroundChange();

            }
        });

        //月間ページに移動
        ImageButton monthButton = (ImageButton) findViewById(R.id.b_mon);
        monthButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent(MainActivity.this,com.example.kurokami.guchitte_hacku_ver2.Monthly.class);
                //intent.setClassName("com.example.kurokami.guchitte_hacku_ver2", "Monthly");
                //int[] data = makeArray(spf);

                intent.putExtra("resetFlag",resetFlag);
                intent.putExtra( "counter",limitedCounter );
                startActivity(intent);
            }
        });
       // deleteMonthLog( spf );
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
        e.remove("gruCounter_1");e.remove("gruCounter_2");e.remove("gruCounter_3");e.remove("gruCounter_4");e.remove("gruCounter_5");e.remove("gruCounter_6");
        e.remove("gruCounter_7");e.remove("gruCounter_8");e.remove("gruCounter_9");e.remove("gruCounter_10");e.remove("gruCounter_11");e.remove("gruCounter_12");
        //e.clear();
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
        gruCounter++;
        limitedCounter=(limitedCounter%180)+1;
        e.putInt("gruCounter_"+strMonth,gruCounter);
        e.putInt( "limitedCounter",limitedCounter);
        e.commit();
        if(gruCounter%30==0 && gruCounter<=180) {
            Intent intent = new Intent(MainActivity.this,com.example.kurokami.guchitte_hacku_ver2.GifPlayer_MakeBottle.class);
            startActivity(intent);
        }

    }
    int getGruCounter(int month,SharedPreferences spf){//gruCounterを獲得するメソッド
        String strMonth = String.valueOf( month );
        return spf.getInt("gruCounter_"+strMonth, 0);
    }

    //愚痴カウンタに応じて背景画面の変更をします
    void backgroundChange(){
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.main);
        if(limitedCounter %30<10)layout.setBackgroundResource(R.drawable.back_1_r);
        if(limitedCounter %30>=10 && limitedCounter %30<=20)layout.setBackgroundResource(R.drawable.back_2_r);
        if(limitedCounter %30>20)layout.setBackgroundResource(R.drawable.back_3_r);
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



}

