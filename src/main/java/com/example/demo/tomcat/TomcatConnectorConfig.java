package com.example.demo.tomcat;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TomcatConnectorConfig implements TomcatConnectorCustomizer {
    private final CustomThreadExecutor customExecutor;

    public TomcatConnectorConfig() {
        log.debug("TomcatConnectorConfig created");
        this.customExecutor = new CustomThreadExecutor();
    }

    @Override
    public void customize(Connector connector) {
        log.debug("TomcatConnectorConfig.customize called");
        connector.getProtocolHandler().setExecutor(this.customExecutor);
    }
}