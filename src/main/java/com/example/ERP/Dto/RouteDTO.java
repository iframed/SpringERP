package com.example.ERP.Dto;

   
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {
    private Long id;
    private String origin;
    private String destination;
    private int distance;
    private Long shipmentId;
}
