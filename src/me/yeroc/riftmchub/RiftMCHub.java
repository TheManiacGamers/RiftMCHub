package me.yeroc.riftmchub;

import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.*;
import me.yeroc.riftmchub.managers.StringsManager;
import me.yeroc.riftmchub.registers.ListenersRegister;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

/**
 * Created by Corey on 19/08/2016.
 */
public class RiftMCHub extends JavaPlugin implements Listener {
    private static RiftMCHub instance;
    public static RiftMCHub plugin;
    private ArrayList<Class> cmdClasses;
    private StringsManager strings = StringsManager.getInstance();
    private ListenersRegister listeners = ListenersRegister.getInstance();
    private CommandsManager<CommandSender> commands;
    private Location spawn;

    public static RiftMCHub getInstance() {
        return instance;
    }

    public static void log(String message) {
        System.out.println("[RiftMCHub] " + message);
    }


    public void onEnable() {
        plugin = this;
        registerCommandClass(Commands.class);
        registerCommands();
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        listeners.registerListeners(plugin);

        // STARTING THE EXP CHECK TASK

        log("Plugin was loaded.");

        if (Bukkit.getOnlinePlayers().size() != 0) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                // put stuff here
            }
        }
    }

    public void onDisable() {
        if (Bukkit.getOnlinePlayers().size() != 0) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                // saving player files
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            commands.execute(cmd.getName(), args, sender, sender);
        } catch (CommandPermissionsException e) {

            sender.sendMessage(ChatColor.RED + "You don't have permission.");
        } catch (MissingNestedCommandException e) {
            sender.sendMessage(ChatColor.RED + e.getUsage());
        } catch (CommandUsageException e) {
            sender.sendMessage(ChatColor.RED + e.getMessage());
            sender.sendMessage(ChatColor.RED + e.getUsage());
        } catch (WrappedCommandException e) {
            if (e.getCause() instanceof NumberFormatException) {

                sender.sendMessage(ChatColor.RED + "You need to enter a number!");
            } else {
                sender.sendMessage(ChatColor.RED + "Error occurred, contact developer. [TheManiacGamers]");
                sender.sendMessage(ChatColor.RED + "Message: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (CommandException e) {
            sender.sendMessage(ChatColor.RED + e.getMessage());
        }

        return true;
    }

    protected void registerCommandClass(Class cmdClass) {
        if (cmdClasses == null)
            cmdClasses = new ArrayList<Class>();

        cmdClasses.add(cmdClass);
    }

    protected void registerCommands() {
        if (cmdClasses == null || cmdClasses.size() < 1) {

            log("Could not register commands! Perhaps you registered no classes?");
            return;
        }

        // Register the commands that we want to use
        commands = new CommandsManager<CommandSender>() {
            @Override
            public boolean hasPermission(CommandSender player, String perm) {
                return getInstance().hasPerm(player, perm);
            }


        };
        commands.setInjector(new SimpleInjector(this));
        final CommandsManagerRegistration cmdRegister = new CommandsManagerRegistration(this, commands);

        for (Class cmdClass : cmdClasses)
            cmdRegister.register(cmdClass);
    }

    public boolean hasPerm(CommandSender sender, String perm) {
        return sender instanceof ConsoleCommandSender || sender.hasPermission(perm);
    }

    public void setSpawn() {
//        spawn.setX(configs.);
//        spawn.setY(configs.);
//        spawn.setZ(configs.);
//        spawn.setYaw(configs.);
//        spawn.setPitch(configs.);
    }

    public Location getSpawn() {
        if (spawn == null) {
            log("SPAWN HAS NOT BEEN SET YET. PLEASE USE /RSS.");
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.hasPermission("riftmc.setspawn") || (p.isOp())) {
                    p.sendMessage(strings.defaultMsgs + ChatColor.RED + "SPAWN HAS NOT BEEN SET YET. PLEASE USE /RSS.");
                }
            }
        }
        return spawn;
    }
}

//    public void onReload() {
//        if (Bukkit.getOnlinePlayers().size() != 0) {
//            for(Player player : Bukkit.getOnlinePlayers()) {
//                PlayerData.loadedPlayer.put(player.getUniqueId(), new PlayerData(player.getUniqueId()));
//            }
//        }
//    }


//        if (Bukkit.getOnlinePlayers().size() != 0) {
//            for (Player p : Bukkit.getOnlinePlayers()) {
//
//
//            }
//        }
