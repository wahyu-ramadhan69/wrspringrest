package com.example.bcaf.wrspringrest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcaf.wrspringrest.dto.BarangDTO;
import com.example.bcaf.wrspringrest.model.Barang;
import com.example.bcaf.wrspringrest.services.BarangService;

@RestController
@RequestMapping("/barang")
public class BarangController {

    private BarangService barangService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BarangController(BarangService barangService) {
        this.barangService = barangService;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> findAll(HttpServletRequest request) {
        return barangService.findAll(request);
    }

    @PostMapping("/simpan")
    public ResponseEntity<Object> save(@RequestBody BarangDTO barangDTO,
            HttpServletRequest request) {
        Barang barang = modelMapper.map(barangDTO, new TypeToken<Barang>() {
        }.getType());
        return barangService.save(barang, request);
    }
}
