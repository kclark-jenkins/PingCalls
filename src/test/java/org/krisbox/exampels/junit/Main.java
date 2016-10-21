package org.krisbox.exampels.junit;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.krisbox.examples.utils.PingProperties;
import org.krisbox.examples.utils.RestClient;
import org.krisbox.examples.utils.impl.PingPropertiesImpl;
import org.krisbox.examples.utils.impl.RestClientImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by kclark on 10/20/16.
 */
public class Main {
    final static Logger LOGGER = Logger.getLogger(Main.class);

    @Test
    public void testGetClientID() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getClientID(), "6ef0f11d-a7bd-44c9-a65c-89b51fbbc707");
    }

    @Test
    public void testGetApiKey() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getApiKey(), "6T7WFc7wlEmqLH2QFy6yZFHp8vS3GT");
    }

    @Test
	public void testGetPingGet() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getPingGet(), "https://directory-api.pingone.com/api/directory/");
    }

    @Test
	public void testGetPingPut() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getPingPut(), "https://directory-api.pingone.com/v1/user/");
    }
    
    @Test
	public void testGetPingPatch() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getPingPatch(), "https://directory-api.pingone.com/v1/group/");
    }
    
    @Test
	public void testGetPingDelete() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getPingDelete(), "https://directory-api.pingone.com/v1/user/");
    }
    
    @Test
	public void testGetPingAuthenticate() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getPingAuthenticate(), "https://directory-api.pingone.com/api/oauth/token");
    }
    
    @Test
	public void testGetPingInvite() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getPingInvite(), "https://directory-api.pingone.com/v1/useractions/invite");
    }
    
    @Test
	public void testGetPingGroupCount() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getPingGroupCount(), "https://directory-api.pingone.com/v1/group/");
    }
    
    @Test
	public void testGetUserAgent() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getUserAgent(), "Mozilla/5.0");
    }

    @Test
    public void testGetAllUsers() throws IOException {
        RestClient restClient = new RestClientImpl();
        assertEquals(restClient.getAllUsers(), "{\"count\":1,\"itemsPerPage\":0,\"startIndex\":1,\"schemas\":[\"urn:scim:schemas:core:1.0\"],\"totalResults\":1,\"resources\":[{\"id\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"photos\":[{\"type\":\"photo\"}],\"schemas\":[\"urn:scim:schemas:com_pingone:1.0\",\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:internal:1.0\"],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"lastModifiedTimeStamp\":1477022534940,\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\",\"state\":\"ACTIVE\",\"lastLoginTime\":1477022534940},\"name\":{\"familyName\":\"Clark\",\"givenName\":\"Kristopher\"},\"active\":true,\"userName\":\"krisclarkdev@krisbox.org\",\"emails\":[{\"primary\":true,\"value\":\"krisclarkdev@krisbox.org\",\"type\":\"work\"}],\"meta\":{\"lastModified\":\"2016-10-20T22:02:14.940-06:00\",\"location\":\"https://directory-api.pingone.com/v1/user/29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"created\":\"2016-10-20T22:00:49.901-06:00\"},\"groups\":[{\"display\":\"Domain Administrators\",\"value\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},{\"display\":\"Users\",\"value\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"}]}]}");
    }
}
