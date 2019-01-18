package com.example.android.newfoodorderclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.shimmer.ShimmerFrameLayout;

public class ShimmerActivity extends AppCompatActivity {

     ShimmerFrameLayout mShimmerViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer);

        mShimmerViewContainer = (ShimmerFrameLayout)findViewById(R.id.shimmer_view_container);
        mShimmerViewContainer.startShimmerAnimation();

        //intent on thread delay
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    Intent intent = new Intent();
                    intent.setClass(ShimmerActivity.this, Main2Activity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }



   /* @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }*/
}