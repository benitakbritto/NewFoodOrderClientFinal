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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

    private EditText email, pass;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    RelativeLayout myLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.editEmail);
        pass = (MaterialEditText) findViewById(R.id.editPass);
        //register user
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("user");
        myLayout = (RelativeLayout) findViewById(R.id.myLayout);


        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
    }

    //user value will be added to the authentication part of firebase
    public void signupButtonClicked(View view)
    {
        final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
        mDialog.setMessage("Please Wait..");
        mDialog.show();
        final String email_text = email.getText().toString().trim();
        String pass_text = pass.getText().toString().trim();

       //check if fields are empty
        if(!TextUtils.isEmpty(email_text) && !TextUtils.isEmpty(pass_text))
        {
            mAuth.createUserWithEmailAndPassword(email_text,pass_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful()) {
                        String user_id = mAuth.getCurrentUser().getUid();
                        DatabaseReference current_user = mDatabase.child(user_id);
                        current_user.child("Name").setValue(email_text);
                        Toast.makeText(MainActivity.this, "Choose a table",
                                Toast.LENGTH_LONG).show();


                        Intent login = new Intent(MainActivity.this, tableBooking.class);
                        startActivity(login);

                    }
                }
            });

        }
        else
        {
            mDialog.dismiss();
            Toast.makeText(MainActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
        }


    }

    public void signinButtonClicked(View view)
    {
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);

    }


}

