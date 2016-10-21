package org.krisbox.examples.models.groups;

/**
 * Created by kclark on 10/21/16.
 */
public class Members {
    private String value;

    private String display;

    private String type;

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

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [value = "+value+", display = "+display+", type = "+type+"]";
    }
}
