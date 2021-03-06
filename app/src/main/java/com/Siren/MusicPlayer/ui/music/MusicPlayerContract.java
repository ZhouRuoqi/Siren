package com.Siren.MusicPlayer.ui.music;

import android.support.annotation.Nullable;
import com.Siren.MusicPlayer.data.model.Song;
import com.Siren.MusicPlayer.player.PlaybackService;
import com.Siren.MusicPlayer.ui.base.BasePresenter;
import com.Siren.MusicPlayer.ui.base.BaseView;

/* package */ interface MusicPlayerContract {

    interface View extends BaseView<Presenter> {

        void handleError(Throwable error);

        void onPlaybackServiceBound(PlaybackService service);

        void onPlaybackServiceUnbound();

       // void onSongSetAsFavorite(@NonNull Song song);

        void onSongUpdated(@Nullable Song song);

    //    void updatePlayMode(PlayMode playMode);

        void updatePlayToggle(boolean play);

     //   void updateFavoriteToggle(boolean favorite);
    }

    interface Presenter extends BasePresenter {

        void retrieveLastPlayMode();

    //    void setSongAsFavorite(Song song, boolean favorite);

        void bindPlaybackService();

        void unbindPlaybackService();
    }
}
