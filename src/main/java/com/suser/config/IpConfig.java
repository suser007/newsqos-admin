package com.suser.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/***
 * 此处用来根据InConfig来获取当前项目所在端口号，用于com.yx.service.UserService 保存头像地址处
 */
@Component
public class IpConfig implements ApplicationListener<WebServerInitializedEvent> {
    private int serverPort;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }
    /**获取端口地址*/
    public int getPort() {
        return this.serverPort;
    }
}
