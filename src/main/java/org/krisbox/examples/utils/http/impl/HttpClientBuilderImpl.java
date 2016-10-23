package org.krisbox.examples.utils.http.impl;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHeader;
import org.krisbox.examples.utils.http.HttpClientBuilder;
import org.krisbox.examples.utils.constants.HttpClientFields;
import org.krisbox.examples.utils.properties.impl.PingPropertiesImpl;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.HashMap;

public class HttpClientBuilderImpl extends PingPropertiesImpl implements HttpClientBuilder {
    public HttpClientBuilderImpl() throws IOException { super(); debug("HttpClientBuilderImpl()");}

    public Object buildHttpClient(HashMap<HttpClientFields, HashMap<HttpClientFields, Object>> requestData) {
        debug("HttpClientBuilderImpl.buildHttpClient()");
        if(requestData.get(HttpClientFields.Client).get(HttpClientFields.Type).equals("GET")) {
            HttpGet httpRequest = new HttpGet(super.getPingGet() + requestData.get(HttpClientFields.Client).get(HttpClientFields.Endpoint));
            httpRequest.addHeader(createAuthHeader());
            return httpRequest;
        }else if(requestData.get(HttpClientFields.Client).get(HttpClientFields.Type).equals("POST")){ /* TODO: Implement */ }
        return null;
    }

    private Header createAuthHeader() { debug("HttpClientBuilderImpl.createAuthHeader()");return new BasicHeader("Authorization", "Basic " + DatatypeConverter.printBase64Binary(new String(super.getClientID() + ":" + super.getApiKey()).getBytes())); }

    // TODO: Implement me
    private Header createHeader(HashMap<String, String> headers) {
        debug("HttpClientBuilderImpl.createHeader()");
        headers.forEach((k,v) -> info("TODO: Implement me!  key: "+k+" value:"+v)); return null;
    }
}
