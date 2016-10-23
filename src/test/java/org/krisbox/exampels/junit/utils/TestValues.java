package org.krisbox.exampels.junit.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by kclark on 10/23/16.
 */
public class TestValues {
    private final String PROPS_FILENAME = "src/test/resources/junit.properties";

    private Properties prop = new Properties();

    public TestValues() {
        try {
            readProperties();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    private void readProperties() throws FileNotFoundException, IOException {
        prop.load(new FileInputStream(PROPS_FILENAME));
    }

    public String getClientId(){return prop.get("CONTROL_CLIENT_ID").toString();}
    public String getApiKey(){return prop.get("CONTROL_API_KEY").toString();}
    public String getAllGroupsExp(){return prop.get("ALL_GROUPS_EXP").toString();}
    public String getAllUsersExp(){return prop.get("ALL_USERS_EXP").toString();}
    public String getPingBaseURL(){return prop.get("PING_BASE_URL").toString();}
    public String getPingUserURL(){return prop.get("PING_USER_URL").toString();}
    public String getPingGroupURL(){return prop.get("PING_GROUP_URL").toString();}
    public String getPingDeleteURL(){return prop.get("PING_DELETE_URL").toString();}
    public String getPingAuthURL(){return prop.get("PING_AUTH_URL").toString();}
    public String getPingInviteURL(){return prop.get("PING_INVITE_URL").toString();}
    public String getGroupCountURL(){return prop.get("PING_GROUP_COUNT_URL").toString();}
    public String getUserAgent(){return prop.get("USER_AGENT").toString();}
    public String getAllUsersJSON(){return prop.get("ALL_USERS_JSON").toString();}
    public String getAllGroupsJSON(){return prop.get("ALL_GROUPS_JSON").toString();}
}
