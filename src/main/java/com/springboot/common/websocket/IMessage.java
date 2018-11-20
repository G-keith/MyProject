package com.springboot.common.websocket;

import java.util.Date;

/**
 * @author keith
 * @version 1.0
 * @date 2018/11/10 11:03
 */
public class IMessage {

    private Integer unreadpoint;

    private Integer Unreadnumbers;

    private String type;

    private Integer uid;

    private Integer ifrom;

    private String avatar;

    private String name;

    private String username;

    private String content;

    private Integer mine;

    private Date times;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnreadpoint() {
        return unreadpoint;
    }

    void setUnreadpoint(Integer unreadpoint) {
        this.unreadpoint = unreadpoint;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getIfrom() {
        return ifrom;
    }

    public void setIfrom(Integer ifrom) {
        this.ifrom = ifrom;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMine() {
        return mine;
    }

    public void setMine(Integer mine) {
        this.mine = mine;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Integer getUnreadnumbers() {
        return Unreadnumbers;
    }

    public void setUnreadnumbers(Integer unreadnumbers) {
        Unreadnumbers = unreadnumbers;
    }
}
