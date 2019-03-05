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
public class EntahActivity extends Fragment {
    RecyclerView rv;

    EntahAdapter adapter;
    public EntahActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_entah, container, false);
        rv = v.findViewById(R.id.rventah);
        adapter = new EntahAdapter(getActivity());
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rv.setAdapter(adapter);
        return v;
    }

}
