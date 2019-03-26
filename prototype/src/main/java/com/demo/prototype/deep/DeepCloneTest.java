package com.demo.prototype.deep;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:54
 * @version: V1.0
 * @detail:
 **/
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
