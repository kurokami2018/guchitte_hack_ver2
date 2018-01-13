package com.example.kurokami.guchitte_hacku;

import android.support.v7.app.AppCompatActivity;
import java.util.Calendar;//日付の操作・計算などを扱うクラス

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;



public class monthCheck extends AppCompatActivity {

  public int getCalender(Calendar cal) {

    int year = cal.get(Calendar.YEAR); //年を取得
    int month = cal.get(Calendar.MONTH)+1; //月を取得
    int day = cal.get(Calendar.DATE);//日を取得

    return month;
  }
  
/*
  public void getPast(int pastMonth,int month){
    
//仮に最終ログイン月をpastMonthとする

    if(pastMonth!=month){
      if((month==1) || (pastMonth==0)){//&&ではなく||じゃないかな　by今野 ほんとだ！ありがとう！by小松
        MainActivity.emptyMonthLog();//月間初期画面を表示する
        MainActivity.emptyGruCounter();//愚痴回数カウンターを0にするメソッド
      }
      else{
        MainActivity.emptyGruCounter();//愚痴回数カウンタを0にするメソッド
      }
    }

 //   if(pastMonth==month){mainDisplay();}//コンストラクタだからこれで呼び出される...？

  }
*/
}
