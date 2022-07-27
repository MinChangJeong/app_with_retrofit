package com.frontend.cj_app.common.payload;

import com.google.gson.annotations.SerializedName;

public class User_Request {

    @SerializedName("USER_ID")
    private String user_id;

    public User_Request(String user_name, String user_id, String user_password, String user_phonenum,
                        String user_bankname, int user_account,
                        String user_carnum, String user_cartype, String user_carnumcolor,
                        String user_couryarea) {

        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_phonenum = user_phonenum;
        this.user_bankname = user_bankname;
        this.user_account = user_account;
        this.user_carnum = user_carnum;
        this.user_cartype = user_cartype;
        this.user_carnumcolor = user_carnumcolor;
        this.user_couryarea = user_couryarea;
    }

    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @SerializedName("USER_PASSWORD")
    private String user_password;

    public String getUser_password() {
        return user_password;
    }
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    @SerializedName("USER_NAME")
    private String user_name;

    public String getUser_name() {
        return user_name;
    }


    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    @SerializedName("USER_PHONENUM")
    private String user_phonenum;

    public String getUser_phonenum() {
        return user_phonenum;
    }

    public void setUser_phonenum(String user_phonenum) {
        this.user_phonenum = user_phonenum;
    }

    @SerializedName("USER_CARNUM")
    private String user_carnum;

    public String getUser_carnum() {
        return user_carnum;
    }

    public void setUser_carnum(String user_carnum) {
        this.user_carnum = user_carnum;
    }

    @SerializedName("USER_CARTYPE")
    private String user_cartype;

    public String getUser_cartype() {
        return user_cartype;
    }

    public void setUser_cartype(String user_cartype) {
        this.user_cartype = user_cartype;
    }
    @SerializedName("USER_CARNUMCOLOR")
    private String user_carnumcolor;

    public String getUser_carnumcolor() {
        return user_carnumcolor;
    }

    public void setUser_carnumcolor(String user_carnumcolor) {
        this.user_carnumcolor = user_carnumcolor;
    }



    @SerializedName("USER_BANKNAME")

    private String user_bankname;

    public String getUser_bankname() {
        return user_bankname;
    }
    public void setUser_bankname(String user_bankname) {
        this.user_bankname = user_bankname;
    }


    @SerializedName("USER_ACCOUNT")
    private int user_account;

    public int getUser_account() {
        return user_account;
    }

    public void setUser_account(int user_account) {
        this.user_account = user_account;
    }


    @SerializedName("USER_COURYAREA")
    private String user_couryarea;

    public String getUser_couryarea() {
        return user_couryarea;
    }

    public void setUser_couryarea(String user_couryarea) {
        this.user_couryarea = user_couryarea;
    }

}
