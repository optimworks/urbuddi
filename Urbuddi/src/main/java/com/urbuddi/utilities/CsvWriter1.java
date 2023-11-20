package com.urbuddi.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter1 {
	 public void writeDataToCsv(List<String> headers, List<List<String>> data, String filePath) {
	        try (FileWriter writer = new FileWriter(filePath)) {
	            // Write headers
	            writeLine(writer, headers);

	            // Write data
	            for (List<String> rowData : data) {
	                writeLine(writer, rowData);
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("Error writing to CSV file", e);
	        }
	    }

	    private void writeLine(FileWriter writer, List<String> data) throws IOException {
	        boolean firstEntry = true;
	        for (String entry : data) {
	            if (!firstEntry) {
	                writer.append(",");
	            }
	            writer.append(entry);
	            firstEntry = false;
	        }
	        writer.append("\n");
	    }

}
