package com.roomwordsample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity {

    private EditText mEditWordV1;
    private EditText mEditWordV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditWordV1 = findViewById(R.id.mail);
        mEditWordV2 = findViewById(R.id.pass);

        Intent myintent = getIntent();
        String value = myintent.getStringExtra("key"); //if it's a string you stored.

        /*TextView textView = findViewById(R.id.logintest);
        textView.setText(value);*/



        final Button button = findViewById(R.id.button_register);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {



                if (TextUtils.isEmpty(mEditWordV1.getText()) || TextUtils.isEmpty(mEditWordV2.getText()) ) {
                    Toast.makeText(
                            getApplicationContext(),
                            R.string.empty_not_saved,
                            Toast.LENGTH_LONG).show();
                } else {
                    String word1= mEditWordV1.getText().toString() ;
                    String word2 = mEditWordV2.getText().toString() ;
                    //Word word = new Word(word1,word2);
                   // mWordViewModel.insert(word);
                }

                Intent myIntent = new Intent(LoginActivity.this, MyTasks.class);
                myIntent.putExtra("key1", "Hello Tasks!"); //Optional parameters
                LoginActivity.this.startActivity(myIntent);

            }
        });
    }

   /* @Override
    public void onSuccess(String message) {
        Toasty.success(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this,message, Toast.LENGTH_SHORT).show();
    }*/

}


