package com.antykostka;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HotbarManager {
    private List<String> hotbarItems;
    private final String configFilePath;

    public HotbarManager(String configFilePath) {
        this.hotbarItems = new ArrayList<>();
        this.configFilePath = configFilePath;
        loadConfiguration();
    }

    public void addItem(String item) {
        hotbarItems.add(item);
    }

    public void removeItem(String item) {
        hotbarItems.remove(item);
    }

    public List<String> getHotbarItems() {
        return hotbarItems;
    }

    public void saveConfiguration() {
        try (OutputStream output = new FileOutputStream(configFilePath)) {
            Properties properties = new Properties();
            for (int i = 0; i < hotbarItems.size(); i++) {
                properties.setProperty("item" + i, hotbarItems.get(i));
            }
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadConfiguration() {
        try (InputStream input = new FileInputStream(configFilePath)) {
            Properties properties = new Properties();
            properties.load(input);
            hotbarItems.clear();
            int i = 0;
            while (properties.containsKey("item" + i)) {
                hotbarItems.add(properties.getProperty("item" + i));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}