package com.wiley.ranku.payLoads.UpdateManageUsers;

import java.util.List;

public class SiteBuild {

    private String site;

    private List<Object> schools = null;

    private List<Product> products = null;

    private String isAdmin;

    public void setSite(String site) {
        this.site = site;
    }

    public void setSchools(List<Object> schools) {
        this.schools = schools;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Site build(){
        Site output = new Site();
        output.setSite(site);
        output.setSchools(schools);
        output.setProducts(products);
        output.setIsAdmin(isAdmin);
        return output;
    }


}
