#策略模式
策略模式是指定义了算法家族，分别封装起来，让他们之间可以互相替换，此模式算法的变化不会影响到使用算法的用户
##应用场景
1、假如系统中有很多类，而他们的区别仅仅在于他们的行为不同。
2、一个系统需要动态地在几种算法中选择一种。

用策略模式实现支付场景：
1、首先创建一个促销策略的抽象：PromotionStrategy
2、然后创建优惠券策略类：CouponStrategy 和各种活动促销类：CashBackStrategy\GroupbuyStrategy\EmptyStrategy
3、创建促销活动方案：PromotionActivity类
4、结合单例模式和工厂模式，创建PromotionStrategyFactory类

###以选择支付方式为例讲解策略模式
支付方式策略模式类结构图如下：
![images](http://git.gupaoedu.com/caowen/pattern/blob/master/strategy/image/%E6%94%AF%E4%BB%98%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F%E7%B1%BB%E7%BB%93%E6%9E%84%E5%9B%BE.jpg)
具体过程：
1、创建Payment抽象类，定义支付规范和支付逻辑
2、分别创建具体的支付方式：例如AliPay
3、创建支付状态的包装类：MsgResult
4、创建策略模式的管理类：PayStrategy
5、创建订单类：Order

##策略模式在JDK源码中的体现
首先来看一个比较常用的比较器Comparator接口，看一个非常熟悉的方法 compare()，就是一个策略抽象的实现
   
    public interface Comparator<T>{
        int compare(T o1,T o2);
    }
Comparator 抽象下面有非常多的实现类，我们经常会把Comparator作为参数传入作为排序策略，例如Arrays类的parallelSort方法
    
    public class Arrays{
    ......
    public static<T> void paralleSort(T[] a,int formIndex,int toIndex,Comparator<? super T> cmp){
        ....
    }
    ....
    }
    
还有TreeMap的构造方法
    
    public class TreeMap<K,V> extends AbstractMap<K,V> implements NavigableMap<K,V>.Cloneable,java.io.Serializable{
        public TreeMap(Comparator<? super K> comparator){
            this.compatator = comparator;
        }
    }
侧库尔模式在Spring源码中的应用，来看下Resource类

    public interface Resource extends InputStreamSource{
        boolean exists();
        default booelan isReadable(){
            return true;
        }
        default boolean isOpen(){
            return false;
        }
        default boolean isFile(){
            return false;
        }
        
       URL getURL()throws IOException;
       URI getURI()throws IOException;
       File getFile() throws IOException;
       
       default ReadableByteChannel readableChannel()throws IOException{
            return Channels.newChannel(this.getInputStream());
       }
       long contentLength() throws IOException;
       long lastModified() throws IOException;
       
       Resource createRelative(String var1)throws IOException;
       @Nullable
       String getFilename();
       
       String getDescription();
    }
    
 我们虽然没有直接使用Resource类，但是经常使用它的子类例如：
 ![images](http://git.gupaoedu.com/caowen/pattern/blob/master/strategy/image/Spring%E7%9A%84Resource%E5%AD%90%E7%B1%BB.jpg)
 
 还有一个经典场景，Spring的初始化也采用了策略模式，不同类型的类采用不同的初始化策略。
首先看一下InstantiationStrategy接口
     
     public interface InstantiationStrategy{
        Object instantiate(RootBeanDefinition var1,@Nullable String var2,BeanFactory var3)throws BeanException;
        
        Object instantiate(RootBeanDefinition var1,@Nullable String var2,BeanFactory var3,Constructor<?> var4,
            @Nullable Object...var5)throws BeanExeption;
        
        Object instantiate(RootBeanDefinition var1,@Nullable String var2,BeanFactory var3,@NullableObject var4,
        Method var5,@Nullable Object...var6)throws BeansException;
     }
     
     
顶层的策略抽象非常简单，但是它下面有两种策略SimpleInstantiationStrategy和CglibSubclassingInstantiationStrategy
类图如下：
![images](http://git.gupaoedu.com/caowen/pattern/blob/master/strategy/image/InstantiationStrategy%E7%B1%BB%E5%9B%BE.jpg)

打开类图，我们还发现CglibSubclassingInstantiationStrategy策略类还继承了SimpleInstantiationStrategy类，说明在实际应用中多种
策略模式还可以继承使用。

##策略模式的优缺点
优点：
1 策略模式符合开闭原则
2 避免使用多重条件转移语句
3 使用策略模式可以提高算法的保密性和安全性
缺点：
1 客户端必须知道所有的策略，并且自行决定使用哪一个策略类
2 代码中非常多策略类会增加维护难度

