package org.krisbox.examples.models.users;

/**
 * Created by kclark on 10/21/16.
 */
public class PingMeta {
    private String lastModified;

    private String created;

    private String location;

    public String getLastModified ()
    {
        return lastModified;
    }

    public void setLastModified (String lastModified)
    {
        this.lastModified = lastModified;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lastModified = "+lastModified+", created = "+created+", location = "+location+"]";
    }
}
