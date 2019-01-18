package com.example.android.newfoodorderclient;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements BlankFragmentTry.OnFragmentInteractionListener,  BlankFragmentTry2.OnFragmentInteractionListener,  BlankFragmentTry3.OnFragmentInteractionListener, BlankFragmentTry4.OnFragmentInteractionListener

{
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_starters:
                    //mTextMessage.setText(R.string.title_home);
                    Fragment fragment1 = new BlankFragmentTry();
                    loadFragment(fragment1);
                    return true;
                case R.id.navigation_maincourse:
                   // mTextMessage.setText(R.string.title_dashboard);
                    Fragment fragment2 = new BlankFragmentTry2();
                    loadFragment(fragment2);
                    return true;
                case R.id.navigation_dessert:
                   // mTextMessage.setText(R.string.title_notifications);
                    Fragment fragment3 = new BlankFragmentTry3();
                    loadFragment(fragment3);
                    return true;

                case R.id.navigation_bill:
                    Fragment fragment4 = new BlankFragmentTry4();
                    loadFragment(fragment4);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextMessage = (TextView) findViewById(R.id.message);
        //shows the bottom navigation
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new BlankFragmentTry());
    }

    private void loadFragment(Fragment fragment) {
        // load fragment on creation of Main2Activity view (that holds these fragments)
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
