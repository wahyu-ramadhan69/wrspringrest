package com.example.bcaf.wrspringrest.controller;

import com.example.bcaf.wrspringrest.dto.KategoriBarangDTO;
import com.example.bcaf.wrspringrest.model.KategoriBarang;
import com.example.bcaf.wrspringrest.services.CsvExport;
import com.example.bcaf.wrspringrest.services.KategoriBarangService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/katbarang")
public class KategoriBarangController {
    private KategoriBarangService kategoriBarangService;
    private CsvExport csvExport;

    public KategoriBarangController(KategoriBarangService kategoriBarangService) {
        this.kategoriBarangService = kategoriBarangService;
    }

    @PostMapping("/sv")
    public ResponseEntity<Object> save(@RequestBody KategoriBarang kategoriBarang, HttpServletRequest request) {

        return kategoriBarangService.save(kategoriBarang, request);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
            @RequestBody KategoriBarang kategoriBarang, HttpServletRequest request)
            throws Exception {
        return kategoriBarangService.update(id, kategoriBarang, request);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        return kategoriBarangService.delete(id, request);
    }

    @PostMapping("/svb")
    public ResponseEntity<Object> saveBatch(@RequestBody List<KategoriBarang> listKategoriBarang,
            HttpServletRequest request) {
        return kategoriBarangService.saveBatch(listKategoriBarang, request);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        return kategoriBarangService.findById(id, request);
    }

    @GetMapping("/v1/fbp/{page}/{size}")
    public ResponseEntity<Object> findByPage(
            @PathVariable(value = "page") Integer page,
            @PathVariable(value = "size") Integer size,
            @RequestParam(value = "col") String columFirst,
            @RequestParam(value = "val") String valueFirst,
            HttpServletRequest request) {
        return kategoriBarangService.findByPage(page, size, columFirst, valueFirst, request);
    }

    @GetMapping("/v1/fabp/{page}/{size}")
    public ResponseEntity<Object> findAllByPage(
            @PathVariable(value = "page") Integer page,
            @PathVariable(value = "size") Integer size,
            HttpServletRequest request) {
        return kategoriBarangService.findAllByPage(page, size, request);
    }

    @GetMapping("/findall")
    public ResponseEntity<Object> findAll(HttpServletRequest request) {
        return kategoriBarangService.findAll(request);
    }

    @PostMapping("/uplcsv")
    public ResponseEntity<Object> export(@RequestParam("demoFile") @RequestHeader MultipartFile multipartFile,
            HttpServletRequest request) {
        return kategoriBarangService.dataToExport(multipartFile, request);
    }

    @GetMapping("/export-csv")
    public ResponseEntity<String> exportCsv() throws IOException {
        kategoriBarangService.exportKatBarangToCsv();
        return ResponseEntity.ok("Data produk telah diekspor ke CSV.");
    }

}