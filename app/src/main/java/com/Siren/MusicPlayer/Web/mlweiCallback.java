package com.Siren.MusicPlayer.Web;

import com.Siren.MusicPlayer.data.jsonmodel.WyRecommendListBean;

public interface mlweiCallback {
    void onFinish(WyRecommendListBean jsonModel);

    void onError(Exception e);

}
