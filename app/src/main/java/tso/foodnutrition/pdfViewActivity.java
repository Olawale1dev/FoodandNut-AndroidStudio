package tso.foodnutrition;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
//import java.util.Arrays;
//import com.google.android.gms.ads.RequestConfiguration;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;


public class pdfViewActivity extends AppCompatActivity {

    PDFView pdfView;

    TextView moduleName;

    AdView mAdView;

    private InterstitialAd mInterstitialAd;
    private AdRequest adRequest;
    private static final String TAG = "pdfViewActivity";

    private RewardedInterstitialAd rewardedInterstitialAd;
    private OnUserEarnedRewardListener OnUserEarnedRewardListener;
    private RewardedAd rewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        getSupportActionBar().hide();




        pdfView = findViewById(R.id.pdfView);
        moduleName = findViewById(R.id.moduleNames);

        mAdView = findViewById(R.id.adView);
        if (mAdView != null) {
            adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(this, "ca-app-pub-9163926251753325/2965563702",
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        Log.d(TAG, loadAdError.toString());
                        rewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd ad) {
                        rewardedAd = ad;
                        Log.d(TAG, "Ad was loaded.");
                    }
                });

        //new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("356D0A1542A015D4A7F240498FA05A10"));

        int position = getIntent().getIntExtra("position", 0);
        loadInterstitial();
        if (rewardedAd != null) {
            Activity activityContext = pdfViewActivity.this;
            rewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    Log.d(TAG, "The user earned the reward.");
                    int rewardAmount = rewardItem.getAmount();
                    String rewardType = rewardItem.getType();
                }
            });
        } else {
            Log.d(TAG, "The rewarded ad wasn't ready yet.");
        }
        loadInterstitial();
        String module = getIntent().getStringExtra("name");
        if (position == 0) {
            pdfView.fromAsset("About.pdf").load();
            moduleName.setText(module);
        } else if (position == 1) {
            pdfView.fromAsset("Unit-1.pdf").load();
            moduleName.setText(module);
        } else if (position == 2) {
            pdfView.fromAsset("Unit-2.pdf").load();
            moduleName.setText(module);
        } else if (position == 3) {
            pdfView.fromAsset("Unit-3.pdf").load();
            moduleName.setText(module);
        } else if (position == 4) {
            pdfView.fromAsset("Unit-4.pdf").load();
            moduleName.setText(module);
        } else if (position == 5) {
            pdfView.fromAsset("Unit-5.pdf").load();
            moduleName.setText(module);
        } else if (position == 6) {
            pdfView.fromAsset("Unit-6.pdf").load();
            moduleName.setText(module);
        } else if (position == 7) {
            pdfView.fromAsset("Unit-7.pdf").load();
            moduleName.setText(module);
        } else if (position == 8) {
            pdfView.fromAsset("Unit-8.pdf").load();
            moduleName.setText(module);
        } else if (position == 9) {
            pdfView.fromAsset("Unit-9.pdf").load();
            moduleName.setText(module);
        } else if (position == 10) {
            pdfView.fromAsset("Unit-10.pdf").load();
            moduleName.setText(module);
        } else if (position == 11) {
            pdfView.fromAsset("Unit-11.pdf").load();
            moduleName.setText(module);
        } else if (position == 12) {
            pdfView.fromAsset("Unit-12.pdf").load();
            moduleName.setText(module);
        } else if (position == 13) {
            pdfView.fromAsset("Unit-13.pdf").load();
            moduleName.setText(module);
        } else if (position == 14) {
            pdfView.fromAsset("Unit-14.pdf").load();
            moduleName.setText(module);
        } else if (position == 15) {
            pdfView.fromAsset("Unit-15.pdf").load();
            moduleName.setText(module);
        } else if (position == 16) {
            pdfView.fromAsset("Unit-16.pdf").load();
            moduleName.setText(module);
        } else if (position == 17) {
            pdfView.fromAsset("Unit-17.pdf").load();
            moduleName.setText(module);
        } else if (position == 18) {
            pdfView.fromAsset("Unit-18.pdf").load();
            moduleName.setText(module);
        } else if (position == 19) {
            pdfView.fromAsset("Unit-19.pdf").load();
            moduleName.setText(module);
        }else if (position == 20) {
            pdfView.fromAsset("About.pdf").load();

        }else if (position == 21) {
            pdfView.fromAsset("About.pdf").load();

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(pdfViewActivity.this);
                }


            }
        }, 2000);



    }

    private void loadInterstitial() {

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, "ca-app-pub-9163926251753325/7449671025", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });



    }
}
