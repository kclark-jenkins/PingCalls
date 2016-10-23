package org.krisbox.examples.models.users;

import org.apache.log4j.Logger;

public class PingPojo {
    final static Logger LOGGER = Logger.getLogger(PingPojo.class);
    private PingResources[] resources;

    private String[] schemas;

    private String startIndex;

    private String count;

    private String totalResults;

    private String itemsPerPage;

    public PingResources[] getResources ()
    {
        return resources;
    }

    public void setResources (PingResources[] resources) { LOGGER.debug("+++++++++++++" + resources); this.resources = resources; }

    public String[] getSchemas ()
    {
        return schemas;
    }

    public void setSchemas (String[] schemas) { LOGGER.debug("++++++++++++++" + schemas); this.schemas = schemas; }

    public String getStartIndex ()
    {
        return startIndex;
    }

    public void setStartIndex (String startIndex) { LOGGER.debug("+++++++++++++" + startIndex); this.startIndex = startIndex; }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count) { LOGGER.debug("++++++++++" + count); this.count = count; }

    public String getTotalResults ()
    {
        return totalResults;
    }

    public void setTotalResults (String totalResults) { LOGGER.debug("++++++++" + totalResults); this.totalResults = totalResults; }

    public String getItemsPerPage ()
    {
        return itemsPerPage;
    }

    public void setItemsPerPage (String itemsPerPage) { LOGGER.debug("++++++++" + itemsPerPage); this.itemsPerPage = itemsPerPage; }

    @Override
    public String toString() { return "ClassPojo [resources = "+resources+", schemas = "+schemas+", startIndex = "+startIndex+", count = "+count+", totalResults = "+totalResults+", itemsPerPage = "+itemsPerPage+"]"; }
}
