package com.roomwordsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.roomwordsample.R;

public class NewTaskActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY_TITLE = "com.example.android.tasklistsql.TITLE";
    public static final String EXTRA_REPLY_DESC = "com.example.android.tasklistsql.REPLY";
    public static final String EXTRA_REPLY_USERID = "com.example.android.tasklistsql.USERID";

    private EditText mEditTaskView1;
    private EditText mEditTaskView2;
    private EditText mEditTaskView3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        mEditTaskView1 = findViewById(R.id.edt1);
        mEditTaskView2 = findViewById(R.id.edt2);
        mEditTaskView3 = findViewById(R.id.edt3);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTaskView1.getText()) || TextUtils.isEmpty(mEditTaskView2.getText()) || TextUtils.isEmpty(mEditTaskView3.getText()) ) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String task = mEditTaskView1.getText().toString() ;
                    String task1 = mEditTaskView2.getText().toString() ;
                    String task2 = mEditTaskView3.getText().toString() ;
                    replyIntent.putExtra(EXTRA_REPLY_TITLE, task);
                    replyIntent.putExtra(EXTRA_REPLY_DESC, task1);
                    replyIntent.putExtra(EXTRA_REPLY_USERID, task2);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}