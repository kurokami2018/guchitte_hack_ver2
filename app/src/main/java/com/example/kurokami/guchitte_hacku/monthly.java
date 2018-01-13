package com.example.kurokami.guchitte_hacku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class monthly extends AppCompatActivity{
    //月間画面を表示する。listを12ヶ月分全部受け取ってx,y座標を指定してそこに瓶を貼り付けるプログラム
    //スクロールを考慮する必要あり
    //うまくいくなら当月のデータが画面の上端にくるようにするといいと思う

    //activity_main.xml(つぶやき画面)から移動するためのコード
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly);

        set();
        int month = MainActivity.monthGetter();
        // int ypos=1000000;//初期値入れてくださいby今野
        // tiedBottle(month,ypos);
    }
    void set() {//各月の愚痴カウンタの数を呼び出し・表示数の瓶を可視化

                MainActivity.getMonthLog(1);

                //findViewById(R.id.).setVisibility(View.VISIBLE);　可視化で使う

    }

/*
    void tiedBottle(int month,int ypos){
        ArrayList thisMonth;
        int number,xpos;
        for(int i=0;i<12;i++){
            xpos=100000000;//初期値入れてくださいby今野
            thisMonth=MainActivity.getMonthLog(month+i);
            drawMonthPic(month+1);
            for(int j=0;j<thisMonth.size();j++){
                number= (int) thisMonth.get(j);
                if(number==0)break;
                xpos=xpos+(50000000*j);//横にずらしていく数字を直してくださいby今野
                setBottle(number,xpos,ypos);
            }
            ypos=ypos+1000000000;//縦にずらしていく数字を直してくださいby今野
        }
    }

    void setBottle(int colorNumber,int xpos,int ypos) {
        if(colorNumber==1){

        }
        if(colorNumber==2){

        }
        if(colorNumber==3){

        }
        if(colorNumber==4){

        }
        if(colorNumber==5){

        }
        if(colorNumber==6){

        }
        if(colorNumber==7){

        }
        if(colorNumber==8){

        }
        if(colorNumber==9){

        }
        if(colorNumber==10){

        }
        if(colorNumber==11){

        }
        if(colorNumber==12){

        }
    }
    int newYearChecker(int month){//monthに１ずつ足していって13月とかができないようにするためのもの
        if(month>12){
            month=month-12;
            return month;
        }
        else return month;
    }
    void drawMonthPic(int month){
        //今日が何月か所得してその月が一番上に来るようにするなら、何月って書いてある絵も動かさないといけないかと思ったので作りました
        if(month==1);//"1月"って書いてある絵を貼る
        if(month==2);
        if(month==3);
        if(month==4);
        if(month==5);
        if(month==6);
        if(month==7);
        if(month==8);
        if(month==9);
        if(month==10);
        if(month==11);
        if(month==12);
    }
    */
}

