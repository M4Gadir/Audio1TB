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

class HewanAdapter extends RecyclerView.Adapter<Inisialisasi> {
    Context context;
    MediaPlayer player;
    String[] namaHewan = {"Kucing","Gajah","Anjing","Kuda","Kambing"};
   int[] gambarHewan = {R.drawable.kucing,R.drawable.gajah,R.drawable.anjing,R.drawable.kuda,R.drawable.kambing};
   int[] soundHewan = {R.raw.kucing,R.raw.gajah,R.raw.anjing,R.raw.quda,R.raw.kambing};
    public HewanAdapter(Context context) {
    this.context = context;
    }

    @NonNull
    @Override
    public Inisialisasi onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.isisemuarv,null );
        player = new MediaPlayer();
        return new Inisialisasi(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull Inisialisasi inisialisasi, final int i) {
        inisialisasi.iv.setImageResource(gambarHewan[i]);
        inisialisasi.tv.setText(namaHewan[i]);
        inisialisasi.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("android.resource://" + context.getPackageName() +"/" + soundHewan[i]);
                player = new MediaPlayer();
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try{
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
        });

    }


    @Override
    public int getItemCount() {
        return namaHewan.length;
    }
}
