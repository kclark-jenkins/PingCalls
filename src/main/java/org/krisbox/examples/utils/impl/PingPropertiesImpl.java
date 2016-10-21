package org.krisbox.examples.utils.impl;

import org.apache.log4j.Logger;
import org.krisbox.examples.utils.PingProperties;
import org.krisbox.examples.utils.PingPropertyFields;

import java.io.*;
import java.util.Properties;

/**
 * Created by kclark on 10/20/16.
 */
public class PingPropertiesImpl implements PingProperties {
    private final Logger LOGGER = Logger.getLogger(PingPropertiesImpl.class);
    private final String PROPS_FILENAME = "src/main/resources/ping.properties";

    private Properties prop = new Properties();

    public PingPropertiesImpl() throws FileNotFoundException, IOException {
        readProperties();
    }

    public String getClientID()          {return prop.get(PingPropertyFields.PING_CLIENT_ID.name()).toString();}
    public String getApiKey()            {return prop.get(PingPropertyFields.PING_API_KEY.name()).toString();}
    public String getPingGet()           {return prop.get(PingPropertyFields.PING_GET.name()).toString();}
    public String getPingPut()           {return prop.get(PingPropertyFields.PING_PUT.name()).toString();};
    public String getPingPatch()         {return prop.get(PingPropertyFields.PING_PATCH.name()).toString();};
    public String getPingDelete()        {return prop.get(PingPropertyFields.PING_DELETE.name()).toString();};
    public String getPingAuthenticate()  {return prop.get(PingPropertyFields.PING_AUTHENTICATE.name()).toString();};
    public String getPingInvite()        {return prop.get(PingPropertyFields.PING_INVITE.name()).toString();};
    public String getPingGroupCount()    {return prop.get(PingPropertyFields.PING_GROUP_COUNT.name()).toString();};
    public String getUserAgent()         {return prop.get(PingPropertyFields.USER_AGENT.name()).toString();}

    private void readProperties() throws FileNotFoundException, IOException {
        prop.load(new FileInputStream(PROPS_FILENAME));
    }
}
