package com.wiley.ranku.payLoads;

public class Permissions {
    private boolean read;

    private boolean publish;

    private boolean create;

    private boolean update;

    private boolean delete;

    public Permissions(){
        this.read = true;
        this.create = true;
        this.update = true;
        this.delete = true;
        this.publish = true;
    }

    public boolean getRead ()
    {
        return read;
    }

    public void setRead (boolean read)
    {
        this.read = read;
    }

    public boolean getPublish ()
    {
        return publish;
    }

    public void setPublish (boolean publish)
    {
        this.publish = publish;
    }

    public boolean getCreate ()
    {
        return create;
    }

    public void setCreate (boolean create)
    {
        this.create = create;
    }

    public boolean getUpdate ()
    {
        return update;
    }

    public void setUpdate (boolean update)
    {
        this.update = update;
    }

    public boolean getDelete ()
    {
        return delete;
    }

    public void setDelete (boolean delete)
    {
        this.delete = delete;
    }

}
