package com.example.kurokami.guchitte_hacku_ver2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

/**
 * Created by konnoyuma on 2018/12/16.
 */


public class MyClickListener extends MainActivity implements View.OnClickListener {
    int j;
    MyClickListener(int a){
        j=a;
    }
    public void setJ(int a){
        j=a;
    }
    public int getJ(){
        return j;
    }



    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        /*
        Calendar cal = Calendar.getInstance();
        int month = cal.get( Calendar.MONTH ) + 1; //月を取得
        String str = spf.getString( "bottleList_"+String.valueOf( month ), "0" );
        Log.d("tst",str);
        Monthly.Flag=1;

        String[] strings = str.split( "," );
        String thisMonth = String.valueOf( month );
        strings[j-1]="0";

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<6;i++) sb.append( strings[i] + "," );

        e.putString( "bottleList_"+thisMonth, sb.toString() ).commit();
        startActivity( intent );*/
    }

}
