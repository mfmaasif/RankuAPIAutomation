package com.wiley.ranku.payLoads.UpdateManageUsers;

public class ProductBuild {

    private String product="5b9bd8cf9242ae000d4916db";

    private Permissions permissions;

    private String roles ="";

    public void setProduct(String product) {
        this.product = product;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Product build(){
        Product output = new Product();
        output.setProduct(product);
        output.setPermissions(permissions);
        output.setRoles(roles);
        return output;
    }
}
