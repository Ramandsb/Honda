package com.example.adminpc.honda.Sos;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.adminpc.honda.MainActivity;
import com.example.adminpc.honda.R;
import com.example.adminpc.honda.SplashActivity;

public class ManualSos extends AppCompatActivity {
    VideoView video_player_view;
    View allbut;
    DisplayMetrics dm;
    SurfaceView sur_View;
    MediaController media_Controller;
    View back,sos,videoview;
    private Handler mHandler = new Handler();
    boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_sos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sos=findViewById(R.id.clicksos);
        videoview=findViewById(R.id.videoview);
        getInit(R.raw.sos_f,20000);
        sos.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                videoview.setVisibility(View.VISIBLE);
                sos.setVisibility(View.GONE);

                getInit(R.raw.sos_s,6000);
                flag=true;
                return false;

            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            Intent i = new Intent(ManualSos.this,MainActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        if (id == R.id.action_reset) {
            Intent i = new Intent(ManualSos.this,SplashActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getInit(final int video,int duration) {
        video_player_view = (VideoView) findViewById(R.id.video_sos);
        media_Controller = new MediaController(this);
        dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        video_player_view.setMinimumWidth(width);
        video_player_view.setMinimumHeight(height);
        video_player_view.setMediaController(null);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + video);
        video_player_view.setVideoURI(uri);
        video_player_view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (flag==false) {
                    videoview.setVisibility(View.GONE);
                    sos.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(ManualSos.this,"Sms Sent",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(ManualSos.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    flag=false;
                }
            }
        });
        video_player_view.start();
//        mHandler.removeCallbacks(loadHomeActivity);
//        mHandler.postDelayed(loadHomeActivity, duration);
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
