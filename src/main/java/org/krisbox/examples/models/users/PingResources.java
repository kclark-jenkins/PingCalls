package org.krisbox.examples.models.users;

/**
 * Created by kclark on 10/21/16.
 */
public class PingResources {
    private PingPhotos[] photos;
    private String id;
    private String[] schemas;
    private PingName name;
    private String userName;
    private String active;
    private PingEmails[] emails;
    private PingGroups[] groups;
    private PingMeta meta;

    public PingPhotos[] getPhotos ()
    {
        return photos;
    }

    public void setPhotos (PingPhotos[] photos)
    {
        this.photos = photos;
    }

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

    public PingGroups[] getGroups ()
    {
        return groups;
    }

    public void setPingGroups (PingGroups[] groups)
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
    public String toString()
    {
        return "ClassPojo [photos = "+photos+", id = "+id+", schemas = "+schemas+", name = "+name+", userName = "+userName+", active = "+active+", emails = "+emails+", groups = "+groups+", meta = "+meta+"]";
    }
}
