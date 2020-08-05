package com.wiley.ranku.payLoads.UpdateManageUsers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserData {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("title")
    private String title;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("email")
    private String email;
    @JsonProperty("performPasswordReset")
    private Boolean performPasswordReset;
    @JsonProperty("sites")
    private List<Site> sites = null;

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("performPasswordReset")
    public Boolean getPerformPasswordReset() {
        return performPasswordReset;
    }

    @JsonProperty("performPasswordReset")
    public void setPerformPasswordReset(Boolean performPasswordReset) {
        this.performPasswordReset = performPasswordReset;
    }

    @JsonProperty("sites")
    public List<Site> getSites() {
        return sites;
    }

    @JsonProperty("sites")
    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}
