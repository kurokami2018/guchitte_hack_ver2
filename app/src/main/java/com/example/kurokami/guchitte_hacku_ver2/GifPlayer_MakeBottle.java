package com.example.kurokami.guchitte_hacku_ver2;


import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;
import android.media.*;





public class GifPlayer_MakeBottle extends AppCompatActivity{
    ImageView imageView;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.gifplayer_makebottle );

        /*
        imageView = (ImageView) findViewById( R.id.imageView1 );
        Glide.with( this ).asGif().load( R.raw.onetimebing ).into( imageView );


        imageView = findViewById( R.id.imageView1 );
        DrawableImageViewTarget target = new DrawableImageViewTarget(imageView) {
            @Override public void onResourceReady(Drawable resource, @Nullable Transition<? super Drawable> transition) {
                if (resource instanceof GifDrawable) ((GifDrawable)resource).setLoopCount(1);
                super.onResourceReady(resource, transition);
            }
        };
        Glide.with( this ).asGif().load( R.raw.onetimebing ).into(target.getView());
        */

        //*****************   mp4   *********************
        videoView = (VideoView)findViewById( R.id.videoView );
        videoView.setVideoURI( Uri.parse( "android.resource://" + this.getPackageName() + "/" + R.raw.onetimebing ));
        //videoView.setMediaController(new MediaController(this));
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp) {
                // 先頭に戻す -> Repeat
                //videoView.seekTo(0);
                finish();
            }
        });

    }

}
