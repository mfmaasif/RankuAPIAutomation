package com.wiley.ranku.payLoads.UpdateManageUsers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Site {

    @JsonProperty("site")
    private String site;
    @JsonProperty("schools")
    private List<Object> schools = null;
    @JsonProperty("products")
    private List<Product> products = null;
    @JsonProperty("isAdmin")
    private String isAdmin;

    @JsonProperty("site")
    public String getSite() {
        return site;
    }

    @JsonProperty("site")
    public void setSite(String site) {
        this.site = site;
    }

    @JsonProperty("schools")
    public List<Object> getSchools() {
        return schools;
    }

    @JsonProperty("schools")
    public void setSchools(List<Object> schools) {
        this.schools = schools;
    }

    @JsonProperty("products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @JsonProperty("isAdmin")
    public String getIsAdmin() {
        return isAdmin;
    }

    @JsonProperty("isAdmin")
    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

}
