package com.roomwordsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.roomwordsample.R;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY_TITLE = "com.example.android.wordlistsql.TITLE";
    public static final String EXTRA_REPLY_DESC = "com.example.android.wordlistsql.REPLY";
    public static final String EXTRA_REPLY_USERID = "com.example.android.wordlistsql.USERID";

    private EditText mEditWordView1;
    private EditText mEditWordView2;
    private EditText mEditWordView3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView1 = findViewById(R.id.edit_word1);
        mEditWordView2 = findViewById(R.id.edit_word2);
        mEditWordView3 = findViewById(R.id.edit_word3);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView1.getText()) || TextUtils.isEmpty(mEditWordView2.getText()) || TextUtils.isEmpty(mEditWordView3.getText()) ) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView1.getText().toString() ;
                    String word1 = mEditWordView2.getText().toString() ;
                    String word2 = mEditWordView3.getText().toString() ;
                    replyIntent.putExtra(EXTRA_REPLY_TITLE, word);
                    replyIntent.putExtra(EXTRA_REPLY_DESC, word1);
                    replyIntent.putExtra(EXTRA_REPLY_USERID, word2);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}