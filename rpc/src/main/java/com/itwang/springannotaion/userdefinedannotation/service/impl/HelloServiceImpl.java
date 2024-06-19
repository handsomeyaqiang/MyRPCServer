package com.itwang.springannotaion.userdefinedannotation.service.impl;

import com.itwang.springannotaion.userdefinedannotation.annotation.RpcService;
import com.itwang.springannotaion.userdefinedannotation.service.HelloService;

@RpcService("helloService")
public class HelloServiceImpl implements HelloService {
    public String hello(String name) {
        return "Hello! " + name;
    }
    
    public void test(){
    	System.out.println("test");
    }
}
