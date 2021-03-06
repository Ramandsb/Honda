package com.example.adminpc.honda;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class AllCars extends AppCompatActivity {
    VideoView video_player_view;
    DisplayMetrics dm;
    SurfaceView sur_View;
    MediaController media_Controller;
    View back;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cars);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        back=findViewById(R.id.shareimage);
//        mHandler.removeCallbacks(loadHomeActivity);
//        mHandler.postDelayed(loadHomeActivity, 27000);
        getInit();


    }

    public void getInit() {
        video_player_view = (VideoView) findViewById(R.id.video_allcars);
        media_Controller = new MediaController(this);
        dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        video_player_view.setMinimumWidth(width);
        video_player_view.setMinimumHeight(height);
        video_player_view.setMediaController(null);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.allcars);
        video_player_view.setVideoURI(uri);
        video_player_view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {


                Intent inten=new Intent(AllCars.this,MainActivity.class);
                startActivity(inten);
                finish();
                MainActivity.clikked=0;
                MainActivity.conviclikked=0;
                MainActivity.utilityclikked=0;
            }
        });
        video_player_view.start();
    }
    // A runnable executed when the progressbar finishes which starts the HomeActivity.
//    private Runnable loadHomeActivity = new Runnable() {
//        public void run() {
//
//
//        }
//
//    };


}
