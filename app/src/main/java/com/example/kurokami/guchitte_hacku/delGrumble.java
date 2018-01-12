package com.example.kurokami.guchitte2018;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class delGrumble extends MainActivity {
    //エフェクト
    public static void delGrumble(ImageView img) {

        AnimatorSet animatorSet = new AnimatorSet();
        ;
        Random rand = new Random();
        int x = rand.nextInt(10) - 20;
        double distance = -5000;
        double degree = 60 + x;

        List<Animator> animatorList1 = new ArrayList<Animator>();

        // 距離と半径から到達点となるX座標、Y座標を求めます
        float toX = (float) (distance * Math.cos(Math.toRadians(degree)));
        float toY = (float) (distance * Math.sin(Math.toRadians(degree)));

        // translationX
        PropertyValuesHolder holderX1 = PropertyValuesHolder.ofFloat("translationX", 0f, toX);
        // translationY
        PropertyValuesHolder holderY1 = PropertyValuesHolder.ofFloat("translationY", 0f, toY);
        // rotation
        PropertyValuesHolder holderRotaion1 = PropertyValuesHolder.ofFloat("rotationY", 0f, 720f);
        // 同時に実行
        ObjectAnimator XYRotationY1 =
                ObjectAnimator.ofPropertyValuesHolder(img, holderX1, holderY1, holderRotaion1);
        // 5秒かけて実行
        XYRotationY1.setDuration(5000);

        // リスト実行
        animatorSet.play(XYRotationY1);
        // アニメーションを開始します
        animatorSet.start();
    }
   /*
       //エフェクト
        ImageView img1 = (ImageView) findViewById(R.id.leaf_1);
        img1.setImageResource(R.drawable.leaf_1);
        fadein_image.setFillAfter(false);
        delGrumble(img1);

        ImageView img2 = (ImageView) findViewById(R.id.leaf_2);
        img2.setImageResource(R.drawable.leaf_2);
        img2.startAnimation(fadein_image);
        delGrumble(img2);

        ImageView img3 = (ImageView) findViewById(R.id.leaf_3);
        img3.setImageResource(R.drawable.leaf_3);
        img3.startAnimation(fadein_image);
        delGrumble(img3);

        ImageView img4 = (ImageView) findViewById(R.id.leaf_4);
        img4.setImageResource(R.drawable.leaf_4);
        img4.startAnimation(fadein_image);
        delGrumble(img4);

        ImageView img5 = (ImageView) findViewById(R.id.leaf_5);
        img5.setImageResource(R.drawable.leaf_5);
        img5.startAnimation(fadein_image);
        delGrumble(img5);

        ImageView img6 = (ImageView) findViewById(R.id.leaf_6);
        img6.setImageResource(R.drawable.leaf_6);
        img6.startAnimation(fadein_image);
        delGrumble(img6);

        ImageView img7 = (ImageView) findViewById(R.id.leaf_7);
        img7.setImageResource(R.drawable.leaf_7);
        img7.startAnimation(fadein_image);
        delGrumble(img7);

        ImageView img8 = (ImageView) findViewById(R.id.leaf_8);
        img8.setImageResource(R.drawable.leaf_8);
        img8.startAnimation(fadein_image);
        delGrumble(img8);

        ImageView img9 = (ImageView) findViewById(R.id.leaf_9);
        img9.setImageResource(R.drawable.leaf_9);
        img9.startAnimation(fadein_image);
        delGrumble(img9);

        ImageView img10 = (ImageView) findViewById(R.id.leaf_10);
        img10.setImageResource(R.drawable.leaf_10);
        img10.startAnimation(fadein_image);
        delGrumble(img10);

        ImageView img11 = (ImageView) findViewById(R.id.leaf_11);
        img11.setImageResource(R.drawable.leaf_11);
        img11.startAnimation(fadein_image);
        delGrumble(img11);

        ImageView img12 = (ImageView) findViewById(R.id.leaf_12);
        img12.setImageResource(R.drawable.leaf_12);
        img12.startAnimation(fadein_image);
        delGrumble(img12);

        ImageView img13 = (ImageView) findViewById(R.id.leaf_13);
        img13.setImageResource(R.drawable.leaf_13);
        img13.startAnimation(fadein_image);
        delGrumble(img13);

        ImageView img14 = (ImageView) findViewById(R.id.leaf_14);
        img14.setImageResource(R.drawable.leaf_14);
        img14.startAnimation(fadein_image);
        delGrumble(img14);

        ImageView img15 = (ImageView) findViewById(R.id.leaf_15);
        img15.setImageResource(R.drawable.leaf_15);
        img15.startAnimation(fadein_image);
        delGrumble(img15);

        ImageView img16 = (ImageView) findViewById(R.id.leaf_16);
        img16.setImageResource(R.drawable.leaf_16);
        img16.startAnimation(fadein_image);
        delGrumble(img16);

        ImageView img17 = (ImageView) findViewById(R.id.leaf_17);
        img17.setImageResource(R.drawable.leaf_17);
        img17.startAnimation(fadein_image);
        delGrumble(img17);

        ImageView img18 = (ImageView) findViewById(R.id.leaf_18);
        img18.setImageResource(R.drawable.leaf_18);
        img18.startAnimation(fadein_image);
        delGrumble(img18);

        ImageView img19 = (ImageView) findViewById(R.id.leaf_19);
        img19.setImageResource(R.drawable.leaf_19);
        img19.startAnimation(fadein_image);
        delGrumble(img19);

        ImageView img20 = (ImageView) findViewById(R.id.leaf_20);
        img20.setImageResource(R.drawable.leaf_20);
        img20.startAnimation(fadein_image);
        delGrumble(img20);
*/
}

