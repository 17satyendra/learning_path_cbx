package com.sample.main;

import java.io.IOException;

import com.sample.core.JsonNodeTreeSample;

/**
 * This class is use to test core sample class for JSON binding and Node Tree Model Parser. 
 * @author satyendra.pal
 * @since 11-03-2019
 */
public class JsonTester {

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\projects\\Json_binding_sample\\src\\user.json";
		//filePath=filePath.replace("\\", "/");
		System.out.println(JsonNodeTreeSample.getuserFromJson(filePath));
	}

}
