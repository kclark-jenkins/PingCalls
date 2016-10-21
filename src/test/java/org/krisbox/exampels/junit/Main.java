package org.krisbox.exampels.junit;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.krisbox.examples.models.groups.PingGroups;
import org.krisbox.examples.models.users.PingPojo;
import org.krisbox.examples.utils.PingProperties;
import org.krisbox.examples.utils.RestClient;
import org.krisbox.examples.utils.impl.PingPropertiesImpl;
import org.krisbox.examples.utils.impl.RestClientImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Main {
    final static Logger LOGGER = Logger.getLogger(Main.class);

    @Test
    public void testGetClientID() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getClientID(), "xxxx");
    }

    @Test
    public void testGetApiKey() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(pingProps.getApiKey(), "xxxx");
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

    @Test
    public void testGetAllGroups() throws IOException {
        RestClient restClient = new RestClientImpl();
        assertEquals(restClient.getAllGroups(), "{\"count\":2,\"itemsPerPage\":0,\"startIndex\":0,\"schemas\":[],\"totalResults\":2,\"resources\":[{\"id\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\",\"displayName\":\"Domain Administrators\",\"schemas\":[\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:com_pingone:1.0\"],\"meta\":{\"lastModified\":\"2016-10-20T22:00:49.901-06:00\",\"created\":\"2016-10-20T22:00:49.676-06:00\",\"location\":\"https://directory-api.pingone.com/v1/group/deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},\"members\":[{\"value\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"type\":\"user\",\"display\":\"krisclarkdev@krisbox.org\"}],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449676,\"lastModifiedTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\"}},{\"id\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\",\"displayName\":\"Users\",\"schemas\":[\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:com_pingone:1.0\"],\"meta\":{\"lastModified\":\"2016-10-20T22:00:49.901-06:00\",\"created\":\"2016-10-20T22:00:49.676-06:00\",\"location\":\"https://directory-api.pingone.com/v1/group/1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"},\"members\":[{\"value\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"type\":\"user\",\"display\":\"krisclarkdev@krisbox.org\"}],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449676,\"lastModifiedTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\"}}]}");
    }

    @Test
    public void testJsonToPojoUsers() {
        String pingJson = "{\"count\":1,\"itemsPerPage\":0,\"startIndex\":1,\"schemas\":[\"urn:scim:schemas:core:1.0\"],\"totalResults\":1,\"resources\":[{\"id\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"photos\":[{\"type\":\"photo\"}],\"schemas\":[\"urn:scim:schemas:com_pingone:1.0\",\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:internal:1.0\"],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"lastModifiedTimeStamp\":1477022534940,\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\",\"state\":\"ACTIVE\",\"lastLoginTime\":1477022534940},\"name\":{\"familyName\":\"Clark\",\"givenName\":\"Kristopher\"},\"active\":true,\"userName\":\"krisclarkdev@krisbox.org\",\"emails\":[{\"primary\":true,\"value\":\"krisclarkdev@krisbox.org\",\"type\":\"work\"}],\"meta\":{\"lastModified\":\"2016-10-20T22:02:14.940-06:00\",\"location\":\"https://directory-api.pingone.com/v1/user/29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"created\":\"2016-10-20T22:00:49.901-06:00\"},\"groups\":[{\"display\":\"Domain Administrators\",\"value\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},{\"display\":\"Users\",\"value\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"}]}]}";
        PingPojo staff = new Gson().fromJson(pingJson, PingPojo.class);
        assertEquals(staff.getCount(), "1");
        assertEquals(staff.getItemsPerPage(), "0");
        assertEquals(staff.getStartIndex(), "1");
        assertEquals(staff.getSchemas()[0], "urn:scim:schemas:core:1.0");
        assertEquals(staff.getTotalResults(), "1");
        assertEquals(staff.getResources()[0].getGroups()[0].getDisplay(), "Domain Administrators");
        assertEquals(staff.getResources()[0].getGroups()[0].getValue(), "deaffe27-01e7-4dc7-a9dd-4815c24150bf");
        assertEquals(staff.getResources()[0].getGroups()[1].getDisplay(), "Users");
        assertEquals(staff.getResources()[0].getGroups()[1].getValue(), "1c8d4730-2c82-4fa7-8dc4-8135fb3a766c");
        assertEquals(staff.getResources()[0].getEmails()[0].getPrimary(), "true");
        assertEquals(staff.getResources()[0].getEmails()[0].getValue(), "krisclarkdev@krisbox.org");
        assertEquals(staff.getResources()[0].getEmails()[0].getType(), "work");
        assertEquals(staff.getResources()[0].getActive(), "true");
        assertEquals(staff.getResources()[0].getPhotos()[0].getType(), "photo");
        assertEquals(staff.getResources()[0].getSchemas()[0], "urn:scim:schemas:com_pingone:1.0");
        assertEquals(staff.getResources()[0].getSchemas()[1], "urn:scim:schemas:core:1.0");
        assertEquals(staff.getResources()[0].getSchemas()[2], "urn:scim:schemas:internal:1.0");
        assertEquals(staff.getResources()[0].getId(), "29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b");
        assertEquals(staff.getResources()[0].getMeta().getCreated(), "2016-10-20T22:00:49.901-06:00");
        assertEquals(staff.getResources()[0].getMeta().getLastModified(), "2016-10-20T22:02:14.940-06:00");
        assertEquals(staff.getResources()[0].getMeta().getLocation(), "https://directory-api.pingone.com/v1/user/29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b");
        assertEquals(staff.getResources()[0].getName().getFamilyName(), "Clark");
        assertEquals(staff.getResources()[0].getName().getGivenName(), "Kristopher");
        assertEquals(staff.getResources()[0].getUserName(), "krisclarkdev@krisbox.org");
    }

    @Test
    public void testJsonToPojoGroups() {
        String pingJson = "{\"count\":2,\"itemsPerPage\":0,\"startIndex\":0,\"schemas\":[],\"totalResults\":2,\"resources\":[{\"id\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\",\"displayName\":\"Domain Administrators\",\"schemas\":[\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:com_pingone:1.0\"],\"meta\":{\"lastModified\":\"2016-10-20T22:00:49.901-06:00\",\"created\":\"2016-10-20T22:00:49.676-06:00\",\"location\":\"https://directory-api.pingone.com/v1/group/deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},\"members\":[{\"value\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"type\":\"user\",\"display\":\"krisclarkdev@krisbox.org\"}],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449676,\"lastModifiedTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\"}},{\"id\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\",\"displayName\":\"Users\",\"schemas\":[\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:com_pingone:1.0\"],\"meta\":{\"lastModified\":\"2016-10-20T22:00:49.901-06:00\",\"created\":\"2016-10-20T22:00:49.676-06:00\",\"location\":\"https://directory-api.pingone.com/v1/group/1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"},\"members\":[{\"value\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"type\":\"user\",\"display\":\"krisclarkdev@krisbox.org\"}],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449676,\"lastModifiedTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\"}}]}";
        PingGroups staff = new Gson().fromJson(pingJson, PingGroups.class);
        assertEquals(staff.getItemsPerPage(), "0");
        assertEquals(staff.getTotalResults(), "2");
        assertEquals(staff.getCount(), "2");
        assertEquals(staff.getStartIndex(), "0");
        assertEquals(staff.getResources()[0].getSchemas()[0], "urn:scim:schemas:core:1.0");
        assertEquals(staff.getResources()[0].getMeta().getLocation(), "https://directory-api.pingone.com/v1/group/deaffe27-01e7-4dc7-a9dd-4815c24150bf");
        assertEquals(staff.getResources()[0].getMeta().getCreated(), "2016-10-20T22:00:49.676-06:00");
        assertEquals(staff.getResources()[0].getMeta().getLastModified(), "2016-10-20T22:00:49.901-06:00");
        assertEquals(staff.getResources()[0].getDisplayName(), "Domain Administrators");
        assertEquals(staff.getResources()[0].getId(), "deaffe27-01e7-4dc7-a9dd-4815c24150bf");
        assertEquals(staff.getResources()[0].getMembers()[0].getType(), "user");
        assertEquals(staff.getResources()[0].getMembers()[0].getValue(), "29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b");
        assertEquals(staff.getResources()[0].getMembers()[0].getDisplay(), "krisclarkdev@krisbox.org");
        assertEquals(staff.getResources()[0].getSchemas()[1], "urn:scim:schemas:com_pingone:1.0");
        assertEquals(staff.getResources()[1].getMeta().getLocation(), "https://directory-api.pingone.com/v1/group/1c8d4730-2c82-4fa7-8dc4-8135fb3a766c");
        assertEquals(staff.getResources()[1].getMeta().getCreated(), "2016-10-20T22:00:49.676-06:00");
        assertEquals(staff.getResources()[1].getMeta().getLastModified(), "2016-10-20T22:00:49.901-06:00");
        assertEquals(staff.getResources()[1].getDisplayName(), "Users");
        assertEquals(staff.getResources()[1].getId(), "1c8d4730-2c82-4fa7-8dc4-8135fb3a766c");
        assertEquals(staff.getResources()[1].getMembers()[0].getType(), "user");
        assertEquals(staff.getResources()[1].getMembers()[0].getValue(), "29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b");
        assertEquals(staff.getResources()[1].getMembers()[0].getDisplay(), "krisclarkdev@krisbox.org");
    }
}