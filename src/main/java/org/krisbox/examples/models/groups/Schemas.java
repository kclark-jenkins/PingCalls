package org.krisbox.examples.models.groups;

/**
 * Created by kclark on 10/21/16.
 */
public class Schemas {
    private String createTimeStamp;

    private String accountId;

    private String lastModifiedTimeStamp;

    private String directoryId;

    public String getCreateTimeStamp ()
    {
        return createTimeStamp;
    }

    public void setCreateTimeStamp (String createTimeStamp)
    {
        this.createTimeStamp = createTimeStamp;
    }

    public String getAccountId ()
    {
        return accountId;
    }

    public void setAccountId (String accountId)
    {
        this.accountId = accountId;
    }

    public String getLastModifiedTimeStamp ()
    {
        return lastModifiedTimeStamp;
    }

    public void setLastModifiedTimeStamp (String lastModifiedTimeStamp)
    {
        this.lastModifiedTimeStamp = lastModifiedTimeStamp;
    }

    public String getDirectoryId ()
    {
        return directoryId;
    }

    public void setDirectoryId (String directoryId)
    {
        this.directoryId = directoryId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [createTimeStamp = "+createTimeStamp+", accountId = "+accountId+", lastModifiedTimeStamp = "+lastModifiedTimeStamp+", directoryId = "+directoryId+"]";
    }
}
