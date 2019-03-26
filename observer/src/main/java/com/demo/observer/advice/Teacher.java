package com.demo.observer.advice;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:43
 * @version: V1.0
 * @detail:
 **/
public class Teacher implements Observer {
    private String name;
    public Teacher(String name){
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        AdviceObserver adviceObserver = (AdviceObserver) o;
        Question question = (Question) arg;
        System.out.println("===================");
        System.out.println(name + "老师，你好！\n"+"您收到了一个来自"+adviceObserver.getName()+"的提问，希望您能解答，解答内容如下：\n"+question.getContent()+"\n"+"提问者："+question.getUserName());
    }
}
