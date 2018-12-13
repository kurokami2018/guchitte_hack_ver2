package com.example.kurokami.guchitte_hacku_ver2;

import android.app.Activity;
import android.os.Bundle;
import com.google.gson.*;
import javax.*;
//import android.app.DownloadManager.Request;
import java.net.MalformedURLException;
import java.net.URL;
import com.squareup.*;
import okhttp3.*;
import java.io.IOException;
import java.util.*;
import android.os.AsyncTask;




/**
 * Created by konnoyuma on 2018/12/12.
 */

public class NaturalLanguageProcessing extends Activity {
    String input;
    String res;
    NaturalLanguageProcessing(String str){
        input=str;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        post();
        //resに結果がすでに入っている


    }
    private void post() {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create( JSON,input );

        String APIkey="396a686f34794531527568675a6a642f6b4743722e786a52787776754a737241554c4e74687a3338556841";
        String url="https://api.apigw.smt.docomo.ne.jp/truetext/v1/clusteranalytics?APIKEY="+APIkey;


        Request request = new Request.Builder()
                .header( "Content-Type","application/x-www-form-urlencoded" )
                .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {e.printStackTrace();}

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                res = response.body().string();
            }
        });
    }

}
