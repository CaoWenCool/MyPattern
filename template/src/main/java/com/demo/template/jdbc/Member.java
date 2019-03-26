package com.demo.template.jdbc;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:22
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    private String username;
    private String password;
    private String nickname;
    private int age;
    private String addr;
}
