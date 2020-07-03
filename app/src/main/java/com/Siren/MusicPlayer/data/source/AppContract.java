package com.Siren.MusicPlayer.data.source;

import com.Siren.MusicPlayer.data.model.Folder;
import com.Siren.MusicPlayer.data.model.PlayList;
import com.Siren.MusicPlayer.data.model.Song;

import java.util.List;

import rx.Observable;


/* package */ interface AppContract {

    // Play List

    Observable<List<PlayList>> playLists();

    List<PlayList> cachedPlayLists();

    Observable<PlayList> create(PlayList playList);

    Observable<PlayList> update(PlayList playList);

    Observable<PlayList> delete(PlayList playList);

    // Folder

    Observable<List<Folder>> folders();

    Observable<Folder> create(Folder folder);

    Observable<List<Folder>> create(List<Folder> folders);

    Observable<Folder> update(Folder folder);

    Observable<Folder> delete(Folder folder);

    // Song

    Observable<List<Song>> insert(List<Song> songs);

    Observable<Song> insert(Song songs);

    Observable<Song> update(Song song);

    Observable<Song> setSongAsFavorite(Song song, boolean favorite);

}
