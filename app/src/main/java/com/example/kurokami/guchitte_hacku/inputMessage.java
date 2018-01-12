package com.example.kurokami.guchitte2018;

import android.animation.ObjectAnimator;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class inputMessage extends MainActivity{

    public static void inputMessage(EditText editText, TextView textView) {
        // 入力された文を取得
        String str = editText.getText().toString();

        //　取得後editText内の文字を削除
        editText.getText().clear();

        //　取得した文字をTextViewにセット
        textView.setText(str);

        //　フェードイン・アウトアニメーション
        AlphaAnimation fadeout_text = new AlphaAnimation(1.0f, 0.0f);
        AlphaAnimation fadein_image = new AlphaAnimation(0.0f, 1.0f);

        //　表示時間を指定
        fadeout_text.setDuration(1000);
        fadein_image.setDuration(1000);

        //　textを上に動かす
        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "translationY", 50, 0);
        animator.setDuration(2000);
        animator.start();

        //　実行
        textView.startAnimation(fadeout_text);
        fadeout_text.setFillAfter(true);

        //カウント

    }
}


