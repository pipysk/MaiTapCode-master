package com.example.tracnghiemta.score;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tracnghiemta.MainActivity;
import com.example.tracnghiemta.R;

public class ScoreFragment extends Fragment {
    ListView lvScore;
    ScoreController scoreController;
    ScoreAdapter scoreAdapter;

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Danh sách điểm");
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        scoreController = new ScoreController(getActivity());
        lvScore = (ListView) getActivity().findViewById(R.id.lvScore);
        Cursor cursor = scoreController.getScore();
        scoreAdapter = new ScoreAdapter(getActivity(), cursor, true);
        lvScore.setAdapter(scoreAdapter);
    }

}
