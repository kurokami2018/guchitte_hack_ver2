package com.example.kurokami.guchitte_hacku;

import android.support.v7.app.AppCompatActivity;
import java.util.Calendar;//日付の操作・計算などを扱うクラス

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;


/*
月(年)が変わった時のデータ取得方法 → 前回ログインしたときの月(month)が保存できれば...！！
[ログインするたびにmonth(月)を保存する。
次にログインした時に保存してあったmonthとその日に保存したmonthが違っていたら愚痴カウンターを0に(12月→1月のみ例外、白紙にする)。
同じだったら呟く画面を表示。]
※白紙にする=背景画像を挿入する
*/

/*
List beforeDate=new ArrayList();
beforeDate.add(month); わからん
*/

public class monthCheck extends AppCompatActivity {

  public static int getCalender(Calendar cal) {

    int year = cal.get(Calendar.YEAR); //年を取得
    int month = cal.get(Calendar.MONTH)+1; //月を取得
    int day = cal.get(Calendar.DATE);//日を取得
    //return文どうすればいい？
    return month;


  }
  
  
  public static void getPast(int pastMonth,int month){
    
//仮に最終ログイン月をpastMonthとする
    
    if(pastMonth!=month){
      if((month==1) && (pastMonth==0)){//&&ではなく||じゃない？by今野
        MainActivity.emptyMonthLog();/*月間初期画面を表示する*/
        MainActivity.emptyGruCounter();/*愚痴回数カウンターを0にするメソッド*/
      }
      else{
        MainActivity.emptyGruCounter();/*愚痴回数カウンタを0にするメソッド*/
      }
    }
    
    if(pastMonth==month){/*呟く画面を表示*/}
    
  }

}
