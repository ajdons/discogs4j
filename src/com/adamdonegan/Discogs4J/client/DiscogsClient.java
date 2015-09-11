package com.adamdonegan.Discogs4J.client;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.adamdonegan.Discogs4J.util.HttpRequest;

public class DiscogsClient {
	
	//Authorization
	private static final String URL_REQUEST_TOKEN = "https://api.discogs.com/oauth/request_token";
	private static final String URL_ACCESS_TOKEN = "https://api.discogs.com/oauth/access_token";
	
	//Database
	private static final String URL_RELEASE = "https://api.discogs.com/releases/{release_id}";
	private static final String URL_MASTER_RELEASE = "https://api.discogs.com/masters/{master_id}";
	private static final String URL_MASTER_RELEASE_VERSIONS = "https://api.discogs.com/masters/{master_id}/versions";
	private static final String URL_ARTIST = "https://api.discogs.com/artists/{artist_id}";
	private static final String URL_ARTIST_RELEASES = "https://api.discogs.com/artists/{artist_id}/releases";
	private static final String URL_LABEL = "https://api.discogs.com/labels/{label_id}";
	private static final String URL_LABEL_RELEASES = "https://api.discogs.com/labels/{label_id}/releases";
	private static final String URL_SEARCH = "https://api.discogs.com/database/search?q={query}";
	
	//User Identity
	private static final String URL_USER_IDENTITY = "https://api.discogs.com/oauth/identity";
	private static final String URL_USER_PROFILE = "https://api.discogs.com/users/{username}";
	
	//User Collection
	private static final String URL_COLLECTION = "https://api.discogs.com/users/{username}/collection/folders";
	private static final String URL_COLLECTION_FOLDER = "https://api.discogs.com/users/{username}/collection/folders/{folder_id}";
	private static final String URL_COLLECTION_RELEASES = "https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases";
	private static final String URL_ADD_RELEASE_TO_FOLDER = "https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases/{release_id}";
	private static final String URL_DELETE_INSTANCE_FROM_FOLDER = "https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases/{release_id}/instances/{instance_id}";
	
	//User Wantlist
	private static final String URL_WANTLIST = "https://api.discogs.com/users/{username}/wants";
	private static final String URL_MODIFY_WANTLIST_WITH_RELEASE = "https://api.discogs.com/users/{username}/wants/{release_id}";
	
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
