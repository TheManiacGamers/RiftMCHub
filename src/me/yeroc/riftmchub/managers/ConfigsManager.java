package me.yeroc.riftmchub.managers;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import me.yeroc.riftmchub.RiftMCHub;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import com.sk89q.minecraft.util.commands.ChatColor;

/**
 * Created by TheManiacGamers on 4/1/2016.
 */
public class ConfigsManager {

    static ConfigsManager instance = new ConfigsManager();
    private RiftMCHub plugin;
    private FileConfiguration config;
    private File cFile;
    private FileConfiguration locations;
    private File locationsFile;
    private FileConfiguration playersFile;
    private File pFile;

    private ConfigsManager() {
    }

    public static ConfigsManager getInstance() {
        return instance;
    }

    public void setup(Plugin p) {
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }

        cFile = new File(p.getDataFolder(), "config.yml");
        config = p.getConfig();

        locationsFile = new File(p.getDataFolder(), "locations.yml");
        if (!locationsFile.exists()) {
            try {
                locationsFile.createNewFile();
            } catch (IOException e) {
                RiftMCHub.log("[SEVERE] Could not create locations.yml!");
            }
        }

        locations = YamlConfiguration.loadConfiguration(locationsFile);
        RiftMCHub.log("Loaded locations.yml file successfully.");

        RiftMCHub.log("[Half A Heart] Loaded all the config files successfully!");
    }

    public FileConfiguration getLocations() {
        return locations;
    }

    public void saveLocations() {
        try {
            locations.save(locationsFile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save locations.yml!");
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            config.save(cFile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(cFile);
    }

    public PluginDescriptionFile getDesc() {
        return plugin.getDescription();
    }

}