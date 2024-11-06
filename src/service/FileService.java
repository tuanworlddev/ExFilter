package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static void createFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                File parentDir = file.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    if (!parentDir.mkdirs()) {
                        throw new RuntimeException("Không thể tạo thư mục: " + parentDir.getAbsolutePath());
                    }
                }

                if (!file.createNewFile()) {
                    throw new RuntimeException("Không thể tạo tệp: " + file.getAbsolutePath());
                }
            } catch (IOException e) {
                throw new RuntimeException("Lỗi khi tạo tệp config.properties", e);
            }
        }
    }

    public static void writeCSVFile(String filePath, Object[][] content, boolean append) {
        File file = new File(filePath);
        if (!file.exists()) {
            createFile(filePath);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            for (Object[] row : content) {
                for (int j = 0; j < row.length; j++) {
                    bw.write(row[j] == null ? "" : row[j].toString());
                    if (j < row.length - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeCSVFile(String filePath, List<String> list, boolean append) {
        File file = new File(filePath);
        if (!file.exists()) {
            createFile(filePath);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            for (String line : list) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (!file.delete()) {
                throw new RuntimeException("Delete failed: " + file.getAbsolutePath());
            }
        }
    }

}
