# discogs4j

**discogs4j** is a Java client/wrapper for [Discogs.com API v2.0](https://www.discogs.com/developers/ "Discogs.com API v2.0"). It allows you to retrieve information from the Discogs database including data on artists, releases, labels, etc. It will also handle the OAuth authentication process for you, allowing you to modify a user's protected resources such as collections, wantlists, etc.


## Quickstart

### Import

Make sure you have added the .jar file to your build path. You can then import the appropriate files.

```java
import com.adamdonegan.Discogs4J.*;
```

### Instantiate a DiscogsClient object

Instantiate a `DiscogsClient` object using the constructor that best fits your application's needs. At the very least, you must provide a [`USER_AGENT`](https://www.discogs.com/developers/#page:home,header:home-general-information).

```java
DiscogsClient client = new DiscogsClient(USER_AGENT);
```

This is all you need to start hitting endpoints. This basic client will allow you access to the API endpoints that do not require Authorization.

## Authorization (optional)

### OAuth Authorization

Before we begin the three-legged OAuth process, you will have to set a few of your `DiscogsClient`'s parameters using setters.

   Alternatively, you can initialize a `DiscogsClient` and set these parameters all in one go using a longer constructor.


   ```java
client.setConsumerKey(CONSUMER_KEY);
client.setConsumerSecret(CONSUMER_SECRET);
client.setCallbackUrl(CALLBACK_URL);

// OR

DiscogsClient client = new DiscogsClient(CONSUMER_KEY, CONSUMER_SECRET, USER_AGENT, CALLBACK_URL);
```

   The `CONSUMER_KEY` and `CONSUMER_SECRET` should be your application-specific key and secret provided by Discogs.com.

   You must also provide a `USER_AGENT` and a `CALLBACK_URL`.

#### Three-legged Oauth Process

1. Use your `DiscogsClient` to retrieve an unauthorized request token.

```java
client.getRequestToken();
```

2. Next, you will have to authorize your request token. This authorization can take place in a web brower for a typical web application, in a WebView if developing for Android, etc.

In any case, you will direct a user to the authorization URL provided by the `DiscogsClient`.

```java
String url = client.getAuthorizationURL();
```

3. Once a Discogs user has authorized your app, you will use the `verifier` that is sent back to retrieve an access token.

```java
client.getAccessToken(verifier);
```


That's it, you are ready to make authenticated requests! This instance of the client will hold onto the access token and secret, but you will want to persist them for the next time you initialize a `DiscogsClient`.

```java
String oauth_token = client.getOauthToken();
String oauth_token_secret = client.getOauthTokenSecret();
//TODO: Save token and secret for future use
```

You can now go ahead and test your identity. You should receive back the identity of the User you authenticated.

```java
String response = client.identity();
```
All methods will return the response body as JSON.

```java
{  
   "username":"discogs4jdev",
   "resource_url":"https://api.discogs.com/users/discogs4jdev",
   "consumer_name":"Discogs4JTester",
   "id":2520622
}
```

The next time you need to initialize a `DiscogsClient`, you will simply use the constructor that includes an `OAUTH_TOKEN` and `OAUTH_TOKEN_SECRET`.

```java
DiscogsClient newClient = new DiscogsClient(CONSUMER_KEY, CONSUMER_SECRET, USER_AGENT, OAUTH_TOKEN, OAUTH_TOKEN_SECRET);
```

## Retrieving Data

Once your DiscogsClient is initialized, you are ready to start working with the Dicogs API.

```java
String artistID = "123456";
newClient.artist(artistID);
```
