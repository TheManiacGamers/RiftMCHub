package me.yeroc.riftmchub.managers;

import com.sk89q.minecraft.util.commands.ChatColor;

/**
 * Created by creyn63 on 5/07/2016.
 */
public class StringsManager {

    static StringsManager instance = new StringsManager();

    private StringsManager() {
    }

    public static StringsManager getInstance() {
        return instance;
    }

    /////////////////////////////////////////////// PLUGIN MESSAGES //////////////////////////////////////////////////////////////////
    public String defaultMsgs = (ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Server" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "] " + ChatColor.GREEN);
    public String noPermissionCommand = (ChatColor.RED + "You do not have enough permissions to execute this command.");
    public String needToBePlayerCMD = (ChatColor.RED + "You need to be a player to execute this command.");

}