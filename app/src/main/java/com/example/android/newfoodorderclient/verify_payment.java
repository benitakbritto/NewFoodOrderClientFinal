package com.example.android.newfoodorderclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class verify_payment extends AppCompatActivity {

    private Spinner spinner1, spinner2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_payment);
       // addListenerOnButton();

        Button nextf = (Button) findViewById(R.id.button_next);
        nextf.setEnabled(false);
        //addListenerOnSpinnerItemSelection();


        Button login = (Button) findViewById(R.id.button_login);
        if (login != null) {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getBaseContext(), "Validating information...Do not exit this page", Toast.LENGTH_SHORT).show();
                    validate();
                }
            });

        }


    }

/*
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

    }
    */

    public void validate() {

        /*EditText card_no = (EditText) findViewById(R.id.editText_card_number);
        EditText cvv = (EditText) findViewById(R.id.editText_cvv);

        try {
            Button nextf = (Button) findViewById(R.id.button_next);
            nextf.setEnabled(true);
            int number = Integer.parseInt(card_no.getText().toString());
            try {
                Button nextff = (Button) findViewById(R.id.button_next);
                nextff.setEnabled(true);
                int cvv_check = Integer.parseInt(cvv.getText().toString());
                Intent intent = new Intent(this, Redirect.class);
                startActivity(intent);
            } catch (Exception e) {
                Button nextfff = (Button) findViewById(R.id.button_next);
                nextfff.setEnabled(false);
                Toast.makeText(getBaseContext(), "Incorrect details.", Toast.LENGTH_SHORT).show();

            }

        } catch (Exception e) {
            Button nextf = (Button) findViewById(R.id.button_next);
            nextf.setEnabled(false);
            Toast.makeText(getBaseContext(), "Incorrect details.", Toast.LENGTH_SHORT).show();

        }*/

        EditText card_no = (EditText) findViewById(R.id.editText_card_number);
        EditText cvv = (EditText) findViewById(R.id.editText_cvv);
        if(validateCreditCardNumber(card_no.getText().toString().trim())&& validateCvv(cvv.getText().toString().trim())){
            Intent intent = new Intent(this, Redirect.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getBaseContext(), "Incorrect details.", Toast.LENGTH_SHORT).show();

    }

    private  boolean validateCreditCardNumber(String str) {
        //long intd;
        try {
           long intd = Long.parseLong(str);
        }
        catch (Exception e)
        {
            Toast.makeText(getBaseContext(), "Incorrect details.", Toast.LENGTH_SHORT).show();
            return false;
        }

        int[] ints = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ints[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        if (sum % 10 == 0) {
            //System.out.println(str + " is a valid credit card number");
            return true;
        } else {
            //System.out.println(str + " is an invalid credit card number");
            return false;
        }
    }
    private  boolean validateCvv(String str){
            int ints;
            try {
                ints = Integer.parseInt(str);
            }
            catch (Exception e)
            {
                Toast.makeText(getBaseContext(), "Incorrect details.", Toast.LENGTH_SHORT).show();
                return false;
            }

        if(str.length()==3)
            return true;
        return false;


    }
}

