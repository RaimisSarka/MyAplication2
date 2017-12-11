package com.example.raisar.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raisar.myapplication.utils.EilutesObj;

import java.util.List;

/**
 * Created by raisar on 12/8/2017.
 */

public class EilutesAdapteris extends RecyclerView.Adapter<EilutesAdapteris.ViewHolder> {
    private List<EilutesObj> eilList;

    public EilutesAdapteris (List<EilutesObj> sarasas) {
        eilList = sarasas;
    }

    @Override
    public EilutesAdapteris.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eil_layout, parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(EilutesAdapteris.ViewHolder holder, int position) {
        EilutesObj eilute = eilList.get(position);
        holder.mZod1.setText(eilute.getZod1());
        holder.mZod2.setText(eilute.getZod2());
        holder.mZod3.setText(eilute.getZod3());
    }

    @Override
    public int getItemCount() {
        return eilList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mZod1, mZod2, mZod3;

        public ViewHolder(View view) {
            super(view);
            mZod1 = (TextView) view.findViewById(R.id.textViewEil1);
            mZod2 = (TextView) view.findViewById(R.id.textViewEil2);
            mZod3 = (TextView) view.findViewById(R.id.textViewEil3);
        }
    }
}

