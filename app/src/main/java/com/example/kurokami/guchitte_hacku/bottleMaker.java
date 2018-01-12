package com.example.kurokami.guchitte_hacku;
import java.util.Random;

class bottleMaker{
    //最初はここで月間画面に変化をもたらす何かをプログラミングするつもりだったけどうまく行かなそうだからここには書きません
    //あと瓶ができる動画を再生して終わりのはず

    static int gruChecker( int gruCounter ){//背景は呟く画面を表示したまま
        if(gruCounter>=20){//瓶がたまるのに必要な愚痴の回数を２０回と仮定、あとで変えてね
            Random rand=new Random();
            int colorNumber=rand.nextInt(12)+1;
            //瓶ができる動画を流す、動画に出でくる瓶の色とcolorNumberが連動
            if(colorNumber==1){//赤ベースの瓶ができる動画を流す

            }
            else if(colorNumber==2){//橙ベースの瓶ができる動画を流す

            }
            else if(colorNumber==3){//黄色ベースの瓶ができる動画を流す

            }
            else if(colorNumber==4){//黄緑の瓶ができる動画を流す

            }
            else if(colorNumber==5){//緑の瓶ができる動画を流す

            }
            else if(colorNumber==6){//青緑の瓶ができる動画を流す

            }
            else if(colorNumber==7){//水色の瓶ができる動画を流す

            }
            else if(colorNumber==8){//青の瓶ができる動画を流す

            }
            else if(colorNumber==9){//青紫の瓶ができる動画を流す

            }
            else if(colorNumber==10){//赤紫の瓶ができる動画を流す

            }
            else if(colorNumber==11){//桃色の瓶ができる動画を流す

            }
            else if(colorNumber==12){//赤桃色の瓶ができる動画を流す

            }


            return colorNumber;
        }
        else{
            return 0;
        }
    }
}
