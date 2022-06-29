package com.poland.bank.controller;

import java.lang.reflect.Method;

public class MethodMap {
    private final Object controllerInstance;
    private final Methods methodType;
    private final Method method;

    public MethodMap(Object controllerInstance, Methods methodType, Method method) {
        this.controllerInstance = controllerInstance;
        this.methodType = methodType;
        this.method = method;
    }

    public Object getControllerInstance() {
        return controllerInstance;
    }

    public Methods getMethodType() {
        return methodType;
    }

    public Method getMethod() {
        return method;
    }
}
