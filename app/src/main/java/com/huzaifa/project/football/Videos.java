package com.huzaifa.project.football;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class Videos extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,YouTubeThumbnailView.OnInitializedListener

{
    YouTubeThumbnailView thums;
    YouTubeThumbnailLoader loader;

    String VIDEO_URL = "lWABI0X5_WY";

    Videos() {
        super();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube);
        youTubePlayerView.initialize("AIzaSyBsde8-wOes9FOe6Y25KaMA1RpN9pb-bfM",this);
        thums = (YouTubeThumbnailView) findViewById(R.id.thumb);
        thums.initialize("AIzaSyBsde8-wOes9FOe6Y25KaMA1RpN9pb-bfM",this);
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Toast.makeText(this, "Player Loaded Successfully", Toast.LENGTH_SHORT).show();
        youTubePlayer.setPlayerStateChangeListener(player);
        youTubePlayer.setPlaybackEventListener(eventListener);
        if (!b) {
            youTubePlayer.cueVideo(VIDEO_URL);
        }

    }
    YouTubePlayer.PlaybackEventListener eventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    YouTubePlayer.PlayerStateChangeListener player = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
        youTubeThumbnailLoader.setVideo(VIDEO_URL);
        youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                youTubeThumbnailLoader.release();
                Toast.makeText(getApplicationContext(),"Loaded",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

            }
        });
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
    }
}
