#适配器模式
##应用场景
适配器模式是指将一个类的接口转换成客户期望的另一个接口，是原本的接口不兼容的类可以一起工作，属于结构型设计模式。
适配器模式适用于以下几种场景：
1 已经存在的类，它的方法和需求不匹配（方法或结果相同或者相似）的情况。
2 适配器模式不是软件设计阶段考虑的设计模式，是随着软件维护，由于不同产品、不同厂家造成功能类似而接口不相同的情况下的解决方案。

##利用适配器模式，扩展第三方登录
1、创建统一的返回结果类：ResultMsg
2、假设老系统的登录逻辑时SiginService
3、为了遵循开闭原则，老系统的代码不要修改。重构过程中我们创建Member类
4、创建一个新的类继承原来的逻辑，运行非常稳定的代码我们不去改动 :SigninForThirdService extends SiginService
5、通过这么一个简单的适配，就完成了代码的兼容，当然我们还可以更加优化，根据不同的登录方法，创建不同的Adapter
6、创建LoginAdapter接口
7、创建不同的的登录方式类，实现LoginAdapter接口
8、创建第三方登录兼容接口：IPassportForThird
9、实现兼容的PassportForThirdAdapter

以下为类图：
![images](https://github.com/CaoWenCool/MyPattern/blob/master/adapter/image/%E9%80%82%E9%85%8D%E5%99%A8%E6%A8%A1%E5%BC%8F%E7%B1%BB%E5%9B%BE.jpg)


##适配器模式在源码中的体现
Spring中适配器模式应用也是非常广泛，例如：SpringAOP中，AdvisorAdapter类，它有三个实现类MethodBeforeAdviceAdapter
、AfterReturningAdvice、ThrowsAdviceAdapter，先看顶层接口AdvisorAdapter的源代码

    public interface AdvisorAdapter{
        boolean supportAdvice(Advice var1);
        MethodInterceptor getInterceptor(Advisor var1);
    }
    
 再看MethodBeforeAdviceAdapter
     
     class MethodBeforeAdviceAdapter implements AdvisorAdapter,Serializable{
        MethodBeforeAdviceAdapter(){
        public boolean supportsAdvice(Advice advice){
            return advice instanceof MethodBeforeAdvice;
        }
        public MethodInterceptor getInterceptor(Advisor advisor){
            MethodBeforeAdvice advice = (MethodBeforeAdvice)advisor.getAdvice();
            return new MethodBeforeAdviceInterceptor(advice);
            }
        }
    }
    

Spring 会根据不同的AOP配置来确定使用对应的Advice，跟策略模式不同的一个方法拥有多个Advice。
接下来我们来看一个SpringMVC中的HandlerAdapter类，他也有过个多个子类，类图如下：
![images](https://github.com/CaoWenCool/MyPattern/blob/master/adapter/image/HandlerAdapter.jpg)

其适配调用的关键代码还是在DispatcherServlet的doDispatch（）方法中，接下来我们看下源码：
    
    protected void doDispatch(HttpServletRequest request,HttpServletResponse response)throws Exception{
        HttpServletRequest processedRequest = request;
        HandlerEecutionChain mappedHandler = null;
        boolean multipartRequestParsed = false;
        WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);
        try{
            try{
                ModelAndView mv = null;
                Object dispatchException = null;
                try{
                    processedRequest = this.checkMultipart(request);
                    multipartRequestParsed = processedRequest != request;
                    mappedHandler = this.getHandler(processedRequest);
                    if(mappedHandler == null){
                        this.noHandlerFound(processedRequest,response);
                        return;
                    }
                    
                    HandlerAdapter ha = this.getHandlerAdapter(mappedHandler.getHnadler());
                    String medthod = request.getMethod();
                    boolean isGet = "GET".equals(method);
                    if(isGet || "HEAD".equals(method)){
                        long lastModified = ha.getLastModified(request,mappedHandler.getHandler());
                        if(this.logger.isDebugEnabled()){
                            this.logger.debug("Last-Modified value for ["+getRequestUrl(request)+"] is:"+lastModified);
                        }
                        
                        if((new ServletWebRequest(request,response)).checkNotModified(lastModified)){
                         && isGet{
                            return;
                         }
                        }
                        if(!mappedHandler.applyPreHandle(processedRequest,respone)){
                            return;
                        }
                        
                        mv = ha.handle(processedRequest,response,mappedHandler.getHandler());
                        if(asyncManager.isConcurrentHandlingStarted()){
                            return;
                        }
                        
                        this.applyDefaultViewName(processedRequest,mv);
                        mappedHandler.applyPostHandle(processedRequest,response,mv);
                    }catch(Exception var20){
                        dispatchException = var20;
                    }catch(Throwable var21){
                        dispatchException = new NestedServletException("Handler dispatcher failed",var21);
                    }
                    this.processDispatchResult(processedRequest,response,mappedHnadler,mv,(Exception)dispatchException);
                }catch(Exception var22){
                    this.triggerAfterCompletion(processedRequest,response,mappedHandler,var22);
                }catch(Throwable var23){
                    this.triggerAfterCompletion(processedRequest,response,mappedHandler,new NestedServletException(
                    "Hnadler processing failed",var23));
                }
            }finally{
                if(asyncManager.isConcurentHnadlingStarted()){
                   if(mappedHnadler != null){
                        mappedHandler.applyAfterConcurrentHandlingStarted(processedRequest,response);
                   }
                }else if(multipartRequestParsed){
                    this.cleanupMultipart(processedRequest);
                }
            }
        }
    }

在doDispatch()方法中调用了getHandlerAdapter()方法，代码如下：

    protedted HandlerAdapter getHandlerAdapter(Object handler)throws ServletException{
        if(this.handlerAdapters != null){
            Iterator var2 = this.handlerAdapters.iterator();
            
            while(var.hasNext()){
                HandlerAdapter ha = (HandlerAdapter)var.next();
                if(this.logger.isTraceEnabled()){
                    this.logger.trace("Testing handler adapter ["+ ha + "]");
                }
                
                if(ha.supports(handler)){
                    return ha;
                }
            }
        }
        
        throw new ServletException("No adapter for handler ["+handler+"]:The DispatcherServlet configuration needs to
        to include a HandlerAdapter that supports this handler");
    }
    
在getHandlerAdapter（）中循环调用了supports()方法，判断是否兼容，循环迭代集合中的Adapter又是初始化时早已赋值。


##适配器模式的优缺点
优点：
1、能提高类的透明性和复用，现有的类复用不需要改变
2、目标类和适配器类解耦，提高程序的扩展性
3、在很多业务场景中符合开闭原则

缺点：
1、适配器编写过程中需要全面考虑，可能会增加系统的复杂性
2、增加代码阅读难度，降低代码可读性，过多使用适配器会使系统代码变得凌乱。
