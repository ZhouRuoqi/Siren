package com.Siren.MusicPlayer.event;


import com.Siren.MusicPlayer.data.model.PlayList;

public class PlayListCreatedEvent {

    public PlayList playList;

    public PlayListCreatedEvent(PlayList playList) {
        this.playList = playList;
    }
}
