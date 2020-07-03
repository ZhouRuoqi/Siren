package com.Siren.MusicPlayer.data.jsonmodel;

import java.util.List;

public class LoginBean {


    public int error;
    public boolean success;
    public List<ResultBean> result;

    public static class ResultBean {

        public String UserName;
        public String UserID;
        public String UserEmail;
        public String UserPic;
        public int UserIdentity;
        public String Message;

        public String getUserPic() {
            return UserPic;
        }

        public int getUserIdentity() {
            return UserIdentity;
        }

        public String getMessage() {
            return Message;
        }

        public String getUserEmail() {
            return UserEmail;
        }

        public String getUserID() {
            return UserID;
        }

        public String getUserName() {
            return UserName;
        }
    }

    public int getError() {
        return error;
    }

    public List<ResultBean> getResult() {
        return result;
    }
    public boolean getSuccess() {
        return success;
    }

}
