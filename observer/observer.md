# 监听模式  
## 应用场景
观察者模式定义了对象之间的一对多关系，让多个观察者对象同时监听一个主体对象，当主体对象发生变化时，它的所有依赖者（观察者）
都会收到通知并更新，属于行为型模式。观察者模式优势也叫做发布订阅模式。观察者模式主要用于在关联行为之间简历一套触发机制的
场景。观察者模式在现实生活中应用也是非常广泛。比如：微信朋友圈动态，邮件通知，广播通知，桌面程序的事件响应  

下面以提问社区，并指定某人回答来模拟应用场景  
1、创建AdviceObserver  
2、创建Question类  
3、创建Teacher类  
4、测试  

java.awt.Event 讲解观察者模式  
1、创建Event类  
2、创建EventLisenter类  
3、创建MouseEventType  
4、创建Mouse类  
5、创建回调MouseEventCallBack类型  
6、测试  

## 观察者模式在源码中的应用
来看一下Spring中的ContextLoaderListener实现了ServletContextListener接口，ServletContextListener接口又继承了
EventListener,在JDK中EventListener又非常广发的应用。我们看一下源代码：ContextLoaderListener:

    public class ContextLoaderListener extends ContextLoader implements ServletContextListener{
        public ContextLoaderListener(){
        }
        
        public ContextLoaderListener(WebApplicationContext context){
            super(context);
        }
        
        public void contextInitialized(ServletContextEvent event){
            this.initWebApplicationContext(event.getServletContext());
        }
        
        public void contextDestroyed(ServletContextEvent event){
            this.closeWebApplicationContext(event.getServletContext());
            ContextCleanupListener.cleanupAttributes(event.getServletContext());
        }
    }
    
ServletContextListener:
    
    public interface ServeltContextListener extends EventListener{
        public void contextInitialized(ServletContextEvent sce);
        public void contextDestroyed(ServletContextEvent sce);
    }
    
EventListener:
    
    public interface EventListener{
    }
    
## 基于Guava API轻松落地观察者模式  
引入依赖  
    
    <dependency>
        <groupId>com.google.guava</groupId>
        <artifactId>guava</artifactid>
        <version>20.0</version>
    </dependency>
    
 创建侦听事件 GuavaEvent  
 测试  
 
## 观察者模式的优缺点  
优点 ：
1、观察者和被观察者之间建立了一个抽象的耦合  
2、观察者模式支持广播通信  

缺点：  
1、观察者之间有过多的细节依赖，提高实际那消耗及程序的复杂度  
2、使用要得当，要避免循环调用  
 