package com.itwang.springannotaion.springrunorder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class One implements ApplicationContextAware ,InitializingBean {
	public One(String one) {
		System.out.println(one);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
			System.out.println("setApplicationContext");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}
}
