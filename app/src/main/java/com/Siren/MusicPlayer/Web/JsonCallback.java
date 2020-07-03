package com.Siren.MusicPlayer.Web;

public interface JsonCallback {

    void onFinish(JsonModel jsonModel);

    void onError(Exception e);

}
