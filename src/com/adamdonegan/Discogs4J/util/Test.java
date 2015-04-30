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
		client.getAccessToken();
	}
}

