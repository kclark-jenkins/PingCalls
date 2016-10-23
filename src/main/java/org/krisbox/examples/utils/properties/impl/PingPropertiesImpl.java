package org.krisbox.examples.utils.properties.impl;

import org.apache.log4j.Logger;
import org.krisbox.examples.utils.logger.impl.PingLoggerImpl;
import org.krisbox.examples.utils.properties.PingProperties;
import org.krisbox.examples.utils.constants.PingPropertyFields;

import java.io.*;
import java.util.Properties;

public class PingPropertiesImpl extends PingLoggerImpl implements PingProperties {
    private final String PROPS_FILENAME = "src/main/resources/ping.properties";

    private Properties prop = new Properties();

    public PingPropertiesImpl() throws FileNotFoundException, IOException {
        debug("PingPropertiesImpl()");
        readProperties();
    }

    public String getClientID()          {debug("PingPropertiesImpl.getCLientID()");return prop.get(PingPropertyFields.PING_CLIENT_ID.name()).toString();}
    public String getApiKey()            {debug("PingPropertiesImpl.getApiKey()");return prop.get(PingPropertyFields.PING_API_KEY.name()).toString();}
    public String getPingGet()           {debug("PingPropertiesImpl.getPingGet()");return prop.get(PingPropertyFields.PING_GET.name()).toString();}
    public String getPingPut()           {debug("PingPropertiesImpl.getPingPut()");return prop.get(PingPropertyFields.PING_PUT.name()).toString();};
    public String getPingPatch()         {debug("PingPropertiesImpl.getPingPatch()");return prop.get(PingPropertyFields.PING_PATCH.name()).toString();};
    public String getPingDelete()        {debug("PingPropertiesImpl.getPingDelete()");return prop.get(PingPropertyFields.PING_DELETE.name()).toString();};
    public String getPingAuthenticate()  {debug("PingPropertiesImpl.getPingAuthenticate()");return prop.get(PingPropertyFields.PING_AUTHENTICATE.name()).toString();};
    public String getPingInvite()        {debug("PingPropertiesImpl.getPingInvite()");return prop.get(PingPropertyFields.PING_INVITE.name()).toString();};
    public String getPingGroupCount()    {debug("PingPropertiesImpl.getPingGroupCount()");return prop.get(PingPropertyFields.PING_GROUP_COUNT.name()).toString();};
    public String getUserAgent()         {debug("PingPropertiesImpl.getUserAgent()");return prop.get(PingPropertyFields.USER_AGENT.name()).toString();}

    private void readProperties() throws FileNotFoundException, IOException {
        debug("PingPropertiesImpl.readProperties()");
        prop.load(new FileInputStream(PROPS_FILENAME));
    }
}
