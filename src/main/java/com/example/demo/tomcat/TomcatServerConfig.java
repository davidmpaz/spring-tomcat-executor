package com.example.demo.tomcat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TomcatServerConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    private final CustomThreadExecutor customExecutor;

    public TomcatServerConfig() {
        log.debug("TomcatServerConfig created");
        this.customExecutor = new CustomThreadExecutor();
    }

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        log.debug("TomcatServerConfig.customize called");
        /*This web server is the Tomcat server embedded in Spring Boot*/
        TomcatWebServer webServer = (TomcatWebServer)factory.getWebServer();
        webServer.getTomcat().getService().addExecutor(this.customExecutor);
    }
}