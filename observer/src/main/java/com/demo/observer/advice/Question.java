package com.demo.observer.advice;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:42
 * @version: V1.0
 * @detail:
 **/
public class Question {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String userName;
    private String content;
}
