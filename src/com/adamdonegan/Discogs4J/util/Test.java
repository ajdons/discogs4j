package com.adamdonegan.Discogs4J.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.adamdonegan.Discogs4J.client.DiscogsClient;

public class Test {
	private static String CONSUMER_KEY = "tZplWaLrLakbPmeKDnNR";
	private static String CONSUMER_SECRET = "WlvAHSrMKkEokrhICslQndFmlwjafEwW";
	private static String USER_AGENT = "Discogs4J/0.1 +https://github.com/ajdons/Discogs4J";
	private static String CALLBACK_URL = "www.callback.com";

	public static void main(String[] args) {
		System.out.println("This is a test");
		DiscogsClient client = new DiscogsClient(CONSUMER_KEY, CONSUMER_SECRET, USER_AGENT, "mbRRMosslqDrucVpQUkNeUzhlylKkMgDaLyJcjCN", "iWnxHVzdSXWlhkWyPCnIqGNbkRCyhWgJrsNbIRCw");
		//DiscogsClient client = new DiscogsClient(CONSUMER_KEY, CONSUMER_SECRET, USER_AGENT, CALLBACK_URL);
		//client.getRequestToken();
		//System.out.println(client.getAuthorizationURL());
		//client.setRequestToken("oEXFOoqaZRJEipLGkeqzDZVcaoFGFUKEXtYkMRaY");
		//client.setRequestTokenSecret("xwSpnmhselKtAgbchhHWlpqwAZIwYwEDtiTkkjkj");
		//client.getAccessToken("VqrLztkdIc");
		
		//client.getAccessToken("jMEDRnZwyz");
		//System.out.println(client.artist("732448"));
		//client.getRequestToken();
		//client.getAccessToken();
		
		//System.out.println(client.identity());
		System.out.println(client.profile("discogs4jdev"));
		//System.out.println(client.genericPost("https://api.discogs.com/users/ajdons", null));
		
		/* DATABASE */
		//System.out.println(client.release("6160782"));
		//System.out.println(client.masterRelease("671582"));
		//System.out.println(client.masterReleaseVersions("671582"));
		//System.out.println(client.artist("732448"));
		//System.out.println(client.artistReleases("732448"));
		//System.out.println(client.label("96508"));
		//System.out.println(client.labelReleases("96508"));
		//System.out.println(client.search("Arkells"));
		//System.out.println(client.advancedSearch("am", map));

		
		/* COLLECTION */
		//System.out.println(client.collection("ajdons"));
		//System.out.println(client.collectionFolder("ajdons", "1"));
		//System.out.println(client.addCollectionFolder("ajdons", "Newest Folder"));
		//System.out.println(client.deleteCollectionFolder("ajdons", "682470"));
		//System.out.println(client.genericDelete("https://api.discogs.com/users/ajdons/collection/folders/682492"));
		//System.out.println(client.collectionReleases("ajdons", "1"));
		//System.out.println(client.addReleaseToFolder("discogs4jdev", "1", "6160782"));
		//System.out.println(client.updateInstanceInFolder("ajdons", "1", "6160782", "149488219", map));
		//System.out.println(client.deleteInstanceFromFolder("ajdons", "1", "6160782", "149488219"));
		
		/* WANTLIST */
		//System.out.println(client.wantlist("ajdons"));
		//System.out.println(client.deleteFromWantlist("ajdons", "5681803"));
		//System.out.println(client.addToWantlist("ajdons", "5681803"));
		
		/* MARKETPLACE */
		//client.inventory("ajdons");
	}

}

