package com.wiley.ranku.payLoads;

public class Sites {

    private String site;

    private String[] schools;

    private String isAdmin;

    private Products[] products;

    public Sites(String site, String[] schools, String isAdmin){
            this.site = site;
            this.schools = schools;
            this.isAdmin = isAdmin;
//            Products pr = new Products();
    }

    public String getSite ()
    {
        return site;
    }

    public void setSite (String site)
    {
        this.site = site;
    }

    public String[] getSchools ()
    {
        return schools;
    }

    public void setSchools (String[] schools)
    {
        this.schools = schools;
    }

    public String getIsAdmin ()
    {
        return isAdmin;
    }

    public void setIsAdmin (String isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    public Products[] getProducts ()
    {
        return products;
    }

    public void setProducts (Products[] products)
    {
        this.products = products;
    }

}
