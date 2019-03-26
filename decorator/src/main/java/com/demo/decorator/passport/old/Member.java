package com.demo.decorator.passport.old;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:03
 * @version: V1.0
 * @detail:
 **/
public class Member {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String username;
    private String password;
    private String mid;
    private String info;
}
