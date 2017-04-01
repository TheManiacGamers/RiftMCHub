package me.yeroc.riftmchub.listeners;

import com.sk89q.minecraft.util.commands.ChatColor;
import me.yeroc.riftmchub.RiftMCHub;
import me.yeroc.riftmchub.managers.StringsManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by Corey on 30/03/2017.
 */
public class PVPListener implements Listener {

    RiftMCHub plugin;
    StringsManager strings = StringsManager.getInstance();

    public PVPListener(RiftMCHub plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerAttacked(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player && e.getEntity() instanceof Player)) {
            return;
        }
        Player p = (Player) e.getEntity();
        Player d = (Player) e.getDamager();
        if (d.getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
            return;
        }
        if (d.getItemInHand().getType().equals(Material.DIAMOND_SWORD)) {
            d.sendMessage(strings.defaultMsgs + ChatColor.RED + "" + ChatColor.BOLD + "Hey!" + ChatColor.GRAY + " Sorry, but you can't PvP here.");
            e.setCancelled(true);
            return;
        }
        if (d.getItemInHand().getType().equals(Material.IRON_SWORD)) {
            d.sendMessage(strings.defaultMsgs + ChatColor.RED + "" + ChatColor.BOLD + "Hey!" + ChatColor.GRAY + " Sorry, but you can't PvP here.");
            e.setCancelled(true);
            return;
        }
        if (d.getItemInHand().getType().equals(Material.GOLD_SWORD)) {
            d.sendMessage(strings.defaultMsgs + ChatColor.RED + "" + ChatColor.BOLD + "Hey!" + ChatColor.GRAY + " Sorry, but you can't PvP here.");
            e.setCancelled(true);
            return;
        }
        if (d.getItemInHand().getType().equals(Material.WOOD_SWORD)) {
            d.sendMessage(strings.defaultMsgs + ChatColor.RED + "" + ChatColor.BOLD + "Hey!" + ChatColor.GRAY + " Sorry, but you can't PvP here.");
            e.setCancelled(true);
            return;
        }
        e.setCancelled(true);
    }
}
