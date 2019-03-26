package com.demo.template.course;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:19
 * @version: V1.0
 * @detail:
 **/
public class ChineseCourse extends Course{
    private boolean needHomeworkFlag = false;

    public ChineseCourse(boolean needHomeworkFlag){
        this.needHomeworkFlag = needHomeworkFlag;
    }

    void checkHomework() {
        System.out.println("检查语文作业");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }
}
