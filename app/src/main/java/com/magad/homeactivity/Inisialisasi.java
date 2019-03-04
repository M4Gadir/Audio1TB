package com.magad.homeactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Inisialisasi extends RecyclerView.ViewHolder {
    ImageView iv;
    TextView tv;

    public Inisialisasi(@NonNull View itemView, Context context) {
        super(itemView);
        iv = itemView.findViewById(R.id.ivrv);
        tv = itemView.findViewById(R.id.tvisi);


    }
}

