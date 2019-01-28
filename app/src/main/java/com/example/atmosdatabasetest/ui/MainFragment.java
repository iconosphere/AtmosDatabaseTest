package com.example.atmosdatabasetest.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.atmosdatabasetest.R;
import com.example.atmosdatabasetest.adapters.BlendAdapter;
import com.example.atmosdatabasetest.data.Blend;
import com.example.atmosdatabasetest.view_models.BlendViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    // Member variables.
    private BlendViewModel mBlendViewModel;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.recyclerview, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        final BlendAdapter adapter = new BlendAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mBlendViewModel = ViewModelProviders.of(this).get(BlendViewModel.class);

        mBlendViewModel.getAllBlends().observe(this, new Observer<List<Blend>>() {
            @Override
            public void onChanged(@Nullable final List<Blend> blends) {
                // Update the cached copy of the words in the adapter.
                adapter.setBlends(blends);
            }
        });
        return rootView;
    }
}
