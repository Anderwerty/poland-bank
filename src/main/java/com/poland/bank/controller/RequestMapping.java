package com.poland.bank.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface RequestMapping {
    String url();
    Methods method();
}

enum Methods{
    GET,POST,PUT
}
