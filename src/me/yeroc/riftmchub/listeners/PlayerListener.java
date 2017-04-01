package me.yeroc.riftmchub.listeners;

import me.yeroc.riftmchub.RiftMCHub;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Corey on 26/03/2017.
 */
public class PlayerListener implements Listener {

    RiftMCHub plugin;

    public PlayerListener(RiftMCHub plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
    }
}
