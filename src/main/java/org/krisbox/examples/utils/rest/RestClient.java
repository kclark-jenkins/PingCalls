package org.krisbox.examples.utils.rest;

import java.io.IOException;

public interface RestClient {
    String getAllUsers() throws IOException;
    String getAllGroups() throws IOException;
}
