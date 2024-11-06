package service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelService {

    public static Object[][] readExcel(String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            int rowIndex = i - 1;
                            switch (cell.getCellType()) {
                                case STRING:
                                    data[rowIndex][j] = cell.getStringCellValue();
                                    break;
                                case NUMERIC:
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        data[rowIndex][j] = cell.getDateCellValue();
                                    } else {
                                        data[rowIndex][j] = cell.getNumericCellValue();
                                    }
                                    break;
                                case BOOLEAN:
                                    data[rowIndex][j] = cell.getBooleanCellValue();
                                    break;
                                case FORMULA:
                                    data[rowIndex][j] = cell.getCellFormula();
                                    break;
                                case BLANK:
                                    data[rowIndex][j] = "";
                                    break;
                                default:
                                    data[rowIndex][j] = "invalid";
                                    break;
                            }
                        }
                    }
                }
            }
            return data;
        }
    }

    public static void writeExcel(String fileName, Object[][] data) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Sheet1");

            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i);

                for (int j = 0; j < data[i].length; j++) {
                    Cell cell = row.createCell(j);
                    Object value = data[i][j];

                    switch (value) {
                        case String s -> cell.setCellValue(s);
                        case Integer integer -> cell.setCellValue(integer);
                        case Double v -> cell.setCellValue(v);
                        case Boolean b -> cell.setCellValue(b);
                        case Long l -> cell.setCellValue(l);
                        case null -> cell.setCellValue("");
                        default -> cell.setCellValue(value.toString());
                    }
                    System.out.print(value + " | ");
                }
                System.out.println();
            }

            workbook.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
