
    package com.example.kurokami.guchitte_hacku;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
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
        import java.util.List;
        import java.util.Calendar;
        import android.support.v4.app.AppLaunchChecker;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        Calendar cal = Calendar.getInstance();//Calenderを取得、MainActivityでしか取得できないから動かさない
        int month = monthCheck.getCalender(cal);//今回ログイン月を取得
        int lastMonth = sharedPreferences.getInt("lastMonth_data", 0);//前回のログインした月をしまっておく
        monthCheck.getPast(lastMonth, month);//前回のログイン月と今回のログイン月を比較するメソッドに前回ログイン月を渡す
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putInt("new_month", month);//キーをnew_monthとしてmonthをプレファレンスに保存
        e.commit();//保存実行
        int gruCounter = sharedPreferences.getInt("grumbleCounter", 0);//保存されていたgruCounterを取得

        forBeginner();//アプリを初回起動の時だけ出てくる説明画像を表示する


        Gson gson = new Gson();
        //ファイル(data)から各月のデータを取得してリストを作成する


        ArrayList<Integer> jan_list = new ArrayList<Integer>();//1月のデータArrayリストのインスタンス生成
        jan_list = gson.fromJson(sharedPreferences.getString("jan_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> feb_list = new ArrayList<Integer>();//2月
        feb_list = gson.fromJson(sharedPreferences.getString("feb_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> mar_list = new ArrayList<Integer>();//3月
        mar_list = gson.fromJson(sharedPreferences.getString("mar_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> apr_list = new ArrayList<Integer>();//4月
        apr_list = gson.fromJson(sharedPreferences.getString("apr_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> may_list = new ArrayList<Integer>();//5月
        may_list = gson.fromJson(sharedPreferences.getString("may_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> jun_list = new ArrayList<Integer>();//6月
        jun_list = gson.fromJson(sharedPreferences.getString("jun_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> jul_list = new ArrayList<Integer>();//7月
        jul_list = gson.fromJson(sharedPreferences.getString("jul_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> aug_list = new ArrayList<Integer>();//8月
        aug_list = gson.fromJson(sharedPreferences.getString("aug_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> sep_list = new ArrayList<Integer>();//9月
        sep_list = gson.fromJson(sharedPreferences.getString("sep_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> oct_list = new ArrayList<Integer>();//10月
        oct_list = gson.fromJson(sharedPreferences.getString("oct_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> nov_list = new ArrayList<Integer>();//11月
        nov_list = gson.fromJson(sharedPreferences.getString("nov_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());

        ArrayList<Integer> dec_list = new ArrayList<Integer>();//12月
        dec_list = gson.fromJson(sharedPreferences.getString("dec_data", null), new TypeToken<ArrayList<String>>() {
        }.getType());


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
                inputMessage.inputMessage(editText, textView);
            }
        });

    }

    void forBeginner() {
        boolean before = AppLaunchChecker.hasStartedFromLauncher(this);
        if (before == false) {
            ImageView imageView = new ImageView(this);//表示する場所と思われるthisか？
            imageView.setImageResource(res.drawable.scene_1);//ここのメソッド使うなら説明画面のファイル名で変更しておいてくださいby今野
            setContentView(imageView);

            //これって消滅でいいんだっけ？使い方の説明を初回起動時のみ表示するためのメソッドだよ

            //タップされたら画面を閉じるみたいな機能をつけて完了のはず
        }
    }
    void emptyMonthLog(ArrayList jan,ArrayList feb,ArrayList mar,ArrayList apr,ArrayList may,ArrayList jun,ArrayList jul,ArrayList aug,ArrayList sep,ArrayList oct,ArrayList nov,ArrayList dec){
        Gson gson=new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        Arrays.fill(jan,0);
        e.putString("jan_data", gson.toJson(jan));
        Arrays.fill(feb,0);
        e.putString("feb_data", gson.toJson(feb));
        Arrays.fill(mar,0);
        e.putString("mar_data", gson.toJson(mar));
        Arrays.fill(apr,0);
        e.putString("apr_data", gson.toJson(apr));
        Arrays.fill(may,0);
        e.putString("may_data", gson.toJson(may));
        Arrays.fill(jun,0);
        e.putString("jun_data", gson.toJson(jun));
        Arrays.fill(jul,0);
        e.putString("jul_data", gson.toJson(jul));
        Arrays.fill(aug,0);
        e.putString("aug_data", gson.toJson(aug));
        Arrays.fill(sep,0);
        e.putString("sep_data", gson.toJson(sep));
        Arrays.fill(oct,0);
        e.putString("oct_data", gson.toJson(oct));
        Arrays.fill(nov,0);
        e.putString("nov_data", gson.toJson(nov));
        Arrays.fill(dec,0);
        e.putString("dec_data", gson.toJson(dec));
        e.commit();
    }
    void emptyCounter(int gruCounter){
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        gruCounter=0;
        e.putInt("grumbleCounter",gruCounter);
        e.commit();
    }
}
