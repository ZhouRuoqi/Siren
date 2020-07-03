package com.Siren.MusicPlayer.event;


import com.Siren.MusicPlayer.data.model.Song;

public class FavoriteChangeEvent {

    public Song song;

    public FavoriteChangeEvent(Song song) {
        this.song = song;
    }
}
