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
	private static final String URL_MODIFY_INSTANCE_IN_FOLDER = "https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases/{release_id}/instances/{instance_id}";
	
	//User Wantlist
	private static final String URL_WANTLIST = "https://api.discogs.com/users/{username}/wants";
	private static final String URL_MODIFY_WANTLIST_WITH_RELEASE = "https://api.discogs.com/users/{username}/wants/{release_id}";
	
	private static String CONSUMER_KEY = "tZplWaLrLakbPmeKDnNR";
	private static String CONSUMER_SECRET = "WlvAHSrMKkEokrhICslQndFmlwjafEwW";
	private static String USER_AGENT = "Discogs4J/0.1 +https://github.com/ajdons/Discogs4J";
	private static String CALLBACK_URL = "http://localhost:8080/instarep/";
	private static String USER_ACCESS_TOKEN = "JWlEeHJJOiySEJRDwHdejYuXWjzCvHZlnNeRSioD";
	private static String USER_ACCESS_TOKEN_SECRET = "HLJkZGFwAShKmRpWtbuHKPXjXAprYBotSxhklBES";
	private static String USER_VERIFIER = "ZCiNfFBNHE";
	
	//For testing purposes only, tokens do not expire
	private static String OAUTH_TOKEN = "VTNIZeQHcCvxXrNUDmkYwLYKbSLfYFVZsTKZYHzR";
	private static String OAUTH_TOKEN_SECRET = "iZiwAPLaIFjjrbgQTRDUjOowDZdLCqdXjRhSdmQJ&";
	
	public DiscogsClient (String consumerKey, String consumerSecret){
		CONSUMER_KEY = consumerKey;
		CONSUMER_SECRET = consumerSecret;
	}
	
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/oauth/identity
	 * params: none
	 */
	public String identity() throws JSONException {
		
		HttpRequest request = HttpRequest.get(HttpRequest.append(URL_USER_IDENTITY, authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/users/{username}
	 * params: username
	 */
	public String profile(String username) throws JSONException {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_USER_PROFILE, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/database/search?q={query}
	 * params: query
	 */
	public String search(String query) throws JSONException 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("query", query);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_SEARCH, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/releases/{release_id}
	 * params: release_id
	 */
	public String release(String release_id) throws JSONException 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("release_id", release_id);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_RELEASE, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/masters/{master_id}
	 * params: master_id
	 */
	public String masterRelease(String master_id) throws JSONException 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("master_id", master_id);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_MASTER_RELEASE, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/masters/{master_id}/versions
	 * params: master_id
	 */
	public String masterReleaseVersions(String master_id) throws JSONException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("master_id", master_id);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_MASTER_RELEASE_VERSIONS, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/artists/{artist_id}
	 * params: artist_id
	 */
	public String artist(String artist_id) throws JSONException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("artist_id", artist_id);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_ARTIST, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/artists/{artist_id}/releases
	 * params: artist_id
	 */
	public String artistReleases(String artist_id) throws JSONException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("artist_id", artist_id);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_ARTIST_RELEASES, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/labels/{label_id}
	 * params: label_id
	 */
	public String label(String label_id) throws JSONException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("label_id", label_id);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_LABEL, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/labels/{label_id}/releases
	 * params: label_id
	 */
	public String labelReleases(String label_id) throws JSONException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("label_id", label_id);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_LABEL_RELEASES, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET, POST
	 * URL   : https://api.discogs.com/users/{username}/collection/folders
	 * params: username
	 */
	public String collection(String username) throws JSONException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_COLLECTION, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET, POST, DELETE
	 * URL   : https://api.discogs.com/users/{username}/collection/folders/{folder_id}
	 * params: username, folder_id
	 */
	public String collectionFolder(String username, String folder_id) throws JSONException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("folder_id", folder_id);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_COLLECTION_FOLDER, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases
	 * params: username, folder_id
	 */
	public String collectionReleases(String username, String folder_id) throws JSONException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("folder_id", folder_id);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_COLLECTION_RELEASES, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: POST
	 * URL   : https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases/{release_id}
	 * params: username, folder_id, release_id
	 * NOTE  : use folder_id = 1 for uncategorized
	 */
	public String addReleaseToFolder(String username, String folder_id, String release_id) throws JSONException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("folder_id", folder_id);
		params.put("release_id", release_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_ADD_RELEASE_TO_FOLDER, params)).contentType(HttpRequest.CONTENT_TYPE_FORM).userAgent(USER_AGENT).form(authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET));
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	/**----------------------------------------------
	 * method: POST, DELETE
	 * URL   : https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases/{release_id}/instances/{instance_id}
	 * params: username, folder_id, release_id, instance_id
	 */
	public String modifyInstanceInFolder(String username, String folder_id, String release_id, String instance_id) throws JSONException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("folder_id", folder_id);
		params.put("release_id", release_id);
		params.put("instance_id", instance_id);
		HttpRequest request = HttpRequest.get(HttpRequest.append(replaceURLParams(URL_MODIFY_INSTANCE_IN_FOLDER, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET))).userAgent(USER_AGENT);
		System.out.println(request.toString());
		JSONObject JSONResponse = new JSONObject(request.body());
		System.out.println(JSONResponse.toString(4));
		
		return JSONResponse.toString(4);
	}
	
	public String replaceURLParams(String start, Map<String, String> keysAndValues){
		String endString = start;
		
		for(String key : keysAndValues.keySet()){
			endString = endString.replace("{"+key+"}", keysAndValues.get(key));
		}
		System.out.println(endString);
		return endString;
	}
	
	public void getRequestToken() throws JSONException{

		HttpRequest request = HttpRequest.get(HttpRequest.append(URL_REQUEST_TOKEN, requestAuthorizationHeader())).userAgent(USER_AGENT).contentType(HttpRequest.CONTENT_TYPE_FORM);
		
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
	
	public Map<String, String> authenticatedHeader(String oauth_token, String oauth_token_secret){
		Map<String, String> data = new HashMap<String, String>();
		java.util.Date date= new java.util.Date();
		data.put("oauth_consumer_key", CONSUMER_KEY);
		data.put("oauth_token", oauth_token);
		data.put("oauth_nonce", String.valueOf(date.getTime()));
		data.put("oauth_signature", CONSUMER_SECRET + "%26" + OAUTH_TOKEN_SECRET);//%26 is unicode for '&'
		data.put("oauth_signature_method", "PLAINTEXT");
		data.put("oauth_token_secret", oauth_token_secret);
		data.put("oauth_timestamp", String.valueOf(date.getTime()));
		
		return data;
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
		data.put("oauth_signature", CONSUMER_SECRET + "%26");//%26 is unicode for '&'
		data.put("oauth_signature_method", "PLAINTEXT");
		data.put("oauth_timestamp", String.valueOf(date.getTime()));
		data.put("oauth_callback", CALLBACK_URL);
								
		return data;
	}
}
