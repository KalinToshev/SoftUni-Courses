package com.example.demoprojectwithjpabuddyplugin.model.entities;

import com.example.demoprojectwithjpabuddyplugin.model.enums.RoleType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private RoleType roleType;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new LinkedHashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}