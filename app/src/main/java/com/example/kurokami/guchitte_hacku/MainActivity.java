
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

        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1; //月を取得

        int lastMonth = sharedPreferences.getInt("lastMonth_data", 0);//前回のログインした月をしまっておく

        if((lastMonth!=month)&&((month==1) || (lastMonth==0))) {//&&ではなく||じゃないかな　by今野 ほんとだ！ありがとう！by小松
            SharedPreferences.Editor e = sharedPreferences.edit();//emptyMonthLogを直書き
            e.remove("GrumbleData");
            e.commit();//月間初期画面を表示する
        }

        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putInt("new_month", month);//キーをnew_monthとしてmonthをプレファレンスに保存
        e.commit();//保存実行

        Gson gson = new Gson();//ファイル(data)から各月のデータを取得してリストを作成する
        ArrayList<Integer> gruCounter = new ArrayList<Integer>();
        gruCounter = gson.fromJson(sharedPreferences.getString("GrumbleData", null), new TypeToken<ArrayList<Integer>>(){}.getType());

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
        ImageButton button = (ImageButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                TextView textView = (TextView) findViewById(R.id.textView);
                AlphaAnimation fadein_image = new AlphaAnimation(0.0f, 1.0f);
                fadein_image.setDuration(1000);
                inputMessage.inputMessage(editText,textView);
                leaf();
            }
        });

        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1; //月を取得
        backgroundChange(month);
    }


    void forBeginner() {
        boolean before = AppLaunchChecker.hasStartedFromLauncher(this);
        if (before == false) {
            ImageView imageView = new ImageView(this);//表示する場所と思われるthisか？
            imageView.setImageResource(R.drawable.exp);
            setContentView(imageView);
            //ファイル名わかったら書き換えること

            //タップされたら画面を閉じるみたいな機能をつけて完了のはず
        }
    }
    void emptyMonthLog(){//ArrayListの中身だけ消去する
        Gson gson=new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.remove("GrumbleData");
        e.commit();
    }
    int getThisMonth(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1; //月を取得
        return month;
    }
    void addgruCounter(int month){//gruCounterに++するメソッド引数なし、リターンもなし
        Gson gson=new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        ArrayList gruLog = gson.fromJson(sharedPreferences.getString("GrumbleData", null), new TypeToken<ArrayList<Integer>>(){}.getType());
        month=month-1;
        int gruCounter=(int)gruLog.get(month);
        gruCounter++;
        gruLog.set(month,gruCounter);
        e.putString("GrumbleData", gson.toJson(gruLog));
        e.commit();
    }
    int getCounter(int month){//gruCounterを獲得するメソッド
        ArrayList gruLog=getMonthLog();
        month=month-1;
        int gruCounter=(int)gruLog.get(month);
        return gruCounter;
    }
    ArrayList getMonthLog(){//愚痴配列をリターンするメソッド
        Gson gson=new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);

        ArrayList gruLog = gson.fromJson(sharedPreferences.getString("GrumbleData", null), new TypeToken<ArrayList<Integer>>(){}.getType());
        return gruLog;
    }

    //<未完成>愚痴カウンタに応じて背景画面の変更をします
    void backgroundChange(int month){
        int count=getCounter(month);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.main);
        if(count==0){
            layout.setBackgroundResource(R.drawable.back_1_r);
        }else if(count==2){
            layout.setBackgroundResource(R.drawable.back_2_r);
        } else if(count==5) {
            layout.setBackgroundResource(R.drawable.back_3_r);
        }
    }
    //葉っぱのエフェクト効果設定
    void leaf(){
        AlphaAnimation fadein_image = new AlphaAnimation(0.0f, 1.0f);
        fadein_image.setDuration(1000);

        ImageView img2 = (ImageView) findViewById(R.id.leaf_2);
        img2.setImageResource(R.drawable.leaf_2);
        img2.startAnimation(fadein_image);
        delGrumble.delGrumble(img2);

        ImageView img3 = (ImageView) findViewById(R.id.leaf_3);
        img3.setImageResource(R.drawable.leaf_3);
        img3.startAnimation(fadein_image);
        delGrumble.delGrumble(img3);

        ImageView img4 = (ImageView) findViewById(R.id.leaf_4);
        img4.setImageResource(R.drawable.leaf_4);
        img4.startAnimation(fadein_image);
        delGrumble.delGrumble(img4);

        ImageView img5 = (ImageView) findViewById(R.id.leaf_5);
        img5.setImageResource(R.drawable.leaf_5);
        img5.startAnimation(fadein_image);
        delGrumble.delGrumble(img5);

        ImageView img6 = (ImageView) findViewById(R.id.leaf_6);
        img6.setImageResource(R.drawable.leaf_6);
        img6.startAnimation(fadein_image);
        delGrumble.delGrumble(img6);

        ImageView img7 = (ImageView) findViewById(R.id.leaf_7);
        img7.setImageResource(R.drawable.leaf_7);
        img7.startAnimation(fadein_image);
        delGrumble.delGrumble(img7);

        ImageView img8 = (ImageView) findViewById(R.id.leaf_8);
        img8.setImageResource(R.drawable.leaf_8);
        img8.startAnimation(fadein_image);
        delGrumble.delGrumble(img8);

        ImageView img9 = (ImageView) findViewById(R.id.leaf_9);
        img9.setImageResource(R.drawable.leaf_9);
        img9.startAnimation(fadein_image);
        delGrumble.delGrumble(img9);

        ImageView img10 = (ImageView) findViewById(R.id.leaf_10);
        img10.setImageResource(R.drawable.leaf_10);
        img10.startAnimation(fadein_image);
        delGrumble.delGrumble(img10);

        ImageView img11 = (ImageView) findViewById(R.id.leaf_11);
        img11.setImageResource(R.drawable.leaf_11);
        img11.startAnimation(fadein_image);
        delGrumble.delGrumble(img11);

        ImageView img12 = (ImageView) findViewById(R.id.leaf_12);
        img12.setImageResource(R.drawable.leaf_12);
        img12.startAnimation(fadein_image);
        delGrumble.delGrumble(img12);

        ImageView img13 = (ImageView) findViewById(R.id.leaf_13);
        img13.setImageResource(R.drawable.leaf_13);
        img13.startAnimation(fadein_image);
        delGrumble.delGrumble(img13);

        ImageView img14 = (ImageView) findViewById(R.id.leaf_14);
        img14.setImageResource(R.drawable.leaf_14);
        img14.startAnimation(fadein_image);
        delGrumble.delGrumble(img14);

        ImageView img15 = (ImageView) findViewById(R.id.leaf_15);
        img15.setImageResource(R.drawable.leaf_15);
        img15.startAnimation(fadein_image);
        delGrumble.delGrumble(img15);

        ImageView img16 = (ImageView) findViewById(R.id.leaf_16);
        img16.setImageResource(R.drawable.leaf_16);
        img16.startAnimation(fadein_image);
        delGrumble.delGrumble(img16);

        ImageView img17 = (ImageView) findViewById(R.id.leaf_17);
        img17.setImageResource(R.drawable.leaf_17);
        img17.startAnimation(fadein_image);
        delGrumble.delGrumble(img17);

        ImageView img18 = (ImageView) findViewById(R.id.leaf_18);
        img18.setImageResource(R.drawable.leaf_18);
        img18.startAnimation(fadein_image);
        delGrumble.delGrumble(img18);

        ImageView img19 = (ImageView) findViewById(R.id.leaf_19);
        img19.setImageResource(R.drawable.leaf_19);
        img19.startAnimation(fadein_image);
        delGrumble.delGrumble(img19);

        ImageView img20 = (ImageView) findViewById(R.id.leaf_20);
        img20.setImageResource(R.drawable.leaf_20);
        img20.startAnimation(fadein_image);
        delGrumble.delGrumble(img20);

    }
    void setBottle(){
        Gson gson = new Gson();//ファイル(data)から各月のデータを取得してリストを作成する
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        ArrayList gruLog = gson.fromJson(sharedPreferences.getString("GrumbleData", null), new TypeToken<ArrayList<Integer>>(){}.getType());

        int jan=(int)gruLog.get(0);
        int feb=(int)gruLog.get(1);
        int mar=(int)gruLog.get(2);
        int apr=(int)gruLog.get(3);
        int may=(int)gruLog.get(4);
        int jun=(int)gruLog.get(5);
        int jul=(int)gruLog.get(6);
        int aug=(int)gruLog.get(7);
        int sep=(int)gruLog.get(8);
        int oct=(int)gruLog.get(9);
        int nov=(int)gruLog.get(10);
        int dec=(int)gruLog.get(11);


        if(jan>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(jan>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(jan>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(jan>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(jan>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(jan>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(feb>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(feb>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(feb>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(feb>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(feb>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(feb>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(mar>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(mar>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(mar>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(mar>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(mar>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(mar>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(apr>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(apr>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(apr>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(apr>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(apr>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(apr>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(may>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(may>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(may>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(may>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(may>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(may>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(jun>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(jun>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(jun>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(jun>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(jun>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(jun>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(jul>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(jul>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(jul>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(jul>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(jul>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(jul>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(aug>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(aug>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(aug>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(aug>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(aug>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(aug>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(sep>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(sep>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(sep>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(sep>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(sep>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(sep>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(oct>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(oct>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(oct>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(oct>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(oct>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(oct>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(nov>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(nov>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(nov>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(nov>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(nov>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(nov>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
        if(dec>9){
            ImageView imageView = (ImageView)findViewById(R.id.imageView5);
            imageView.setVisibility(View.VISIBLE);
        }
        if(dec>19){
            ImageView imageView2 = (ImageView)findViewById(R.id.imageView6);
            imageView2.setVisibility(View.VISIBLE);
        }
        if(dec>29){
            ImageView imageView3 = (ImageView)findViewById(R.id.imageView7);
            imageView3.setVisibility(View.VISIBLE);
        }
        if(dec>39){
            ImageView imageView4 = (ImageView)findViewById(R.id.imageView8);
            imageView4.setVisibility(View.VISIBLE);
        }
        if(dec>49){
            ImageView imageView5 = (ImageView)findViewById(R.id.imageView9);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(dec>59){
            ImageView imageView6 = (ImageView)findViewById(R.id.imageView10);
            imageView6.setVisibility(View.VISIBLE);
        }
    }

}

