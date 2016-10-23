package org.krisbox.examples.utils.logger;

/**
 * Created by kclark on 10/23/16.
 */
public interface PingLogger {
    public void debug(Object message);
    public void info(Object message);
    public void error(Object message);
    public void fatal(Object message);
    public void trace(Object message);
    public void warn(Object message);
}
