package com.example.adminpc.honda;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.adminpc.honda.BokkingService.ServiceBokking;
import com.example.adminpc.honda.CallNow.CallNow;
import com.example.adminpc.honda.CarCallander.CarCallander;
import com.example.adminpc.honda.CheckHonda.CheckHonda;
import com.example.adminpc.honda.ConsolidateAllcars.ConsolidateCars;
import com.example.adminpc.honda.DocumentsWallet.DocumentWallet;
import com.example.adminpc.honda.FuelLog.FuelLog;
import com.example.adminpc.honda.ImpactAlert.ImpactAlertgif;
import com.example.adminpc.honda.Locate.Locatemycar;
import com.example.adminpc.honda.PitStop.PitStop;
import com.example.adminpc.honda.RequestEnquiry.SelectCar;
import com.example.adminpc.honda.ServiceHistory.ServiceHistory;
import com.example.adminpc.honda.Sos.ManualSos;
import com.example.adminpc.honda.TripAnalysis.TripAnalysisMain;
import com.example.adminpc.honda.UserFeedback.Feedback;
import com.example.adminpc.honda.VehicalHealth.VehicalHealth;
import com.example.adminpc.honda.WhatsNew.WhatsNew;
import com.example.adminpc.honda.locatemycar.AddACar;
import com.example.adminpc.honda.locatemycar.Register;

public class MainActivity extends AppCompatActivity {
    Button safty, convie, utility, impact, share, locate, cars;
    Button trip, sos, health, calander;
    Button callnow, serbookin, serhist, whatsnew;
    Button pitstop, checkhonda, feedback, refer, wallet, fuelbook;
    View view;
    private Handler mHandler = new Handler();
    public static int clikked =0;
    public static int conviclikked =0;
    public static int utilityclikked =0;
    public static String currentSelection ="";
    MediaPlayer voiceover;
   public static int voi=0;
    Class gotoclass;
    View impactlayout,lay_share,lay_locate,lay_trip,lay_health,lay_sos;
    View lay_cars,lay_calendar,lay_serbook,lay_serhis,lay_callnow,lay_whats;
    View lay_pit,lay_check,lay_feed,lay_reffer,lay_wallet,lay_fuel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        view = findViewById(R.id.hidview);
        safty = (Button) findViewById(R.id.safety);
        convie = (Button) findViewById(R.id.convie);
        utility = (Button) findViewById(R.id.utility);
        impact = (Button) findViewById(R.id.impact);
        share = (Button) findViewById(R.id.share);
        locate = (Button) findViewById(R.id.locate);
        calander = (Button) findViewById(R.id.calander);
        trip = (Button) findViewById(R.id.trip);
        sos = (Button) findViewById(R.id.sos);
        cars = (Button) findViewById(R.id.cars);
        serbookin = (Button) findViewById(R.id.serboking);
        serhist = (Button) findViewById(R.id.serhis);
        callnow = (Button) findViewById(R.id.callnow);
        whatsnew = (Button) findViewById(R.id.whatsnew);
        pitstop = (Button) findViewById(R.id.pit);
        checkhonda = (Button) findViewById(R.id.checkhonda);
        feedback = (Button) findViewById(R.id.feedback);
        refer = (Button) findViewById(R.id.reffer);
        wallet = (Button) findViewById(R.id.wallet);
        fuelbook = (Button) findViewById(R.id.fuel);
        health = (Button) findViewById(R.id.health);
        /////////////////////////////////////////////
        impactlayout =  findViewById(R.id.impactlayout);
        lay_share =  findViewById(R.id.lay_share);
        lay_locate =  findViewById(R.id.lay_locate);
        lay_health =  findViewById(R.id.lay_health);
        lay_trip =  findViewById(R.id.lay_trip);
        lay_sos =  findViewById(R.id.lay_sos);
        lay_cars =  findViewById(R.id.hidview);
        lay_calendar =  findViewById(R.id.lay_calender);
        lay_serbook =  findViewById(R.id.lay_serbook);
        lay_serhis =  findViewById(R.id.lay_serhis);
        lay_callnow =  findViewById(R.id.lay_callnow);
        lay_whats =  findViewById(R.id.lay_whats);
        lay_pit =  findViewById(R.id.lay_pit);
        lay_check =  findViewById(R.id.lay_check);
        lay_feed =  findViewById(R.id.lay_feed);
        lay_reffer =  findViewById(R.id.lay_reffer);
        lay_wallet =  findViewById(R.id.lay_wallet);
        lay_fuel =  findViewById(R.id.lay_fuel);
        if (voi==0){
            playVO(null,12000,R.raw.menu_page);

        }
        voi++;
        if (currentSelection.equals("")){
            showsafety(false);
            showconvi(false);
            showutility(false);


        }else if (currentSelection.equals("safety")){
            showsafety(true);
            showconvi(false);
            showutility(false);


        }else if (currentSelection.equals("convie")){
            showsafety(false);
            showconvi(true);
            showutility(false);

        }else if (currentSelection.equals("utility")){
            showsafety(false);
            showconvi(false);
            showutility(true);

        }
        safty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                StopVoiceOver();
                currentSelection="safety";
                clikked++;
//                if (clikked==1) {
//                    showsafety(true);
//                    showconvi(false);
//                    showutility(false);
//                    playVO(null, 26000, R.raw.saftyandsec);
//                }else if (clikked==2){
//                    Intent i = new Intent(MainActivity.this,ImpactAlertgif.class);
//                    startActivity(i);
//                }
                showsafety(true);
                    showconvi(false);
                    showutility(false);
                    playVO(null, 26000, R.raw.saftyandsec);
                conviclikked=0;
                utilityclikked=0;


            }
        });
        convie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                StopVoiceOver();
                currentSelection="convie";
                conviclikked++;
//                if (conviclikked==1) {
//                    showsafety(false);
//                    showconvi(true);
//                    showutility(false);
//                    playVO(null, 15000, R.raw.convience);
//                }else if (conviclikked==2){
//                    Intent i = new Intent(MainActivity.this,AllCars.class);
//                    startActivity(i);
//                }
                showsafety(false);
                    showconvi(true);
                    showutility(false);
                    playVO(null, 15000, R.raw.convience);

                clikked=0;
                utilityclikked=0;

                /////////////////////////////////////

            }
        });
        utility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                currentSelection="utility";
                utilityclikked++;
                StopVoiceOver();
//                if (utilityclikked==1) {
//                    showsafety(false);
//                    showconvi(false);
//                    showutility(true);
//
//                    playVO(null, 11000, R.raw.utility);
//                }else if (utilityclikked==2){
//                    Intent i = new Intent(MainActivity.this,CheckHonda.class);
//                    startActivity(i);
//                }
                showsafety(false);
                    showconvi(false);
                    showutility(true);

                    playVO(null, 11000, R.raw.utility);
                clikked=0;
                conviclikked=0;
            }
        });
        impactlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
//               playVO(ImpactAlertgif.class, 15000, R.raw.impact_alert);

                GotoClass(ImpactAlertgif.class);
            }
        });
        impact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
//               playVO(ImpactAlertgif.class, 15000, R.raw.impact_alert);

                GotoClass(ImpactAlertgif.class);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(ShareMylocation.class);
            }
        });
        lay_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(ShareMylocation.class);
            }
        });
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(Locatemycar.class);

            }
        });
        lay_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(Locatemycar.class);

            }
        });
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(VehicalHealth.class);

            }
        });
        lay_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(VehicalHealth.class);

            }
        });
        trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(TripAnalysisMain.class);

            }
        });
        lay_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(TripAnalysisMain.class);

            }
        });
        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(ManualSos.class);

            }
        });
        lay_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(ManualSos.class);

            }
        });
        cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(ConsolidateCars.class);

            }
        });
        lay_cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(ConsolidateCars.class);

            }
        });
        calander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(CarCallander.class);

            }
        });
        lay_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(CarCallander.class);

            }
        });
        serbookin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(ServiceBokking.class);

            }
        });
        lay_serbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(ServiceBokking.class);

            }
        });
        serhist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(ServiceHistory.class);

            }
        });
        lay_serhis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(ServiceHistory.class);

            }
        });
        callnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(CallNow.class);

            }
        });
        lay_callnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(CallNow.class);

            }
        });
        whatsnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(WhatsNew.class);

            }
        });
        lay_whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(WhatsNew.class);

            }
        });
        refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(SelectCar.class);

            }
        });
        lay_reffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(SelectCar.class);

            }
        });


        checkhonda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                Intent intent = new Intent(MainActivity.this, CheckHonda.class);
                startActivity(intent);


            }
        });
        lay_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                Intent intent = new Intent(MainActivity.this, CheckHonda.class);
                startActivity(intent);


            }
        });


        pitstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(PitStop.class);


            }
        });
        lay_pit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(PitStop.class);


            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(Feedback.class);


            }
        });
        lay_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(Feedback.class);


            }
        });
//        refer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.startAnimation(animScale);
//                GotoClass(SelectCar.class);
//
//
//            }
//        });
//        lay_reffer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.startAnimation(animScale);
//                GotoClass(SelectCar.class);
//
//
//            }
//        });
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(DocumentWallet.class);


            }
        });
        lay_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(DocumentWallet.class);


            }
        });
        fuelbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(FuelLog.class);


            }
        });
        lay_fuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                GotoClass(FuelLog.class);


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
            Intent i = new Intent(MainActivity.this,SplashActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        if (id == R.id.action_reset) {
            Intent i = new Intent(MainActivity.this,AddACar.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void registerClick(View view) {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

    public void showsafety(Boolean res) {
        impact.setEnabled(res);
        share.setEnabled(res);
        locate.setEnabled(res);
        health.setEnabled(res);
        trip.setEnabled(res);
        sos.setEnabled(res);
        impactlayout.setEnabled(res);
        lay_share.setEnabled(res);
        lay_locate.setEnabled(res);
        lay_health.setEnabled(res);
        lay_trip.setEnabled(res);
        lay_sos.setEnabled(res);
        if (res) {
            redSafety();
            greyconvie();
            greyutility();
        } else greySafety();
    }

    public void showconvi(Boolean res) {

        lay_cars.setEnabled(res);
        lay_calendar.setEnabled(res);
        lay_serbook.setEnabled(res);
        lay_serhis.setEnabled(res);
        lay_callnow.setEnabled(res);
        lay_whats.setEnabled(res);
        cars.setEnabled(res);
        calander.setEnabled(res);
        serbookin.setEnabled(res);
        serhist.setEnabled(res);
        callnow.setEnabled(res);
        whatsnew.setEnabled(res);
        if (res) {
            redconvie();
            greyutility();
            greySafety();
        } else greyconvie();
    }

    public void showutility(Boolean res) {
        lay_pit.setEnabled(res);
        lay_check.setEnabled(res);
        lay_feed.setEnabled(res);
        lay_reffer.setEnabled(res);
        lay_wallet.setEnabled(res);
        lay_fuel.setEnabled(res);
        pitstop.setEnabled(res);
        checkhonda.setEnabled(res);
        feedback.setEnabled(res);
        refer.setEnabled(res);
        wallet.setEnabled(res);
        fuelbook.setEnabled(res);
        if (res) {
            redutility();
            greyconvie();
            greySafety();
        } else greyutility();
    }


    public void redSafety() {
        impact.setBackgroundResource(R.drawable.impact);
        share.setBackgroundResource(R.drawable.share);
        locate.setBackgroundResource(R.drawable.locate);
        health.setBackgroundResource(R.drawable.health);
        trip.setBackgroundResource(R.drawable.ana);
        sos.setBackgroundResource(R.drawable.sos);
    }

    public void greySafety() {
        impact.setBackgroundResource(R.drawable.grimpact);
        share.setBackgroundResource(R.drawable.grshare);
        locate.setBackgroundResource(R.drawable.grloca);
        health.setBackgroundResource(R.drawable.grhealth);
        trip.setBackgroundResource(R.drawable.grtrip);
        sos.setBackgroundResource(R.drawable.grsos);
    }

    public void redconvie() {
        cars.setBackgroundResource(R.drawable.redconsoli);
        calander.setBackgroundResource(R.drawable.cal);
        serbookin.setBackgroundResource(R.drawable.service);
        serhist.setBackgroundResource(R.drawable.history);
        callnow.setBackgroundResource(R.drawable.redcallnow);
        whatsnew.setBackgroundResource(R.drawable.redwahts);
    }

    public void greyconvie() {
        cars.setBackgroundResource(R.drawable.grconsoli);
        calander.setBackgroundResource(R.drawable.grcal);
        serbookin.setBackgroundResource(R.drawable.grservice);
        serhist.setBackgroundResource(R.drawable.grservicehistory);
        callnow.setBackgroundResource(R.drawable.grcallnow);
        whatsnew.setBackgroundResource(R.drawable.grwhats);
    }

    public void redutility() {
        pitstop.setBackgroundResource(R.drawable.pit);
        checkhonda.setBackgroundResource(R.drawable.redhondacars);
        feedback.setBackgroundResource(R.drawable.feedback);
        refer.setBackgroundResource(R.drawable.redcreat);
        wallet.setBackgroundResource(R.drawable.wallet);
        fuelbook.setBackgroundResource(R.drawable.fuel);
    }

    public void greyutility() {
        pitstop.setBackgroundResource(R.drawable.grservice);
        checkhonda.setBackgroundResource(R.drawable.grhondacars);
        feedback.setBackgroundResource(R.drawable.grfeedback);
        refer.setBackgroundResource(R.drawable.grcreate);
        wallet.setBackgroundResource(R.drawable.grwal);
        fuelbook.setBackgroundResource(R.drawable.gefuel);
    }

    public void GotoClass(Class clas){
        Intent i = new Intent(MainActivity.this, clas);
        startActivity(i);
    }

    public void playVO(Class classtogo,int duration,int sound){

        mHandler.removeCallbacks(loadHomeActivity);
        mHandler.postDelayed(loadHomeActivity, duration);
        voiceover = MediaPlayer.create(this,sound);
        voiceover.start();
        gotoclass=classtogo;
    }
    private Runnable loadHomeActivity = new Runnable() {
        public void run() {
            if (gotoclass==null){

            }else GotoClass(gotoclass);


        }

    };

    @Override
    protected void onPause() {
        super.onPause();
        StopVoiceOver();

    }

    @Override
    protected void onStop() {
        super.onStop();
        StopVoiceOver();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        StopVoiceOver();
    }

    public void StopVoiceOver(){
        try{
            if(voiceover !=null && voiceover.isPlaying()){
                Log.d("TAG------->", "player is running");
                voiceover.stop();
                Log.d("Tag------->", "player is stopped");
                voiceover.release();
                Log.d("TAG------->", "player is released");
            }
        }catch(Exception e){
        }
    }
}

