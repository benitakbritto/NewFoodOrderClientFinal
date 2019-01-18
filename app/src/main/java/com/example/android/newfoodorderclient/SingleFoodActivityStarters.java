package com.example.android.newfoodorderclient;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class SingleFoodActivityStarters extends AppCompatActivity {

    //used to uniquely identify each item when it is clicked
    private String food_key = null;

    private DatabaseReference mDatabase;
    private TextView singleFoodTitle, singleFoodDesc, singleFoodPrice;
    private ImageView singleFoodImage;
    private Button orderButton;
    private FirebaseAuth mAuth;
    private FirebaseUser current_user;
    private DatabaseReference tempData;
    private DatabaseReference userData;
    private DatabaseReference database;
    private DatabaseReference mRef;
    private String food_name, food_price, food_desc, food_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_food_starters);


        food_key = getIntent().getExtras().getString("FoodId");
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Starters");


        singleFoodDesc = (TextView) findViewById(R.id.singleDesc);
        singleFoodTitle = (TextView) findViewById(R.id.singleTitle);
        singleFoodPrice = (TextView) findViewById(R.id.singlePrice);
        singleFoodImage = (ImageView) findViewById(R.id.singleImageView);

        mAuth = FirebaseAuth.getInstance();

        //knows which user is ordering
        current_user = mAuth.getCurrentUser();
       // database=  FirebaseDatabase.getInstance().getReference().child(current_user).child("name");
        //permanent
        tempData = FirebaseDatabase.getInstance().getReference().child("user").child(current_user.getUid()).child("Orders");
        //temporary for bill calculation
        userData= FirebaseDatabase.getInstance().getReference().child("Order");


        //mRef  = FirebaseDatabase.getInstance().getReference().child("user");

        //got access to one of the roots, thus extract the values from the db
        mDatabase.child(food_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                food_name = (String) dataSnapshot.child("name").getValue();
                food_price = (String) dataSnapshot.child("price").getValue();
                food_desc = (String) dataSnapshot.child("desc").getValue();
                food_image = (String) dataSnapshot.child("image").getValue();

                singleFoodTitle.setText(food_name);
                singleFoodDesc.setText(food_desc);
                singleFoodPrice.setText(food_price);
                Picasso.with(SingleFoodActivityStarters.this).load(food_image).into(singleFoodImage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void orderItemClicked(View view)
    {

        final DatabaseReference newOrder = userData.push();
        //final DatabaseReference newOrdertemp = tempData.push();
        //mRef.push();
        userData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                newOrder.child("itemname").setValue(food_name);
                newOrder.child("itemprice").setValue(food_price);

                newOrder.child("user").setValue(current_user.getEmail());
               // newOrder.child("user1").setValue(current_user.getDisplayName().toString());

                newOrder.child("username").setValue(dataSnapshot.child("Name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //redirects to menu
                        startActivity(new Intent(SingleFoodActivityStarters.this, ShimmerActivity.class));

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        final DatabaseReference newOrderTemp = tempData.push();
        //mRef.push();
        tempData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                newOrderTemp.child("itemname").setValue(food_name);
                newOrderTemp.child("itemprice").setValue(food_price);
                newOrderTemp.child("username").setValue(dataSnapshot.child("Name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //redirects to menu
                        //startActivity(new Intent(SingleFoodActivity.this, MenuActivity.class));
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}

