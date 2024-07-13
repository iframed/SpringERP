package com.example.ERP.Mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.UserDTO;
import com.example.ERP.Models.AuditLog;
import com.example.ERP.Models.Role;
import com.example.ERP.Models.User;

@Component
public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.isActive(),
                user.getRoles() != null ? user.getRoles().stream().map(Role::getId).collect(Collectors.toSet()) : null,
                user.getAuditLogs() != null ? user.getAuditLogs().stream().map(AuditLog::getId).collect(Collectors.toSet()) : null
        );
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setActive(userDTO.isActive());
        // roles and auditLogs should be set by service layer or ORM relationships
        return user;
    }
}
