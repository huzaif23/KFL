package com.huzaifa.project.football.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.huzaifa.project.football.R;


public class video_screen extends Fragment implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView youTubePlayerView;
        String y;
    @SuppressLint("ValidFragment")
    public video_screen(String x) {
        y=x;
    }

    public video_screen() {

    }

    RelativeLayout frame;
   View view1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_screen,container,false);

        YouTubePlayerSupportFragment supportFragment = YouTubePlayerSupportFragment.newInstance();
        Toast.makeText(getContext(),""+y,Toast.LENGTH_SHORT).show();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.rl,supportFragment);
        ft.addToBackStack(null);
        ft.commit();
        supportFragment.initialize("AIzaSyBsde8-wOes9FOe6Y25KaMA1RpN9pb-bfM",this);
             return view;
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
       if (!b) {
           youTubePlayer.cueVideo("VvtVK3GxoO4");

          youTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
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
          });
       }
       youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
    }



    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getContext(),"not work",Toast.LENGTH_SHORT).show();
    }


}