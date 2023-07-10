package com.javacorner.admin.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long roleId;
    @Basic
    @Column(name = "name", nullable = false, length = 45, unique = true)
    private String name;
    /**
     * com.javacorner.admin.entity.User
     *
     *     @ManyToMany(fetch = FetchType.EAGER) //LAZY = fetch when needed, EAGER = fetch immediately!!
     *     @JoinTable(name = "user_role",
     *         joinColumns = {@JoinColumn(name = "user_id")},
     *         inverseJoinColumns = {@JoinColumn(name = "role_id")})
     *     private Set<Role> roles = new HashSet<>();
     */
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    public Long getRoleId() {
        return roleId;
    }

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId.equals(role.roleId) && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                '}';
    }
}
