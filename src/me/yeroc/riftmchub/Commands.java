package me.yeroc.riftmchub;


import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import me.yeroc.riftmchub.managers.PermissionsManager;
import me.yeroc.riftmchub.managers.StringsManager;
import me.yeroc.riftmchub.utils.CoreysAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Created by Corey on 3/12/2016.
 */
public class Commands {
    CoreysAPI api = CoreysAPI.getInstance();
    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();
    RiftMCHub plugin;

    public Commands(RiftMCHub plugin) {
        this.plugin = plugin;
    }

    @Command(aliases = "rs", desc = "Teleport to spawn.")
    public void onList(CommandContext args, CommandSender sender) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("riftmc.rs")) {
                // teleport to spawn, no message.

            } else {
                sender.sendMessage(strings.noPermissionCommand);
            }
        } else {
            sender.sendMessage(strings.needToBePlayerCMD);
        }
    }
}