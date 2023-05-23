package br.comvarejonline.projetoinicial.role.model;

import br.comvarejonline.projetoinicial.role.enuns.RoleEnuns;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

public class Role implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleEnuns roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public RoleEnuns getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleEnuns roleName) {
        this.roleName = roleName;
    }

}
