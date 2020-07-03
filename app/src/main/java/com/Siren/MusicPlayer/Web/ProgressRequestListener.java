package com.Siren.MusicPlayer.Web;

public interface ProgressRequestListener  {
    void onRequestProgress(long bytesWritten, long contentLength, boolean done);
}
