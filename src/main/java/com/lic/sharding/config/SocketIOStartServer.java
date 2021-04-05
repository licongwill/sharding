package com.lic.sharding.config;

import com.corundumstudio.socketio.SocketIOServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author licong
 * @version 1.0
 * @date 2021/4/4 18:42
 */
@Component
@Order(1)
public class SocketIOStartServer implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketIOStartServer.class);
    /**
     * socketIOServer
     */
    private final SocketIOServer socketIOServer;

    @Autowired
    public SocketIOStartServer(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    @Override
    public void run(String... args) {
        System.out.println("---------- NettySocket通知服务开始启动 ----------");
        socketIOServer.start();
        System.out.println("---------- NettySocket通知服务启动成功 ----------");
    }
}
