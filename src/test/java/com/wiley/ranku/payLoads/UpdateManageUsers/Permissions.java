package com.wiley.ranku.payLoads.UpdateManageUsers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Permissions {

    @JsonProperty("read")
    private Boolean read;
    @JsonProperty("create")
    private Boolean create;
    @JsonProperty("update")
    private Boolean update;
    @JsonProperty("delete")
    private Boolean delete;
    @JsonProperty("publish")
    private Boolean publish;
    @JsonProperty("edit")
    private Boolean edit;




    @JsonProperty("read")
    public Boolean getRead() {
        return read;
    }

    @JsonProperty("read")
    public void setRead(Boolean read) {
        this.read = read;
    }

    @JsonProperty("create")
    public Boolean getCreate() {
        return create;
    }

    @JsonProperty("create")
    public void setCreate(Boolean create) {
        this.create = create;
    }

    @JsonProperty("update")
    public Boolean getUpdate() {
        return update;
    }

    @JsonProperty("update")
    public void setUpdate(Boolean update) {
        this.update = update;
    }

    @JsonProperty("delete")
    public Boolean getDelete() {
        return delete;
    }

    @JsonProperty("delete")
    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    @JsonProperty("publish")
    public Boolean getPublish() {
        return publish;
    }

    @JsonProperty("publish")
    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    @JsonProperty("edit")
    public Boolean getEdit() {
        return edit;
    }

    @JsonProperty("edit")
    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

}
