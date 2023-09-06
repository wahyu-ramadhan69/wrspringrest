package com.example.bcaf.wrspringrest.services;

import com.example.bcaf.wrspringrest.configuration.OtherConfiguration;
import com.example.bcaf.wrspringrest.core.ITService;
import com.example.bcaf.wrspringrest.dto.KategoriBarangDTO;
import com.example.bcaf.wrspringrest.handler.RequestCapture;
import com.example.bcaf.wrspringrest.handler.ResponseHandler;
import com.example.bcaf.wrspringrest.model.KategoriBarang;
import com.example.bcaf.wrspringrest.repo.KategoriBarangRepo;
import com.example.bcaf.wrspringrest.util.CsvReader;
import com.example.bcaf.wrspringrest.util.LoggingFile;
import com.example.bcaf.wrspringrest.util.TransformDataPaging;
import com.opencsv.CSVWriter;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class KategoriBarangService implements ITService<KategoriBarang> {

    private KategoriBarangRepo kategoriBarangRepo;
    private String[] strExceptionArr = new String[2];

    private TransformDataPaging transformDataPaging = new TransformDataPaging();
    private Map<String, Object> mapz = new HashMap<>();

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public KategoriBarangService(KategoriBarangRepo kategoriBarangRepo) {
        strExceptionArr[0] = "KategoriBarangService";
        this.kategoriBarangRepo = kategoriBarangRepo;
    }

    @Override
    public ResponseEntity<Object> save(KategoriBarang kategoriBarang, HttpServletRequest request) {
        if (kategoriBarang == null) {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid", // message
                    HttpStatus.BAD_REQUEST, // httpstatus
                    null, // object
                    "FV001001", // errorCode Fail Validation modul-code 001 sequence 001 range 001 - 010
                    request);
        }

        try {
            // untuk mencoba apakah exceptionnya sudah jalan atau belum
            // int intx = 1/0;
            kategoriBarangRepo.save(kategoriBarang);
        } catch (Exception e) {
            strExceptionArr[1] = "save(KategoriBarang kategoriBarang, HttpServletRequest request) --- LINE 59 \n"
                    + RequestCapture.allRequest(request);
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfiguration.getFlagLoging());
            return new ResponseHandler().generateResponse(
                    "Data Gagal Disimpan", // message
                    HttpStatus.INTERNAL_SERVER_ERROR, // httpstatus
                    null, // object
                    "FE001001", // errorCode Fail Error modul-code 001 sequence 001 range 001 - 010
                    request);
        }

        return new ResponseHandler().generateResponse(
                "Data Berhasil Disimpan", // message
                HttpStatus.CREATED, // httpstatus created
                null, // object
                null, // errorCode diisi null ketika data berhasil disimpan
                request);
    }

    @Override
    public ResponseEntity<Object> update(Long id, KategoriBarang kategoriBarang, HttpServletRequest request) {

        Optional<KategoriBarang> katBarang = kategoriBarangRepo.findById(id);

        if (katBarang.isEmpty()) {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid", // message
                    HttpStatus.BAD_REQUEST, // httpstatus
                    null, // object
                    "FV001011", // errorCode Fail Validation modul-code 001 sequence 001 range 011 - 020
                    request);
        }

        KategoriBarang kBarang = katBarang.get();

        try {
            kBarang.setNamaKategoriBarang(kategoriBarang.getNamaKategoriBarang());
        } catch (Exception e) {
            strExceptionArr[1] = " update(Long id,KategoriBarang kategoriBarang, HttpServletRequest request) --- LINE 101 \n"
                    + RequestCapture.allRequest(request);
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfiguration.getFlagLoging());
            return new ResponseHandler().generateResponse(
                    "Data Gagal Diubah", // message
                    HttpStatus.INTERNAL_SERVER_ERROR, // httpstatus
                    null, // object
                    "FE001011", // errorCode Fail Error modul-code 001 sequence 001 range 011 - 020
                    request);
        }

        return new ResponseHandler().generateResponse(
                "Data Berhasil Diubah", // message
                HttpStatus.CREATED, // httpstatus seharusnya no content 204 (permintaan berhasil tapi tidak ada
                                    // content untuk dikirim dalam response)
                null, // object
                null, // errorCode diisi null ketika data berhasil disimpan
                request);
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        Optional<KategoriBarang> katBarang = kategoriBarangRepo.findById(id);

        if (katBarang.isEmpty()) {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid", // message
                    HttpStatus.BAD_REQUEST, // httpstatus
                    null, // object
                    "FV001021", // errorCode Fail Validation modul-code 001 sequence 001 range 021 - 030
                    request);
        }

        try {
            kategoriBarangRepo.deleteById(id);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(
                    "Data Gagal Dihapus", // message
                    HttpStatus.INTERNAL_SERVER_ERROR, // httpstatus
                    null, // object
                    "FE001021", // errorCode Fail Error modul-code 001 sequence 001 range 021 - 030
                    request);
        }
        return new ResponseHandler().generateResponse(
                "Data Berhasil Dihapus", // message
                HttpStatus.CREATED, // httpstatus seharusnya no content 204 (permintaan berhasil tapi tidak ada
                                    // content untuk dikirim dalam response)
                null, // object
                null, // errorCode diisi null ketika data berhasil disimpan
                request);
    }

    @Override
    public ResponseEntity<Object> saveBatch(List<KategoriBarang> lt, HttpServletRequest request) {

        /*
         * Struk + Barang Detail
         * // generate struk
         * // save ke table header
         * // save all ke table detail
         */
        if (lt.isEmpty()) {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid", // message
                    HttpStatus.BAD_REQUEST, // httpstatus
                    null, // object
                    "FV001031", // errorCode Fail Validation modul-code 001 sequence 001 range 031 - 040
                    request);
        }

        try {
            kategoriBarangRepo.saveAll(lt);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(
                    "Data Gagal Disimpan", // message
                    HttpStatus.INTERNAL_SERVER_ERROR, // httpstatus
                    null, // object
                    "FE001031", // errorCode Fail Error modul-code 001 sequence 001 range 031 - 040
                    request);
        }

        return new ResponseHandler().generateResponse(
                "Data Berhasil Disimpan", // message
                HttpStatus.CREATED, // httpstatus created
                null, // object
                null, // errorCode diisi null ketika data berhasil disimpan
                request);

    }

    @Override
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {

        Optional<KategoriBarang> kategoriBarang;

        try {
            kategoriBarang = kategoriBarangRepo.findById(id);

            if (kategoriBarang == null) {
                return new ResponseHandler().generateResponse(
                        "Data tidak Ditemukan", // message
                        HttpStatus.NOT_FOUND, // httpstatus
                        null, // object
                        "FV001041", // errorCode Fail Validation modul-code 001 sequence 001 range 041 - 050
                        request);
            }

        } catch (Exception e) {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid", // message
                    HttpStatus.INTERNAL_SERVER_ERROR, // httpstatus
                    null, // object
                    "FE001041", // errorCode Fail Validation modul-code 001 sequence 001 range 041 - 050
                    request);
        }

        return new ResponseHandler().generateResponse(
                "Data Ditemukan", // message
                HttpStatus.OK, // httpstatus OK
                kategoriBarang.get(), // object
                null, // errorCode diisi null ketika data berhasil disimpan
                request);
    }

    @Override
    public ResponseEntity<Object> findByPage(Integer page,
            Integer size,
            String columFirst,
            String valueFirst,
            HttpServletRequest request) {

        Page<KategoriBarang> pageKategoriBarang;
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by("idKategoriBarang"));
            if (columFirst.equals("nama")) {
                pageKategoriBarang = kategoriBarangRepo.findByNamaKategoriBarangContains(pageable, valueFirst);
            } else {
                pageKategoriBarang = kategoriBarangRepo.findAll(pageable);
            }

            int dataSize = pageKategoriBarang.getContent().size();

            if (dataSize == 0) {
                return new ResponseHandler().generateResponse(
                        "Data tidak Ditemukan", // message
                        HttpStatus.NOT_FOUND, // httpstatus
                        null, // object
                        "FV001051", // errorCode Fail Validation modul-code 001 sequence 001 range 051 - 060
                        request);
            }

        } catch (Exception e) {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid", // message
                    HttpStatus.INTERNAL_SERVER_ERROR, // httpstatus
                    null, // object
                    "FE001051", // errorCode Fail Validation modul-code 001 sequence 001 range 051 - 060
                    request);
        }
        return new ResponseHandler().generateResponse(
                "Data Ditemukan", // message
                HttpStatus.OK, // httpstatus OK
                transformDataPaging.mapDataPaging(mapz, pageKategoriBarang), // object
                null, // errorCode diisi null ketika data berhasil disimpan
                request);
    }

    @Override
    public ResponseEntity<Object> findAllByPage(Integer page,
            Integer size,
            HttpServletRequest request) {
        Page<KategoriBarang> pageKategoriBarang;
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by("idKategoriBarang"));
            pageKategoriBarang = kategoriBarangRepo.findAll(pageable);
            int dataSize = pageKategoriBarang.getContent().size();
            if (dataSize == 0) {
                return new ResponseHandler().generateResponse(
                        "Data tidak Ditemukan", // message
                        HttpStatus.NOT_FOUND, // httpstatus
                        null, // object
                        "FV001061", // errorCode Fail Validation modul-code 001 sequence 001 range 061 - 070
                        request);
            }

        } catch (Exception e) {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid", // message
                    HttpStatus.INTERNAL_SERVER_ERROR, // httpstatus
                    null, // object
                    "FE001061", // errorCode Fail Validation modul-code 001 sequence 001 range 061 - 070
                    request);
        }
        return new ResponseHandler().generateResponse(
                "Data Ditemukan", // message
                HttpStatus.OK, // httpstatus OK
                transformDataPaging.mapDataPaging(mapz, pageKategoriBarang), // object
                null, // errorCode diisi null ketika data berhasil disimpan
                request);
    }

    @Override
    public ResponseEntity<Object> findAll(HttpServletRequest request) {
        List<KategoriBarang> listKategoriBarang;
        List<KategoriBarangDTO> listKategoriBarangDTO;
        try {
            listKategoriBarang = kategoriBarangRepo.findAll();
            listKategoriBarangDTO = modelMapper.map(listKategoriBarang, new TypeToken<List<KategoriBarangDTO>>() {
            }.getType());
            if (listKategoriBarang.size() == 0) {
                return new ResponseHandler().generateResponse(
                        "Data tidak Ditemukan", // message
                        HttpStatus.NOT_FOUND, // httpstatus
                        null, // object
                        "FV001071", // errorCode Fail Validation modul-code 001 sequence 001 range 071 - 080
                        request);
            }
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid", // message
                    HttpStatus.INTERNAL_SERVER_ERROR, // httpstatus
                    null, // object
                    "FE001071", // errorCode Fail Validation modul-code 001 sequence 001 range 071 - 080
                    request);
        }

        return new ResponseHandler().generateResponse(
                "Data Ditemukan", // message
                HttpStatus.OK, // httpstatus OK
                listKategoriBarangDTO, // object
                null, // errorCode diisi null ketika data berhasil disimpan
                request);
    }

    @Override
    public ResponseEntity<Object> dataToExport(MultipartFile multipartFile, HttpServletRequest request) {
        try {
            if (!CsvReader.isCsv(multipartFile)) {
                return new ResponseHandler().generateResponse(
                        "Tipe File tidak Valid", // message
                        HttpStatus.UNSUPPORTED_MEDIA_TYPE, // httpstatus
                        null, // object
                        "FV001081", // errorCode Fail Validation modul-code 001 sequence 001 range 081 - 090
                        request);
            }

            List<KategoriBarang> listKategoriBarang = CsvReader.csvToKategoriBarangData(multipartFile.getInputStream());
            if (listKategoriBarang.size() == 0) {
                return new ResponseHandler().generateResponse(
                        "Content tidak valid", // message
                        HttpStatus.BAD_REQUEST, // httpstatus
                        null, // object
                        "FV001082", // errorCode Fail Validation modul-code 001 sequence 001 range 081 - 090
                        request);
            }

            kategoriBarangRepo.saveAll(listKategoriBarang);

        } catch (Exception e) {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid", // message
                    HttpStatus.INTERNAL_SERVER_ERROR, // httpstatus
                    null, // object
                    "FE001081", // errorCode Fail Validation modul-code 001 sequence 001 range 081 - 090
                    request);
        }

        return new ResponseHandler().generateResponse(
                "Data Berhasil di Unggah", // message
                HttpStatus.CREATED, // httpstatus OK
                null, // object
                null, // errorCode diisi null ketika data berhasil disimpan
                request);
    }

    public void exportKatBarangToCsv() throws IOException {
        List<KategoriBarang> kategoriBarang = kategoriBarangRepo.findAll();

        String currentWorkingDirectory = System.getProperty("user.dir");
        // Membuat path ke folder target
        String targetDirectory = currentWorkingDirectory + "/target/";
        // Membuat file CSV dalam folder target
        FileWriter fileWriter = new FileWriter(targetDirectory + "products.csv");
        CSVWriter csvWriter = new CSVWriter(fileWriter);

        // Header CSV
        String[] header = { "ID", "Nama Produk", "Harga" };
        csvWriter.writeNext(header);

        // Data Produk
        for (KategoriBarang kategoriBarang2 : kategoriBarang) {
            String[] data = { String.valueOf(kategoriBarang2.getIdKategoriBarang()),
                    kategoriBarang2.getNamaKategoriBarang() };
            csvWriter.writeNext(data);
        }

        csvWriter.close();
    }
}