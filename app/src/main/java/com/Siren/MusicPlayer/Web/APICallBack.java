package com.Siren.MusicPlayer.Web;


public interface APICallBack {
    void onFinish(String json);

    void onError(Exception e);
}
