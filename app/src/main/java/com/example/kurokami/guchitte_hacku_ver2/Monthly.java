package com.example.kurokami.guchitte_hacku_ver2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import java.util.Calendar;
import java.util.Random;

import android.view.View;
import android.widget.ImageButton;
import java.lang.*;

public class Monthly extends AppCompatActivity {

    //activity_main.xml(つぶやき画面)から移動するためのコード
    int resetFlag = 0;
    SharedPreferences spf;
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
        spf = getSharedPreferences( "monthlyData", Context.MODE_PRIVATE );
        for (int i = 0; i < 12; i++) {
            String str = spf.getString( "bottleList_"+String.valueOf( i+1 ), "0" );
            setBottleFromString( str, (i+1) );
        }
        Intent intent = getIntent();
        //resetBottles();

        resetFlag = intent.getIntExtra("resultFlag" ,0);
        if(resetFlag==1)resetBottles();

        Calendar cal = Calendar.getInstance();
        int month = cal.get( Calendar.MONTH ) + 1; //月を取得
        int GruCounter = intent.getIntExtra( "counter",0 );//今月の愚痴カウンターをもらいたい
        int incremental = (GruCounter / 30) - getNumOfBottle( month );
        for (int i = 0; i < incremental; i++) choiceAndSetBottle( month );

        for (int i = 1; i <= month; i++) displayBottles( i );

        //---Parryへ移動---
        ImageButton parryButton = (ImageButton) findViewById(R.id.top_d);
        parryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // parry 画面を起動
                Intent intent = new Intent(Monthly.this,com.example.kurokami.guchitte_hacku_ver2.Parry.class);
                startActivity(intent);
            }
        });
        //-------

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
        SharedPreferences.Editor e = spf.edit();
        e.putString( "bottleList_"+thisMonth, ArrToStr( month ) ).commit();//今月のボトルをspfに保存
    }

    public void displayBottles( int month ) {
        for (int i = 1; i <= month; i++) {
            for (int j = 0; j < bottle[month-1].length; j++) {
                if (bottle[i - 1][j] != 0) {
                    int a = (month - 1) * 6 + j + 1;
                    int id = getResources().getIdentifier( "imageView" + a, "id", getPackageName() );
                    ImageView img = (ImageView) findViewById( id );
                    int imageId = getResources().getIdentifier( "b" + bottle[i-1][j] + "f", "drawable", getPackageName() );
                    img.setImageResource( imageId );
                }
            }
        }
    }

    public int getNumOfBottle( int month ) {
        int count = 0;
        for (int i = 0; i < 6; i++) {if (bottle[month - 1][i] != 0) count++;}
        return count;
    }

    public void resetBottles() {
        SharedPreferences.Editor e = spf.edit();
        //if (resetFlag == 1) spf.edit().clear().commit();//本当はこっちを使うんだけど、デバッグ用に今はSharedPreference全消すのを採用
        e.clear();e.commit();
    }


        /*
        int jan=data[0];
        int feb=data[1];
        int mar=data[2];
        int apr=data[3];
        int may=data[4];
        int jun=data[5];
        int jul=data[6];
        int aug=data[7];
        int sep=data[8];
        int oct=data[9];
        int nov=data[10];
        int dec=data[11];

        if(jan>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(jan>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(jan>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(jan>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(jan>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(jan>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(feb>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView11);
            imageView.setVisibility(View.VISIBLE);
        }
        if(feb>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView12);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(feb>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView13);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(feb>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView14);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(feb>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView15);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(feb>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView16);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(mar>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView17);
            imageView.setVisibility(View.VISIBLE);
        }
        if(mar>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView18);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(mar>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView19);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(mar>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView20);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(mar>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView21);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(mar>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView22);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(apr>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView23);
            imageView.setVisibility(View.VISIBLE);
        }
        if(apr>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView24);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(apr>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView25);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(apr>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView26);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(apr>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView27);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(apr>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView28);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(may>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView29);
            imageView.setVisibility(View.VISIBLE);
        }
        if(may>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView30);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(may>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView31);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(may>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView32);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(may>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView33);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(may>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView34);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(jun>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView35);
            imageView.setVisibility(View.VISIBLE);
        }
        if(jun>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView36);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(jun>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView37);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(jun>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView38);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(jun>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView39);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(jun>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView40);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(jul>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView41);
            imageView.setVisibility(View.VISIBLE);
        }
        if(jul>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView42);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(jul>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView43);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(jul>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView44);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(jul>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView45);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(jul>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView46);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(aug>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView47);
            imageView.setVisibility(View.VISIBLE);
        }
        if(aug>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView48);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(aug>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView49);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(aug>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView50);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(aug>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView51);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(aug>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView52);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(sep>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView53);
            imageView.setVisibility(View.VISIBLE);
        }
        if(sep>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView54);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(sep>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView55);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(sep>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView56);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(sep>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView57);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(sep>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView58);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(oct>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView59);
            imageView.setVisibility(View.VISIBLE);
        }
        if(oct>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView60);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(oct>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView61);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(oct>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView62);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(oct>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView63);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(oct>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView64);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(nov>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView65);
            imageView.setVisibility(View.VISIBLE);
        }
        if(nov>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView66);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(nov>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView67);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(nov>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView68);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(nov>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView69);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(nov>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView70);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(dec>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView71);
            imageView.setVisibility(View.VISIBLE);
        }
        if(dec>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView72);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(dec>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView1);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(dec>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView2);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(dec>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView3);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(dec>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView4);
            imageView6.setVisibility(View.VISIBLE);
        }


    }
    */




}

