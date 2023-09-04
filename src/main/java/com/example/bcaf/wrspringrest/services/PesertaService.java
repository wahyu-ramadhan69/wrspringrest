package com.example.bcaf.wrspringrest.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bcaf.wrspringrest.configuration.OtherConfiguration;
import com.example.bcaf.wrspringrest.model.PesertaModel;
import com.example.bcaf.wrspringrest.repo.PesertaRepo;
import com.example.bcaf.wrspringrest.util.LoggingFile;

@Service
@Transactional
public class PesertaService {

    @Autowired
    private PesertaRepo pesertaRepo;
    private String[] strExceptionArr = new String[2];

    public void simpanPeserta(PesertaModel pesertaModel) {
        pesertaRepo.save(pesertaModel);
    }

    public void save(PesertaModel pesertaModel) {
        try {
            int intX = 1 / 0;// COBA ERRORIN
            pesertaRepo.save(pesertaModel);
        } catch (Exception e) {
            strExceptionArr[1] = "save(Peserta peserta) --- LINE 30";
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfiguration.getFlagLoging());
        }

        /*
         * INSERT INTO PESERTA (id,nama,alamat,batch) VALUES
         * (peserta.getID,peserta.getNama,peserta.getAlamat,peserta.getBatch);
         */
    }
}
