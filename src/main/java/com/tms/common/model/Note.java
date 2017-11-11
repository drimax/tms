package com.tms.common.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by hp on 10/29/2017.
 */
@Embeddable
@Table(name="notes")
public class Note {

    @Column(name = "source_key")
    private String sourceKey;

    @Column(name = "source_values")
    private long sourceValue;

    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private String user;

    public String getSourceKey() {
        return sourceKey;
    }

    public long getSourceValue() {
        return sourceValue;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public void setSourceValue(long sourceValue) {
        this.sourceValue = sourceValue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
