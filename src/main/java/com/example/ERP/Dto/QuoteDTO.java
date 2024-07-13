package com.example.ERP.Dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDTO {
    private Long id;
    private LocalDate quoteDate;
    private String status;
    private Long clientId;
    private List<Long> quoteItemIds;
}
