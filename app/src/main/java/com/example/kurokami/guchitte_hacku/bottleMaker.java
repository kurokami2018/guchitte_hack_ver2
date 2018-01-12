package com.example.kurokami.guchitte2018;
import java.util.Random;

public class bottleMaker{
    //最初はここで月間画面に変化をもたらす何かをプログラミングするつもりだったけどうまく行かなそうだからここには書きません
    //あと瓶ができる動画を再生して終わりのはず

    public int gruConterChecker(int gruCounter){//背景は呟く画面を表示したまま
        if(gruCounter>=20){//瓶がたまるのに必要な愚痴の回数を２０回と仮定、あとで変えてね
            Random rand=new Random();
            int colorNumber=rand.nextInt(5)+1;//瓶の色が5色と仮定、あとで変えてね
            //瓶ができる動画を流す、動画に出でくる瓶の色とcolorNumberが連動


            return colorNumber;
        }
        else{
            return 0;
        }
    }
}
