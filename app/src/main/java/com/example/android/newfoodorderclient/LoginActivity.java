package com.example.android.newfoodorderclient;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginActivity extends AppCompatActivity {

    private EditText userEmail, userPass;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    public static String key;
    private FirebaseUser current_user;
    RelativeLayout myLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = (EditText)findViewById(R.id.userEmail);
        userPass = (MaterialEditText)findViewById(R.id.userPass);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("user");

        myLayout = (RelativeLayout) findViewById(R.id.LoginLayout);

        //gradient background
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
    }

    public void signinButtonClicked(View view)
    {
        //progress bar
        final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
        mDialog.setMessage("Please Wait..");
        mDialog.show();
        final String email = userEmail.getText().toString().trim();
        String pass  = userPass.getText().toString().trim();

        //validates user and makes sure that the required fields are not empty
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass))
        {
            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        checkUserExists();
                    }
                }
            });
        }
        else
        {
            mDialog.dismiss();
            Toast.makeText(LoginActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkUserExists()
    {
        final String user_id = mAuth.getCurrentUser().getUid();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               if(dataSnapshot.hasChild(user_id))
               {

                   Toast.makeText(LoginActivity.this, "Choose a table",
                           Toast.LENGTH_LONG).show();

                   Intent menuIntent = new Intent(LoginActivity.this, tableBooking.class);
                   startActivity(menuIntent);

               }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

