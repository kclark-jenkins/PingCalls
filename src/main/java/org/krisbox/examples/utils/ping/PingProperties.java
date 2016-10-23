package org.krisbox.examples.utils.ping;

public interface PingProperties {
    String getClientID();
    String getApiKey();
    String getPingGet();
    String getPingPut();
    String getPingPatch();
    String getPingDelete();
    String getPingAuthenticate();
    String getPingInvite();
    String getPingGroupCount();
    String getUserAgent();
    void debug(Object message);
    void info(Object message);
    void error(Object message);
    void fatal(Object message);
    void trace(Object message);
    void warn(Object message);
}
