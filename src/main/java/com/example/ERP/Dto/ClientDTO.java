package com.example.ERP.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<Long> orderIds;
    private List<Long> quoteIds;
}
