package com.Siren.MusicPlayer.data.jsonmodel;

import java.util.List;

public class MyCommentBean {


    public int error;
    public boolean success;
    public List<ResultBean> result;

    public int getError() {
        return error;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class ResultBean {

        public String UserName;
        public String commentDate;
        public String UserPic;
        public String content;
        public String musicId;
        public String commentId;

        public String getUserPic() {
            return UserPic;
        }

        public String getUserName() {
            return UserName;
        }

        public String getCommentDate() {
            return commentDate;
        }

        public String getContent() {
            return content;
        }

        public String getMusicId() {
            return musicId;
        }

        public int getCommentId() {
            if(commentId!=null){
                return Integer.parseInt(commentId);
            }
            return 0;
        }
    }
}
