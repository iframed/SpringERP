package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.RoleDTO;
import com.example.ERP.Models.Permission;
import com.example.ERP.Models.Role;
import com.example.ERP.Models.User;


@Component
public class RoleMapper {
    public static RoleDTO toDTO(Role role) {
        return new RoleDTO(
                role.getId(),
                role.getName(),
                role.getUsers() != null ? role.getUsers().stream().map(User::getId).collect(Collectors.toSet()) : null,
                role.getPermissions() != null ? role.getPermissions().stream().map(Permission::getId).collect(Collectors.toSet()) : null
        );
    }

    public static Role toEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        // users and permissions should be set by service layer or ORM relationships
        return role;
    }
}
