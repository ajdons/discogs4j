package com.adamdonegan.Discogs4J.client;

import java.util.HashMap;
import java.util.Map;

import com.adamdonegan.Discogs4J.util.HttpRequest;

public class DiscogsClient {
	
	//Authorization
	public static final String URL_REQUEST_TOKEN = "https://api.discogs.com/oauth/request_token";
	public static final String URL_AUTHORIZE = "https://discogs.com/oauth/authorize";
	public static final String URL_ACCESS_TOKEN = "https://api.discogs.com/oauth/access_token";
	
	//Database
	public static final String URL_RELEASE = "https://api.discogs.com/releases/{release_id}";
	public static final String URL_MASTER_RELEASE = "https://api.discogs.com/masters/{master_id}";
	public static final String URL_MASTER_RELEASE_VERSIONS = "https://api.discogs.com/masters/{master_id}/versions";
	public static final String URL_ARTIST = "https://api.discogs.com/artists/{artist_id}";
	public static final String URL_ARTIST_RELEASES = "https://api.discogs.com/artists/{artist_id}/releases";
	public static final String URL_LABEL = "https://api.discogs.com/labels/{label_id}";
	public static final String URL_LABEL_RELEASES = "https://api.discogs.com/labels/{label_id}/releases";
	public static final String URL_SEARCH = "https://api.discogs.com/database/search?q={query}";
	
	//User Identity
	public static final String URL_USER_IDENTITY = "https://api.discogs.com/oauth/identity";
	public static final String URL_USER_PROFILE = "https://api.discogs.com/users/{username}";
	
	//User Collection
	public static final String URL_COLLECTION = "https://api.discogs.com/users/{username}/collection/folders";
	public static final String URL_COLLECTION_FOLDER = "https://api.discogs.com/users/{username}/collection/folders/{folder_id}";
	public static final String URL_COLLECTION_RELEASES = "https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases";
	public static final String URL_ADD_RELEASE_TO_FOLDER = "https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases/{release_id}";
	public static final String URL_MODIFY_INSTANCE_IN_FOLDER = "https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases/{release_id}/instances/{instance_id}";
	
	//User Wantlist
	public static final String URL_WANTLIST = "https://api.discogs.com/users/{username}/wants";
	public static final String URL_MODIFY_WANTLIST_WITH_RELEASE = "https://api.discogs.com/users/{username}/wants/{release_id}";
	
	//Marketplace
	public static final String URL_INVENTORY ="https://api.discogs.com/users/{username}/inventory";
	public static final String URL_LISTING = "https://api.discogs.com/marketplace/listings/{listing_id}";
	
	private static String consumerKey = "";
	private static String consumerSecret = "";
	private static String userAgent = "";
	private static String callbackUrl = "";
	
	private static String requestToken = "";
	private static String requestTokenSecret = "";
	private static String accessVerifier = "";
	
	private static String oauthToken = "";
	private static String oauthTokenSecret = "";
	
	public DiscogsClient (String consumer_key, String consumer_secret, String user_agent, String callback_url){
		consumerKey = consumer_key;
		consumerSecret = consumer_secret;
		userAgent = user_agent;
		callbackUrl = callback_url;
	}
	
	public DiscogsClient (String consumer_key, String consumer_secret, String user_agent, String oauth_token, String oauth_token_secret){
		consumerKey = consumer_key;
		consumerSecret = consumer_secret;
		userAgent = user_agent;
		oauthToken = oauth_token;
		oauthTokenSecret = oauth_token_secret;
		
	}
	
	
	public String genericGet(String URL) {
		
		HttpRequest request = HttpRequest.get(URL, authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/oauth/identity
	 * params: none
	 */
	public String identity() {
		
		HttpRequest request = HttpRequest.get(URL_USER_IDENTITY, authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/users/{username}
	 * params: username
	 */
	public String profile(String username) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_USER_PROFILE, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/database/search?q={query}
	 * params: query
	 */
	public String search(String query) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("query", query);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_SEARCH, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/releases/{release_id}
	 * params: release_id
	 */
	public String release(String release_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("release_id", release_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_RELEASE, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/masters/{master_id}
	 * params: master_id
	 */
	public String masterRelease(String master_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("master_id", master_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_MASTER_RELEASE, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/masters/{master_id}/versions
	 * params: master_id
	 */
	public String masterReleaseVersions(String master_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("master_id", master_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_MASTER_RELEASE_VERSIONS, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/artists/{artist_id}
	 * params: artist_id
	 */
	public String artist(String artist_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("artist_id", artist_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_ARTIST, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/artists/{artist_id}/releases
	 * params: artist_id
	 */
	public String artistReleases(String artist_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("artist_id", artist_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_ARTIST_RELEASES, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/labels/{label_id}
	 * params: label_id
	 */
	public String label(String label_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("label_id", label_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_LABEL, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/labels/{label_id}/releases
	 * params: label_id
	 */
	public String labelReleases(String label_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("label_id", label_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_LABEL_RELEASES, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET, POST
	 * URL   : https://api.discogs.com/users/{username}/collection/folders
	 * params: username
	 */
	public String collection(String username) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_COLLECTION, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET, POST, DELETE
	 * URL   : https://api.discogs.com/users/{username}/collection/folders/{folder_id}
	 * params: username, folder_id
	 */
	public String collectionFolder(String username, String folder_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("folder_id", folder_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_COLLECTION_FOLDER, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	
	/**----------------------------------------------
	 * method: DELETE
	 * URL   : https://api.discogs.com/users/{username}/collection/folders/{folder_id}
	 * params: username, folder_id
	 */
	public String deleteCollectionFolder(String username, String folder_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("folder_id", folder_id);
		HttpRequest request = HttpRequest.delete(replaceURLParams(URL_COLLECTION_FOLDER, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		if(request.noContent()){
			System.out.println(Integer.toString(request.code()));
			return Integer.toString(request.code());
		}
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases
	 * params: username, folder_id
	 */
	public String collectionReleases(String username, String folder_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("folder_id", folder_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_COLLECTION_RELEASES, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: POST
	 * URL   : https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases/{release_id}
	 * params: username, folder_id, release_id
	 * NOTE  : use folder_id = 1 for uncategorized
	 */
	public String addReleaseToFolder(String username, String folder_id, String release_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("folder_id", folder_id);
		params.put("release_id", release_id);
		HttpRequest request = HttpRequest.post(replaceURLParams(URL_ADD_RELEASE_TO_FOLDER, params), authenticatedHeader(), true).contentType(HttpRequest.CONTENT_TYPE_FORM).userAgent(userAgent).form(authenticatedHeader());
		System.out.println(request.toString());
		System.out.println(request.code());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: POST
	 * URL   : https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases/{release_id}/instances/{instance_id}
	 * params: username, folder_id, release_id, instance_id
	 */
	public String modifyInstanceInFolder(String username, String folder_id, String release_id, String instance_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("folder_id", folder_id);
		params.put("release_id", release_id);
		params.put("instance_id", instance_id);
		//TODO: this shouldn't be a get, post for update
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_MODIFY_INSTANCE_IN_FOLDER, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	
	/**----------------------------------------------
	 * method: DELETE
	 * URL   : https://api.discogs.com/users/{username}/collection/folders/{folder_id}/releases/{release_id}/instances/{instance_id}
	 * params: username, folder_id, release_id, instance_id
	 */
	public String deleteInstanceFromFolder(String username, String folder_id, String release_id, String instance_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("folder_id", folder_id);
		params.put("release_id", release_id);
		params.put("instance_id", instance_id);
		
		HttpRequest request = HttpRequest.delete(replaceURLParams(URL_MODIFY_INSTANCE_IN_FOLDER, params), authenticatedHeader(), true).userAgent(userAgent);
		
		if(request.noContent()){
			System.out.println(Integer.toString(request.code()));
			return Integer.toString(request.code());
		}
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/users/{username}/wants
	 * params: username
	 */
	public String wantlist(String username) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_WANTLIST, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: PUT
	 * URL   : https://api.discogs.com/users/{username}/wants/{release_id}
	 * params: username, release_id
	 */
	public String addToWantlist(String username, String release_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("release_id", release_id);
		HttpRequest request = HttpRequest.put(replaceURLParams(URL_MODIFY_WANTLIST_WITH_RELEASE, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		System.out.println(request.code());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: DELETE
	 * URL   : https://api.discogs.com/users/{username}/wants/{release_id}
	 * params: username, release_id
	 */
	public String deleteFromWantlist(String username, String release_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("release_id", release_id);
		HttpRequest request = HttpRequest.delete(replaceURLParams(URL_MODIFY_WANTLIST_WITH_RELEASE, params), authenticatedHeader(), true).contentType(HttpRequest.CONTENT_TYPE_FORM).userAgent(userAgent).form(authenticatedHeader());
		System.out.println(request.toString());
		if(request.noContent()){
			System.out.println(Integer.toString(request.code()));
			return Integer.toString(request.code());
		}
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/users/{username}/inventory
	 * params: username
	 */
	public String inventory(String username) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_INVENTORY, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
	/**----------------------------------------------
	 * method: GET
	 * URL   : https://api.discogs.com/marketplace/listings/{listing_id}
	 * params: listing_id
	 */
	public String listing(String listing_id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("listing_id", listing_id);
		HttpRequest request = HttpRequest.get(replaceURLParams(URL_LISTING, params), authenticatedHeader(), true).userAgent(userAgent);
		System.out.println(request.toString());
		
		
		
		return request.body();
	}
	
//	public String editListing(String listing_id) 
//	{
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("listing_id", listing_id);
//		HttpRequest request = HttpRequest.get(replaceURLParams(URL_LISTING, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET), true).userAgent(USER_AGENT);
//		System.out.println(request.toString());
//		
//		
//		
//		return request.body();
//	}
	
//	public String deleteListing(String listing_id) 
//	{
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("listing_id", listing_id);
//		HttpRequest request = HttpRequest.delete(replaceURLParams(URL_LISTING, params), authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET), true).contentType(HttpRequest.CONTENT_TYPE_FORM).userAgent(USER_AGENT).form(authenticatedHeader(OAUTH_TOKEN, OAUTH_TOKEN_SECRET));
//		System.out.println(request.toString());
//		
//		if(request.noContent()){
//			System.out.println(Integer.toString(request.code()));
//			return Integer.toString(request.code());
//		}
//		
//		
//		
//		return request.body();
//	}
	
	public String replaceURLParams(String start, Map<String, String> keysAndValues){
		String endString = start;
		
		for(String key : keysAndValues.keySet()){
			endString = endString.replace("{"+key+"}", keysAndValues.get(key));
		}
		
		return endString;
	}
	
	public Map<String, String> parseParameters (String responseString) {
		Map<String, String> responseMap = new HashMap<String, String>();
		System.out.println(responseString);
		String[] keysAndValues = responseString.split("&");
		
		for(int i=0; i<keysAndValues.length; i++){
			String[] keyAndValue = keysAndValues[i].split("=");
			
			responseMap.put(keyAndValue[0], keyAndValue[1]);
		}
		return responseMap;
	}
	
	public void getRequestToken() {

		HttpRequest request = HttpRequest.get(HttpRequest.append(URL_REQUEST_TOKEN, requestAuthorizationHeader())).userAgent(userAgent).contentType(HttpRequest.CONTENT_TYPE_FORM);
		
		System.out.println(request.toString());
		System.out.println(request.code());
		Map<String, String> r = parseParameters(request.body());
		String token = r.get("oauth_token");
		String token_secret = r.get("oauth_token_secret");
		System.out.println(token);
		System.out.println(token_secret);
		
		requestToken = token;
		requestTokenSecret = token_secret;
	}
	
	public String getAuthorizationURL() {

		return HttpRequest.append(URL_AUTHORIZE, "oauth_token", requestToken);
	}
	
	public void getAccessToken(String verifier) {
		accessVerifier = verifier;
		HttpRequest request = HttpRequest.post(URL_ACCESS_TOKEN).contentType(HttpRequest.CONTENT_TYPE_FORM).userAgent(userAgent).form(accessAuthorizationHeader());
		System.out.println(request.toString());
		System.out.println(request.code());
		Map<String, String> r = parseParameters(request.body());
		String token = r.get("oauth_token");
		String token_secret = r.get("oauth_token_secret");
		System.out.println(token);
		System.out.println(token_secret);
		
		oauthToken = token;
		oauthTokenSecret = token_secret;
	}
	
	public Map<String, String> authenticatedHeader(){
		Map<String, String> data = new HashMap<String, String>();
		java.util.Date date= new java.util.Date();
		data.put("oauth_consumer_key", consumerKey);
		data.put("oauth_token", oauthToken);
		data.put("oauth_nonce", String.valueOf(date.getTime()));
		data.put("oauth_signature", consumerSecret + "%26" + oauthTokenSecret);//%26 is unicode for '&'
		data.put("oauth_signature_method", "PLAINTEXT");
		data.put("oauth_token_secret", oauthTokenSecret);
		data.put("oauth_timestamp", String.valueOf(date.getTime()));
		
		return data;
	}
	
	public Map<String, String> accessAuthorizationHeader(){
		Map<String, String> data = new HashMap<String, String>();
		java.util.Date date= new java.util.Date();
		data.put("oauth_consumer_key", consumerKey);
		data.put("oauth_nonce", String.valueOf(date.getTime()));
		data.put("oauth_token", requestToken);
		data.put("oauth_signature", consumerSecret + "&" + requestTokenSecret);
		data.put("oauth_signature_method", "PLAINTEXT");
		data.put("oauth_timestamp", String.valueOf(date.getTime()));
		data.put("oauth_verifier", accessVerifier);
		
		return data;
	}

	
	public Map<String, String> requestAuthorizationHeader(){
		Map<String, String> data = new HashMap<String, String>();
		java.util.Date date= new java.util.Date();
		data.put("oauth_consumer_key", consumerKey);
		data.put("oauth_nonce", String.valueOf(date.getTime()));
		data.put("oauth_signature", consumerSecret + "%26");//%26 is unicode for '&'
		data.put("oauth_signature_method", "PLAINTEXT");
		data.put("oauth_timestamp", String.valueOf(date.getTime()));
		data.put("oauth_callback", callbackUrl);
								
		return data;
	}

	public static String getConsumerKey() {
		return consumerKey;
	}

	public static void setConsumerKey(String consumerKey) {
		DiscogsClient.consumerKey = consumerKey;
	}

	public static String getConsumerSecret() {
		return consumerSecret;
	}

	public static void setConsumerSecret(String consumerSecret) {
		DiscogsClient.consumerSecret = consumerSecret;
	}

	public static String getUserAgent() {
		return userAgent;
	}

	public static void setUserAgent(String userAgent) {
		DiscogsClient.userAgent = userAgent;
	}

	public static String getCallbackUrl() {
		return callbackUrl;
	}

	public static void setCallbackUrl(String callbackUrl) {
		DiscogsClient.callbackUrl = callbackUrl;
	}

	public static String getRequestTokenSecret() {
		return requestTokenSecret;
	}

	public static void setRequestTokenSecret(String requestTokenSecret) {
		DiscogsClient.requestTokenSecret = requestTokenSecret;
	}

	public static String getAccessVerifier() {
		return accessVerifier;
	}

	public static void setAccessVerifier(String accessVerifier) {
		DiscogsClient.accessVerifier = accessVerifier;
	}

	public static String getOauthToken() {
		return oauthToken;
	}

	public static void setOauthToken(String oauthToken) {
		DiscogsClient.oauthToken = oauthToken;
	}

	public static String getOauthTokenSecret() {
		return oauthTokenSecret;
	}

	public static void setOauthTokenSecret(String oauthTokenSecret) {
		DiscogsClient.oauthTokenSecret = oauthTokenSecret;
	}

	public static void setRequestToken(String requestToken) {
		DiscogsClient.requestToken = requestToken;
	}
}
