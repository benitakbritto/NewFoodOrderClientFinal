package com.example.android.newfoodorderclient;

//when food item is clicked

/*
public class SingleFoodActivity extends AppCompatActivity {

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
    private DatabaseReference mRef;
    private String food_name, food_price, food_desc, food_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_food);


        food_key = getIntent().getExtras().getString("FoodId");
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Item");

        singleFoodDesc = (TextView) findViewById(R.id.singleDesc);
        singleFoodTitle = (TextView) findViewById(R.id.singleTitle);
        singleFoodPrice = (TextView) findViewById(R.id.singlePrice);
        singleFoodImage = (ImageView) findViewById(R.id.singleImageView);

        mAuth = FirebaseAuth.getInstance();

        //knows which user is ordering
        current_user = mAuth.getCurrentUser();
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
                Picasso.with(SingleFoodActivity.this).load(food_image).into(singleFoodImage);
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
                newOrder.child("username").setValue(dataSnapshot.child("Name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //redirects to menu
                        startActivity(new Intent(SingleFoodActivity.this, MenuActivity.class));
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
*/