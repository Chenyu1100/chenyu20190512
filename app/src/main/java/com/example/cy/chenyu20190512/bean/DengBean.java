package com.example.cy.chenyu20190512.bean;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/5/10 19:14
 * update: $date$
 */
public class DengBean {

    /**
     * result : {"phone":"13937499551","nickName":"uD_z9k16","sex":1,"sessionId":"15569324813702351","headPic":"http://172.17.8.100/images/small/default/user.jpg","userId":2351}
     * message : 登录成功
     * status : 0000
     */
    private ResultEntity result;
    private String message;
    private String status;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultEntity getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public class ResultEntity {
        /**
         * phone : 13937499551
         * nickName : uD_z9k16
         * sex : 1
         * sessionId : 15569324813702351
         * headPic : http://172.17.8.100/images/small/default/user.jpg
         * userId : 2351
         */
        private String phone;
        private String nickName;
        private int sex;
        private String sessionId;
        private String headPic;
        private int userId;

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getPhone() {
            return phone;
        }

        public String getNickName() {
            return nickName;
        }

        public int getSex() {
            return sex;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getHeadPic() {
            return headPic;
        }

        public int getUserId() {
            return userId;
        }
    }
}

