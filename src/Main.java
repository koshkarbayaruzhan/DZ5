package singleton;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {

    private static volatile ConfigurationManager instance;

    private Map<String, String> settings;

    private ConfigurationManager() {
        settings = new HashMap<>();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public void set(String key, String value) {
        settings.put(key, value);
    }

    public String get(String key) {
        if (!settings.containsKey(key)) {
            throw new RuntimeException("Нет такой настройки: " + key);
        }
        return settings.get(key);
    }

    public void loadFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    settings.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
    }

    public void saveToFile(String path) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Map.Entry<String, String> entry : settings.entrySet()) {
                bw.write(entry.getKey() + "=" + entry.getValue());
                bw.newLine();
            }
        }
    }

    public void printAll() {
        settings.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
