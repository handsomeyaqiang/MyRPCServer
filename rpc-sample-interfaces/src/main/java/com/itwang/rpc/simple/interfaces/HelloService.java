package com.itwang.rpc.simple.interfaces;

public interface HelloService {

    String hello(String name);

    String hello(Person person);
}
