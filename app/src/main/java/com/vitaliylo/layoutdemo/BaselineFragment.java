package com.vitaliylo.layoutdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaselineFragment extends Fragment {


    public BaselineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_baseline, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final LinearLayout ll = (LinearLayout) view.findViewById(R.id.linearlayout);
        for (int i = 0; i < ll.getChildCount(); i++) {
            ll.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    int index = (ll.getBaselineAlignedChildIndex() + 1)%ll.getChildCount();
                    ll.setBaselineAlignedChildIndex(ll.indexOfChild(v));
                    ll.requestLayout();
                }
            });
        }
    }
}
