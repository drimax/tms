package com.tms.user.model;

import com.tms.common.model.Track;

import javax.persistence.*;

/**
 * Created by hp on 9/17/2017.
 */

@Entity
@Table(name = "role")
public class Role extends Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private boolean active;

    public int getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
