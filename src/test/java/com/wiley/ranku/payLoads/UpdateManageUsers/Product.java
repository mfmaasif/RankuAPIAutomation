package com.wiley.ranku.payLoads.UpdateManageUsers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty("product")
    private String product;
    @JsonProperty("permissions")
    private Permissions permissions;
    @JsonProperty("roles")
    private String roles;
    @JsonProperty("product")
    public String getProduct() {
        return product;
    }

    @JsonProperty("product")
    public void setProduct(String product) {
        this.product = product;
    }

    @JsonProperty("permissions")
    public Permissions getPermissions() {
        return permissions;
    }

    @JsonProperty("permissions")
    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    @JsonProperty("roles")
    public String getRoles() {
        return roles;
    }

    @JsonProperty("roles")
    public void setRoles(String roles) {
        this.roles = roles;
    }

}
