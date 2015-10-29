package com.adamdonegan.Discogs4J.util;

import org.json.JSONException;

import com.adamdonegan.Discogs4J.client.DiscogsClient;

public class Test {
	private static String CONSUMER_KEY = "tZplWaLrLakbPmeKDnNR";
	private static String CONSUMER_SECRET = "WlvAHSrMKkEokrhICslQndFmlwjafEwW";
	private static String USER_AGENT = "Discogs4J/0.1 +https://github.com/ajdons/Discogs4J";
	private static String CALLBACK_URL = "www.callback.com";

	public static void main(String[] args) throws JSONException {
		System.out.println("This is a test");
		DiscogsClient client = new DiscogsClient(CONSUMER_KEY, CONSUMER_SECRET, USER_AGENT, CALLBACK_URL);
		//client.getRequestToken();
		//client.getAccessToken();
		
		System.out.println(client.identity());
		//client.profile("discogs4jdev");
		
		/* DATABASE */
		//client.release("6160782");
		//client.masterRelease("671582");
		//client.masterReleaseVersions("671582");
		//client.artist("732448");
		//client.artistReleases("732448");
		//client.label("96508");
		//client.labelReleases("96508");
		//client.search("Arkells");
		
		/* COLLECTION */
		//client.collection("discogs4jdev");
		//client.collectionFolder("discogs4jdev", "1");
		//client.deleteCollectionFolder("discogs4jdev", "633608");
		//client.collectionReleases("discogs4jdev", "1");
		//client.addReleaseToFolder("discogs4jdev", "1", "6160782");
		//client.modifyInstanceInFolder("discogs4jdev", "1", "6160782", "143245571");
		//client.deleteInstanceFromFolder("discogs4jdev", "1", "6160782", "145292580");
		
		/* WANTLIST */
		//client.wantlist("discogs4jdev");
		//client.deleteFromWantlist("discogs4jdev", "5681803");
		//client.addToWantlist("discogs4jdev", "5681803");
		
		/* MARKETPLACE */
		//client.inventory("discogs4jdev");
	}
}

