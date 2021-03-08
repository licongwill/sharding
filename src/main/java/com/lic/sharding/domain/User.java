package com.lic.sharding.domain;

import java.io.Serializable;

/**
 * @author licong
 * @version 1.0
 * @date 2021/3/8 20:33
 */
public class User implements Serializable {
    private Long id;

    private String userName;

    private String realName;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
