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
import com.platzi.sezzh.thefm.domain.Artist;
import com.platzi.sezzh.thefm.ui.adapter.HypedArtistAdapter;

import java.util.ArrayList;


/**
 * Created by sezzh on 07/03/2016.
 */
public class HypedArtistFragment extends Fragment {

  public static final Integer NUM_COLUMNS = 2;
  private RecyclerView mHypedArtistList;
  private HypedArtistAdapter adapter;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    adapter = new HypedArtistAdapter(this.getActivity());
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater
        .inflate(R.layout.fragment_hyped_artist, container, false);
    this.mHypedArtistList = (RecyclerView) root
        .findViewById(R.id.hyped_artists_list);

    this.setupArtistList();
    this.setDummyContent();

    return root;
  }

  private void setupArtistList() {
    this.mHypedArtistList.setLayoutManager(new GridLayoutManager(
        this.getActivity(), NUM_COLUMNS
    ));
    this.mHypedArtistList.setAdapter(this.adapter);
    this.mHypedArtistList.addItemDecoration(
        new ItemOffsetDecoration(this.getActivity(), R.integer.offset)
    );
  }

  private void setDummyContent() {
    /**
     * This method is for debug porpuses.
     */
    ArrayList<Artist> artistsDummy = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      artistsDummy.add(new Artist("Artist" + i));
    }
    this.adapter.addAll(artistsDummy);
  }
}
