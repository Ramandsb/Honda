package com.example.adminpc.honda.VehicalHealth;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.adminpc.honda.MainActivity;
import com.example.adminpc.honda.R;

public class HealthFrag extends Fragment {
    private String TAG;
    LayoutInflater inflater;
    private static int InstanceCount = 0;
    VideoView video_player_view;
    DisplayMetrics dm;
    SurfaceView sur_View;
    MediaController media_Controller;
    View back;
    View view;
    private Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler.removeCallbacks(loadHomeActivity);
        mHandler.postDelayed(loadHomeActivity, 16000);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.inflater = inflater;
        view=inflater.inflate(R.layout.fragment_layout, container, false);
        getInit(view);
        return view;

    }

    public static HealthFrag newInstance() {
        HealthFrag fragment = new HealthFrag();
        fragment.setTAG((HealthFrag.InstanceCount++) + "");
        return fragment;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public void getInit(View view) {
        video_player_view = (VideoView) view.findViewById(R.id.video_healthfrag);
        media_Controller = new MediaController(getActivity());
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        video_player_view.setMinimumWidth(width);
        video_player_view.setMinimumHeight(height);
        video_player_view.setMediaController(null);
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.splash);
        video_player_view.setVideoURI(uri);
        video_player_view.start();
    }
    // A runnable executed when the progressbar finishes which starts the HomeActivity.
    private Runnable loadHomeActivity = new Runnable() {
        public void run() {
            MainActivity.clikked=0;
        }

    };


}
