package com.example.ibnahmad.conversionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    EditText mNameEditText;
    Button mEnterButton;

    String entered_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (NamePreference.getStoredName(this) == null){
            setContentView(R.layout.activity_main);
            mNameEditText = findViewById(R.id.enter_name_edit_text);
            mEnterButton = findViewById(R.id.enter_button);

            mEnterButton.setOnClickListener(this);
//            setupApp();
        } else {
            startConversionActivity();
        }

    }

    private void setupApp(){
        entered_name = mNameEditText.getText().toString().trim();
        NamePreference.setStoredName(this, entered_name);
        finish();
        Log.i(TAG, "Entered name is added to preference." + NamePreference.getStoredName(this));
    }

    private void startConversionActivity(){
        Intent intent = new Intent(this, ConversionActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, entered_name);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.enter_button){
            setupApp();
            startConversionActivity();
        }
    }
}
