package com.example.adminpc.honda.VehicalHealth;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.adminpc.honda.MainActivity;
import com.example.adminpc.honda.R;
import com.example.adminpc.honda.SplashActivity;

public class VehicalHealth extends AppCompatActivity {

    Button topLocate, topTrip, topHealth;
    VideoView video_player_view;
    DisplayMetrics dm;
    SurfaceView sur_View;
    MediaController media_Controller;
    View topbar;
    View frame;
    boolean flag=false;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehical_health);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        topLocate = (Button) findViewById(R.id.topLocate);
        topTrip = (Button) findViewById(R.id.topTrip);
        topHealth = (Button) findViewById(R.id.topHealth);
        topLocate.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        topLocate.setTextColor(Color.WHITE);
        topbar=findViewById(R.id.topbar);
        frame=findViewById(R.id.frame);
        topbar.setVisibility(View.GONE);
        getInit(R.raw.health_f,16000);
        topLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topLocate.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                topLocate.setTextColor(Color.WHITE);
                topTrip.setBackgroundColor(Color.WHITE);
                topTrip.setTextColor(getResources().getColor(R.color.colorPrimary));
                topHealth.setBackgroundColor(Color.WHITE);
                topHealth.setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });
        topTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topTrip.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                topTrip.setTextColor(Color.WHITE);
                topLocate.setBackgroundColor(Color.WHITE);
                topLocate.setTextColor(getResources().getColor(R.color.colorPrimary));
                topHealth.setBackgroundColor(Color.WHITE);
                topHealth.setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });
        topHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topHealth.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                topHealth.setTextColor(Color.WHITE);
                topLocate.setBackgroundColor(Color.WHITE);
                topLocate.setTextColor(getResources().getColor(R.color.colorPrimary));
                topTrip.setBackgroundColor(Color.WHITE);
                topTrip.setTextColor(getResources().getColor(R.color.colorPrimary));
                video_player_view.setVisibility(View.VISIBLE);

                getInit(R.raw.health_s, 19000);
                frame.setBackgroundColor(Color.parseColor("#EEEEEE"));
                flag=true;
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
            Intent i = new Intent(VehicalHealth.this,MainActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        if (id == R.id.action_reset) {
            Intent i = new Intent(VehicalHealth.this,SplashActivity.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getInit(int video,int duration) {
        video_player_view = (VideoView) findViewById(R.id.video_firhealth);
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
        video_player_view.start();
        mHandler.removeCallbacks(loadHomeActivity);
        mHandler.postDelayed(loadHomeActivity, duration);
    }
    // A runnable executed when the progressbar finishes which starts the HomeActivity.
    private Runnable loadHomeActivity = new Runnable() {
        public void run() {

            if (flag==false) {
                video_player_view.stopPlayback();
                video_player_view.setVisibility(View.GONE);
                topbar.setVisibility(View.VISIBLE);
                frame.setBackgroundResource(R.drawable.health_between);
            }else {
                Intent intent= new Intent(VehicalHealth.this,MainActivity.class);
                startActivity(intent);
                finish();
                MainActivity.clikked=0;
                flag=false;
            }

        }

    };


}
