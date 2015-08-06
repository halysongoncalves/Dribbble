package br.goncalves.dribbble.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.goncalves.dribbble.Dribbble;
import br.goncalves.dribbble.R;
import br.goncalves.dribbble.interfaces.RecyclerViewClickListener;
import br.goncalves.dribbble.model.entities.Shot;


public class PopularityShotsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<Shot> shotList;
    public RecyclerViewClickListener recyclerViewClickListener;

    public PopularityShotsAdapter(List<Shot> shotList, RecyclerViewClickListener recyclerViewClickListener) {
        this.shotList = shotList;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_home_comp, viewGroup, false), recyclerViewClickListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Shot shot = shotList.get(position);

        holder.textViewLike.setText(String.valueOf(shot.getLikesCount()));
        holder.textViewComments.setText(String.valueOf(shot.getCommentsCount()));

        Picasso.with(Dribbble.getContext())
                .load(shot.getImageUrl())
                .placeholder(R.drawable.placeholder_shot_home)
                .resize(492,369)
                .into(holder.imageViewShot);
    }

    @Override
    public int getItemCount() {
        return shotList.size();
    }

    public List<Shot> getShotList() {
        return shotList;
    }
}

class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final RecyclerViewClickListener recyclerViewClickListener;
    ImageView imageViewLikes;
    ImageView imageViewComments;
    ImageView imageViewShot;
    TextView textViewLike;
    TextView textViewComments;

    public ViewHolder(View itemView, RecyclerViewClickListener recyclerViewClickListener) {
        super(itemView);
        this.recyclerViewClickListener = recyclerViewClickListener;
        imageViewShot = (ImageView) itemView.findViewById(R.id.activity_home_comp_image_view_shot);
        imageViewShot.setOnClickListener(this);
        imageViewShot.setDrawingCacheEnabled(true);
        imageViewLikes = (ImageView) itemView.findViewById(R.id.activity_home_comp_image_view_shot_likes);
        imageViewLikes.setDrawingCacheEnabled(true);
        imageViewComments = (ImageView) itemView.findViewById(R.id.activity_home_comp_image_view_shot_comments);
        imageViewComments.setDrawingCacheEnabled(true);

        textViewLike = (TextView) itemView.findViewById(R.id.activity_home_comp_text_view_shot_like);
        textViewComments = (TextView) itemView.findViewById(R.id.activity_home_comp_text_view_shot_comments);
    }

    @Override
    public void onClick(View view) {
        recyclerViewClickListener.onClick(view, getPosition());
    }
}



