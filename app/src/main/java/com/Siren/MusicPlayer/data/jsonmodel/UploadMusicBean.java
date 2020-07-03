package com.Siren.MusicPlayer.data.jsonmodel;

import java.util.List;

public class UploadMusicBean {


    public int error;
    public boolean success;
    public List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public int getError() {
        return error;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class ResultBean {

        public String UserEmail;
        public String filepath;
        public String MusicId;
        public String Title;
        public String Album;
        public String Artist;
        public String DisplayName;
        public String Size;
        public String Duration;

        public void setMusicId(String musicId) {
            MusicId = musicId;
        }

        public int getMusicId() {
            if(MusicId!=null){
                return Integer.parseInt(MusicId);
            }
            return 0;
        }

        public int getSize() {
            if(Size!=null){
                return Integer.parseInt(Size);
            }
            return 0;
        }

        public int getDuration() {
            if(Duration!=null){
                return Integer.parseInt(Duration);
            }
            return 0;
        }

        public String getFilepath() {
            return filepath;
        }

        public String getUserEmail() {
            return UserEmail;
        }

        public String getAlbum() {
            return Album;
        }

        public String getArtist() {
            return Artist;
        }

        public String getDisplayName() {
            return DisplayName;
        }

        public String getTitle() {
            return Title;
        }

    }
}
