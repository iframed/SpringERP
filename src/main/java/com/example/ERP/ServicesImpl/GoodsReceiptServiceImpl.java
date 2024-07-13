package com.example.ERP.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.Dto.GoodsReceiptDTO;
import com.example.ERP.Mappers.GoodsReceiptMapper;
import com.example.ERP.Models.GoodsReceipt;
import com.example.ERP.Repository.GoodsReceiptRepository;
import com.example.ERP.Services.GoodsReceiptService;


@Service
public class GoodsReceiptServiceImpl  implements GoodsReceiptService {

    @Autowired
    private GoodsReceiptRepository goodsReceiptRepository;

    @Override
    public GoodsReceiptDTO createGoodsReceipt(GoodsReceiptDTO goodsReceiptDTO) {
        GoodsReceipt goodsReceipt = GoodsReceiptMapper.toEntity(goodsReceiptDTO);
        GoodsReceipt savedGoodsReceipt = goodsReceiptRepository.save(goodsReceipt);
        return GoodsReceiptMapper.toDTO(savedGoodsReceipt);
    }

    @Override
    public GoodsReceiptDTO updateGoodsReceipt(Long id, GoodsReceiptDTO goodsReceiptDTO) {
        GoodsReceipt goodsReceipt = goodsReceiptRepository.findById(id).orElseThrow(() -> new RuntimeException("GoodsReceipt not found"));
        goodsReceipt.setReceiptDate(goodsReceiptDTO.getReceiptDate());
        goodsReceipt.setStatus(goodsReceiptDTO.getStatus());
        GoodsReceipt updatedGoodsReceipt = goodsReceiptRepository.save(goodsReceipt);
        return GoodsReceiptMapper.toDTO(updatedGoodsReceipt);
    }

    @Override
    public void deleteGoodsReceipt(Long id) {
        goodsReceiptRepository.deleteById(id);
    }

    @Override
    public GoodsReceiptDTO getGoodsReceiptById(Long id) {
        GoodsReceipt goodsReceipt = goodsReceiptRepository.findById(id).orElseThrow(() -> new RuntimeException("GoodsReceipt not found"));
        return GoodsReceiptMapper.toDTO(goodsReceipt);
    }

    @Override
    public List<GoodsReceiptDTO> getAllGoodsReceipts() {
        return goodsReceiptRepository.findAll().stream().map(GoodsReceiptMapper::toDTO).collect(Collectors.toList());
    }
}
