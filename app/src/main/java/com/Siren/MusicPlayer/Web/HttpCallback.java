package com.Siren.MusicPlayer.Web;

import android.graphics.Bitmap;

import java.io.InputStream;

public interface HttpCallback {
    void onFinish(String response);
    void onFinish(InputStream in);
    void onFinish(Bitmap bm);
    void onError(Exception e);
}
