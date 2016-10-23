package org.krisbox.examples.models.groups;

public class Meta {
    private String lastModified;

    private String location;

    private String created;

    public String getLastModified ()
    {
        return lastModified;
    }

    public void setLastModified (String lastModified)
    {
        this.lastModified = lastModified;
    }

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    @Override
    public String toString() { return "ClassPojo [lastModified = "+lastModified+", location = "+location+", created = "+created+"]"; }
}
