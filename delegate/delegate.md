#委派模式
##委派模式的定义及应用场景
委派模式不属于23种设计模式中，委派模式的基本作用就是负责任务的调度和分配任务，跟代理模式模式很像，可以看做是一种特殊情况下的静态
的全权代理，但是代理模式注重的是过程，而委派模式注重的是结果。委派模式在Spring中应用的非常多，大家常用的DispatcherServlet
其实就是用到了委派模式。显示生活中也常有委派的场景发生，例如：老板给项目经理下达任务，项目经理会根据实际情况给每个员工派发工作
任务，待员工把工作任务完成之后，再由项目经理汇报工作进度和结果。下面为该业务场景的类结构图
![images](https://github.com/CaoWenCool/MyPattern/blob/master/delegate/image/%E8%80%81%E6%9D%BF%E5%A7%94%E6%B4%BE%E7%9A%84%E7%B1%BB%E7%BB%93%E6%9E%84%E5%9B%BE.jpg)
####具体过程
1、创建IEmployee接口
2、创建员工类IEmployeeA类
3、创建员工类IEmployeeB类
4、创建项目经理Leader类
5、创建Boss类下达命令

##委派模式在源码中的体现
下面我们来还原一下SpringMVC的DispatcherServlet是如何实现委派模式的，

1、创建业务类MemberController
2、创建OrderController类
3、创建SystemController类
4、创建DispatcherServlet类
5、配置web.xml文件
    如下：
   
    <?xml version="1.0" encoding="UTF-8"?>
     <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:javaee="http://java.sun.com/xml/ns/javaee"
             xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
             xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd"
             version="2.4">
        <display-name>Gupao Web Application</display-name>
        <servlet>
            <servlet-name>delegateServlet</servlet-name>
            <servlet-class>com.demo.mvc.DispatcherServlet</servlet-class>
            <load-on-startup>1</load-on-startup>
        </servlet>
        <servlet-mapping>
            <servlet-name>delegateServlet</servlet-name>
            <url-pattern>/*</url-pattern>
        </servlet-mapping>
    </web-app>
    
一个完整的委派模式就出现了。当然在Spring中运用到委派模式不仅如此，还有很多。在Spring源码中，只要以Delegate结尾的都是实现了委派
模式。例如：BeanDefinitionParserDelegate根据不同类型委派不同逻辑解析BeanDefinition
