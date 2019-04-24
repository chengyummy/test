package com.baidu.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author : cym
 * @Date : 2019/4/14 17:06
 * urlPatterns = "/user"-->当前SpringMVC映射请求，就是客户端访问这个http://localhost:8080/user的请求都让这个处理
 * initParams = {@WebInitParam(name = "load",value = "abc.xml")}servlet初始化相关参数
 */
@WebServlet(name = "springmvc",
        urlPatterns = "/iuser",  //可以多写几个{"/user","/hello"}
        initParams = {@WebInitParam(name = "load",value = "abc.xml")},
        loadOnStartup = 1
        )
public class UserServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("当loadOnStartup=1不配置,则这个方法在servlet容器启动后,用户第一次访问servlet前会执行一次,且只执行一次");
        System.out.println("当loadOnStartup=1配置后,则这个方法在servlet容器启动后,就执行这个方法,且执行一次");
        String load = config.getInitParameter("load");
        System.out.println(load);//可以获取对应的值abc.xml
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
