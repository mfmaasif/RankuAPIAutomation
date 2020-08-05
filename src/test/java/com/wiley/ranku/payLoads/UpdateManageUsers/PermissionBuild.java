package com.wiley.ranku.payLoads.UpdateManageUsers;

public class PermissionBuild {

    private boolean read=true;
    private boolean create=true;
    private boolean update=true;
    private boolean delete=true;
    private boolean publish=true;
    private boolean edit=true;

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Permissions build(){
        Permissions output = new Permissions();
        output.setCreate(create);
        output.setRead(read);
        output.setDelete(delete);
        output.setEdit(edit);
        output.setPublish(publish);
        output.setUpdate(update);

        return output;
    }




}
