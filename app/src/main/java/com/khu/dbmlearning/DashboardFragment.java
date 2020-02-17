package com.khu.dbmlearning;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements View.OnClickListener{


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dashboardr, container, false);



        CardView card1 =  rootView.findViewById(R.id.card1);
        CardView card2 =  rootView.findViewById(R.id.card2);
        CardView card3 =  rootView.findViewById(R.id.card3);
        CardView card4 =  rootView.findViewById(R.id.card4);
        CardView card5 =  rootView.findViewById(R.id.card5);
        CardView card6 =  rootView.findViewById(R.id.card6);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.card1:
                Intent i = new Intent(getActivity(), CardViewNoteActivity.class);
                startActivity(i);
                break;
            case R.id.card2:

                break;
            case R.id.card3:
                i = new Intent(getActivity(), CardViewQuizActivity.class);
                startActivity(i);
                break;
            case R.id.card4:
                i = new Intent(getActivity(), PastActivity.class);
                startActivity(i);
                break;
            case R.id.card5:
                i = new Intent(getActivity(), Exercise1Activity.class);
                startActivity(i);
                break;
            case R.id.card6:
                i = new Intent(getActivity(), AboutUsActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
