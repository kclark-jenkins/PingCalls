package org.krisbox.examples.models.users;

/**
 * Created by kclark on 10/21/16.
 */
public class PingName {
    private String familyName;

    private String givenName;

    public String getFamilyName ()
    {
        return familyName;
    }

    public void setFamilyName (String familyName)
    {
        this.familyName = familyName;
    }

    public String getGivenName ()
    {
        return givenName;
    }

    public void setGivenName (String givenName)
    {
        this.givenName = givenName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [familyName = "+familyName+", givenName = "+givenName+"]";
    }
}
