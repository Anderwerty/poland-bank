package com.poland.bank.injector;

import com.poland.bank.controller.MethodMap;
import com.poland.bank.controller.RequestMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterForControllers {

    public Map<String, MethodMap> register(Object... controllerInstances) {
        Map<String, MethodMap> urlToMethodMap = new HashMap<>();
        for (Object controllerInstance : controllerInstances) {
            Class<?> clazz = controllerInstance.getClass();
            Method[] methods = clazz.getMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                    urlToMethodMap.put(annotation.url(), new MethodMap(controllerInstance, annotation.method(),method));
                }
            }
        }

        return urlToMethodMap;
    }

}
