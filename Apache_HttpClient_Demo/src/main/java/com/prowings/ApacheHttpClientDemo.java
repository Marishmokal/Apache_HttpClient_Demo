package com.prowings;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApacheHttpClientDemo {
public static void main(String[] args) {
	
	CloseableHttpClient client=HttpClients.createDefault();
	HttpGet get=new HttpGet("http://localhost:8080/account/124");
	
	try {
		CloseableHttpResponse response= client.execute(get);
		String result=EntityUtils.toString(response.getEntity());
		System.out.println(result);
		HttpPost post=new HttpPost("http://localhost:8080/account");
		final String json="'{"
				+ "\"accountNo\":172,"
				+ "\"ifseCode\":\"CITI78045\","
				+ "\"branch\":\"nagar\","
				+ "\"accountHolderName\":\"Rahul kangude\""
				+ ""
				+ "}'";
		final StringEntity entity = new StringEntity(json);
		post.setHeader("Content-type", "application/json");
		post.setEntity(entity);
		
		CloseableHttpResponse postResponse = client.execute(post);
		String postRes = EntityUtils.toString(postResponse.getEntity());
		System.out.println(postRes);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
}
