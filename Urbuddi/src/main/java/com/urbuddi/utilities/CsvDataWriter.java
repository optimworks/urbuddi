package com.urbuddi.utilities;

import java.io.FileWriter;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVWriter;

public class CsvDataWriter {
	private final String csvFilePath;

    public CsvDataWriter(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }
    public void writeDataToCsv(String[] data) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath, true)) /* 'true' to append data */) {
            writer.writeNext(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
