package com.example.dora.eletricity.framgment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dora.eletricity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SzFragment extends Fragment {


    public SzFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_sz,container,false);
    }

}
