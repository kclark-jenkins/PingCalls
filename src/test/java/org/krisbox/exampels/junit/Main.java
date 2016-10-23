package org.krisbox.exampels.junit;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.junit.Test;
import org.krisbox.exampels.junit.utils.TestValues;
import org.krisbox.examples.PingClient;
import org.krisbox.examples.models.groups.PingGroups;
import org.krisbox.examples.models.users.PingPojo;
import org.krisbox.examples.utils.properties.PingProperties;
import org.krisbox.examples.utils.rest.RestClient;
import org.krisbox.examples.utils.properties.impl.PingPropertiesImpl;
import org.krisbox.examples.utils.rest.impl.RestClientImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Main {
    private final Logger LOGGER = Logger.getLogger(Main.class);
    private final TestValues testValues = new TestValues();

    @Test
    public void testGetClientID() throws IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(testValues.getClientId(), pingProps.getClientID());
    }

    @Test
    public void testGetApiKey() throws IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(testValues.getApiKey(), pingProps.getApiKey());
    }

    @Test
    public void testGetPingGet() throws IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(testValues.getPingBaseURL(), pingProps.getPingGet());
    }

    @Test
    public void testGetPingPut() throws IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(testValues.getPingUserURL(), pingProps.getPingPut());
    }

    @Test
    public void testGetPingPatch() throws IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(testValues.getPingGroupURL(), pingProps.getPingPatch());
    }

    @Test
    public void testGetPingDelete() throws IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(testValues.getPingDeleteURL(), pingProps.getPingDelete());
    }

    @Test
    public void testGetPingAuthenticate() throws IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(testValues.getPingAuthURL(), pingProps.getPingAuthenticate());
    }

    @Test
    public void testGetPingInvite() throws IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(testValues.getPingInviteURL(), pingProps.getPingInvite());
    }

    @Test
    public void testGetPingGroupCount() throws IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(testValues.getPingGroupURL(), pingProps.getPingGroupCount());
    }

    @Test
    public void testGetUserAgent() throws IOException {
        PingProperties pingProps = new PingPropertiesImpl();
        assertEquals(testValues.getUserAgent(), pingProps.getUserAgent());
    }

    @Test
    public void testGetAllUsers() throws IOException {
        RestClient restClient = new RestClientImpl();
        assertEquals(testValues.getAllUsersJSON(), restClient.getAllUsers());
    }

    @Test
    public void testGetAllGroups() throws IOException {
        RestClient restClient = new RestClientImpl();
        assertEquals(testValues.getAllGroupsJSON(), restClient.getAllGroups());
    }

    @Test
    public void testJsonToPojoUsers() {
        String pingJson = "{\"count\":1,\"itemsPerPage\":0,\"startIndex\":1,\"schemas\":[\"urn:scim:schemas:core:1.0\"],\"totalResults\":1,\"resources\":[{\"id\":\"29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"schemas\":[\"urn:scim:schemas:com_pingone:1.0\",\"urn:scim:schemas:internal:1.0\",\"urn:scim:schemas:core:1.0\"],\"urn:scim:schemas:com_pingone:1.0\":{\"createTimeStamp\":1477022449901,\"accountId\":\"6ef0f11d-a7bd-44c9-a65c-89b51fbbc707\",\"lastModifiedTimeStamp\":1477082875864,\"directoryId\":\"70ea7957-c81f-4a10-918d-29b3b17701fd\",\"state\":\"ACTIVE\",\"lastLoginTime\":1477082752760},\"name\":{\"familyName\":\"Clark\",\"givenName\":\"Kristopher\"},\"active\":true,\"userName\":\"krisclarkdev@krisbox.org\",\"emails\":[{\"primary\":true,\"value\":\"krisclarkdev@krisbox.org\",\"type\":\"work\"}],\"externalId\":\"jdbc:classicmodels\",\"meta\":{\"lastModified\":\"2016-10-21T14:47:55.864-06:00\",\"location\":\"https://directory-api.pingone.com/v1/user/29ae00ca-eb3d-4ee2-a5b9-bd3c3f1ee73b\",\"created\":\"2016-10-20T22:00:49.901-06:00\"},\"groups\":[{\"display\":\"Domain Administrators\",\"value\":\"deaffe27-01e7-4dc7-a9dd-4815c24150bf\"},{\"display\":\"Users\",\"value\":\"1c8d4730-2c82-4fa7-8dc4-8135fb3a766c\"}]}]}";
        PingPojo pingUsersObject = new Gson().fromJson(pingJson, PingPojo.class);
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
        assertEquals(testValues.getAllUsersExp(), new PingClient().getAllUsers());
    }

    @Test
    public void testExperimentalPingClientGetAllGroups() throws IOException {
        assertEquals(testValues.getAllGroupsExp(), new PingClient().getAllGroups());
    }
}