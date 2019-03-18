package com.poc.elasticsample.services;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.poc.elasticsample.models.User;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.Update;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private JestClient jestClient;
	
	@Override
	public String save(User user) throws IOException {
		Index index = new Index.Builder(user)
								.index("sample")
								.type("users")
								.id(user.getId())
								.build();
		String id = jestClient.execute(index).getId();
		return id;
	}

	@Override
	public String update(User user, String id) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		/*ObjectNode node = JsonNodeFactory.instance.objectNode();
		node.set(, value)*/
		ObjectMapper mapper2 = new ObjectMapper();
		JsonNode jsonNode = mapper2.convertValue(user, JsonNode.class);
		ObjectNode node = JsonNodeFactory.instance.objectNode();
		node.set("doc", jsonNode);
		String script = "{\n" +
                "    \"id\" : \"sdvcvxxsk123\",\n" +
                "    \"name\" :\"sdvcvxxsk123\", \n" +
                "    \"email\":\"some@some.com\"\n" +
                "}";

//		String node = mapper.writeValueAsString(user);
		Update  update = new Update.Builder(node.toString()).index("sample").type("users").id(id).build();
		//PutMapping putMapping = new PutMapping.Builder("sample", "users", user).build();
		JestResult jestResult = jestClient.execute(update);
		int statusCode = jestResult.getResponseCode();
		return "sd";
	}

	@Override
	public void delete(String id) throws IOException {
		Delete delete = new Delete.Builder(id).index("sample").type("users").build();
		jestClient.execute(delete);
	}

	@Override
	public User get(String id) throws IOException {
		Get get = new Get.Builder("sample", id).type("users").build();
		JestResult result = jestClient.execute(get);
		return result.getSourceAsObject(User.class);
	}

	@Override
	public List<User> inLineSearch(String text) throws IOException {
		text = "*"+text+"*";
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		boolQueryBuilder.must(QueryBuilders.queryStringQuery(text).field("name"));
		SearchSourceBuilder builder = new SearchSourceBuilder();
		builder.query(boolQueryBuilder);
		Search search = new Search.Builder(builder.toString()).addIndex("sample").addType("users").build();
		List<User> result = jestClient.execute(search).getSourceAsObjectList(User.class);
		return result;
	}
}
