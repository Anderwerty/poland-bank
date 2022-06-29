package com.poland.bank.controller;

import com.poland.bank.injector.ContextInjector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


//DispatcherServlet is from Spring MVC, it is Front Controller
public class DispatcherServlet extends HttpServlet {
    private static final Map<String, MethodMap> URL_TO_METHOD_MAP = ContextInjector.URL_TO_METHOD_MAP;
    // init. work, destroy

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String httpMethod = req.getMethod();
        String uri = req.getRequestURI();

        Map<String, MethodMap> urlToMethodMap = URL_TO_METHOD_MAP;

        MethodMap methodMap = urlToMethodMap.get(uri);

        Method method = methodMap.getMethod();
        Object controller = methodMap.getControllerInstance();
        Methods methodType = methodMap.getMethodType();

        if (httpMethod.equalsIgnoreCase(methodType.name())) {
            try {
                method.invoke(controller, req, resp);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

// bank/transaction/all - GET
// bank/transaction/{id} -GET
// bank/transaction - POST

