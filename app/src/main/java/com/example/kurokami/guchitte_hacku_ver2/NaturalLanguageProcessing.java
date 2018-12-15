package com.example.kurokami.guchitte_hacku_ver2;

import android.os.AsyncTask;
import android.util.Log;

import okhttp3.*;
import java.io.IOException;




/**
 * Created by konnoyuma on 2018/12/12.
 */

public class NaturalLanguageProcessing extends AsyncTask<Void, Void, String> {
    String input;
    String res;
    NaturalLanguageProcessing(){
        super();
    }

    public void setInput( String input ) {
        this.input = input;
    }
    public String getRes(){return res;}

    @Override
    protected String doInBackground( Void... voids ) {
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

        try {
            Response response = client.newCall(request).execute();
            res = response.body().string();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("NaturalLanguageProcessing","変数 res は「" + res + "」");
        return res;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute( String s ) {
        super.onPostExecute( s );
    }


}
