package com.itwang.springannotaion.springrunorder;

import org.springframework.stereotype.Component;

@Component
public class Three {
	public Three() {
		System.out.println("three");
	}
	public Three(String three) {
		System.out.println(three);
	}
}
