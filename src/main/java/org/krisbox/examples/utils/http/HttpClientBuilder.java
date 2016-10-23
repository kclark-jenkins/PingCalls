package org.krisbox.examples.utils.http;

import org.krisbox.examples.utils.constants.HttpClientFields;

import java.util.HashMap;

public interface HttpClientBuilder {
    Object buildHttpClient(HashMap<HttpClientFields, HashMap<HttpClientFields, Object>> requestData);
}
