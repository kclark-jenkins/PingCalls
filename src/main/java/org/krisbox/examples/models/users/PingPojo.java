package org.krisbox.examples.models.users;

/**
 * Created by kclark on 10/21/16.
 */
public class PingPojo {
    private PingResources[] resources;

    private String[] schemas;

    private String startIndex;

    private String count;

    private String totalResults;

    private String itemsPerPage;

    public PingResources[] getResources () {
        return resources;
    }

    public void setResources (PingResources[] resources) {
        this.resources = resources;
    }

    public String[] getSchemas () {
        return schemas;
    }

    public void setSchemas (String[] schemas) {
        this.schemas = schemas;
    }

    public String getStartIndex () {
        return startIndex;
    }

    public void setStartIndex (String startIndex) {
        this.startIndex = startIndex;
    }

    public String getCount () {
        return count;
    }

    public void setCount (String count) {
        this.count = count;
    }

    public String getTotalResults () {
        return totalResults;
    }

    public void setTotalResults (String totalResults) {
        this.totalResults = totalResults;
    }

    public String getItemsPerPage () {
        return itemsPerPage;
    }

    public void setItemsPerPage (String itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    @Override
    public String toString() {
        return "ClassPojo [resources = "+resources+", schemas = "+schemas+", startIndex = "+startIndex+", count = "+count+", totalResults = "+totalResults+", itemsPerPage = "+itemsPerPage+"]";
    }
}
