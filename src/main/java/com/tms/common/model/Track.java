package com.tms.common.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by hp on 9/17/2017.
*/
@MappedSuperclass
public class Track {

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "modified_time")
    private Date modifiedTime;

    @Column(name = "version")
    private int version;

    public Track(){
    }

    public Track(Date createdTime, Date modifiedTime, int version){
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.version = version;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public int getVersion() {
        return version;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
