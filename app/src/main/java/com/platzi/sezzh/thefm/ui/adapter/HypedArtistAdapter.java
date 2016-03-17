package com.platzi.sezzh.thefm.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzi.sezzh.thefm.R;
import com.platzi.sezzh.thefm.domain.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sezzh on 15/03/2016.
 */
public class HypedArtistAdapter extends
    RecyclerView.Adapter<HypedArtistAdapter.HypedArtistViewHolder> {
  private ArrayList<Artist> artistList;
  private Context context;

  public HypedArtistAdapter(Context context) {
    this.context = context;
    this.artistList = new ArrayList<>();
  }

  @Override
  public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
    View itemView = LayoutInflater.from(this.context)
            .inflate(R.layout.item_hyped_artist, parent, false);
    HypedArtistViewHolder viewHolder = new HypedArtistViewHolder(itemView);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(HypedArtistViewHolder holder, int position) {
    Artist currentArtist = artistList.get(position);
    holder.setArtistName(currentArtist.getName());
  }

  @Override
  public int getItemCount() {
    return this.artistList.size();
  }

  public void addAll(@NonNull ArrayList<Artist> artistList) {
    if (artistList == null) {
      throw new NullPointerException("The items cannot be null");
    } else {
      this.artistList.addAll(artistList);
      this.notifyItemRangeInserted(
          this.getItemCount() - 1, this.artistList.size()
      );
      // this.notifyDataSetChanged(); Another possibilities of notify.
    }
  }


  public class HypedArtistViewHolder extends RecyclerView.ViewHolder {

    public TextView artistName;
    public ImageView artistImage;

    /**
     * This View is the element that has to be inflated
     * in the onCreateViewHolder() inside the adapter.
     * @param itemView
     */
    public HypedArtistViewHolder(View itemView) {
      super(itemView);
      this.artistName = (TextView) itemView.findViewById(R.id.txt_name);
      this.artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
    }

    public void setArtistName(String name) {
      this.artistName.setText(name);
    }

  }
}
