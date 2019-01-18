package com.example.android.newfoodorderclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OpenBill extends AppCompatActivity {

    private RecyclerView mFoodList;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser current_user;
    //Button seeBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_bill);

        mAuth = FirebaseAuth.getInstance();
        mFoodList = (RecyclerView) findViewById(R.id.billLayout);
        mFoodList.setHasFixedSize(true);
        mFoodList.setLayoutManager(new LinearLayoutManager(this));
        current_user = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("user").child(current_user.getUid()).child("Orders");
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Order");

        //bottom sheet
        Button viewBill = (Button) findViewById(R.id.viewTheBill);
        viewBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(OpenBill.this);
                View parentView = getLayoutInflater().inflate(R.layout.dialog, null);
                bottomSheetDialog.setContentView(parentView);
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) parentView.getParent());
                bottomSheetBehavior.setPeekHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics()));
                bottomSheetDialog.show();

                //retrieve data

                final TextView mTotal = (TextView) parentView.findViewById(R.id.displayAmount);
                final TextView mService = (TextView) parentView.findViewById(R.id.displayService);
                final TextView mGst = (TextView) parentView.findViewById(R.id.displayGst);
                final TextView mGrand = (TextView) parentView.findViewById(R.id.displayGrand);



                //int sum =0;
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int sum = 0;
                        double value_service;
                        double value_gst;
                        double value_grand;

                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            String price = (String) ds.child("itemprice").getValue();
                            String b = price.replaceAll("₹", "");

                            int pValue = Integer.parseInt(String.valueOf(b));
                            sum += pValue;

                        }
                        mTotal.setText(String.valueOf(sum));

                        //double roundOff = (double) Math.round(a * 100) / 100;

                        value_gst = (double) Math.round(sum * 0.18 * 100)/100;
                         value_service = (double) Math.round(sum *0.1*100)/100;
                         value_grand = (double) Math.round((sum + value_gst + value_service)*100)/100;;
                        mService.setText((String.valueOf(value_service)));
                        mGst.setText((String.valueOf(value_gst)));
                        mGrand.setText((String.valueOf( value_grand)));

                    }





                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                Button proceedPayment = (Button) parentView.findViewById(R.id.proceedToPayment);
                proceedPayment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OpenBill.this, Payment.class);
                        startActivity(intent);

                    }
                });


            }

        });
    }


                                        @Override
                                        protected void onStart() {
                                            super.onStart();
                                            FirebaseRecyclerAdapter<Bill, BillViewHolder> FRBA = new FirebaseRecyclerAdapter<Bill, BillViewHolder>(
                                                    Bill.class,
                                                    R.layout.singlebilllayout,
                                                    BillViewHolder.class,
                                                    mDatabase
                                            ) {
                                                @Override
                                                protected void populateViewHolder(BillViewHolder viewHolder, Bill model, int position) {
                                                    viewHolder.setItemName(model.getItemname());
                                                    viewHolder.setItemPrice(model.getItemprice());

                                                }
                                            };
                                            mFoodList.setAdapter(FRBA);
                                        }

                                        public static class BillViewHolder extends RecyclerView.ViewHolder {
                                            View billView;

                                            // public RelativeLayout viewBackground, viewForeground;
                                            public BillViewHolder(View itemView) {
                                                super(itemView);
                                                billView = itemView;
                                                // viewBackground = itemView.findViewById(R.id.view_background);
                                                //viewForeground = itemView.findViewById(R.id.view_foreground);
                                            }

                                            public void setItemName(String itemname) {
                                                TextView itemname_content = (TextView) billView.findViewById(R.id.billItemName);
                                                itemname_content.setText(itemname);

                                            }

                                            public void setItemPrice(String itemprice) {
                                                TextView itemprice_content = (TextView) billView.findViewById(R.id.billItemPrice);
                                                itemprice_content.setText(itemprice);

                                            }
                                        }

                                    }

   /* public void goToBillAmount(View view)
    {
        Intent billIntent = new Intent(OpenBill.this, BillAmount.class);
        startActivity(billIntent);
    }*/

                //public void goToBillAmount(View view)
   /*{

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(OpenBill.this);
        View parentView = getLayoutInflater().inflate(R.layout.dialog,null);
        bottomSheetDialog.setContentView(parentView);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) parentView.getParent());
        bottomSheetBehavior.setPeekHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,getResources().getDisplayMetrics()));
        bottomSheetDialog.show();
        Button b = (Button) parentView.findViewById(R.id.proceedToPayment);
        b.setOnClickListener(new View.onClickListener()) {



    }*/


                //}





