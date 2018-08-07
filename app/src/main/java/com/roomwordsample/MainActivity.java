package com.roomwordsample;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mEditWordV1;
    private EditText mEditWordV2;
    private EditText mEditWordV3;
    private WordViewModel mWordViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditWordV1 = findViewById(R.id.edit1);
        mEditWordV2 = findViewById(R.id.edit2);
        mEditWordV3 = findViewById(R.id.edit3);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(words);
            }
        });

        final Button button = findViewById(R.id.button_register);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {



                if (TextUtils.isEmpty(mEditWordV1.getText()) || TextUtils.isEmpty(mEditWordV2.getText()) || TextUtils.isEmpty(mEditWordV3.getText()) ) {
                    Toast.makeText(
                            getApplicationContext(),
                            R.string.empty_not_saved,
                            Toast.LENGTH_LONG).show();
                } else {
                    String word1= mEditWordV1.getText().toString() ;
                    String word2 = mEditWordV2.getText().toString() ;
                    String word3 = mEditWordV3.getText().toString() ;
                    Word word = new Word(word1,word2, word3);
                    mWordViewModel.insert(word);
                }

                Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                myIntent.putExtra("key", "Hello Login!"); //Optional parameters
                MainActivity.this.startActivity(myIntent);

            }
        });
    }





}
