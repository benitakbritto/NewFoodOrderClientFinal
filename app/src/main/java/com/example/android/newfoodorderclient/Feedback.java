package com.example.android.newfoodorderclient;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class Feedback extends AppCompatActivity {


    private RatingBar ratingBar1;
    private RatingBar ratingBar2;
    private RatingBar ratingBar3;

    private String rating1;
    private String rating2;
    private String rating3;

    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        //addListenerOnRatingBar();
        //addListenerOnButton();
        ratingBar1 = findViewById(R.id.ratingBar1);
        ratingBar2 = findViewById(R.id.ratingBar2);
        ratingBar3 = findViewById(R.id.ratingBar3);



        //TextView submit = findViewById(R.id.btnSubmit);
        /*if (submit != null) {
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(Feedback.this, R.raw.thankyou);
                    mediaPlayer.start();
                    //Intent pageIntent = new Intent(Feedback.this, MainActivity.class);
                    //startActivity(pageIntent);


                }
            });
        }*/

        Button send = (Button) findViewById(R.id.send);
        if (send != null) {
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rating1=String.valueOf(ratingBar1.getRating());
                    rating2=String.valueOf(ratingBar2.getRating());
                    rating3=String.valueOf(ratingBar3.getRating());
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto","beni220698@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback!");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Share your experience with us.");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "SERVICE: "+rating1+"/5.0 \n AMBIENCE: "+rating2+"/5.0 \n FOOD: "+rating3+"/5.0 \n \n Please describe your experience with us. We strive to be better everyday!");
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                }
            });
        }


    }

    /*
    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar1);
        txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                txtRatingValue.setText(String.valueOf(rating));

            }
        });
    }

    public void addListenerOnButton() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //if click on me, then display the current rating value.
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(User.this,
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();

            }

        });*/

}