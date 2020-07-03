package com.Siren.MusicPlayer.Web;

import android.widget.Toast;

import com.Siren.MusicPlayer.MusicPlayerApplication;

public class TextHelper {

    public static void showText(final String text){

        MusicPlayerApplication.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MusicPlayerApplication.getInstance(),text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void showLongText(final String text){

        MusicPlayerApplication.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MusicPlayerApplication.getInstance(),text, Toast.LENGTH_LONG).show();
            }
        });
    }
}