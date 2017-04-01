package me.yeroc.riftmchub.utils;

import com.sk89q.minecraft.util.commands.ChatColor;
import me.yeroc.riftmchub.RiftMCHub;
import me.yeroc.riftmchub.managers.PermissionsManager;
import me.yeroc.riftmchub.managers.StringsManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

/**
 * Created by creyn63 on 5/07/2016.
 */
public class CoreysAPI {
    RiftMCHub plugin;
    private static CoreysAPI instance = new CoreysAPI();
    private StringsManager strings = StringsManager.getInstance();
    private PermissionsManager perms = PermissionsManager.getInstance();

    public CoreysAPI() {
    }

    public static CoreysAPI getInstance() {
        return instance;
    }

    public void broadcastMessage(String args) {
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.LIGHT_PURPLE + "Broadcast" + ChatColor.DARK_PURPLE + "]" + ChatColor.DARK_GRAY + " >> " + ChatColor.WHITE + args.replaceAll("(&([a-o0-9]))", "\u00A7$2"));
    }

    // player files
    public void savePF(final Player p) {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Hub").getDataFolder(), File.separator + "PlayerDatabase");
        File pFile = new File(userdata, File.separator + p.getUniqueId() + ".yml");
        final FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
        try {
            playerData.save(pFile);
            RiftMCHub.log("Saved Player File.");
        } catch (IOException ex) {
            RiftMCHub.log("Could not save " + p.getName() + "'s player file!");
            Bukkit.broadcastMessage("Error has been found. Please get yeroc to check console.");
            ex.printStackTrace();
        }
    }

    public void pfExists(final Player p) {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Hub").getDataFolder(), File.separator + "PlayerDatabase");
        File pFile = new File(userdata, File.separator + p.getUniqueId() + ".yml");
        final FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
        if (pFile.exists()) {
            RiftMCHub.log(p.getName() + "'s player file has been loaded. (" + p.getUniqueId() + ")");
            if (playerData.get("Options.username") == null) {
                playerData.set("Options.username", p.getName());
                RiftMCHub.log("Player was found with an incomplete player file. Fixed Options.username");
            }
            if (playerData.get("Stats.totalLogins") == null) {
                playerData.set("Stats.totalLogins", 1);
                RiftMCHub.log("Player was found with an incomplete player file. Fixed Stats.totalLogins");

            }
            if (playerData.get("Stats.totalAchievements") == null) {
                playerData.set("Stats.totalAchievements", 0);
                RiftMCHub.log("Player was found with an incomplete player file. Fixed Stats.totalAchievements");

            }
            if (playerData.get("Stats.kills") == null) {
                playerData.set("Stats.kills", 0);
                RiftMCHub.log("Player was found with an incomplete player file. Fixed Stats.kills");

            }
            if (playerData.get("Stats.deaths") == null) {
                playerData.set("Stats.deaths", 0);
                RiftMCHub.log("Player was found with an incomplete player file. Fixed Statas.deaths");

            }
            if (playerData.get("Stats.killstreak") == null) {
                playerData.set("Stats.killstreak", 0);
                RiftMCHub.log("Player was found with an incomplete player file. Fixed Stats.killstreak");

            }
            if (playerData.get("Stats.highestKS") == null) {
                playerData.set("Stats.highestKS", 0);
                RiftMCHub.log("Player was found with an incomplete player file. Fixed Stats.highestKS");

            }
            if (playerData.get("Stats.xptonextlevel") == null) {
                playerData.set("Stats.xptonextlevel", 100);
                RiftMCHub.log("Player was found with an incomplete player file. Fixed Stats.xptonextlevel");
            }
            if (playerData.get("Stats.level") == null) {
                playerData.set("Stats.level", 0);
                RiftMCHub.log("Player was found with an incomplete player file. Fixed Stats.level");
            }
            try {
                playerData.save(pFile);
            } catch (IOException ex) {
                RiftMCHub.log("Could not save " + p.getName() + "'s player file!");
                Bukkit.broadcastMessage("Error has been found. Please get yeroc to check console.");
                ex.printStackTrace();
            }
            playerData.set("Stats.totalLogins", playerData.getInt("Stats.totalLogins") + 1);
            try {
                playerData.save(pFile);
            } catch (IOException ex) {
                RiftMCHub.log("Could not save " + p.getName() + "'s player file!");
                Bukkit.broadcastMessage("Error has been found. Please get yeroc to check console.");
                ex.printStackTrace();
            }
        } else {
            createPF(p);
        }
    }

    public void savePfToFile(final Player p) {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Hub").getDataFolder(), File.separator + "PlayerDatabase");
        File pFile = new File(userdata, File.separator + p.getUniqueId() + ".yml");
        final FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
//        playerData.getConfigurationSection("Options").set("Group", pInfo.GROUP);
//        playerData.getConfigurationSection("Stats").set("kills", pStats.kills);
//        playerData.getConfigurationSection("Stats").set("deaths", pStats.deaths);
//        playerData.getConfigurationSection("Stats").set("level", pStats.level);
//        playerData.getConfigurationSection("Stats").set("xptonextlevel", pStats.xptonxtlevel);
//        playerData.getConfigurationSection("Stats").set("killstreak", pStats.killstreak);
//        playerData.getConfigurationSection("Stats").set("highestks", pStats.highestks);
//        playerData.set("Achievements.Reach10Kills", pAchs.Reach10Kills);
//        playerData.set("Achievements.Reach50Kills", pAchs.Reach50Kills);
//        playerData.set("Achievements.KillyeroC", pAchs.KillyeroC);
//        playerData.set("Achievements.Join50Times", pAchs.Join50Times);
//        playerData.set("Achievements.Join100Times", pAchs.Join100Times);
//        playerData.set("Achievements.Join150Times", pAchs.Join150Times);
//        playerData.set("Achievements.Join200Times", pAchs.Join200Times);
//        playerData.set("Achievements.ReachAKSOf20", pAchs.ReachAKSOf20);
//        playerData.set("Achievements.ReachGod", pAchs.ReachGod);
//        playerData.set("Stats.totalAchievements", pAchs.totalAchievements);
        try {
            playerData.save(pFile);
        } catch (IOException ex) {
            ex.printStackTrace();
            Bukkit.broadcastMessage(ChatColor.RED + "Couldn't save " + p.getName() + "'s stats file!");
        }
    }

    public void createPF(final Player p) {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Hub").getDataFolder(), File.separator + "PlayerDatabase");
        File pFile = new File(userdata, File.separator + p.getUniqueId() + ".yml");
        final FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
        if (pFile.exists()) {
            RiftMCHub.log(p.getUniqueId() + "'s player file has already been created.");
        } else {
            RiftMCHub.log(p.getUniqueId() + "'s player file was not found. Generating it.");
            try {
                pFile.createNewFile();
                playerData.createSection("Options.username");
                playerData.createSection("Stats.totalLogins");
                playerData.createSection("Stats.totalAchievements");
                playerData.createSection("Stats.level");
                playerData.createSection("Stats.kills");
                playerData.createSection("Stats.deaths");
                playerData.createSection("Stats.killstreak");
                playerData.createSection("Stats.highestKS");
                playerData.createSection("Stats.xptonextlevel");
                playerData.set("Options.username", p.getName());
                playerData.set("Stats.totalLogins", 1);
                playerData.set("Stats.totalAchievements", 0);
                playerData.set("Stats.level", 0);
                playerData.set("Stats.kills", 0);
                playerData.set("Stats.deaths", 0);
                playerData.set("Stats.killstreak", 0);
                playerData.set("Stats.highestKS", 0);
                playerData.set("Stats.xptonextlevel", 100);
                try {
                    playerData.save(pFile);
                } catch (IOException ex) {
                    RiftMCHub.log("Could not save " + p.getName() + "'s player file!");
                    Bukkit.broadcastMessage("Error has been found. Please get yeroc to check console.");
                    ex.printStackTrace();
                }
            } catch (IOException ex) {
                Bukkit.broadcastMessage("Error has been found. Please get yeroc to check console.");
                ex.printStackTrace();
            }
        }
    }

    public void setPF(final Player p, String loc, String args) {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Hub").getDataFolder(), File.separator + "PlayerDatabase");
        File pFile = new File(userdata, File.separator + p.getUniqueId() + ".yml");
        final FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
    }

    public void resetPF(final Player p) {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Hub").getDataFolder(), File.separator + "PlayerDatabase");
        File pFile = new File(userdata, File.separator + p.getUniqueId() + ".yml");
        final FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
        pFile.delete();
        pfExists(p);
        p.sendMessage(strings.defaultMsgs + ChatColor.RED + "Your player file was reset.");
        RiftMCHub.log(p.getName() + "'s player file was reset.");
        try {
            playerData.save(pFile);
        } catch (IOException ex) {
            RiftMCHub.log("Could not save " + p.getName() + "'s player file!");
            Bukkit.broadcastMessage("Error has been found. Please get yeroc to check console.");
            ex.printStackTrace();
        }
    }

}