package com.adamdonegan.Discogs4J.util;

import org.codehaus.jettison.json.JSONException;

import com.adamdonegan.Discogs4J.client.DiscogsClient;

public class Test {
	private static String CONSUMER_KEY = "tZplWaLrLakbPmeKDnNR";
	private static String CONSUMER_SECRET = "WlvAHSrMKkEokrhICslQndFmlwjafEwW";
	public static void main(String[] args) throws JSONException {
		System.out.println("This is a test");
		DiscogsClient client = new DiscogsClient(CONSUMER_KEY, CONSUMER_SECRET);
		//client.getRequestToken();
		//client.getAccessToken();
		
		//client.identity();
		//client.profile("discogs4jdev");
		
		//client.getReleaseById("249504");
		//client.masterRelease("671582");
		//client.masterReleaseVersions("671582");
		//client.artist("732448");
		//client.artistReleases("732448");
		//client.label("96508");
		//client.labelReleases("96508");
		//client.search("Arkells");
		
		//client.collection("discogs4jdev");
		client.collectionFolder("discogs4jdev", "1");
	}
}

