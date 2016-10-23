package org.krisbox.examples.models.users;

public class PingResources {
    private String id;

    private String[] schemas;

    private PingName name;

    private String userName;

    private String active;

    private PingEmails[] emails;

    private String externalId;

    private PingGroups[] groups;

    private PingMeta meta;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String[] getSchemas ()
    {
        return schemas;
    }

    public void setSchemas (String[] schemas)
    {
        this.schemas = schemas;
    }

    public PingName getName ()
    {
        return name;
    }

    public void setName (PingName name)
    {
        this.name = name;
    }

    public String getUserName ()
    {
        return userName;
    }

    public void setUserName (String userName)
    {
        this.userName = userName;
    }

    public String getActive ()
    {
        return active;
    }

    public void setActive (String active)
    {
        this.active = active;
    }

    public PingEmails[] getEmails ()
    {
        return emails;
    }

    public void setEmails (PingEmails[] emails)
    {
        this.emails = emails;
    }

    public String getExternalId ()
    {
        return externalId;
    }

    public void setExternalId (String externalId)
    {
        this.externalId = externalId;
    }

    public PingGroups[] getGroups ()
    {
        return groups;
    }

    public void setGroups (PingGroups[] groups)
    {
        this.groups = groups;
    }

    public PingMeta getMeta ()
    {
        return meta;
    }

    public void setMeta (PingMeta meta)
    {
        this.meta = meta;
    }

    @Override
    public String toString() { return "ClassPojo [id = "+id+", schemas = "+schemas+", name = "+name+", userName = "+userName+", active = "+active+", emails = "+emails+", externalId = "+externalId+", groups = "+groups+", meta = "+meta+"]"; }
}
