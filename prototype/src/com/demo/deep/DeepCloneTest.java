package com.demo.deep;

/**
 * Created by 曹文 on 2019/3/13.
 */
public class DeepCloneTest {

    public static void main(String[] args) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();

        try{
            QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng.clone();

            System.out.println("深克隆"+(qiTianDaSheng.jinGuBang == clone.jinGuBang));
        }catch (Exception e){
            e.printStackTrace();
        }

        QiTianDaSheng q = new QiTianDaSheng();
        QiTianDaSheng n = q.shallowClone(q);
        System.out.println("浅克隆"+(q.jinGuBang == n.jinGuBang));
    }
}
