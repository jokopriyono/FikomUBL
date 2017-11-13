package id.ac.budiluhur.fikom.fikomubl.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.budiluhur.fikom.fikomubl.R;

public class ContactFragment extends Fragment {
    public ContactFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_contact, container, false);
        setHasOptionsMenu(true);

        return view;
    }
}
