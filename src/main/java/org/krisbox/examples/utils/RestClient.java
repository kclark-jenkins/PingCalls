package org.krisbox.examples.utils;

import java.io.IOException;
import java.net.ProtocolException;

/**
 * Created by kclark on 10/20/16.
 */
public interface RestClient {
    public String getAllUsers() throws IOException;
}
