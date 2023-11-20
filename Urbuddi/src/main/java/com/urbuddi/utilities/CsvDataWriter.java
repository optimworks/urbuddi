package com.urbuddi.utilities;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import au.com.bytecode.opencsv.CSVWriter;

public class CsvDataWriter {
	private final String csvFilePath;

	public CsvDataWriter(String csvFilePath) {
		this.csvFilePath = csvFilePath;
	}

	public void appendDataToNextRow(String[] newData) throws CsvException {
		try {
			// Read existing data
			List<String[]> existingData = readAllData();

			// Append new data to the next row
			existingData.add(newData);

			// Write the updated data back to the CSV file
			writeAllData(existingData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<String[]> readAllData() throws IOException, CsvException {
		try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
			return reader.readAll();
		}
	}

	private void writeAllData(List<String[]> data) throws IOException {
		try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
			writer.writeAll(data);
		}
	}

	public void writeHeaders(String[] headers) {
		try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
			writer.writeNext(headers);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
