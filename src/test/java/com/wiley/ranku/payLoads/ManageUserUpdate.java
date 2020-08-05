package com.wiley.ranku.payLoads;

public class ManageUserUpdate {

    private UserData userData;

    private String ip;

    private String _username;

    private String userId;

    public ManageUserUpdate(String ip, String _username, String userId){
        this._username = _username;

    }

    public UserData getUserData ()
    {
        return userData;
    }

    public void setUserData (UserData userData)
    {
        this.userData = userData;
    }

    public String getIp ()
    {
        return ip;
    }

    public void setIp (String ip)
    {
        this.ip = ip;
    }

    public String get_username ()
    {
        return _username;
    }

    public void set_username (String _username)
    {
        this._username = _username;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

}
