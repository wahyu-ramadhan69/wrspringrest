package com.example.bcaf.wrspringrest.services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bcaf.wrspringrest.model.KategoriBarang;
import com.example.bcaf.wrspringrest.repo.KategoriBarangRepo;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@Service
public class CsvExport {

    @Autowired
    private KategoriBarangRepo kategoriBarangRepo;

    public void exportToCsv() throws IOException {
        List<KategoriBarang> data = kategoriBarangRepo.findAll();

        try (Writer writer = new FileWriter("data.csv")) {
            StatefulBeanToCsv<KategoriBarang> beanToCsv = new StatefulBeanToCsvBuilder<KategoriBarang>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
        }
    }
}
