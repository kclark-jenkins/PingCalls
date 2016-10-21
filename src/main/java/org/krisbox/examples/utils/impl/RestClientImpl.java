package org.krisbox.examples.utils.impl;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.krisbox.examples.utils.PingProperties;
import org.krisbox.examples.utils.RestClient;


import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.util.List;

/**
 * Created by kclark on 10/20/16.
 */
public class RestClientImpl implements RestClient {
    private PingProperties pingProps;

    public RestClientImpl() throws IOException {
        pingProps = new PingPropertiesImpl();
    }

    public String getAllUsers() throws IOException {
        return sendGET(pingProps.getPingGet() + "user", pingProps.getUserAgent());
    }

    public String getAllGroups() throws IOException {
        return sendGET(pingProps.getPingGet() + "group", pingProps.getUserAgent());
    }

    public String sendGET(String get_url, String user_agent) throws ProtocolException, IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet request = new HttpGet(get_url);
        request.addHeader("Authorization", "Basic " +
                DatatypeConverter.printBase64Binary(new String(pingProps.getClientID() + ":" + pingProps.getApiKey()).getBytes()));

        HttpResponse response = httpclient.execute(request);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    public void sendPOST(String post_url, String user_agent,  List<NameValuePair> post_params) throws IOException {
        String url = "https://selfsolve.apple.com/wcResults.do";

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", pingProps.getUserAgent());
        post.setHeader("Authorization", "Basic " +
                DatatypeConverter.printBase64Binary(new String(pingProps.getClientID() + ":" + pingProps.getApiKey()).getBytes()));
        post.setEntity(new UrlEncodedFormEntity(post_params));

        HttpResponse response = client.execute(post);
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
    }
}
