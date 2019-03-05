package com.magad.homeactivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

class EntahAdapter extends RecyclerView.Adapter<Inisialisasi> {
    MediaPlayer player;
    Context context;
    String[] namaEntah={"mobil","kapalbesar","gerbong","pesawat",};
    int[] namaGambar = {R.drawable.car,R.drawable.cargoship,R.drawable.cargo,R.drawable.airplane};
    int[] soundentah = {R.raw.cars,R.raw.train,R.raw.train,R.raw.airlane};
    public EntahAdapter(Context context) {
    this.context = context;

    }

    @NonNull
    @Override
    public Inisialisasi onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.isisemuarv, null);
        player = new MediaPlayer();
        return new Inisialisasi(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull final Inisialisasi inisialisasi, final int i) {
    inisialisasi.tv.setText(namaEntah[i]);
    inisialisasi.iv.setImageResource(namaGambar[i]);
    inisialisasi.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + soundentah[i]);
            if (inisialisasi.itemView.isClickable()){
                player = new MediaPlayer();
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    player.setDataSource(context,uri);
                }catch (IOException e){
                    e.printStackTrace();
                }catch (IllegalStateException e){
                    e.printStackTrace();
                }try{
                    player.prepare();
                }catch (IOException e){
                    e.printStackTrace();
                }
                player.start();

            }

        }
    });
    }

    @Override
    public int getItemCount() {
        return namaEntah.length;
    }
}
