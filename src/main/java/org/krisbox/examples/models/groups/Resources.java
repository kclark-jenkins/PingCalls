package org.krisbox.examples.models.groups;

/**
 * Created by kclark on 10/21/16.
 */
public class Resources {
    private String id;

    private String[] schemas;

    private String displayName;

    private Members[] members;

    private Meta meta;

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

    public String getDisplayName ()
    {
        return displayName;
    }

    public void setDisplayName (String displayName)
    {
        this.displayName = displayName;
    }

    public Members[] getMembers ()
    {
        return members;
    }

    public void setMembers (Members[] members)
    {
        this.members = members;
    }

    public Meta getMeta ()
    {
        return meta;
    }

    public void setMeta (Meta meta)
    {
        this.meta = meta;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", schemas = "+schemas+", displayName = "+displayName+", members = "+members+", meta = "+meta+"]";
    }
}
