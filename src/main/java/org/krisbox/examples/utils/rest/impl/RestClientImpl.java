package org.krisbox.examples.utils.rest.impl;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.krisbox.examples.utils.constants.HttpClientFields;
import org.krisbox.examples.utils.http.impl.HttpClientBuilderImpl;
import org.krisbox.examples.utils.rest.RestClient;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.HashMap;
import java.util.List;

public class RestClientImpl extends HttpClientBuilderImpl implements RestClient {
    public RestClientImpl() throws IOException {
    }

    public String getAllUsers() throws IOException {
        debug("RestClientImpl.getAllUsers()");
        HashMap<HttpClientFields, HashMap<HttpClientFields, Object>> rootRequest = new HashMap<HttpClientFields, HashMap<HttpClientFields, Object>>();
        HashMap<HttpClientFields, Object> clientOptions = new HashMap<HttpClientFields, Object>();

        clientOptions.put(HttpClientFields.Type, "GET");
        clientOptions.put(HttpClientFields.Endpoint, "user");
        rootRequest.put(HttpClientFields.Client, clientOptions);

        return sendGET((HttpGet)buildHttpClient(rootRequest));
    }

    public String getAllGroups() throws IOException {
        debug("RestClientImpl.getAllGroups()");
        HashMap<HttpClientFields, HashMap<HttpClientFields, Object>> rootRequest = new HashMap<HttpClientFields, HashMap<HttpClientFields, Object>>();
        HashMap<HttpClientFields, Object> clientOptions = new HashMap<HttpClientFields, Object>();

        clientOptions.put(HttpClientFields.Type, "GET");
        clientOptions.put(HttpClientFields.Endpoint, "group");
        rootRequest.put(HttpClientFields.Client, clientOptions);

        return sendGET((HttpGet)buildHttpClient(rootRequest));
    }

    private String sendGET(Object request) throws ProtocolException, IOException {
        debug("RestClientImpl.sendGET()");
        return EntityUtils.toString(new DefaultHttpClient().execute((HttpGet)request).getEntity(), "UTF-8");
    }

    private void sendPOST(String post_url, String user_agent,  List<NameValuePair> post_params) throws IOException {
        debug("RestClientImpl.sendPOST()");
        // TODO: Implement
    }
}
