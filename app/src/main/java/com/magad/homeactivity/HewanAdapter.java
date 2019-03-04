package com.magad.homeactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

class HewanAdapter extends RecyclerView.Adapter<Inisialisasi> {
    Context context;
    String[] namaHewan = {"Kucing","Gajah","Anjing","Kuda","Kambing"};
   int[] gambarHewan = {R.drawable.ic_home_black_24dp,R.drawable.ic_dashboard_black_24dp,R.drawable.ic_launcher_background};
    public HewanAdapter(Context context) {
    this.context = context;
    }

    @NonNull
    @Override
    public Inisialisasi onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.isisemuarv,null );
        return new Inisialisasi(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull Inisialisasi inisialisasi, int i) {
        inisialisasi.iv.setImageResource(gambarHewan[i]);

    }


    @Override
    public int getItemCount() {
        return namaHewan.length;
    }
}
