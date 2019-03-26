package com.demo.observer.advice;

import java.util.Observable;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:42
 * @version: V1.0
 * @detail:
 **/
public class AdviceObserver extends Observable {
    private String name = "提问系统";
    private static AdviceObserver adviceObserver = null;
    public static AdviceObserver getInstance(){
        if(null == adviceObserver){
            adviceObserver = new AdviceObserver();
        }
        return adviceObserver;
    }

    public String getName(){
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName() + "在" + this.name + "提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
