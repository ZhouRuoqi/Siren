package com.Siren.MusicPlayer.event;


import com.Siren.MusicPlayer.data.model.PlayList;

public class PlayListUpdatedEvent {

    PlayList playList;

    public PlayListUpdatedEvent(PlayList playList) {
        this.playList = playList;
    }
}
