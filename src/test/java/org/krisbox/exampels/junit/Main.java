package org.krisbox.exampels.junit;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.junit.Test;
import org.krisbox.examples.PingClient;
import org.krisbox.examples.models.groups.PingGroups;
import org.krisbox.examples.models.users.PingPojo;
import org.krisbox.examples.utils.ping.PingProperties;
import org.krisbox.examples.utils.rest.RestClient;
import org.krisbox.examples.utils.ping.impl.PingPropertiesImpl;
import org.krisbox.examples.utils.rest.impl.RestClientImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Main {
    final static Logger LOGGER = Logger.getLogger(Main.class);
    final String CONTROL_CLIENT_ID = "xxxx";
    final String CONTROL_API_KEY   = "xxxx";
    final String ALL_GROUPS_EXP    = "{\"count\":2,\"itemsPerPage\":0,\"startIndex\":0,\"schemas\":[],\"totalResults\":2,\"resources\":[{\"id\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\",\"displayName\":\"Domain Administrators\",\"schemas\":[\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:com_pingone:1.0\"],\"meta\":{\"lastModified\":\"2016-10-20T22:00:49.901-06:00\",\"created\":\"2016-10-20T22:00:49.676-06:00\",\"location\":\"https://directory-api.pingone.com/v1/group/deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},\"members\":[{\"value\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"type\":\"user\",\"display\":\"krisclarkdev@krisbox.org\"}],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449676,\"lastModifiedTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\"}},{\"id\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\",\"displayName\":\"Users\",\"schemas\":[\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:com_pingone:1.0\"],\"meta\":{\"lastModified\":\"2016-10-20T22:00:49.901-06:00\",\"created\":\"2016-10-20T22:00:49.676-06:00\",\"location\":\"https://directory-api.pingone.com/v1/group/1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"},\"members\":[{\"value\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"type\":\"user\",\"display\":\"krisclarkdev@krisbox.org\"}],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449676,\"lastModifiedTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\"}}]}";
    final String ALL_USERS_EXP     = "{\"count\":1,\"itemsPerPage\":0,\"startIndex\":1,\"schemas\":[\"urn:scim:schemas:core:1.0\"],\"totalResults\":1,\"resources\":[{\"id\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"schemas\":[\"urn:scim:schemas:com_pingone:1.0\",\"urn:scim:schemas:internal:1.0\",\"urn:scim:schemas:core:1.0\"],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"lastModifiedTimeStamp\":1477082875864,\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\",\"state\":\"ACTIVE\",\"lastLoginTime\":1477082752760},\"name\":{\"familyName\":\"Clark\",\"givenName\":\"Kristopher\"},\"active\":true,\"userName\":\"krisclarkdev@krisbox.org\",\"emails\":[{\"primary\":true,\"value\":\"krisclarkdev@krisbox.org\",\"type\":\"work\"}],\"externalId\":\"jdbc:classicmodels\",\"meta\":{\"lastModified\":\"2016-10-21T14:47:55.864-06:00\",\"location\":\"https://directory-api.pingone.com/v1/user/29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"created\":\"2016-10-20T22:00:49.901-06:00\"},\"groups\":[{\"display\":\"Domain Administrators\",\"value\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},{\"display\":\"Users\",\"value\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"}]}]}";
    final String PING_BASE_URL     = "https://directory-api.pingone.com/api/directory/";
    final String PING_USER_URL     = "https://directory-api.pingone.com/v1/user/";
    final String PING_GROUP_URL    = "https://directory-api.pingone.com/v1/group/";
    final String PING_DELETE_URL   = "https://directory-api.pingone.com/v1/user/";
    final String PING_AUTH_URL     = "https://directory-api.pingone.com/api/oauth/token";
    final String PING_INVITE_URL   = "https://directory-api.pingone.com/v1/useractions/invite";
    final String PING_GROUP_COUNT_URL = "https://directory-api.pingone.com/v1/group/";
    final String USER_AGENT           = "Mozilla/5.0";
    final String ALL_USERS_JSON       = "{\"count\":1,\"itemsPerPage\":0,\"startIndex\":1,\"schemas\":[\"urn:scim:schemas:core:1.0\"],\"totalResults\":1,\"resources\":[{\"id\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"schemas\":[\"urn:scim:schemas:com_pingone:1.0\",\"urn:scim:schemas:internal:1.0\",\"urn:scim:schemas:core:1.0\"],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"lastModifiedTimeStamp\":1477082875864,\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\",\"state\":\"ACTIVE\",\"lastLoginTime\":1477082752760},\"name\":{\"familyName\":\"Clark\",\"givenName\":\"Kristopher\"},\"active\":true,\"userName\":\"krisclarkdev@krisbox.org\",\"emails\":[{\"primary\":true,\"value\":\"krisclarkdev@krisbox.org\",\"type\":\"work\"}],\"externalId\":\"jdbc:classicmodels\",\"meta\":{\"lastModified\":\"2016-10-21T14:47:55.864-06:00\",\"location\":\"https://directory-api.pingone.com/v1/user/29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"created\":\"2016-10-20T22:00:49.901-06:00\"},\"groups\":[{\"display\":\"Domain Administrators\",\"value\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},{\"display\":\"Users\",\"value\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"}]}]}";
    final String ALL_GROUPS_JSON      = "{\"count\":2,\"itemsPerPage\":0,\"startIndex\":0,\"schemas\":[],\"totalResults\":2,\"resources\":[{\"id\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\",\"displayName\":\"Domain Administrators\",\"schemas\":[\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:com_pingone:1.0\"],\"meta\":{\"lastModified\":\"2016-10-20T22:00:49.901-06:00\",\"created\":\"2016-10-20T22:00:49.676-06:00\",\"location\":\"https://directory-api.pingone.com/v1/group/deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},\"members\":[{\"value\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"type\":\"user\",\"display\":\"krisclarkdev@krisbox.org\"}],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449676,\"lastModifiedTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\"}},{\"id\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\",\"displayName\":\"Users\",\"schemas\":[\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:com_pingone:1.0\"],\"meta\":{\"lastModified\":\"2016-10-20T22:00:49.901-06:00\",\"created\":\"2016-10-20T22:00:49.676-06:00\",\"location\":\"https://directory-api.pingone.com/v1/group/1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"},\"members\":[{\"value\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"type\":\"user\",\"display\":\"krisclarkdev@krisbox.org\"}],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449676,\"lastModifiedTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\"}}]}";

    @Test
    public void testGetClientID() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(CONTROL_CLIENT_ID, pingProps.getClientID());
    }

    @Test
    public void testGetApiKey() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(CONTROL_API_KEY, pingProps.getApiKey());
    }

    @Test
	public void testGetPingGet() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(PING_BASE_URL, pingProps.getPingGet());
    }

    @Test
	public void testGetPingPut() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(PING_USER_URL, pingProps.getPingPut());
    }
    
    @Test
	public void testGetPingPatch() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(PING_GROUP_URL, pingProps.getPingPatch());
    }
    
    @Test
	public void testGetPingDelete() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(PING_DELETE_URL, pingProps.getPingDelete());
    }
    
    @Test
	public void testGetPingAuthenticate() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(PING_AUTH_URL, pingProps.getPingAuthenticate());
    }
    
    @Test
	public void testGetPingInvite() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(PING_INVITE_URL, pingProps.getPingInvite());
    }
    
    @Test
	public void testGetPingGroupCount() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(PING_GROUP_COUNT_URL, pingProps.getPingGroupCount());
    }
    
    @Test
	public void testGetUserAgent() throws FileNotFoundException, IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(USER_AGENT, pingProps.getUserAgent());
    }

    @Test
    public void testGetAllUsers() throws IOException {
        RestClient restClient = new RestClientImpl();
        assertEquals(ALL_USERS_JSON, restClient.getAllUsers());
    }

    @Test
    public void testGetAllGroups() throws IOException {
        RestClient restClient = new RestClientImpl();
        assertEquals(ALL_GROUPS_JSON, restClient.getAllGroups());
    }

    @Test
    public void testJsonToPojoUsers() {
        String pingJson = "{\"count\":1,\"itemsPerPage\":0,\"startIndex\":1,\"schemas\":[\"urn:scim:schemas:core:1.0\"],\"totalResults\":1,\"resources\":[{\"id\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"schemas\":[\"urn:scim:schemas:com_pingone:1.0\",\"urn:scim:schemas:internal:1.0\",\"urn:scim:schemas:core:1.0\"],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"lastModifiedTimeStamp\":1477082875864,\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\",\"state\":\"ACTIVE\",\"lastLoginTime\":1477082752760},\"name\":{\"familyName\":\"Clark\",\"givenName\":\"Kristopher\"},\"active\":true,\"userName\":\"krisclarkdev@krisbox.org\",\"emails\":[{\"primary\":true,\"value\":\"krisclarkdev@krisbox.org\",\"type\":\"work\"}],\"externalId\":\"jdbc:classicmodels\",\"meta\":{\"lastModified\":\"2016-10-21T14:47:55.864-06:00\",\"location\":\"https://directory-api.pingone.com/v1/user/29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"created\":\"2016-10-20T22:00:49.901-06:00\"},\"groups\":[{\"display\":\"Domain Administrators\",\"value\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},{\"display\":\"Users\",\"value\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"}]}]}";
        PingPojo pingUsersObject = new Gson().fromJson(pingJson, PingPojo.class);
        LOGGER.debug(pingUsersObject.toString());
//        LOGGER.debug("++++++++" + pingUsersObject.getCount());
        assertEquals("1", pingUsersObject.getCount());
        assertEquals("0", pingUsersObject.getItemsPerPage());
        assertEquals("1", pingUsersObject.getStartIndex());
        assertEquals("urn:scim:schemas:core:1.0", pingUsersObject.getSchemas()[0]);
        assertEquals("1", pingUsersObject.getTotalResults());
        assertEquals("Domain Administrators", pingUsersObject.getResources()[0].getGroups()[0].getDisplay());
        assertEquals("deaffe27-01e7-4dc7-a9dd-4815c24150bf", pingUsersObject.getResources()[0].getGroups()[0].getValue());
        assertEquals("Users", pingUsersObject.getResources()[0].getGroups()[1].getDisplay());
        assertEquals("1c8d4730-2c82-4fa7-8dc4-8135fb3a766c", pingUsersObject.getResources()[0].getGroups()[1].getValue());
        assertEquals("true", pingUsersObject.getResources()[0].getEmails()[0].getPrimary());
        assertEquals("krisclarkdev@krisbox.org", pingUsersObject.getResources()[0].getEmails()[0].getValue());
        assertEquals("work", pingUsersObject.getResources()[0].getEmails()[0].getType());
        assertEquals("true", pingUsersObject.getResources()[0].getActive());
        assertEquals("urn:scim:schemas:com_pingone:1.0", pingUsersObject.getResources()[0].getSchemas()[0]);
        assertEquals("urn:scim:schemas:internal:1.0", pingUsersObject.getResources()[0].getSchemas()[1]);
        assertEquals("urn:scim:schemas:core:1.0", pingUsersObject.getResources()[0].getSchemas()[2]);
        assertEquals("29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b", pingUsersObject.getResources()[0].getId());
        assertEquals("2016-10-20T22:00:49.901-06:00", pingUsersObject.getResources()[0].getMeta().getCreated());
        assertEquals("2016-10-21T14:47:55.864-06:00", pingUsersObject.getResources()[0].getMeta().getLastModified());
        assertEquals("https://directory-api.pingone.com/v1/user/29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b", pingUsersObject.getResources()[0].getMeta().getLocation());
        assertEquals("Clark", pingUsersObject.getResources()[0].getName().getFamilyName());
        assertEquals("Kristopher", pingUsersObject.getResources()[0].getName().getGivenName());
        assertEquals("krisclarkdev@krisbox.org", pingUsersObject.getResources()[0].getUserName());

    }

    @Test
    public void testJsonToPojoGroups() throws JSONException {
        String pingJson = "{\"count\":2,\"itemsPerPage\":0,\"startIndex\":0,\"schemas\":[],\"totalResults\":2,\"resources\":[{\"id\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\",\"displayName\":\"Domain Administrators\",\"schemas\":[\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:com_pingone:1.0\"],\"meta\":{\"lastModified\":\"2016-10-20T22:00:49.901-06:00\",\"created\":\"2016-10-20T22:00:49.676-06:00\",\"location\":\"https://directory-api.pingone.com/v1/group/deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},\"members\":[{\"value\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"type\":\"user\",\"display\":\"krisclarkdev@krisbox.org\"}],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449676,\"lastModifiedTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\"}},{\"id\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\",\"displayName\":\"Users\",\"schemas\":[\"urn:scim:schemas:core:1.0\",\"urn:scim:schemas:com_pingone:1.0\"],\"meta\":{\"lastModified\":\"2016-10-20T22:00:49.901-06:00\",\"created\":\"2016-10-20T22:00:49.676-06:00\",\"location\":\"https://directory-api.pingone.com/v1/group/1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"},\"members\":[{\"value\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"type\":\"user\",\"display\":\"krisclarkdev@krisbox.org\"}],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449676,\"lastModifiedTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\"}}]}";
        PingGroups pingGroupsObject = new Gson().fromJson(pingJson, PingGroups.class);

        assertEquals("0", pingGroupsObject.getItemsPerPage());
        assertEquals("2", pingGroupsObject.getTotalResults());
        assertEquals("2", pingGroupsObject.getCount());
        assertEquals("0", pingGroupsObject.getStartIndex());
        assertEquals("urn:scim:schemas:core:1.0", pingGroupsObject.getResources()[0].getSchemas()[0]);
        assertEquals("https://directory-api.pingone.com/v1/group/deaffe27-01e7-4dc7-a9dd-4815c24150bf", pingGroupsObject.getResources()[0].getMeta().getLocation());
        assertEquals("2016-10-20T22:00:49.676-06:00", pingGroupsObject.getResources()[0].getMeta().getCreated());
        assertEquals("2016-10-20T22:00:49.901-06:00", pingGroupsObject.getResources()[0].getMeta().getLastModified());
        assertEquals("Domain Administrators", pingGroupsObject.getResources()[0].getDisplayName());
        assertEquals("deaffe27-01e7-4dc7-a9dd-4815c24150bf", pingGroupsObject.getResources()[0].getId());
        assertEquals("user", pingGroupsObject.getResources()[0].getMembers()[0].getType());
        assertEquals("29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b", pingGroupsObject.getResources()[0].getMembers()[0].getValue());
        assertEquals("krisclarkdev@krisbox.org", pingGroupsObject.getResources()[0].getMembers()[0].getDisplay());
        assertEquals("urn:scim:schemas:com_pingone:1.0", pingGroupsObject.getResources()[0].getSchemas()[1]);
        assertEquals("https://directory-api.pingone.com/v1/group/1c8d4730-2c82-4fa7-8dc4-8135fb3a766c", pingGroupsObject.getResources()[1].getMeta().getLocation());
        assertEquals("2016-10-20T22:00:49.676-06:00", pingGroupsObject.getResources()[1].getMeta().getCreated());
        assertEquals("2016-10-20T22:00:49.901-06:00", pingGroupsObject.getResources()[1].getMeta().getLastModified());
        assertEquals("Users", pingGroupsObject.getResources()[1].getDisplayName());
        assertEquals("1c8d4730-2c82-4fa7-8dc4-8135fb3a766c", pingGroupsObject.getResources()[1].getId());
        assertEquals("user", pingGroupsObject.getResources()[1].getMembers()[0].getType());
        assertEquals("29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b", pingGroupsObject.getResources()[1].getMembers()[0].getValue());
        assertEquals("krisclarkdev@krisbox.org", pingGroupsObject.getResources()[1].getMembers()[0].getDisplay());
    }

    @Test
    public void testExperimentalPingClientGetAllUsers() throws IOException {
        assertEquals(new PingClient().getAllUsers(), ALL_USERS_EXP);
    }

    @Test
    public void testExperimentalPingClientGetAllGroups() throws IOException {
        assertEquals(new PingClient().getAllGroups(), ALL_GROUPS_EXP);
    }
}