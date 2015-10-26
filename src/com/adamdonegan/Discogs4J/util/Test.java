package com.adamdonegan.Discogs4J.util;

import org.codehaus.jettison.json.JSONException;

import com.adamdonegan.Discogs4J.client.DiscogsClient;

public class Test {
	private static String CONSUMER_KEY = "tZplWaLrLakbPmeKDnNR";
	private static String CONSUMER_SECRET = "WlvAHSrMKkEokrhICslQndFmlwjafEwW";
	private static String USER_AGENT = "Discogs4J/0.1 +https://github.com/ajdons/Discogs4J";

	public static void main(String[] args) throws JSONException {
		System.out.println("This is a test");
		DiscogsClient client = new DiscogsClient(CONSUMER_KEY, CONSUMER_SECRET, USER_AGENT);
		//client.getRequestToken();
		//client.getAccessToken();
		
		//client.identity();
		//client.profile("discogs4jdev");
		
		//client.release("6160782");
		//client.masterRelease("671582");
		//client.masterReleaseVersions("671582");
		//client.artist("732448");
		//client.artistReleases("732448");
		//client.label("96508");
		//client.labelReleases("96508");
		//client.search("Arkells");
		
		//client.collection("discogs4jdev");
		//client.collectionFolder("discogs4jdev", "1");
		//client.collectionReleases("discogs4jdev", "1");
		//client.addReleaseToFolder("discogs4jdev", "1", "6160782");
		//client.modifyInstanceInFolder("discogs4jdev", "1", "6160782", "143245571");
	}
}

