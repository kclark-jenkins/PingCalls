package org.krisbox.examples.models.users;

/**
 * Created by kclark on 10/21/16.
 */
public class PingPhotos {
    private String type;

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
        return "ClassPojo [type = "+type+"]";
    }
}
