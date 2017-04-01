package me.yeroc.riftmchub.registers;

import me.yeroc.riftmchub.RiftMCHub;
import me.yeroc.riftmchub.listeners.PVPListener;
import me.yeroc.riftmchub.listeners.PlayerListener;
import org.bukkit.plugin.PluginManager;

/**
 * Created by creyn63 on 5/07/2016.
 */
public class ListenersRegister {
    RiftMCHub plugin;

    public ListenersRegister(RiftMCHub plugin) {
        this.plugin = plugin;
    }

    public ListenersRegister() {

    }

    public static ListenersRegister instance = new ListenersRegister();

    public static ListenersRegister getInstance() {
        return instance;
    }

    public void registerListeners(RiftMCHub plugin) {
        RiftMCHub.log("Enabling the listener classes.");
        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new PlayerListener(plugin), plugin);
        RiftMCHub.log("Player Listener Class was registered.");

        pm.registerEvents(new PVPListener(plugin), plugin);
        RiftMCHub.log("PVPListener Class was registered.");

        RiftMCHub.log("All Listener Classes were registered.");

    }
}
