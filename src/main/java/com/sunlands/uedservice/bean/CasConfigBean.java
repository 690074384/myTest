package com.sunlands.uedservice.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 18:29 2017/12/13
 * @ModifiedBy :
 */
@Component
@ConfigurationProperties(prefix = "cas")
public class CasConfigBean {
    private String casServer;
    private String serverName;
    private String ignoreAddress;

    public String getCasServer() {
        return casServer;
    }

    public void setCasServer(String casServer) {
        this.casServer = casServer;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIgnoreAddress() {
        return ignoreAddress;
    }

    public void setIgnoreAddress(String ignoreAddress) {
        this.ignoreAddress = ignoreAddress;
    }

}
