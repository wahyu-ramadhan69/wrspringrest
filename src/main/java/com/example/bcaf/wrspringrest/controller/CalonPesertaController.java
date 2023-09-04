package com.example.bcaf.wrspringrest.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bcaf.wrspringrest.model.CalonPeserta;

@RestController
@RequestMapping("/calon")
public class CalonPesertaController {

    @PostMapping("/seleksi")
    public Map<String, Object> seleksiCalonPeserta(@Valid @RequestBody CalonPeserta calon) {
        System.out.println("Parkir Disini !!");
        calon.setNilai(100);
        calon.setUmur(79);

        Map<String, Object> mapz = new HashMap<>();
        mapz.put("message", "OK BOSS !!");
        mapz.put("data", calon);
        mapz.put("status", "single");
        mapz.put("waktu", new Date());
        if (calon.getNilai() > 80
                && calon.getUmur() >= 18
                && calon.getUmur() <= 60) {
            // return calon.getNama() + " lolos seleksi";
            // business logic
        } else {
            // return calon.getNama() + " tidak lolos seleksi";
            // business logic
        }
        return mapz;
    }

}
