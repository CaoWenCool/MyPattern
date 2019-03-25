package com.pattern.newFac.simpleFactory;

import com.pattern.newFac.Car;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:17
 * @version: V1.0
 * @detail:
 **/
public class CarFactory {
    public Car install(Class<? extends Car> clazz){
        try{

            if(null != clazz){
                return clazz.newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Car installTwo(String className){
        try{
            if(!(null == className  || "".equals(className))){
                return (Car) Class.forName(className).newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
