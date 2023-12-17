package zero.discord.spigotcreate.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import zero.discord.spigotcreate.Main;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class CustomConfigManager {

    private final Plugin plugin;
    private final File configFile;
    private FileConfiguration fileConfiguration;

    public CustomConfigManager(Plugin plugin, String fileName) {
        this.plugin = Main.Instance;
        this.configFile = new File(plugin.getDataFolder(), fileName);
        createConfig();
    }

    private void createConfig() {
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();

            plugin.saveResource(configFile.getName(), false);
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
    }

    public FileConfiguration getConfig() {
        if (fileConfiguration == null) {
            reloadConfig();
        }
        return fileConfiguration;
    }

    public synchronized void saveConfig() {
        if (fileConfiguration == null || configFile == null) {
            return;
        }
        try {
            getConfig().save(configFile);
        } catch (IOException ex) {
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex);
        }
    }

    public void reloadConfig() {
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
    }

    public String getName() {
        return configFile.getName();
    }
}
