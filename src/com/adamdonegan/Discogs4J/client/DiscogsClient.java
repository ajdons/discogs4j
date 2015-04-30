package com.adamdonegan.Discogs4J.client;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.adamdonegan.Discogs4J.util.HttpRequest;

public class DiscogsClient {
	private static final String URL_REQUEST_TOKEN = "https://api.discogs.com/oauth/request_token";
	private static final String URL_ACCESS_TOKEN = "https://api.discogs.com/oauth/access_token";
	
	
	private static String CONSUMER_KEY = "tZplWaLrLakbPmeKDnNR";
	private static String CONSUMER_SECRET = "WlvAHSrMKkEokrhICslQndFmlwjafEwW";
	private static String USER_AGENT = "Discogs4J/0.1 +https://github.com/ajdons/Discogs4J";
	private static String CALLBACK_URL = "http://localhost:8080/instarep/";
	private static String USER_ACCESS_TOKEN = "vPDSzNjAlFTVxQhEGOzEOUngFJLkWlagDCHrzlxN";
	private static String USER_ACCESS_TOKEN_SECRET = "vPxDSytzltJUKgwupvKmZOAvLjIOPjcKluhxmbSs";
	private static String USER_VERIFIER = "eXbSBbASki";
	
	public DiscogsClient (String consumerKey, String consumerSecret){
		CONSUMER_KEY = consumerKey;
		CONSUMER_SECRET = consumerSecret;
	}
	
	public void getRequestToken() throws JSONException{
		HttpRequest request = HttpRequest.get(URL_REQUEST_TOKEN).contentType(HttpRequest.CONTENT_TYPE_FORM).userAgent(USER_AGENT).form(requestAuthorizationHeader());
		System.out.println(request.toString());
		System.out.println(request.code());
		String response = "{\"" + request.body() + "\"}";
		response = response.replace("=", "\":\"");
		response = response.replace("&", "&\", \"");
		System.out.println(response);
		JSONObject responseAsJSON = new JSONObject(response);
		String token = responseAsJSON.getString("oauth_token");
		String token_secret = responseAsJSON.getString("oauth_token_secret");
		System.out.println("token : " + token);
		System.out.println("token secret : " + token_secret);
	}
	
	public void getAccessToken() {
		HttpRequest request = HttpRequest.post(URL_ACCESS_TOKEN).contentType(HttpRequest.CONTENT_TYPE_FORM).userAgent(USER_AGENT).form(accessAuthorizationHeader(USER_ACCESS_TOKEN, USER_VERIFIER));
		System.out.println(request.toString());
		System.out.println(request.code());
		System.out.println(request.body());
	}
	
	public Map<String, String> accessAuthorizationHeader(String token, String verifier){
		Map<String, String> data = new HashMap<String, String>();
		java.util.Date date= new java.util.Date();
		data.put("oauth_consumer_key", CONSUMER_KEY);
		data.put("oauth_nonce", String.valueOf(date.getTime()));
		data.put("oauth_token", token);
		data.put("oauth_signature", CONSUMER_SECRET + "&" + USER_ACCESS_TOKEN_SECRET);
		data.put("oauth_signature_method", "PLAINTEXT");
		data.put("oauth_timestamp", String.valueOf(date.getTime()));
		data.put("oauth_verifier", verifier);
		
		return data;
	}
	
	public Map<String, String> requestAuthorizationHeader(){
		Map<String, String> data = new HashMap<String, String>();
		java.util.Date date= new java.util.Date();
		data.put("oauth_consumer_key", CONSUMER_KEY);
		data.put("oauth_nonce", String.valueOf(date.getTime()));
		data.put("oauth_signature", CONSUMER_SECRET + "&");
		data.put("oauth_signature_method", "PLAINTEXT");
		data.put("oauth_timestamp", String.valueOf(date.getTime()));
		data.put("oauth_callback", CALLBACK_URL);
								
		return data;
	}
}
