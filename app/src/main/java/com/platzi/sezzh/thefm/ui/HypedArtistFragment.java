package com.platzi.sezzh.thefm.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platzi.sezzh.thefm.R;


/**
 * Created by sezzh on 07/03/2016.
 */
public class HypedArtistFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root =
        inflater.inflate(R.layout.fragment_hyped_artist, container, false);
    return root;
  }
}
