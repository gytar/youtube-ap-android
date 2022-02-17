package com.gytar.mybestyoutube.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gytar.mybestyoutube.R;
import com.gytar.mybestyoutube.data.YoutubeVideo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class YoutubeVideoAdapter extends RecyclerView.Adapter<YoutubeVideoAdapter.YtVideoViewHolder> {



    private final List<YoutubeVideo> youtubeVideos;
    private final OnItemClickListener listener;

    public YoutubeVideoAdapter(List<YoutubeVideo> youtubeVideos, OnItemClickListener listener) {
        this.youtubeVideos = youtubeVideos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public YtVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.youtube_video_item, parent, false);
        return new YtVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YtVideoViewHolder holder, int position) {
        YoutubeVideo youtubeVideo = youtubeVideos.get(position);

        holder.bind(youtubeVideos.get(position), listener);

        holder.tvTitle.setText(youtubeVideo.getTitle());
        holder.tvChannel.setText(youtubeVideo.getChannel());
        holder.tvCategory.setText(youtubeVideo.getCategory());
        Picasso.get().load(youtubeVideo.getImageUrl()).into(holder.ivThumbnail);


    }

    @Override
    public int getItemCount() {
        return youtubeVideos.size();
    }

    ///// YT_VIDEO_VIEW_HOLDER CLASS /////
    public static class YtVideoViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvChannel;
        public TextView tvCategory;
        public ImageView ivThumbnail;

        public YtVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvChannel = itemView.findViewById(R.id.tvChannel);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            ivThumbnail = itemView.findViewById(R.id.thumbnail_iv);
        }

        public void bind(final YoutubeVideo youtubeVideo, final OnItemClickListener listener) {
            itemView.setOnClickListener(view -> listener.onItemClick(youtubeVideo));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(YoutubeVideo item);
    }
}
