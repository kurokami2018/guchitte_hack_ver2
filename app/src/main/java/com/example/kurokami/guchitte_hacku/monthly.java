package com.example.kurokami.guchitte2018;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class monthly extends MainActivity{
    //月間画面を表示する。listを12ヶ月分全部受け取ってx,y座標を指定してそこに瓶を貼り付けるプログラム
    //スクロールを考慮する必要あり
    //うまくいくなら当月のデータが画面の上端にくるようにするといいと思う

    //activity_main.xml(つぶやき画面)から移動するためのコード
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly);
    }

/*
    void tapGetter_S() {//タップされたことを感知して画面を切り替える,月間画面を表示する
        //XMLファイルの設定を呼び出すor画像を表示する

    }
    void tapGetter_C(){//タップされたことを感知して画面を切り替える、通常の呟く画面を表示する

    }
    monthly(list<int> jan,list<int> feb,list<int> mar,list<int> apr,list<int> may,list<int> jun,list<int> jul,list<int> aug,list<int> sep,list<int> oct,list<int> nov,list<int> dec) {
        for (int i=0; i < 50; i++) {//1月のリストデータを元に瓶を紐につなげる

        }

    }


    void setBottle(list<int> list,int i) {
        if(list[i]==1){

        }
        if(list[i]==2){

        }
        if(list[i]==3){

        }
        if(list[i]==4){

        }
        if(list[i]==5){

        }
        if(list[i]==6){

        }
        else{

        }
    }
    */
}

