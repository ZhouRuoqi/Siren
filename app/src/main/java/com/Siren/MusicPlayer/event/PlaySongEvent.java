package com.Siren.MusicPlayer.event;


import com.Siren.MusicPlayer.data.model.Song;

public class PlaySongEvent {

    public Song song;

    public PlaySongEvent(Song song) {
        this.song = song;
    }
}
