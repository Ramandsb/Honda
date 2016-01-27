package com.example.adminpc.honda.DocumentsWallet;

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
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.adminpc.honda.MainActivity;
import com.example.adminpc.honda.R;
import com.example.adminpc.honda.SplashActivity;

public class DocumentWallet extends AppCompatActivity {
    VideoView video_player_view;
    DisplayMetrics dm;
    MediaController media_Controller;
    View back;
    View butts;
    View videoview;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_wallet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        back=findViewById(R.id.back);
        videoview=findViewById(R.id.videoview);
        butts=findViewById(R.id.doc_wal_but);
        getInit();
        Button doc_wal= (Button) findViewById(R.id.mydoc);
        doc_wal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DocumentWallet.this,Documents.class);
                startActivity(i);
                finish();
            }
        });
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
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.doc_wal_f);
        video_player_view.setVideoURI(uri);
        video_player_view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoview.setVisibility(View.GONE);
                back.setVisibility(View.VISIBLE);

            }
        });
        video_player_view.start();
//        mHandler.removeCallbacks(loadHomeActivity);
//        mHandler.postDelayed(loadHomeActivity, 27000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_doc, menu);
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
            Intent i = new Intent(DocumentWallet.this,MainActivity.class);
            startActivity(i);
            finish();
            return true;
        }

        if (id == R.id.action_reset) {

            back.setVisibility(View.VISIBLE);
            butts.setVisibility(View.VISIBLE);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//    private Runnable loadHomeActivity = new Runnable() {
//        public void run() {
//
//        }
//
//    };

}
