package com.demo.template.course;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:21
 * @version: V1.0
 * @detail:
 **/
public class CourseTest {
    public static void main(String[] args) {
        System.out.println("数学课程---------------");
        Course mathCourse = new MathCourse();
        mathCourse.createCouse();

        System.out.println("语文课程------------------");
        Course chineseCourse = new ChineseCourse(true);
        chineseCourse.createCouse();
    }
}
