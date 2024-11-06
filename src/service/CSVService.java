package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVService {
    public static void writeCSV(String fileName, Object[][] data) {
        try (FileWriter writer = new FileWriter(fileName)) {

            for (Object[] datum : data) {
                StringBuilder rowBuilder = new StringBuilder();

                for (int j = 0; j < datum.length; j++) {
                    Object value = datum[j];

                    String cellValue;
                    if (value == null) {
                        cellValue = "";
                    } else if (value instanceof String) {
                        cellValue = escapeSpecialCharacters((String) value);
                    } else {
                        cellValue = value.toString();
                    }

                    rowBuilder.append(cellValue);

                    if (j < datum.length - 1) {
                        rowBuilder.append(",");
                    }
                }

                writer.write(rowBuilder.toString());
                writer.write("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException("Error writing CSV file: " + e.getMessage(), e);
        }
    }

    private static String escapeSpecialCharacters(String value) {
        String escapedValue = value;

        if (escapedValue.contains("\"")) {
            escapedValue = escapedValue.replace("\"", "\"\"");
        }

        if (escapedValue.contains(",") || escapedValue.contains("\"")) {
            escapedValue = "\"" + escapedValue + "\"";
        }

        return escapedValue;
    }

    public static List<String> readCSV(String fileName) throws IOException {
        File file = new File(fileName);
        List<String> data = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = bf.readLine()) != null) {
                    data.add(line);
                }
            }
        }
        return data;
    }
}
