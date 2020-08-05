package com.wiley.ranku.payLoads.UpdateManageUsers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateManageUsers {

    @JsonProperty("userId")
    private String userId;
    @JsonProperty("userData")
    private UserData userData;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("_username")
    private String username;

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("userData")
    public UserData getUserData() {
        return userData;
    }

    @JsonProperty("userData")
    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("_username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("_username")
    public void setUsername(String username) {
        this.username = username;
    }

}
