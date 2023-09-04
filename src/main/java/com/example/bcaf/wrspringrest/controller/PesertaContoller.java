package com.example.bcaf.wrspringrest.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bcaf.wrspringrest.model.PesertaModel;
import com.example.bcaf.wrspringrest.repo.PesertaRepo;
import com.example.bcaf.wrspringrest.services.PesertaService;

@RestController
@RequestMapping("/peserta")
public class PesertaContoller {

    @Autowired
    PesertaRepo pesertaRepo;
    @Autowired
    PesertaService pesertaService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        Map<String, Object> m = new HashMap<String, Object>();
        List<PesertaModel> daftarPeserta = pesertaRepo.findAll();
        m.put("Data : ", daftarPeserta);
        m.put("Tanggal : ", new Date());
        m.put("Msg : ", "Berhasil mengambil data");
        return new ResponseEntity<Object>(m, HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    public String postData(@Valid @RequestBody PesertaModel pesertaModel) {

        pesertaService.save(pesertaModel);
        return "data" + pesertaModel.getNama() + "berhasil di input";
    }

    @GetMapping("/{id}")
    public Optional<PesertaModel> getPesertaById(@PathVariable Integer id) {
        return pesertaRepo.findById(id);
    }

    @GetMapping("/search-peserta-by-id")
    public Map<String, Object> searchPesertaById(@RequestParam(value = "id") Integer id) {
        Optional<PesertaModel> hasil = pesertaRepo.findById(id);
        Map<String, Object> m = new HashMap<>();
        if (hasil.isEmpty()) {
            m.put("msg", "hasil pencarian tidak ditemukan");
            return m;
        } else {
            m.put("data : ", hasil);
            m.put("msg : ", "data berhasil ditemukan");
            return m;
        }

    }

    @GetMapping("/search-peserta-by-nama")
    public Map<String, Object> searchPesertaByName(
            @RequestParam(value = "nama") String nama,
            @RequestParam(value = "batch") String batch) {
        List<PesertaModel> hasil = pesertaRepo.findBynamaContainsAndBatchContains(nama, batch);
        Map<String, Object> m = new HashMap<>();
        if (hasil.isEmpty()) {
            m.put("message", "Data tidak ada");
            return m;
        }
        m.put("data", hasil);
        m.put("message", "Data ditemukan");
        return m;
    }

}
