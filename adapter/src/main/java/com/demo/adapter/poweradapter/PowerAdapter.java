package com.demo.adapter.poweradapter;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:17
 * @version: V1.0
 * @detail:
 **/
public class PowerAdapter implements DC5{
    private AC220 ac220;

    public PowerAdapter(AC220 ac220){
        this.ac220 = ac220;
    }
    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput /44;
        System.out.println("使用PowerAdapter输入AC0"+adapterInput+"V,输出电流为"+adapterOutput+"V");
        return adapterOutput;
    }
}
