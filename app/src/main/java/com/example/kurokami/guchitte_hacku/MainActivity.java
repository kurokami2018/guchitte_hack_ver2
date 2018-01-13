
package com.example.kurokami.guchitte_hacku;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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
            emptyMonthLog();
        }

        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putInt("new_month", month);//キーをnew_monthとしてmonthをプレファレンスに保存
        e.commit();//保存実行

    }
    //onResume
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);


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
                Calendar cal = Calendar.getInstance();
                int month = cal.get(Calendar.MONTH)+1; //月を取得
                addGruCounter(month);
                backgroundChange(month);
            }
        });

        //月間ページに移動
        ImageButton monthButton = (ImageButton) findViewById(R.id.b_mon);
        monthButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent();
                intent.setClassName("com.example.kurokami.guchitte_hacku", "com.example.kurokami.guchitte_hacku.monthly");
                int[] data = makeArray();
                intent.putExtra("data",data);
                startActivity(intent);
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
        SharedPreferences sharedPreferences = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.remove("1");
        e.remove("2");
        e.remove("3");
        e.remove("4");
        e.remove("5");
        e.remove("6");
        e.remove("7");
        e.remove("8");
        e.remove("9");
        e.remove("10");
        e.remove("11");
        e.remove("12");
        e.commit();
    }
    int getThisMonth(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1; //月を取得
        return month;
    }
    void addGruCounter(int month){//gruCounterに++するメソッド引数なし、リターンもなし
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();
        int gruCounter = 0;
        if(month==1)gruCounter=sharedPreferences.getInt("1", 0);
        if(month==2)gruCounter=sharedPreferences.getInt("2", 0);
        if(month==3)gruCounter=sharedPreferences.getInt("3", 0);;
        if(month==4)gruCounter=sharedPreferences.getInt("4", 0);
        if(month==5)gruCounter=sharedPreferences.getInt("5", 0);
        if(month==6)gruCounter=sharedPreferences.getInt("6", 0);
        if(month==7)gruCounter=sharedPreferences.getInt("7", 0);
        if(month==8)gruCounter=sharedPreferences.getInt("8", 0);
        if(month==9)gruCounter=sharedPreferences.getInt("9", 0);
        if(month==10)gruCounter=sharedPreferences.getInt("10", 0);
        if(month==11)gruCounter=sharedPreferences.getInt("11", 0);
        if(month==12)gruCounter=sharedPreferences.getInt("12", 0);
        gruCounter++;
        if(month==1){e.putInt("1",gruCounter);e.commit();}
        if(month==2){e.putInt("2",gruCounter);e.commit();}
        if(month==3){e.putInt("3",gruCounter);e.commit();}
        if(month==4){e.putInt("4",gruCounter);e.commit();}
        if(month==5){e.putInt("5",gruCounter);e.commit();}
        if(month==6){e.putInt("6",gruCounter);e.commit();}
        if(month==7){e.putInt("7",gruCounter);e.commit();}
        if(month==8){e.putInt("8",gruCounter);e.commit();}
        if(month==9){e.putInt("9",gruCounter);e.commit();}
        if(month==10){e.putInt("10",gruCounter);e.commit();}
        if(month==11){e.putInt("11",gruCounter);e.commit();}
        if(month==12){e.putInt("12",gruCounter);e.commit();}
    }
    int getCounter(int month){//gruCounterを獲得するメソッド
        int gruCounter=0;
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        if(month==1)gruCounter=sharedPreferences.getInt("1", 0);
        if(month==2)gruCounter=sharedPreferences.getInt("2", 0);
        if(month==3)gruCounter=sharedPreferences.getInt("3", 0);;
        if(month==4)gruCounter=sharedPreferences.getInt("4", 0);
        if(month==5)gruCounter=sharedPreferences.getInt("5", 0);
        if(month==6)gruCounter=sharedPreferences.getInt("6", 0);
        if(month==7)gruCounter=sharedPreferences.getInt("7", 0);
        if(month==8)gruCounter=sharedPreferences.getInt("8", 0);
        if(month==9)gruCounter=sharedPreferences.getInt("9", 0);
        if(month==10)gruCounter=sharedPreferences.getInt("10", 0);
        if(month==11)gruCounter=sharedPreferences.getInt("11", 0);
        if(month==12)gruCounter=sharedPreferences.getInt("12", 0);
        return gruCounter;
    }

    //愚痴カウンタに応じて背景画面の変更をします
    void backgroundChange(int month){
        int count=getCounter(month);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.main);
        if(count==0)layout.setBackgroundResource(R.drawable.back_1_r);
        if(count==3)layout.setBackgroundResource(R.drawable.back_2_r);
        if(count==8)layout.setBackgroundResource(R.drawable.back_3_r);
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
    int[] makeArray(){
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        int jan = sharedPreferences.getInt("1", 0);
        int feb = sharedPreferences.getInt("2", 0);
        int mar = sharedPreferences.getInt("3", 0);
        int apr = sharedPreferences.getInt("4", 0);
        int may = sharedPreferences.getInt("5", 0);
        int jun = sharedPreferences.getInt("6", 0);
        int jul = sharedPreferences.getInt("7", 0);
        int aug = sharedPreferences.getInt("8", 0);
        int sep = sharedPreferences.getInt("9", 0);
        int oct = sharedPreferences.getInt("10", 0);
        int nov = sharedPreferences.getInt("11", 0);
        int dec = sharedPreferences.getInt("12", 0);
       int[] data = new int[]{jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec};
        return data;

    }

}

