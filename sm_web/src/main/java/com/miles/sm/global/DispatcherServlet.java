package com.miles.sm.global;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Miles
 * @date 2020/12/26 23:08
 */
public class DispatcherServlet extends GenericServlet {
    private ApplicationContext context;
    public void init() throws ServletException {
        super.init();
        context=new ClassPathXmlApplicationContext("spring.xml");
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getServletPath().substring(1);
//        System.out.println(path);
        String beanName = null;
        String methodName = null;
        int index=path.indexOf("/");
        if (index!=-1){
            beanName=path.substring(0,index)+"Controller";
            methodName = path.substring(index + 1, path.indexOf(".do"));
            System.out.println(beanName+":"+methodName);
        }else {
            beanName="selfController";
            methodName=path.substring(0,path.indexOf(".do"));
            System.out.println("selfController:"+methodName);
        }
        Object obj=context.getBean(beanName);
        try {
            Method method = obj.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(obj,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
