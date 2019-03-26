package com.demo.delegate.mvc;

import com.demo.delegate.mvc.controller.MemberController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:37
 * @version: V1.0
 * @detail:
 **/
public class DispatcherServlet extends HttpServlet {
    public List<Handler> handlerMapping = new ArrayList<Handler>();

    public void init() throws ServletException {
        try {

            Class<?> memberControllerClass = MemberController.class;
            handlerMapping.add(new Handler()
                    .setController(memberControllerClass.newInstance())
                    .setMethod(memberControllerClass.getMethod("getMemberById", new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void doDispatch(HttpServletRequest request, HttpServletResponse response) {
        //获取用户请求的url
        //如果按照J2EE的标准，每个url对应一个Servlet，url由浏览器输入
        String url = request.getRequestURI();

        //Servlet拿到url之后，要做权衡，要判断要选择
        //根据用户请求的url，去找到这个url对应的某各java类的方法

        //通过拿到的url去HandlerMapping
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (url.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }

        //4 将具体的任务分发给method 通过反射去调用其对应的方法
        Object obj = null;
        try {
            obj = handler.getMethod().invoke(handler.getController(), request.getParameter("mid"));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        //5 获取Method执行的结果，通过Response返回回去
//        response.getWriter().write();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doDispatch(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class Handler {
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }

    }
}
