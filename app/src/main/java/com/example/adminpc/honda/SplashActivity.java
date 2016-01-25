package com.example.adminpc.honda;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Handler mHandler = new Handler();
    VideoView video_player_view;
    DisplayMetrics dm;
    SurfaceView sur_View;
    MediaController media_Controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getInit();
        MainActivity.voi=0;
    }

    @Override
    public void onStart() {
        // When the aplication starts, show the progressbar for 2 seconds. After that, execute loadHomeActivity runnable.
        long mStartTime = 0;
        if (mStartTime == 0L) {
            mStartTime = System.currentTimeMillis();
            mHandler.removeCallbacks(loadHomeActivity);
            mHandler.postDelayed(loadHomeActivity, 14000);
        }
        super.onStart();
    }

    // A runnable executed when the progressbar finishes which starts the HomeActivity.
    private Runnable loadHomeActivity = new Runnable() {
        public void run() {
            Intent intenthome = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intenthome);
            finish();
        }

    };

    public void getInit() {
        video_player_view = (VideoView) findViewById(R.id.video_player_view);
        media_Controller = new MediaController(this);
        dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        video_player_view.setMinimumWidth(width);
        video_player_view.setMinimumHeight(height);
        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash);
        video_player_view.setVideoURI(uri);
        video_player_view.setMediaController(null);
        video_player_view.start();
    }

}