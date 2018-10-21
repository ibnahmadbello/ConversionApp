package com.example.ibnahmad.conversionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.ibnahmad.conversionapp.R.string.welcome_greeting;

public class ConversionActivity extends AppCompatActivity {

    private static final String TAG = ConversionActivity.class.getSimpleName();

    TextView helloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        helloTextView = findViewById(R.id.hello_text_view);
        setupHello();
    }

    private void setupHello(){
        String receivedText = null;
        Intent receivedIntent = getIntent();
        if (receivedIntent.hasExtra(Intent.EXTRA_TEXT)){
            receivedText = receivedIntent.getStringExtra(Intent.EXTRA_TEXT);
        }
        helloTextView.setText(getResources().getString(R.string.welcome_greeting, receivedText));
    }
}
