package com.demo.template.course;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:20
 * @version: V1.0
 * @detail:
 **/
public abstract class Course {
    protected final void createCouse(){
        //1、预习
        this.preview();
        //听讲
        this.listen();
        //复习
        this.review();
        //布置作业，如果有作业的哈，需要进行检查
        if(needHomework()){
            checkHomework();
        }
    }

    abstract void checkHomework();

    //钩子方法实现流程的微调
    protected boolean needHomework(){
        return false;
    }

    final  void preview(){
        System.out.println("上课前要提前预习");
    }

    final void listen(){
        System.out.println("上课时，要认真听讲");
    }

    final void review(){
        System.out.println("课后要经常复习");
    }
}
