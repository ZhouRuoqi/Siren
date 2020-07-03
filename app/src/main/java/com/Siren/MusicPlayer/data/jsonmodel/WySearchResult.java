package com.Siren.MusicPlayer.data.jsonmodel;

import java.util.List;

public class WySearchResult {

    public String Code;
    public List<BodyBean> Body;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }
}
