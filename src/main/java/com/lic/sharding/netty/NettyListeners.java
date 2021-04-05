package com.lic.sharding.netty;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

/**
 * @author licong
 * @version 1.0
 * @date 2021/4/4 17:13
 */
@Component
public class NettyListeners {

    private static Logger LOGGER = LoggerFactory.getLogger(NettyListeners.class);

    /**
     * socketIOServer
     */
    private final SocketIOServer socketIOServer;

    public NettyListeners(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    @OnConnect
    public void onConnect(SocketIOClient socketIOClient){
        UUID sessionId = socketIOClient.getSessionId();
        Transport transport = socketIOClient.getTransport();
        Set<String> allRooms = socketIOClient.getAllRooms();
        LOGGER.info("nettyListeners,sessionId is {},transport is {},allRooms is {}",
                String.valueOf(sessionId),String.valueOf(transport),String.valueOf(allRooms));
        socketIOClient.sendEvent("欢迎您");
        System.out.println("会话已连接");
    }

    @OnDisconnect
    public void disConnect(SocketIOClient socketIOClient){
        System.out.println("客户端已断开连接");
    }
}
