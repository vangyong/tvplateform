package com.wisesoft.demo.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJava8New {

	static int[] arr = { 1, 3, 4, 5, 6, 7, 8, 9, 10 };

	public static void main(String[] args) {

		// 函数式编程
		// Arrays.stream(arr).map((x)->x=x+1).forEach(System.out::println);
		// System.out.println();
		// Arrays.stream(arr).forEach(System.out::println);

		//String separator = ",";
		//Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator));
		
		List a = new ArrayList();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("d");
		a.forEach((e)->System.out.println(e));
		
		
	}

}
