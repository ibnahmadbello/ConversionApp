package com.example.ibnahmad.conversionapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ConversionAdapter extends RecyclerView.Adapter<ConversionAdapter.ConversionViewHolder>{

    private static final String TAG = ConversionAdapter.class.getSimpleName();

    private RecyclerViewClickListener clickListener;

    ArrayList<Currency> currencyList;
    private Context context;

    public ConversionAdapter(ArrayList<Currency> currencyList, Context context, RecyclerViewClickListener clickListener){
        this.currencyList = currencyList;
        this.context = context;
        this.clickListener = clickListener;
    }

    public interface RecyclerViewClickListener{
        void onItemClick(int clickItemPosition);
    }
    @NonNull
    @Override
    public ConversionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.each_row_item, parent, false);
        Log.i(TAG, "View is created");
        return new ConversionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversionAdapter.ConversionViewHolder holder, int position) {
        Currency currency = currencyList.get(position);
        holder.bindCurrency(currency);

    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "The array list size is: " + currencyList.size());
        return currencyList == null ? 0 : currencyList.size();
    }

    class ConversionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView currencyImage;
        private TextView currencyName;
        private Currency currency;

        public ConversionViewHolder(View itemView){
            super(itemView);
            currencyImage = itemView.findViewById(R.id.currency_image);
            currencyName = itemView.findViewById(R.id.full_currency_name);
            itemView.setOnClickListener(this);
        }

        public void bindCurrency(Currency currencyItem){
            currency = currencyItem;
            currencyName.setText(currency.getCurrency_name());
            currencyImage.setImageResource(currency.getCurrency_image());

//            holder.currencyName.setText(currencyList.get(position).getCurrency_name());
//            holder.currencyImage.setImageResource(currencyList.get(position).getCurrency_image());
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            clickListener.onItemClick(clickedPosition);
            Currency singleCurrency = currencyList.get(clickedPosition);
            Log.i(TAG, singleCurrency.getCurrency_name() + "was clicked.");
        }
    }
}
