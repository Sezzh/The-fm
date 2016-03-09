package com.platzi.sezzh.thefm.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platzi.sezzh.thefm.R;


/**
 * Created by sezzh on 07/03/2016.
 */
public class HypedArtistFragment extends Fragment {

  public static final Integer NUM_COLUMNS = 2;
  private RecyclerView mHypedArtistList;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root =
        inflater.inflate(R.layout.fragment_hyped_artist, container, false);
    this.mHypedArtistList =
        (RecyclerView) root.findViewById(R.id.hyped_artist_list);

    return root;
  }

  private void setupArtistList() {
    this.mHypedArtistList.setLayoutManager(
        new GridLayoutManager(this.getActivity(),NUM_COLUMNS)
    );
  }
}
