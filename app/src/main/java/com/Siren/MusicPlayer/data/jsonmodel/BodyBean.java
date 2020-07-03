package com.Siren.MusicPlayer.data.jsonmodel;

public class BodyBean {

    public int id;
    public String mid;
    public String title;
    public String author;
    public String album;
    public String url;
    public String pic;
    public String lrc;
    public int getId() {
        return id;
    }

    public int getMid() {
        return Integer.parseInt(mid);
    }

    public String getAlbum() {
        return album;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }
}
