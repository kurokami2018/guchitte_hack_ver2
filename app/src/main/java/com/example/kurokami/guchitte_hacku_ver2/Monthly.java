package com.example.kurokami.guchitte_hacku_ver2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Monthly extends AppCompatActivity{
    //月間画面を表示する。listを12ヶ月分全部受け取ってx,y座標を指定してそこに瓶を貼り付けるプログラム
    //スクロールを考慮する必要あり
    //うまくいくなら当月のデータが画面の上端にくるようにするといいと思う

    //activity_main.xml(つぶやき画面)から移動するためのコード
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.kurokami.guchitte_hacku_ver2.R.layout.activity_monthly);

        Intent intent = getIntent();
        int[] data = intent.getIntArrayExtra( "data" );
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
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(feb>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(feb>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(feb>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(feb>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(feb>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(mar>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(mar>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(mar>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(mar>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(mar>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(mar>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(apr>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(apr>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(apr>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(apr>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(apr>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(apr>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(may>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(may>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(may>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(may>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(may>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(may>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(jun>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(jun>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(jun>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(jun>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(jun>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(jun>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(jul>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(jul>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(jul>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(jul>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(jul>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(jul>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(aug>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(aug>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(aug>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(aug>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(aug>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(aug>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(sep>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(sep>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(sep>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(sep>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(sep>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(sep>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(oct>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(oct>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(oct>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(oct>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(oct>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(oct>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(nov>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(nov>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(nov>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(nov>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(nov>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(nov>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(dec>9){
            ImageView imageView = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(dec>19){
            ImageView imageView2 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(dec>29){
            ImageView imageView3 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(dec>39){
            ImageView imageView4 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(dec>49){
            ImageView imageView5 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(dec>59){
            ImageView imageView6 = (ImageView)findViewById(com.example.kurokami.guchitte_hacku_ver2.R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        // int ypos=1000000;//初期値入れてくださいby今野
        // tiedBottle(month,ypos);
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

