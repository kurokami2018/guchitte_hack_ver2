package com.example.kurokami.guchitte_hacku_ver2;

import android.os.AsyncTask;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import okhttp3.*;
import java.io.IOException;




/**
 * Created by konnoyuma on 2018/12/12.
 */

public class NaturalLanguageProcessing extends AsyncTask<Void, Void, String> {
    String input;
    String res,utf;
    String[] splitRes;

    NaturalLanguageProcessing(){
        super();
    }

    public void setInput( String input ) {
        this.input = input;
    }
    public String getRes(){return res;}

    @Override
    protected String doInBackground( Void... voids ) {
        MediaType JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
        try {
            input = URLEncoder.encode(input,"utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        utf = "text="+input;
        RequestBody body = RequestBody.create( JSON, utf);

        String APIkey="396a686f34794531527568675a6a642f6b4743722e786a52787776754a737241554c4e74687a3338556841";
        String url="https://api.apigw.smt.docomo.ne.jp/truetext/v1/clusteranalytics?APIKEY="+APIkey;


        Request request = new Request.Builder()
                .header( "APIKEY",APIkey )
                .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                .post(body)
                .build();
        Log.d("NaturalLanguageProcessing","変数requestは「"+request+"」");
        OkHttpClient client = new OkHttpClient();

        try {
            Response response = client.newCall(request).execute();
            res = response.body().string();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("NaturalLanguageProcessing","変数 utf は「" + utf + "」");
        Log.d("NaturalLanguageProcessing","変数 res は「" + res + "」");

        return res;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute( String s ) {
        setSplitStr(s);
        super.onPostExecute( s );
    }

    public String[] getSplitStr(){
        return splitRes;
    }
    public void setSplitStr(String res) {
        String[] split = res.split(",", 0);
        int i=0,n=0;
        String str=split[1];
        str= str.replaceAll("\"count\":","");
        n = Integer.parseInt(str);
        for(int j=3; j<n;j+=3){
            splitRes[i]=split[j];
            splitRes[i]=splitRes[i].substring(18,splitRes[i].length()-1);
            i++;
        }


    }
}


