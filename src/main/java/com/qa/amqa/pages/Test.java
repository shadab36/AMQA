package com.qa.amqa.pages;

import io.qameta.allure.internal.shadowed.jackson.databind.deser.std.UUIDDeserializer;
import java.util.*;
public class Test {

	public static void main(String[] args) {

		System.out.println(getEmail());

	}

	private static String getEmail() {
		//return "testautomation" + UUID.randomUUID() + "@gmail.com";
		 return "test" + System.currentTimeMillis()+"@gmail.com";
	}

}
