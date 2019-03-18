package com.sample.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sample.pojo.User;


/**
 * This class is use to get json as string and try to map json node tree binding.
 * @author satyendra.pal
 * @since 11-03-2019
 */
public class JsonNodeTreeSample {
	
	public static void jsonparser(String filePath) throws IOException {
		//reading file
        String genreJson = new String(Files.readAllBytes(Paths.get(filePath)));
        //creating object mapper object.
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(genreJson);
        jsonNode.forEach(System.out::println);
        System.out.println(jsonNode.getNodeType().name());//print object
        System.out.println(jsonNode.get("id").asInt());//print id
        System.out.println(jsonNode.hasNonNull("id"));//print true
        System.out.println(jsonNode.path("name"));//print value against key
        System.out.println(jsonNode.size());//print size like 2 
        System.out.println(jsonNode.isContainerNode());// print true
        System.out.println(jsonNode.isPojo());
        System.out.println(jsonNode.get("addresses").getNodeType());
	}
	
	public static User getuserFromJson(String filePath) throws IOException {
		String genreJson = new String(Files.readAllBytes(Paths.get(filePath)));
        //creating object mapper object.
        ObjectMapper mapper = new ObjectMapper();
        //for unknown properties which is not available in POJO
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS);
      //  mapper.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        return mapper.readValue(genreJson, User.class);		
	}
}
