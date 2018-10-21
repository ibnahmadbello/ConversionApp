package com.example.ibnahmad.conversionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
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
            }
        });
    }

    private void getUrl(int currencyClicked){
        switch (currencyClicked){
            case 0:
                url = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=NGN&amount=1";
                currency = "Nigerian Naira";
                break;
            case 1:
                url = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=USD&amount=1";
                currency = "United State of American Dollar";
                break;
            case 2:
                url = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=JPY&amount=1";
                currency = "Japanese Yen";
                break;
            case 3:
                url = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=NZD&amount=1";
                currency = "New Zealand Dollar";
                break;
            case 4:
                url = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=EUR&amount=1";
                currency = "Euro";
                break;
            case 5:
                url = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=GBP&amount=1";
                currency = "Great Britain Pounds";
                break;
            case 6:
                url = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=RUB&amount=1";
                currency = "Russian Ruble";
                break;
            case 7:
                url = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=INR&amount=1";
                currency = "Indian Rupees";
                break;
            case 8:
                url = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=CAD&amount=1";
                currency = "Canadian Dollar";
                break;
            case 9:
                url = "https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=AUD&amount=1";
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
