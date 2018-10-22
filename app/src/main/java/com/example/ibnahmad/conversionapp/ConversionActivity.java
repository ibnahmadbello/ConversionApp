package com.example.ibnahmad.conversionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;


public class ConversionActivity extends AppCompatActivity implements ConversionAdapter.RecyclerViewClickListener{

    private static final String TAG = ConversionActivity.class.getSimpleName();

    private ArrayList<Currency> currencyList = new ArrayList<>();

    TextView helloTextView;
    private RecyclerView currencyRecyclerView;
    private ConversionAdapter conversionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        setupArrayList();


        helloTextView = findViewById(R.id.hello_text_view);
        currencyRecyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        conversionAdapter = new ConversionAdapter(currencyList, this, this);
        currencyRecyclerView.setLayoutManager(layoutManager);
        currencyRecyclerView.setAdapter(conversionAdapter);

        setupHello();

    }

    private void setupHello(){
        String receivedText = NamePreference.getStoredName(this);
        helloTextView.setText(getResources().getString(R.string.welcome_greeting, receivedText));

    }

    private void setupArrayList(){
        currencyList.add(new Currency("Nigeria Naira\t(NGN)", getResources().getIdentifier("naira","drawable",getPackageName())));
        currencyList.add(new Currency("United State Dollar\t(USD)", getResources().getIdentifier("dollar", "drawable", getPackageName())));
        currencyList.add(new Currency("Japanese Yen\t(JPY)", getResources().getIdentifier("yen", "drawable", getPackageName())));
        currencyList.add(new Currency("New Zealand Dollar\t(NZD)", getResources().getIdentifier("dollar", "drawable", getPackageName())));
        currencyList.add(new Currency("European Euro\t(EUR)", getResources().getIdentifier("euro", "drawable", getPackageName())));
        currencyList.add(new Currency("Great Britain Pounds\t(GBP)", getResources().getIdentifier("pound", "drawable", getPackageName())));
        currencyList.add(new Currency("Russian Ruble\t(RUB)", getResources().getIdentifier("ruble", "drawable", getPackageName())));
        currencyList.add(new Currency("Indian Rupees\t(INR)", getResources().getIdentifier("rupee", "drawable", getPackageName())));
        currencyList.add(new Currency("Canadian Dollar\t(CAD)", getResources().getIdentifier("dollar", "drawable", getPackageName())));
        currencyList.add(new Currency("Australian Dollar\t(AUD)", getResources().getIdentifier("dollar", "drawable", getPackageName())));
    }

    @Override
    public void onItemClick(int clickItemPosition) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Position Clicked", clickItemPosition);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
