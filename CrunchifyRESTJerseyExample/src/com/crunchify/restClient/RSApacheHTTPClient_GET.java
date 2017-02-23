package com.crunchify.restClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class RSApacheHTTPClient_GET {

	public static void main(String[] args) {

		try {

			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet getRequest = new HttpGet("http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/ctofservice/");

			getRequest.addHeader("accept", "application/xml");

			HttpResponse response = httpClient.execute(getRequest);

			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}

			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
