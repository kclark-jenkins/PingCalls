package org.krisbox.examples.utils.logger.impl;


import org.apache.log4j.Logger;

/**
 * Created by kclark on 10/23/16.
 */
public class PingLoggerImpl {
    private final Logger LOGGER;

    public PingLoggerImpl() {
        LOGGER = Logger.getLogger(PingLoggerImpl.class);
    }

    public void debug(Object message){LOGGER.debug(message);}
    public void info(Object message){LOGGER.info(message);}
    public void error(Object message){LOGGER.error(message);}
    public void fatal(Object message){LOGGER.fatal(message);}
    public void trace(Object message){LOGGER.trace(message);}
    public void warn(Object message){LOGGER.warn(message);}
}
