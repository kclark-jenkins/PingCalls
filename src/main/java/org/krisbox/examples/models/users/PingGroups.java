package org.krisbox.examples.models.users;

/**
 * Created by kclark on 10/21/16.
 */
public class PingGroups {
    private String value;

    private String display;

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getDisplay ()
    {
        return display;
    }

    public void setDisplay (String display)
    {
        this.display = display;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [value = "+value+", display = "+display+"]";
    }
}
