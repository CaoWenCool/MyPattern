#代理模式
##应用场景
在生活中，我们经常见到这样的场景：租房中介，售票黄牛，婚介，经纪人，快递，事务代理，非侵入式日志监听等。这些都是代理模式的实际
体现。代理模式的定义也非常简单，是指为其他对象提供一种代理，以控制这个对象的访问。代理对象在客户端和目标对象之间起到中介作用，
代理模式属于结构型设计模式。使用代理模式主要有两个目的：一保护目标对象，二增强目标对象。
如下为：代理模式的类结构图：
![images](http://git.gupaoedu.com/caowen/pattern/blob/master/proxy/image/%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F%E7%B1%BB%E7%BB%93%E6%9E%84%E5%9B%BE.jpg)
Subject 是顶层接口，RealSubject是真实对象（被代理对象），Proxy是代理对象，代理对象持有被代理对象的引用，客户端调用
代理对象方法，同时也调用被代理对象的方法，但是在代理对象前后增加一个处理。在代码中，我们想到代理，就会理解为是代理增强
，其实就是在原本逻辑前后增加一些逻辑，而调用者无感知。代理模式属于结构型模式，有静态代理和动态代理

##静态代理
###实际的应用场景：
在分布式业务场景中，我们通常会对数据库进行分库分表，分库分表之后使用java操作时，就可能需要配置多个数据源，我们通过
设置数据源路由来动态切换数据源。
1、首先创建Order订单实体： 项目中的Order类
2、创建OrderDao持久层操作类：OrderDao
3、创建IOrderService接口
4、创建OrderService实现类
5、接下来使用静态代理，主要完成的功能是，根据订单创建时间自动按照年进行分库。根据开闭原则，原来写好的逻辑我们不去修改
通过代理对象来完成。先创建数据源路由对象，我们ThreadLocal的单例来时间，DynamicDataSourceEntry类：
6、创建切换数据源的代理OrderServiceStaticProxy类

下图为：静态代理的类结构图
![images](http://git.gupaoedu.com/caowen/pattern/blob/master/proxy/image/%E9%9D%99%E6%80%81%E4%BB%A3%E7%90%86%E7%B1%BB%E7%BB%93%E6%9E%84%E5%9B%BE.jpg)


##动态代理
动态代理和静态对比基本思路是一致的，只不过动态代理功能更加强大，随着业务的扩展适应性更强。如果还以找对象为例，使用
动态代理相当于是能够适应更加复杂的业务场景。
里婚介所为例进行实现：
###JDK实现动态代理的方式
1、创建媒婆（婚介）：JDKMeipo类
2、创建单身的客户：Customer类
就完成了动态动态代理的一个业务：
我们再来看数据源动态路由业务，用动态代理来实现
1、创建动态代理类：OrderServiceDynamicProxy,
依然能够达到相同的运行效果，但是动态代理实现之后，我们不仅能时间Order的数据源动态路由，还可以实现其他任何类的数据源
路由。当然，有比较重要的约定，必须要实现getCreateTime()方法，因为路由规则而是根据时间来运算的。当然我们可以通过接口规范
来达到约束的目的。
### 高仿真的JDK Proxy
我们通过模仿JDK Proxy自己动手写一个属于自己的动态代理
我们知道JDK Proxy 采用字节重组，重新生成的对象来代替原始的对象以达到动态代理的目的。JDK Proxy生成对象的步骤如下：
1、拿到被代理对象的引用，并且获取到它的所有的接口，反射获取。
2、JDK Proxy类重新生成一个新的类，同时新的类要实现被代理类所有实现的所有的接口。
3、动态生成JAVA代码，把新增加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
4、编译新生成的JAVA代码.class
5、再重新加载到JVM中运行
以上的这个过程就叫字节码重组。JDK中有一个规范，在ClassPath下只要是$开头的class文件一般都是自动生成的。那么我们有没有
办法看到代替后的对象的真容呢？我们可以从内存中的对象字节码通过文件流输出到一个新的Class文件，然后，利用反编译工具
查看Class的源代码
运行之后，我们就可以在指定的位置看到我们的$Proxy0.class文件。使用JAD反编译，得到$Proxy0.jad文件。
打开文件之后，我们发现$Proxy0继承了Proxy类，同时还实现了我们的Person接口，而且重写了findLove()方法。而且在静态块中
用反射调用目标对象的所有方法，而且保存了所有方法的引用。在重写方法用反射调用目标对象的方法。其实这些代码都是JDK帮助自动
生成的。我们我们不依赖JDK自己动手来实现动态生成源代码，动态完成编译，然后，替代目标对象并执行
1、创建GPInvocationHandler接口
2、创建GPProxy类
3、创建GPClassLoader类
4、创建GPMeipo类
5、然后进行测试
到此手写JDK动态代理就完成了

###CGLib调用API及原理分析
我们还是应用媒婆的实际应用场景
1、创建CglibMeipo类
2、创建单身客户Customer类
 注意：CGLib代理的目标对象不需要实现任何接口，它是通过动态继承目标对象实现的动态代理。
然后进行测试
CGLib的实现原理又是怎么样的呢？我们可以将测试代理代码上加上一句，将CGLib代理后的class写入磁盘，然后在再反编译
通过分析反编译文件，
我们知道重新了Customer类的所有方法，我们通过代理类的源码就可以看到，代理类会获得所有在父类继承来的方法，并且会有
MethodProxy与之对应。
调用过程：代理对象调用this.findLove()方法 -》 调用拦截器 -》 methodProxy.invokeSuper -》 CGLib$findLove$0
-》被代理对象findLove()方法。
此时，我们发现拦截器MethodIntercepto中就是由MethodProxy的invokeSuper方法调用代理方法的。MethodProxy
非常关键。
我们分析一下它具体做了什么

    public class MethodProxy{
        private Signature sig1;
        private Signature sig2;
        private MethodProxy.CreateInfo createInfo;
        private final Object initLock = new Object();
        private volatile MethodProxy.FastClassInfo fastClassInfo;
        
       public static MethodProxy create(Class c1,Class c2,String desc,String name1,String name2){
            MethodProxy proxy = new MethodProxy();
            proxy.sig1 = new Signature(name1,desc);
            proxy.sig2 = new Signature(name2,desc);
            proxy.createInfo = new MethodProxy.CreateInfo(c1,c2);
            return proxy;
       }
       
       
       private static class CreateInfo{
            Class c1;
            Class c2;
            NamingPolicy namingPolicy;
            GeneratorStrategy strategy;
            boolean attemtLoad;
            
            public CreateInfo(Class c1,Class c2){
                this.c1 = c1;
                this.c2 = c2;
                AbstractClassGenerator formEnhancer = AbstractClassGenerator.getCurrent();
                if(formEnhancer != null){
                    this.namingPolicy = formEnhancer.getNamingPolicy();
                    this.strategy = fromEnhancer.getStategy();
                    this,attempLoad = formEnhancer.getAttemptLoad();
                }
            }
       
       }
    }
    
继续查看 invokeSuper()方法
    
    public Object invokeSuper(Object obj,Object[] args) throws Throwable{
        try{
            this.init;
            MethodProxy.FastClassInfo fci = this.fastClassInfo;
            return fci.f2.invoe(fci.v2,obj,args);
        }catch(InvocationTargetException var4){
            throw var4.getTargetException();
        }
    }
    
    private static class FastClassInfo{
        FastClass f1;
        FastClass f2;
        int i1;
        int i2;
        private FastClassInfo(){
        
        }
    }
    
上面代码调用过程就是获取代理类对应的FastClass，并执行了代理方法。



CGLib 动态代理执行代理方法效率之所以比JDK的高就是因为CGLib采用了FastClass机制，它的原理简单来说就是：为代理
类和别代理类各生成一个Class，这个Class会为代理类会被代理类的方法分配一个index(int 类型)。这个index当做一个入参
FastClass就可以直接定位要调用的方法进行调用，这样省去了发射调用，所以调用效率比JDK动态代理通过反射要高。

FastClass 并不是跟着代理类一块生成的，而是在第一次执行MethodProxy invoke/invokeSuper时生成的并放在缓存中

    //MethodProxy invoke/invokeSuper都调用了init（）
    public void init(){
        if(this.fastClassInfo == null){
            Object var1 = this.initLock;
            synchronized(this.initLock){
                if(this.fastClassInfo == null){
                    MethodProxy.CrateInfo ci = this.createInfo;
                    MethodProxy.FastClassInfo fci = new MethodProxy.FastClassInfo();
                    fci.f1 = helper(ci,ci,c1);//如果缓存中就取出，没有就生成新的FastClass
                    fci.f2 = helper(ci,ci.c2);
                    fci.i1 = fci.f1.getIndex(this.sig1);//获取方法的index
                    fci.i2 = fci.i2.getIndex(this.sig2);
                    this.fastClassInfo = fci;
                }
            }
        }
    }
    
 至此，CGLib动态代理的原理我们就基本搞清楚了，
 
 ####CGLib和JDK动态代理对比
 1、JDK动态代理是实现了被代理对象的接口，CGLib是继承了被代理对象
 2、JDK和CGLib都是在运行期生成字节码，JDK是直接写Class字节码，CGLib使用ASM框架写Class字节码，CGLib代理实现
 更加复杂，生成代理类比JDK效率低
 3、JDK调用代理方法，是通过反射机制调用，CGLib是通过FastClass机制直接调用方法，CGLib执行效率更高。
 
 ##代理模式和Spring
 ###代理模式在Spring源码中的应用
 先看ProxyFactoryBean核心的方法就是getObject()方法
 源码如下：
    
    public Object getObject() throws BeansException{
        initializeAdvisorChain();
        if(isSingleton()){
            return getSingletonInstance();
        }else{
            if(this.targetName == null){
                logger.warn();
            }
            
            return newPrototypeInstance();
        }
    }
    
 在getObject()方法中，主要调用getSingletonlnstance()和newPrototypeInstance();
 在Spring配置中，如果不做任何设置，那么Spring代理生成的Bean都是单例对象。
 如果修改Scope则每次创建一个新的原型对象。newPrototypeInstance()里面的逻辑比较复杂，
 Spring 利用动态代理实现AOP有两个非常重要的类，一个JdkDynamicAopProxy类和CglibAopProxy类，
 如下为类结构图：
    ![images](http://git.gupaoedu.com/caowen/pattern/blob/master/proxy/image/Spring%E7%B1%BB%E7%BB%93%E6%9E%84%E5%9B%BE.jpg)
####Spring 中代理选择原则
1、当Bean有实现接口时，Spring就会用JDK动态代理
2、当Bean没有实现接口时，Spring 选择CGLib
3、Spring 可以通过配置强制使用CGLib，只需要在Spring的配置文件中加入如下代码
   
    <aop:aspectj-autoproxy proxy-target-class = "true"/>
    
##静态代理与动态代理的本质区别
1、静态代理只能通过手动完成代理操作，如果静态代理类增加新的方法，代理类需要同步增加，违背了开闭原则
2、动态代理采用运行时动态生成代码的方式，取消了对被代理类的扩展限制，遵循开闭原则
3、若动态代理要对目标类的增强逻辑扩展，结合粗略模式，只需要新增策略类便可完成。无需修改代理类的代码

##代理模式的优缺点
优点：
    1、代理模式能将代理对象与真实被调用的目标对象分离
    2、一定程度上降低了系统的耦合度，扩展性好
    3、可以起到保护目标对象的作用
    4、可以对目标对象的功能增强。
缺点：
    1、代理模式会造成系统设计类中的数量增加
    2、在客户端和目标对象增加一个代理对象，会造成请求处理速度变慢
    3、增加了系统的复杂度
    