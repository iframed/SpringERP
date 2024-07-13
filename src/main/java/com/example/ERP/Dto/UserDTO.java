package com.example.ERP.Dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private boolean active;
    private Set<Long> roleIds;
    private Set<Long> auditLogIds;
}