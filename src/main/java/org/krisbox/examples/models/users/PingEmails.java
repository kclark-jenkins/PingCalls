package org.krisbox.examples.models.users;

public class PingEmails {
    private String primary;

    private String value;

    private String type;

    public String getPrimary () { return primary; }

    public void setPrimary (String primary)
    {
        this.primary = primary;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString() { return "ClassPojo [primary = "+primary+", value = "+value+", type = "+type+"]"; }
}
