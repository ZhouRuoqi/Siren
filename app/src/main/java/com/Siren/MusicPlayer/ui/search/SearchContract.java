package com.Siren.MusicPlayer.ui.search;

import com.Siren.MusicPlayer.data.jsonmodel.BodyBean;
import com.Siren.MusicPlayer.data.model.PlayList;
import com.Siren.MusicPlayer.data.model.Song;
import com.Siren.MusicPlayer.ui.base.BaseView;

import java.util.List;

public interface SearchContract {
    interface View extends BaseView<SearchContract.Presenter> {

        void showLoading();

        void hideLoading();

        void handleError(Throwable e);

        void setAdapter(List<BodyBean> searchResult);
    }

    interface Presenter  {
        void addSongToPlayList(Song song, PlayList playList);
        void start();
        void stop();
        void search(String key);
    }
    interface ActionCallback {
        void onAction(android.view.View actionView, Song song);
        public void OnClickItem(PlayList songs, int position);
    }
}
