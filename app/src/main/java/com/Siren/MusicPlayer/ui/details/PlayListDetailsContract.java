package com.Siren.MusicPlayer.ui.details;

import com.Siren.MusicPlayer.data.model.PlayList;
import com.Siren.MusicPlayer.data.model.Song;
import com.Siren.MusicPlayer.ui.base.BasePresenter;
import com.Siren.MusicPlayer.ui.base.BaseView;

public interface PlayListDetailsContract {

    interface View extends BaseView<Presenter> {

        void showLoading();

        void hideLoading();

        void handleError(Throwable e);

        void onSongDeleted(Song song);
    }

    interface Presenter extends BasePresenter {

        void addSongToPlayList(Song song, PlayList playList);

        void delete(Song song, PlayList playList);
    }
}
