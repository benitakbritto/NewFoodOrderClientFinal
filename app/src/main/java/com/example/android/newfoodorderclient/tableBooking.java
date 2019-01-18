package com.example.android.newfoodorderclient;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class tableBooking extends AppCompatActivity {

    Button chosenButton;
    Button tableButton;
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference table = database.getReference("table");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_booking);



        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t1").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button20);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t2").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button19);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t3").child("booked").getValue().toString();
                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button18);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t4").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button17);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t5").child("booked").getValue().toString();
                Log.d("tag", table1);
                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button16);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t6").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button15);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t7").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button14);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t8").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button13);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t9").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button12);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t10").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button11);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t11").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button2);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t12").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button3);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t13").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button4);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t14").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button5);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t15").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button6);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t16").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button7);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t17").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button8);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t18").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button9);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String table1 = dataSnapshot.child("t19").child("booked").getValue().toString();

                if(table1.equals("true")) {
                    tableButton = (Button) findViewById(R.id.button10);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });




    }
    public void table1(View view){
        chosenButton = (Button) findViewById(R.id.button20);
        if(chosenButton.isEnabled())
        {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t1").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    public void table2(View view) {
        chosenButton = (Button) findViewById(R.id.button19);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t2").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table3(View view) {
        chosenButton = (Button) findViewById(R.id.button18);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t3").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table4(View view) {
        chosenButton = (Button) findViewById(R.id.button17);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t4").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table5(View view) {
        chosenButton = (Button) findViewById(R.id.button16);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t5").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table6(View view) {
        chosenButton = (Button) findViewById(R.id.button15);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t6").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table7(View view) {
        chosenButton = (Button) findViewById(R.id.button14);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t7").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table8(View view) {
        chosenButton = (Button) findViewById(R.id.button13);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t8").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table9(View view) {
        chosenButton = (Button) findViewById(R.id.button12);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t9").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table10(View view) {
        chosenButton = (Button) findViewById(R.id.button11);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t10").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table11(View view) {
        chosenButton = (Button) findViewById(R.id.button2);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t11").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    public void table12(View view) {
        chosenButton = (Button) findViewById(R.id.button3);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t12").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table13(View view) {
        chosenButton = (Button) findViewById(R.id.button4);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t13").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table14(View view) {
        chosenButton = (Button) findViewById(R.id.button5);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t14").updateChildren(result);

                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table15(View view) {
        chosenButton = (Button) findViewById(R.id.button6);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t15").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table16(View view) {
        chosenButton = (Button) findViewById(R.id.button7);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t16").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    public void table17(View view) {
        chosenButton = (Button) findViewById(R.id.button8);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t17").updateChildren(result);

                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table18(View view) {
        chosenButton = (Button) findViewById(R.id.button9);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t18").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    public void table19(View view) {
        chosenButton = (Button) findViewById(R.id.button10);
        if (chosenButton.isEnabled()) {
            chosenButton.setBackgroundColor(Color.GREEN);
            table.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    HashMap<String, Object> result = new HashMap<>();
                    result.put("booked", "true");
                    table.child("t19").updateChildren(result);
                    Intent intent = new Intent(tableBooking.this, ShimmerActivity.class);

                    startActivity(intent);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }


}
