package com.Siren.MusicPlayer.Web;

public interface ResultCallback {

    void onFinish(Object o, int code);

    void onError(Exception e);

}
