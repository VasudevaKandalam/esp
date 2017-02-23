package com.crunchify.restClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class RSApacheHTTPClient_POST {

	public static void main(String[] args) {

		try {
			String url = "http://selfsolve.apple.com/wcResults.do";
			final String USER_AGENT = "Mozilla/5.0";

			HttpClient client = HttpClientBuilder.create().build();

			HttpPost post = new HttpPost(url);

			// add header
			post.addHeader("User-Agent", USER_AGENT);

			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
			urlParameters.add(new BasicNameValuePair("cn", ""));
			urlParameters.add(new BasicNameValuePair("locale", ""));
			urlParameters.add(new BasicNameValuePair("caller", ""));
			urlParameters.add(new BasicNameValuePair("num", "12345"));

			post.setEntity(new UrlEncodedFormEntity(urlParameters));

			HttpResponse response = client.execute(post);
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println("Response result : " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
