package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.PermissionDTO;
import com.example.ERP.Models.Permission;
import com.example.ERP.Models.Role;



@Component
public class PermissionMapper {
    public static PermissionDTO toDTO(Permission permission) {
        return new PermissionDTO(
                permission.getId(),
                permission.getName(),
                permission.getRoles() != null ? permission.getRoles().stream().map(Role::getId).collect(Collectors.toSet()) : null
        );
    }

    public static Permission toEntity(PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setId(permissionDTO.getId());
        permission.setName(permissionDTO.getName());
        // roles should be set by service layer or ORM relationships
        return permission;
    }
}
