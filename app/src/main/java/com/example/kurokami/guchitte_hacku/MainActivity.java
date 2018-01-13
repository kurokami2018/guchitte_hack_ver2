
    package com.example.kurokami.guchitte_hacku;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.support.constraint.ConstraintLayout;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.animation.AlphaAnimation;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.TextView;
        import com.google.gson.Gson;
        import com.google.gson.reflect.TypeToken;
        import java.util.ArrayList;
        import java.util.Calendar;
        import android.support.v4.app.AppLaunchChecker;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forBeginner();//アプリを初回起動の時だけ出てくる説明画像を表示する

        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        //Calenderを取得、MainActivityでしか取得できないから動かさない
        int month = monthGetter();//今回ログイン月を取得
        int lastMonth = sharedPreferences.getInt("lastMonth_data", 0);//前回のログインした月をしまっておく
        monthCheck.getPast(lastMonth, month);//前回のログイン月と今回のログイン月を比較するメソッドに前回ログイン月を渡す
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putInt("new_month", month);//キーをnew_monthとしてmonthをプレファレンスに保存
        e.commit();//保存実行
        int gruCounter = sharedPreferences.getInt("grumbleCounter", 0);//保存されていたgruCounterを取得

        Gson gson = new Gson();//ファイル(data)から各月のデータを取得してリストを作成する
        ArrayList<Integer> jan = new ArrayList<Integer>();//1月のデータを格納するArrayListのjanを生成
        jan = gson.fromJson(sharedPreferences.getString("jan_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> feb = new ArrayList<Integer>();//2月
        feb = gson.fromJson(sharedPreferences.getString("feb_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> mar = new ArrayList<Integer>();//3月
        mar = gson.fromJson(sharedPreferences.getString("mar_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> apr = new ArrayList<Integer>();//4月
        apr = gson.fromJson(sharedPreferences.getString("apr_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> may = new ArrayList<Integer>();//5月
        may = gson.fromJson(sharedPreferences.getString("may_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> jun = new ArrayList<Integer>();//6月
        jun = gson.fromJson(sharedPreferences.getString("jun_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> jul = new ArrayList<Integer>();//7月
        jul = gson.fromJson(sharedPreferences.getString("jul_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> aug = new ArrayList<Integer>();//8月
        aug = gson.fromJson(sharedPreferences.getString("aug_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> sep = new ArrayList<Integer>();//9月
        sep = gson.fromJson(sharedPreferences.getString("sep_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> oct = new ArrayList<Integer>();//10月
       oct = gson.fromJson(sharedPreferences.getString("oct_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> nov = new ArrayList<Integer>();//11月
        nov = gson.fromJson(sharedPreferences.getString("nov_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        ArrayList<Integer> dec = new ArrayList<Integer>();//12月
        dec = gson.fromJson(sharedPreferences.getString("dec_data", null), new TypeToken<ArrayList<Integer>>(){}.getType());


        data(month, gruCounter);
    }
        //onResume
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);

        //月間ページに移動
        ImageButton monthButton = (ImageButton) findViewById(R.id.b_mon);
        monthButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.example.kurokami.guchitte_hacku", "com.example.kurokami.guchitte_hacku.monthly");
                startActivity(intent);
            }
        });

        //呟きを入力・消えるview
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                TextView textView = (TextView) findViewById(R.id.textView);
                AlphaAnimation fadein_image = new AlphaAnimation(0.0f, 1.0f);
                fadein_image.setDuration(1000);
                inputMessage.inputMessage(editText,textView);
            }
        });
        backgroundChange();
    }

    void data(int month,int gruCounter){

        int colorNumber=bottleMaker.gruChecker(gruCounter);
        if(colorNumber!=0)gruCounter=0;
        else{
            //colorNumberをリストに追加する

            String key;
            if(month==1)key="jan_data";
            else if(month==2)key="feb_data";
            else if(month==3)key="mar_data";
            else if(month==4)key="apr_data";
            else if(month==5)key="may_data";
            else if(month==6)key="jun_data";
            else if(month==7)key="jul_data";
            else if(month==8)key="aug_data";
            else if(month==9)key="sep_data";
            else if(month==10)key="oct_data";
            else if(month==11)key="nov_data";
            else if(month==12)key="dec_data";
            else key=null;

            Gson gson=new Gson();
            SharedPreferences sharedPreferences =  getSharedPreferences("data", Context.MODE_PRIVATE);
            ArrayList list = gson.fromJson(sharedPreferences.getString(key, null), new TypeToken<ArrayList<Integer>>(){}.getType());
            list.add(colorNumber);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("data", gson.toJson(list));
            editor.commit();
        }

    }

    void forBeginner() {
        boolean before = AppLaunchChecker.hasStartedFromLauncher(this);
        if (before == false) {
            ImageView imageView = new ImageView(this);//表示する場所と思われるthisか？
            imageView.setImageResource(res.drawable.scene_1);
            setContentView(imageView);
            //ファイル名わかったら書き換えること

            //タップされたら画面を閉じるみたいな機能をつけて完了のはず
        }
    }
    void emptyMonthLog(){//ArrayListの中身だけ消去する
        Gson gson=new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.remove("jan_data");
        e.remove("feb_data");
        e.remove("mar_data");
        e.remove("apr_data");
        e.remove("may_data");
        e.remove("jun_data");
        e.remove("jul_data");
        e.remove("aug_data");
        e.remove("sep_data");
        e.remove("oct_data");
        e.remove("nov_data");
        e.remove("dec_data");
        e.commit();
    }
    void emptyGruCounter(){//gruCounterを０にするためのメソッド、引数なしでリターンもなし
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        int gruCounter=0;
        e.putInt("grumbleCounter",gruCounter);
        e.commit();
    }
    void addgruCounter(){//gruCounterに++するメソッド引数なし、リターンもなし

        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        int gruCounter=sharedPreferences.getInt("grumbleCounter",0);
        gruCounter++;
        e.putInt("grumbleCounter",gruCounter);
        e.commit();
    }
    int getCounter(){//gruCounterを獲得するメソッド
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        int gruCounter=sharedPreferences.getInt("grumbleCounter",0);
        return gruCounter;
    }
    ArrayList getMonthLog(int month){//指定した月の配列をリターンするメソッド
        Gson gson=new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);

        String key;
        if(month==1)key="jan_data";
        else if(month==2)key="feb_data";
        else if(month==3)key="mar_data";
        else if(month==4)key="apr_data";
        else if(month==5)key="may_data";
        else if(month==6)key="jun_data";
        else if(month==7)key="jul_data";
        else if(month==8)key="aug_data";
        else if(month==9)key="sep_data";
        else if(month==10)key="oct_data";
        else if(month==11)key="nov_data";
        else if(month==12)key="dec_data";
        else key=null;

        ArrayList monthLog = gson.fromJson(sharedPreferences.getString(key, null), new TypeToken<ArrayList<Integer>>(){}.getType());
        return monthLog;
    }
    int monthGetter(){
        Calendar cal = Calendar.getInstance();
        int month = monthCheck.getCalender(cal);
        return month;
    }
    //愚痴カウンタに応じて背景画面の変更をします
    void backgroundChange(){
        int count=getCounter();
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.main);
        if(count==0){
            layout.setBackgroundResource(R.drawable.back_1_r);
        }else if(count==2){
            layout.setBackgroundResource(R.drawable.back_2_r);
        } else if(count==5){
            layout.setBackgroundResource(R.drawable.back_3_r);
        }
    }
}

