package id.ac.budiluhur.fikom.fikomubl.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import id.ac.budiluhur.fikom.fikomubl.R;

public class HomeFragment extends Fragment implements View.OnClickListener {
    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private SliderLayout slider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_home_screen, container, false);
        setHasOptionsMenu(true);

        slider = (SliderLayout)view.findViewById(R.id.slider_home_screen);
        ImageView imgBLTV = (ImageView)view.findViewById(R.id.imgBLTV);
        ImageView imgLMK = (ImageView)view.findViewById(R.id.imgLMK);
        ImageView imgMGT = (ImageView)view.findViewById(R.id.imgMGT);
        ImageView imgRBL = (ImageView)view.findViewById(R.id.imgRBL);

        imgBLTV.setOnClickListener(this);
        imgLMK.setOnClickListener(this);
        imgMGT.setOnClickListener(this);
        imgRBL.setOnClickListener(this);

        HashMap<String,Integer> img_maps = new HashMap<>();
        img_maps.put("Program Studi Ilmu Komunikasi",R.drawable.slide_1);
        img_maps.put("Testimoni",R.drawable.slide_2);

        for(String name : img_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(img_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            Toast.makeText(getContext(),slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
                        }
                    });

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            slider.addSlider(textSliderView);
        }
        slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(4000);
        slider.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    @Override
    public void onStop() {
        slider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.addCategory(Intent.CATEGORY_BROWSABLE);

        switch (v.getId()){
            case R.id.imgBLTV:
                i.setData(Uri.parse("http://www.budiluhur.tv/"));
                startActivity(i);
                break;
            case R.id.imgRBL:
                i.setData(Uri.parse("http://www.radiobudiluhur.com/"));
                startActivity(i);
                break;
            case R.id.imgMGT:
                i.setData(Uri.parse("http://issuu.com/magentamagz/docs/magenta_edisi_ke_2"));
                startActivity(i);
                break;
            case R.id.imgLMK:
                i.setData(Uri.parse("http://labmediaubl.com/"));
                startActivity(i);
                break;
        }
    }
}
