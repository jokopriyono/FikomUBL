package id.ac.budiluhur.fikom.fikomubl.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import id.ac.budiluhur.fikom.fikomubl.activity.DetailBrochureActivity;
import id.ac.budiluhur.fikom.fikomubl.R;

public class BrochureFragment extends Fragment implements View.OnClickListener {
    public BrochureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected static String KEY = "konten";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_brochure, container, false);
        setHasOptionsMenu(true);

        LinearLayout konten1 = (LinearLayout)view.findViewById(R.id.konten1);
        LinearLayout konten2 = (LinearLayout)view.findViewById(R.id.konten2);
        LinearLayout konten3 = (LinearLayout)view.findViewById(R.id.konten3);
        LinearLayout konten4 = (LinearLayout)view.findViewById(R.id.konten4);
        LinearLayout konten5 = (LinearLayout)view.findViewById(R.id.konten5);
        LinearLayout konten6 = (LinearLayout)view.findViewById(R.id.konten6);

        konten1.setOnClickListener(this);
        konten2.setOnClickListener(this);
        konten3.setOnClickListener(this);
        konten4.setOnClickListener(this);
        konten5.setOnClickListener(this);
        konten6.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getContext(), DetailBrochureActivity.class);
        switch (v.getId()){
            case R.id.konten1:
                i.putExtra(KEY, "1");
                startActivity(i);
                break;
            case R.id.konten2:
                i.putExtra(KEY, "2");
                startActivity(i);
                break;
            case R.id.konten3:
                i.putExtra(KEY, "3");
                startActivity(i);
                break;
            case R.id.konten4:
                i.putExtra(KEY, "4");
                startActivity(i);
                break;
            case R.id.konten5:
                i.putExtra(KEY, "5");
                startActivity(i);
                break;
            case R.id.konten6:
                i.putExtra(KEY, "6");
                startActivity(i);
                break;
        }
    }
}
