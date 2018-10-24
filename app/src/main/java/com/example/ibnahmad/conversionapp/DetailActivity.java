package com.example.ibnahmad.conversionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    TextView textView;
    ProgressBar progressBar;
    String url, currency, price;
    Intent intent;
    private static final String BASE_URL = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = findViewById(R.id.display_result);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setIndeterminate(true);
        intent = getIntent();

        makeNetworkCall();
    }



    public void makeNetworkCall(){
        AsyncHttpClient client = new AsyncHttpClient();
        if (intent.hasExtra("Position Clicked")){
            getUrl(intent.getIntExtra("Position Clicked", 0));
        } else {
            return;
        }

        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {
                try {
                    price = responseBody.getString("price");
                    displayResult();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Log.i(TAG, "Failed to get response. " + statusCode);
            }
        });
    }

    private void getUrl(int currencyClicked){
        switch (currencyClicked){
            case 0:
                url = BASE_URL + "&to=NGN&amount=1";
                currency = "Nigerian Naira";
                break;
            case 1:
                url = BASE_URL + "&to=USD&amount=1";
                currency = "United State of American Dollar";
                break;
            case 2:
                url = BASE_URL + "&to=JPY&amount=1";
                currency = "Japanese Yen";
                break;
            case 3:
                url = BASE_URL + "&to=NZD&amount=1";
                currency = "New Zealand Dollar";
                break;
            case 4:
                url = BASE_URL + "&to=EUR&amount=1";
                currency = "Euro";
                break;
            case 5:
                url = BASE_URL + "&to=GBP&amount=1";
                currency = "Great Britain Pounds";
                break;
            case 6:
                url = BASE_URL + "&to=RUB&amount=1";
                currency = "Russian Ruble";
                break;
            case 7:
                url = BASE_URL + "&to=INR&amount=1";
                currency = "Indian Rupees";
                break;
            case 8:
                url = BASE_URL + "&to=CAD&amount=1";
                currency = "Canadian Dollar";
                break;
            case 9:
                url = BASE_URL + "&to=AUD&amount=1";
                currency = "Australian Dollar";
                break;
        }
    }

    private void displayResult(){
        progressBar.setVisibility(View.GONE);
        textView.setText(getResources().getString(R.string.conversion_result, Double.parseDouble(price), currency));
        textView.setVisibility(View.VISIBLE);
    }

}
