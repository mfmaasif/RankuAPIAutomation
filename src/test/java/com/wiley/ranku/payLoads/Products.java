package com.wiley.ranku.payLoads;

public class Products {

    private String product;

    private Permissions permissions;

    private String roles;

    public Products(String product, String roles){
        this.product = product;
        this.roles = roles;
        this.permissions = new Permissions();
    }

    public String getProduct ()
    {
        return product;
    }

    public void setProduct (String product)
    {
        this.product = product;
    }

    public Permissions getPermissions ()
    {
        return permissions;
    }

    public void setPermissions (Permissions permissions)
    {
        this.permissions = permissions;
    }

    public String getRoles ()
    {
        return roles;
    }

    public void setRoles (String roles)
    {
        this.roles = roles;
    }

}
