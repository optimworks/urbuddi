package com.urbuddi.steps;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CsvDataReader {
	public List<String[]> readDataFromCsv(String filePath) {
        List<String[]> data = null;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            data = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

}
