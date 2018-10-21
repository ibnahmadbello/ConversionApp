package com.example.ibnahmad.conversionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText mNameEditText;
    String entered_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (NamePreference.getStoredName(this) == null){
            setContentView(R.layout.activity_main);
        } else {
            Intent intent = new Intent(this, ConversionActivity.class);
            startActivity(intent);
        }


        mNameEditText = findViewById(R.id.enter_name_edit_text);

        setupApp();
    }

    private void setupApp(){
        entered_name = mNameEditText.getText().toString().trim();
        NamePreference.setStoredName(this, entered_name);
    }
}
