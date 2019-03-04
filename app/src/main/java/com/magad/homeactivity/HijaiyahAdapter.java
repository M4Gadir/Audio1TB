package com.magad.homeactivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

class HijaiyahAdapter extends RecyclerView.Adapter<Inisialisasi> {

    MediaPlayer player;

    private Context konten;
    String[] hurufnya = {"alif","ba","ta","tsa","jim","ha","kha","dal","dzal","ra","za","sin","syin","shad","dhod","tha","dho","'a","gh'a","fa","qaf","kaf","lam","mim","nun","waw","HA","ya"};
    int[] gambar = {R.drawable.hamzah_alif,R.drawable.ba,R.drawable.ta,R.drawable.tsa,R.drawable.jim,R.drawable.kha,R.drawable.kho,R.drawable.dal,R.drawable.dzal,R.drawable.ra,R.drawable.za,R.drawable.sin,R.drawable.syin,R.drawable.shad,R.drawable.dhod
            ,R.drawable.tha,R.drawable.dha,R.drawable.ain,R.drawable.ghain,R.drawable.fa,R.drawable.qof,R.drawable.kaf,R.drawable.lam,R.drawable.mim,R.drawable.nun,R.drawable.wawu,R.drawable.ha,R.drawable.ya};
    int[] sound = {R.raw.fatah_a,R.raw.fatah_ba,R.raw.fatah_ta,R.raw.fatah_tsa
            ,R.raw.fatah_ja,R.raw.fatah_ha,R.raw.fatah_kho,R.raw.fatah_da,R.raw.fatah_dza
            ,R.raw.fatah_ro,R.raw.fatah_za,R.raw.fatah_sa,R.raw.fatah_sya,R.raw.fatah_sho
            ,R.raw.fatah_dho,R.raw.fatah_tho,R.raw.fatah_dzo,R.raw.fatah_qo,R.raw.fatah_ba,R.raw.fatah_aa,R.raw.fatah_gho,R.raw.fatah_ka,R.raw.fatah_la
            ,R.raw.fatah_ma,R.raw.fatah_na,R.raw.fatah_wa,R.raw.fatah_haa,R.raw.fatah_ya,};
    public HijaiyahAdapter(Context context) {

        konten = context;
    }

    @NonNull
    @Override
    public Inisialisasi onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(konten).inflate(R.layout.isisemuarv, null);
        player = new MediaPlayer();
        return new Inisialisasi(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull final Inisialisasi inisialisasi, final int i) {
        inisialisasi.iv.setImageResource(gambar[i]);
        inisialisasi.tv.setText(hurufnya[i]);
        inisialisasi.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("android.resource://" + konten.getPackageName() + "/" + sound[i]);
                if (inisialisasi.itemView.isClickable())
                player = new MediaPlayer();
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    player.setDataSource(konten, uri);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
                try {
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();

                }

                player.start();
//                if (player.isPlaying()==false){
//
//                inisialisasi.itemView.isClickable();
//                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return hurufnya.length;
    }

}
