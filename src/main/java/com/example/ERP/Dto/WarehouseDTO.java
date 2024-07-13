package com.example.ERP.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDTO {
    private Long id;
    private String name;
    private String location;
    private List<Long> inventoryIds;
}
