package com.fadv.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.fadv.myapplication.R;
import com.fadv.myapplication.dto.CountryDTO;

import java.util.List;

/**
 * Created by Amit Rawat  on 18-02-2021.
 */
public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private List<CountryDTO> listdata;
    private Context context;


    // RecyclerView recyclerView;
    public MyListAdapter(List<CountryDTO> listdata, Context mcontext) {
        this.listdata = listdata;
        this.context = mcontext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_country, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CountryDTO myListData = listdata.get(position);
        if (myListData != null) {
            holder.countryname.setText(myListData.getName());
            if (myListData.getCurrencies().get(0).getCode() != null) {
                holder.currency.setText(myListData.getCurrencies().get(0).getCode());
            }
            if (myListData.getCallingCodes().get(0) != null) {
                holder.code.setText(myListData.getCallingCodes().get(0));
            }


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Currency :" + "" + myListData.getCurrencies().get(0).getCode() + "\n" +
                            "Code :" + "" + myListData.getCallingCodes().get(0), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView countryname;
        public TextView code;
        public TextView currency;

        public ViewHolder(View itemView) {
            super(itemView);
            this.countryname = (TextView) itemView.findViewById(R.id.country_name);
            this.code = (TextView) itemView.findViewById(R.id.country_code);
            this.currency = (TextView) itemView.findViewById(R.id.currency_code);

        }
    }
}