package com.example.android.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView img;
    TextView expandedtext;
    TextView tellmemore;
    CardView card;



    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.notif, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(getActivity(),"In The App Notifications Will Be Shown",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        img = view.findViewById(R.id.expand);
        expandedtext = view.findViewById(R.id.exptxt);
        tellmemore = view.findViewById(R.id.tell);
        card = view.findViewById(R.id.card);

        view.findViewById(R.id.weather).setOnClickListener(this);
        view.findViewById(R.id.amazonsmile).setOnClickListener(this);
        view.findViewById(R.id.gift).setOnClickListener(this);
        view.findViewById(R.id.pray).setOnClickListener(this);
        view.findViewById(R.id.newphoto).setOnClickListener(this);
        view.findViewById(R.id.newspon).setOnClickListener(this);
        view.findViewById(R.id.year3).setOnClickListener(this);
        view.findViewById(R.id.thank).setOnClickListener(this);
        view.findViewById(R.id.video).setOnClickListener(this);


        tellmemore.setOnClickListener(this);
        img.setOnClickListener(this);
        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.weather:
                Toast.makeText(getActivity(),"In the app weather Fragment will open",Toast.LENGTH_SHORT).show();
                break;
            case R.id.amazonsmile:
                Toast.makeText(getActivity(),"In the app Amazon Smile Fragment will open",Toast.LENGTH_SHORT).show();
                break;
            case R.id.gift:
                Toast.makeText(getActivity(),"In the app Gift Fragment will open",Toast.LENGTH_SHORT).show();
                break;
            case R.id.pray:
                Toast.makeText(getActivity(),"In the app Pray Fragment will open",Toast.LENGTH_SHORT).show();
                break;
            case R.id.newphoto:
                Toast.makeText(getActivity(),"In the app New Photo functionality is handled",Toast.LENGTH_SHORT).show();
                break;
            case R.id.newspon:
                Toast.makeText(getActivity(),"In the app New Sponsorship Fragment will open",Toast.LENGTH_SHORT).show();
                break;
            case R.id.year3:
                Toast.makeText(getActivity(),"In the app 3 year anniversary functionality is handled",Toast.LENGTH_SHORT).show();
                break;
            case R.id.thank:
                Toast.makeText(getActivity(),"In the app My Children Fragment will open",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tell:
            case R.id.expand:
                if(expandedtext.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(card,new AutoTransition());
                    expandedtext.setVisibility(View.VISIBLE);
                    tellmemore.setText("see less");
                    img.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);

                }
                else{
                    TransitionManager.beginDelayedTransition(card,new AutoTransition());
                    expandedtext.setVisibility(View.GONE);
                    tellmemore.setText("Tell me more");
                    img.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);

                }
                break;


        }


    }
}
