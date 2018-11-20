package com.springboot.common.websocket;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author keith
 * @version 1.0
 * @date 2018/11/10 10:42
 */
@Component
@ServerEndpoint(value = "/webSocket",configurator = SpringConfigurator.class)
public class WebSocketController {

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<WebSocketController> webSockets = new CopyOnWriteArraySet<>();

    private Session session;
    /**
     * 连接成功查询信息
     *
     * @param session
     */
    @RequestMapping(value = "/getIMessages")
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        addOnlineCount();
        System.out.println("连接成功查询信息,当前人数为>>"+getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        // 从set中删除
        webSockets.remove(this);
        subOnlineCount(); // 在线数减
        System.out.println("有一连接关闭！当前在线人数为>>" + getOnlineCount());
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 接受客户端发送过来的消息并返回
     * @param s
     */
    @RequestMapping(value = "/saveImessage")
    @OnMessage
    public void onMessage(@RequestParam("res") String s) throws IOException {
        // 转换成为json格式：下面是获取前台传来的消息，可以用大家自己的代码代替。
        JSONObject js = JSONObject.fromObject(s);
        System.out.println("接收方法------【websocket消息】收到客户端发来的消息:{}" + s);
        for (WebSocketController item : webSockets) {
            if(item.session.getQueryString().equals(js.get("receiveId").toString())){
                item.sendMessage(s);
            }
        }
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        // this.session.getAsyncRemote().sendText(message);
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketController.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketController.onlineCount--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        WebSocketController that = (WebSocketController) o;
        return Objects.equals(session, that.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(session);
    }
}
