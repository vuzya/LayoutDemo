package com.vitaliylo.layoutdemo;


import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrameLayoutFragment extends Fragment {


    public FrameLayoutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frame_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View v = view.findViewById(android.R.id.text1);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup vg = (ViewGroup) v.getParent();
                vg.setSelected(!vg.isSelected());
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.frame_layout, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        PorterDuff.Mode mode = null;
        switch (item.getItemId()){
            case R.id.mode_add:
                mode = PorterDuff.Mode.ADD;
                break;
            case R.id.mode_multiply:
                mode = PorterDuff.Mode.MULTIPLY;
                break;
            case R.id.mode_screen:
                mode = PorterDuff.Mode.SCREEN;
                break;
            case R.id.mode_src_atop:
                mode = PorterDuff.Mode.SRC_ATOP;
                break;
            case R.id.mode_src_in:
                mode = PorterDuff.Mode.SRC_IN;
                break;
            case R.id.mode_src_over:
                mode = PorterDuff.Mode.SRC_OVER;
                break;
        }

        FrameLayout vg = (FrameLayout) getView().findViewById(android.R.id.text1).getParent();
        vg.setForegroundTintMode(mode);
        return super.onOptionsItemSelected(item);
    }
}
