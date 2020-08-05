package com.wiley.ranku.payLoads;

public class UserData {

    private String last_name;

    private String active;

    private String performPasswordReset;

    private Sites[] sites;

    private String title;

    private String first_name;

    private String email;

    public String getLast_name ()
    {
        return last_name;
    }

    public void setLast_name (String last_name)
    {
        this.last_name = last_name;
    }

    public String getActive ()
    {
        return active;
    }

    public void setActive (String active)
    {
        this.active = active;
    }

    public String getPerformPasswordReset ()
    {
        return performPasswordReset;
    }

    public void setPerformPasswordReset (String performPasswordReset)
    {
        this.performPasswordReset = performPasswordReset;
    }

    public Sites[] getSites ()
    {
        return sites;
    }

    public void setSites (Sites[] sites)
    {
        this.sites = sites;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getFirst_name ()
    {
        return first_name;
    }

    public void setFirst_name (String first_name)
    {
        this.first_name = first_name;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

}
