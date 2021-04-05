package com.lic.sharding.config;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author licong
 * @version 1.0
 * @date 2021/4/4 18:36
 */
@Configuration
public class SocketIOConfig {

    @Bean
    public SocketIOServer socketIOServer(){
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setPort(9090);
        config.setBossThreads(1);
        config.setWorkerThreads(30);
        config.setAllowCustomRequests(true);
        config.setMaxFramePayloadLength(1048576);
        config.setMaxHttpContentLength(1048576);
        SocketIOServer socketIOServer = new SocketIOServer(config);
        socketIOServer.addNamespace("/test");
        return socketIOServer;
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketIOServer) {
        return new SpringAnnotationScanner(socketIOServer);
    }
}
