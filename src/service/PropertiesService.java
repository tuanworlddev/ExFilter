package service;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class PropertiesService {
    private static PropertiesService instance;
    private final String propertiesFilePath = "resources/config.properties";
    private final Properties properties;

    private PropertiesService() {
        properties = new Properties();
        File file = new File(propertiesFilePath);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            FileService.createFile(propertiesFilePath);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
        try (FileOutputStream fos = new FileOutputStream(propertiesFilePath)) {
            properties.store(fos, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setProperty(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            properties.setProperty(entry.getKey(), entry.getValue());
        }
        try (FileOutputStream fos = new FileOutputStream(propertiesFilePath)) {
            properties.store(fos, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PropertiesService getInstance() {
        if (instance == null) {
            instance = new PropertiesService();
        }
        return instance;
    }
}
