package com.Siren.MusicPlayer.ui.recommend;

import com.Siren.MusicPlayer.data.model.PlayList;

public interface RecommendItemLitener {
//    public void OnClickItem(Song song);
    void OnClickItem(PlayList songs, int position);
}
