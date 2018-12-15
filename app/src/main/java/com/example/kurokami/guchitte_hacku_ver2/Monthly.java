package com.example.kurokami.guchitte_hacku_ver2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import java.util.Calendar;
import java.util.Random;
import android.util.Log;

import android.view.*;
import android.widget.ImageButton;
import java.lang.*;

public class Monthly extends AppCompatActivity {

    //activity_main.xml(つぶやき画面)から移動するためのコード
    int resetFlag = 0;
    int limitedCounter;
    SharedPreferences spf;
    SharedPreferences.Editor e;

    int[] janBottle; int[] febBottle; int[] marBottle;
    int[] aprBottle; int[] mayBottle; int[] junBottle;
    int[] julBottle; int[] augBottle; int[] sepBottle;
    int[] octBottle; int[] novBottle; int[] decBottle;

    int[][] bottle = {
            janBottle=new int[6], febBottle=new int[6], marBottle=new int[6],
            aprBottle=new int[6], mayBottle=new int[6], junBottle=new int[6],
            julBottle=new int[6], augBottle=new int[6], sepBottle=new int[6],
            octBottle=new int[6], novBottle=new int[6], decBottle=new int[6]
    };


    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( com.example.kurokami.guchitte_hacku_ver2.R.layout.activity_monthly );
        spf = getSharedPreferences( "data", Context.MODE_PRIVATE );
        e=spf.edit();
        for (int i = 0; i < 12; i++) {
            String str = spf.getString( "bottleList_"+String.valueOf( i+1 ), "0" );
            setBottleFromString( str, (i+1) );
        }
        Intent intent = getIntent();
        //resetBottles();

        resetFlag = intent.getIntExtra("resultFlag" ,0);
        if(resetFlag==1)resetBottles();

        int month = getThisMonth();
        limitedCounter = intent.getIntExtra( "limitedCounter",0 );//今月の愚痴カウンターをもらいたい

        for (int i = 1; i <= month; i++) displayBottles( i );

        int incremental = (int)(limitedCounter / 30) - getNumOfBottle( month );

        Log.d("/30",String.valueOf(limitedCounter / 30));
        Log.d("getNumOfBottle",String.valueOf( getNumOfBottle( month ) ));
        Log.d("インクリメンタル",String.valueOf( incremental ));
        for (int i = 0; i < incremental; i++) choiceAndSetBottle( month );


        //---ビンがあったらParryへ移動---
        /*
        ImageButton parryButton = (ImageButton) findViewById(R.id.top_d);
        parryButton.setVisibility(View.INVISIBLE);
        if(getNumOfBottle(month)>0) parryButton.setVisibility(View.VISIBLE);
        for(int i=0;i<72;i++){

        }
        parryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // parry 画面を起動
                Intent intent = new Intent(Monthly.this,com.example.kurokami.guchitte_hacku_ver2.Parry.class);
                startActivity(intent);
            }
        });
        //-------
        */

    }
    @Override
    public void onResume() {
        super.onResume();
        displayBottles( getThisMonth() );
    }

    public void setBottleFromString( String str, int month ) {
        String[] strings = str.split( "," );
        for (int i = 0; i < strings.length; i++) bottle[month - 1][i] = Integer.parseInt( strings[i] );
    }

    public String ArrToStr( int month ) {
        StringBuilder sb = new StringBuilder();
        int[] arr = bottle[month - 1];
        for (int i=0;i<6;i++) sb.append( arr[i] + "," );
        return sb.toString();
    }

    public void choiceAndSetBottle( int month ) {//ここをで配列の先頭にある空欄にボトルをランダムで配置しています。人口知能を入れるならここを弄る
        Random rdm = new Random();
        for (int i = 0; i < 6; i++) {
            if (bottle[month - 1][i] == 0) {
                bottle[month - 1][i] = rdm.nextInt( 15 ) + 1;
                break;
            }
        }
        String thisMonth = String.valueOf( month );
        e.putString( "bottleList_"+thisMonth, ArrToStr( month ) ).commit();//今月のボトルをspfに保存
    }



    public int getThisMonth(){
        Calendar cal = Calendar.getInstance();
        return cal.get( Calendar.MONTH ) + 1; //月を取得
    }

    public void displayBottles( int month ) {

        for (int i=1; i <= month; i++) {
            for (int j=0; j < bottle[month-1].length; j++) {
                int a = (month - 1) * 6 + j + 1;
                int id = getResources().getIdentifier( "imageButton" + a, "id", getPackageName() );
                ImageButton img =  findViewById( id );
                if (bottle[i - 1][j] != 0) {
                    int imageId = getResources().getIdentifier( "b" + bottle[i-1][j] + "f", "drawable", getPackageName() );
                    img.setImageResource( imageId );
                    img.setOnClickListener(new MyClickListener(j){
                        public void onClick(View v){
                            Calendar cal = Calendar.getInstance();
                            int month = cal.get( Calendar.MONTH ) + 1; //月を取得
                            int num=getJ();
                            Log.d("消す前",ArrToStr( month ));
                            bottle[ month - 1 ][num]=0;
                            String thisMonth = String.valueOf( month );
                            e.putString( "bottleList_"+thisMonth, ArrToStr( month ) ).commit();
                            Log.d("消した後",ArrToStr( month ));
                            delGruCounter();
                            PlayBrakeVideo();
                        }
                    });
                }
                else{img.setImageDrawable( null );}
            }
        }
    }

    public int getNumOfBottle( int month ) {
        int count = 0;
        for (int i = 0; i < 6; i++) {if (bottle[month - 1][i] != 0) count++;}
        return count;
    }

    public void resetBottles() {
        //if (resetFlag == 1) spf.edit().clear().commit();//本当はこっちを使うんだけど、デバッグ用に今はSharedPreference全消すのを採用
        e.clear();e.commit();
    }
    public void PlayBrakeVideo(){
        Intent intent = new Intent(this,com.example.kurokami.guchitte_hacku_ver2.Parry.class);
        startActivity(intent);
    }
    void delGruCounter(){
        String month=String.valueOf( getThisMonth() );
        if(limitedCounter-30>=0)limitedCounter-=30;
        //else{limitedCounter=0;}
        e.putInt("limitedCounter",limitedCounter);
        e.putInt( "gruCounter_"+month,limitedCounter );
        e.commit();
    }
}

