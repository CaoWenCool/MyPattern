# 装饰器模式  
## 应用场景  
装饰器模式是指在改变原有对象的基础之上，将功能附加到对象上，提供了比继承更有弹性的替代方案（扩展原有对象的功能），属于结构型模式
装饰者模式在我们生活中的例子：煎饼加蛋，蛋糕加水果，买房子装修等等  
在代码中的场景：  
1、用于扩展一个类的功能或给一个添加附加职责  
2、动态的给一个对象添加功能，这些功能可以再动态的撤销  

### 用代码实现一个煎饼加鸡蛋的过程  
1、创建煎饼类：Battercake  
2、创建一个加鸡蛋的煎饼类，BattercakeWithEgg  
3、创建一个加了鸡蛋和香肠的煎饼类，BattercakeWithEggAndSausage  
4、测试BattercakeTest  

类图如下：  
![iamges](https://github.com/CaoWenCool/MyPattern/blob/master/decorator/image/V1%E7%89%88%E6%9C%AC%E7%9A%84%E7%85%8E%E9%A5%BC%E7%B1%BB%E5%9B%BE.jpg)  
测试结果，但是如果场景更加丰富，我们岂不是要加很多个类，这样一直加不是很合理。  

### 通过装饰者模式来进行优化  
1、创建基础煎饼类：BaseBattercake  
2、创建一个扩展套餐的抽象装饰者BattercakeDecotator类  
3、创建鸡蛋装饰者 EggDecorator  
4、创建香肠装饰者 SausageDeorator类  
5、测试  

类图如下：  
![iamges](https://github.com/CaoWenCool/MyPattern/blob/master/decorator/image/V2%E7%89%88%E6%9C%AC%E7%9A%84%E7%85%8E%E9%A5%BC%E7%B1%BB%E5%9B%BE.jpg)  

### 利用适配器模式实现多种方式登录  
1、创建Member成员类  
2、创建返回类ResultMsg  
3、创建ISigninService接口  
4、创建SigninService实现类  
5、创建第三方登录的接口，集成ISigninService  
6、创建第三方登录的实现类，SigninForThirdService  
7、测试：DecoratorTest  
类图如下：  
![iamges](https://github.com/CaoWenCool/MyPattern/blob/master/decorator/image/%E8%A3%85%E9%A5%B0%E8%80%85%E5%AE%9E%E7%8E%B0%E7%AC%AC%E4%B8%89%E6%96%B9%E7%99%BB%E5%BD%95.jpg)  

装饰者模式最本质的特征就是原有类的附加功能抽离出来，简化原有的逻辑。  

## 装饰者模式和适配器模式对比  
装饰者和适配器模式都是包装模式 ，装饰者模式也是一种特殊的代理模式。    
装饰者模式  
形式：是一种非常特别的适配器模式  
定义：装饰者和被装饰者都实现同一个接口，主要目的是为了扩展之后依旧保留的OOP关系  
关系：满足is-a的关系  
功能：注重覆盖和扩展  
设计：前置考虑  

适配器模式
形式：没有层级关系，装饰器模式有层级关系  
定义：适配器和被适配者没有必然的联系，通常是采用继承或者代理的形式进行包装  
关系：满足has-a的关系
功能：注重兼容、转换  
设计：后置考虑  

## 装饰器模式在源码中的应用  
JDK中最明显的类就是IO相关的类，如BufferedReader\InputStream\OutputStream,  
让我们看下InputStream类  
类结构图如下：  
![iamges](https://github.com/CaoWenCool/MyPattern/blob/master/decorator/image/InputStream%E7%B1%BB%E5%9B%BE.jpg)  
在Spring 中TransactionAwareCacheDecorator类，这个类主要是用来处理事务缓存的  
源代码如下：
`public class TransactionAwareCacheDecorator implements Cache{
    private final Cache targetCache;
    public TransactionAwareCacheDecorator(Cache targetCache){
        Assert.notNull(target,"Target Cache must not be null");
        this.targetCache = targetCache;
        }
        public Cache getTargetCache(){
            return this.targetCache;
        }}`
 TransactionAwareCacheDecorator 就是对Cache的一个包装类，再来看一个MVC中装饰者模式HttpHeadResponseDecorator类
 
 `public class HttpHeadResponseDecorator extends ServletHttpResponseDecorator{
    public HttpHeadResponseDecorator(ServletHttpResponse delegate){
        super(delegate);
        }
        }`
        
再看看Mybatis 中的一段处理缓存的设计,org.apache.ibatis.cache.Cache类，找到他的包定位：  
![iamges](https://github.com/CaoWenCool/MyPattern/blob/master/decorator/image/cache%E5%8C%85.jpg)  
从名字上其实更加容易理解了：比如：FifoCache先入先出算法，LruCache最近最少使用的缓存，TransactionCache事务相关的缓存，
都是采用装饰者模式，

## 装饰者模式的优缺点  
优点  
1、装饰者是继承的有力补充，比继承灵活，不改变原有对象的情况下动态地给一个对象扩展功能，即插即用  
2、通过使用不同装饰类以及这些装饰类的排列组合，可以实现不同的效果  
3、装饰者完全遵守开闭原则  
缺点：
1、会出现更多的代码，更多的类，增加程序复杂性  
2、动态装饰时，多层装饰会更加复杂  
