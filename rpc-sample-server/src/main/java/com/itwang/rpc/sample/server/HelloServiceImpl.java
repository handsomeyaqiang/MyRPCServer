package com.itwang.rpc.sample.server;

import com.itwang.rpc.server.RpcService;
import com.itwang.rpc.simple.interfaces.HelloService;
import com.itwang.rpc.simple.interfaces.Person;

@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
    	System.out.println("已经调用服务端接口实现，业务处理结果为：");
    	System.out.println("Hello! " + name);
        return "Hello! " + name;
    }

    public String hello(Person person) {
    	System.out.println("已经调用服务端接口实现，业务处理为：");
    	System.out.println("Hello! " + person.getFirstName() + " " + person.getLastName());
        return "Hello! " + person.getFirstName() + " " + person.getLastName();
    }
}
