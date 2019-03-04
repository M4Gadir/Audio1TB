package com.magad.homeactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HijaiyahFragment extends Fragment {
    RecyclerView rv;
    HijaiyahAdapter adapter;

    public HijaiyahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hijaiyah, container, false);
        rv = v.findViewById(R.id.rvHIjaiyah);
        adapter = new HijaiyahAdapter(getActivity());
        rv.setLayoutManager(new GridLayoutManager(getActivity(),2 ));
        rv.setAdapter(adapter);
        return v;
    }

}
