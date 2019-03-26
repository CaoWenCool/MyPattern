# 设计模式的总结  
## 分类
创建型：工厂方法模式、抽象工厂模式、建造者模式、原型模式、单例模式
结构型：适配器模式、桥接模式、组合模式、装饰器模式、门面模式、享元模式、代理模式  
行为型：解释器模式、模板方法模式、责任链模式、命令模式、迭代器模式、调解者模式、备忘录模式、观察者模式、状态模式、策略模式、
访问者模式  

## 设计模式之间的关联关系和对比  
单例模式和工厂模式  
    实际业务代码中，通常会把工厂类设计为单例模式  

策略模式和工厂模式  
1、工厂模式保安和你你工厂方法模式和抽象工厂模式是创建型模式，策略模式属于行为型模式。
2、工厂模式主要目的是封装好创建逻辑，策略模式就收工厂创建好的队形，从而实现不同的行为。  

策略模式和委派模式  
1、策略模式是委派模式内部的一种实现形式，策略模式关注的结果是能相互替代的  
2、委派模式更关注的分发和调度的过程  

模板方法模式和工厂方法模式  
工厂方法是模板方法的一种特殊的实现  

模板方法模式和策略模式  
1、模板方法和策略模式都有封装算法  
2、模板模式是使不同算法可以相互替换，且不影响客户端应用层的使用  
3、模板方法使针对顶一个算法的流程，将一些有细微差异的部分交给子类实现。  
4、模板方法模式不能改变算法流程，策略模式可以改变算法流程且可替换，策略模式通常可以代理  if..else 等条件分支语句。  

装饰者模式和静态代理模式  
1、装饰者模式关注点在于给对象动态添加方法，而代理更加注重控制对对象的访问。  
2、代理模式通常会在代理类中创建被代理对象的实例，而装饰者模式通常把被装饰者作为构造参数，  

装饰者模式和适配器模式  
1、装饰者模式和适配器模式都属于包装器模式  
2、装饰者模式可以实现被装饰者与相同的接口或者继承被装饰者作为它的子类，而适配器和被适配器可以实现不同的接口。   
装饰者和适配器都是对SiginService的包装和扩展，属于装饰器模式的实现方法。但是装饰者需要满足OOP的is-a关系。适配器主要解决
兼容问题，不一定要统一父类。  
适配器模式和静态代理模式  
适配器可以结合静态代理来实现，保存被适配对象的引用，但不是唯一的实现方式，  
适配器模式和策略模式  
在适配业务复杂的情况下，利用策略模式优化动态适配逻辑。  

##Spring 中常用的设计模式对比  

工厂模式： 只对结果负责，封建创建过程  BeanFactory、Calender
单例模式： 保证独一无二                ApplicationContext Calender  
原型模式： 把一根毫毛，吹出千万个。    ArrayList  PrototypeBean
代理模式： 找人办事、增强职责          ProxyFactoryBean\JdkDynamicAopProxy\CglibAopProxy  
委派模式： 干活算你的（普通员工），功劳算我的（项目经理）  DispatcherServlet\BeanDefinitionParserDelegate  
策略模式： 用户选择，结果统一          InstantiationStrategy  
模板模式： 流程标准化、自己实现定制    JdbcTemplate、HttpServlet  
适配器模式：兼容转换头                 AdvisorAdapter、HandlerAdapter  
装饰器模式：包装、同宗同源             BufferedReader\InputStream\OutputStream\HttpHeadResponseDecorator  
观察者模式：任务完成时通知             ContextLoaderListener  

## Spring 中的编程思想总结  
OOP   Object Oriented Programming 面向对象编程 用程序归纳总结生活中的一切事物      封装、继承、多态  
BOP   Bean Oriented Programming 面向Bean（普通的Java类）设计程序，解放程序员       一切从Bean开始
AOP   Aspect Oriented Programming 面向切面编程 找出多个类中由一定规律的代码，开发时拆开，运行时再合并，面型切面编程即面向规则编程    解耦专人做专事
IOC   Inversion of Control 控制反转 将new对象的动作交给Spring管理，并由Spring保存已经创建的对象（IOC）容器。   转交控制权（即控制 反转）  
DI/IL Dependency Injection(依赖注入)或者Dependency Lookup(依赖查找) 依赖注入、依赖查找，Spring不仅保存自己创建的对象，而且保存对象与对象之间的关系。
   注入赋值，主要有三种构造方法，set方法、直接赋值    赋值
   
## Aop 再Spring中的应用  
SpringAOP 是一种编程范式，主要目的是将非功能性需求从并能性需求中分离出来，达到解耦的目的。主要应用场景：Authentication(权限认证)、
Auto Caching(自动缓存处理)、Error Handling(统一错误处理)、Debugging(调试信息输出)、Logging(日志记录)、Transactions(事务处理)。  
AOP的几个概念：   
1、Aspect（切面）：通常是一个类，里面可以定义切入点和通知。  
2、JoinPoint(连接点)：程序执行过程中明确的点，一般是方法的调用。   
3、Advice(通知)：AOP再特定的切入点上执行的增强处理，有before、after、afterReturning、afterThrowing、around  
4、Pointcut(切入点)：就是待用通知的连接点，在程序中主要体现为写入切入点表达式AOP框架创建的对象，实际就是使用代理目标对象功能增强。
Spring中的AOP代理可以使JDK动态代理，也可以使CGLIB代理，前者基于接口，后者基于子类。  

## 关于Execution 表达式  
    execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)  
modifiers-pattern:方法的操作权限  
ret-type-pattern:返回值（必填）  
declaring-type-pattern:方法所在的包  
name-pattern:方法名【必填】  
parm-pattern:参数名  
throws-pattern：异常  

Annotation配置形式：  
    
    //生命这是一个组件
    @Component
    //声明这是一个切面Bean
    @Aspect
    @Slf4j
    public class AnnotationAspect{
        //配置切入点，该方法没有方法体，主要为方便同类中其他方法使用此处配置的切入点
        @Ponintcut("execution(* com.demo.pattern.spring.aop.service..*(..))")
        public void aspect(){}
        
        /**
        * 配置前置通知，使用再方法aspect()撒谎给你注册的切入点，同时接收JoinPoint切入点对象，可以没有该参数
        **/
        @Before("aspect()")
        public void befor(JoinPoint joinPoint){
            log.info("before通知"+joinPoint);
        }
        
        //配置后置通知，使用方法再aspect（）上注册的切入点
        public void after(JoinPoint joinPoint){
            log.info("after通知"+joinPoint);
        }
        
        //配置环绕通知，使用方法再aspect（）上注册的切入点
        @Arount("aspect()")
        public void around(JoinPoint joinPoint){
            long start = System.currentTimeMills();
            try{
                ((ProceeedingJoinPoint) joinPoint).proceed();
                long end = Sytem.currentTimeMills();
                log.info("around通知"+jointPoint + "\tUser time:"+（end-start）="ms!");
            }catch(Throwable e){
                long end = System.currentTimeMills();
                log.info("around通知"+joinPoint + "\tUse time"+(end - start)+"ms with execption:"+e.getMessage);
            }
        }
        
        @AfterReturning("aspect()")
        public void afterReturn(JoinPoint joinPoint){
            log.info("afterReturn 通知"+ joinPoint);
        }
        
        //配置抛出异常后通知，使用再方法aspect()上注册的切入点
        @AfterThrowing(pointcut="aspect()",throwing="ex")
        public void afterThrow(JoinPoint joinPoint,Exception ex){
            log.info("afterThrow通知"+joinPoint + "\t"+ex.getMessage());
        }
    }
    
XML配置形式：
    
    <bean id="xmlAspect" class = "com.demo.pattern.spring.aop.aspect.XmlAspect"></bean>
    <!-- AOP -->
    <aop:config>
        <!-- 生命一个切面，并注入切面Bean,相当于@Aspect -->
        <aop:aspect ref="xmlAspect">
            <!- 配置一个切入点，相当于@Pointcut
            <aop:pointCut expression = "execution(* com.demo.pattern.spring.aop.serice.. *(...))" id = "simplePointcut"/>
            <!-- 配置通知，相当于@Before \@After @AfterReturn @Around @AfteerThrowing -->
            <aop:before poingcut-ref="simplePointcut" method="befoire"/>
            <aop:after ponint-cref="simplePointcut" method="afterReturn"/>
            <aop:after-return pointcut-ref="simplePointcut" method="afterReturn"/>
            <aop:after-throwing pointcut-ref="simplementcut" method = "afterThrow" throwing="ex"/>
        </aop:aspect>
    </config>