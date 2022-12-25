package de.philipp.wirelesschest.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileUtils {

    private File folder = new File("plugins/WirelessChest/");
    private File chestFiles = new File(folder, "chests.yml");

    private YamlConfiguration chestConfig = YamlConfiguration.loadConfiguration(chestFiles);

    public FileUtils() {
        if(!folder.exists()) {
            folder.mkdir();
        }
        try {
            if(!chestFiles.exists()) {
                chestFiles.createNewFile();
            }
        }catch (Exception ex ) {
            ex.printStackTrace();
        }

    }
}
