package com.demo.observer.advice;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:43
 * @version: V1.0
 * @detail:
 **/
public class ObserverTest {
    public static void main(String[] args) {
        AdviceObserver adviceObserver = AdviceObserver.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");

        Question question = new Question();
        question.setUserName("小明");
        question.setContent("观察者设计模式适用于哪些场景？");
        adviceObserver.addObserver(tom);
        adviceObserver.addObserver(mic);
        adviceObserver.publishQuestion(question);
    }
}
