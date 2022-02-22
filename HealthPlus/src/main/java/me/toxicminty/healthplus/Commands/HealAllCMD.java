package me.toxicminty.healthplus.Commands;

import jdk.tools.jlink.plugin.Plugin;
import me.toxicminty.healthplus.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class HealAllCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                    a.setHealth(a.getMaxHealth());
                }
                p.sendMessage(ChatColor.GREEN + "Healed " + ChatColor.GRAY + "All players");
            }else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("players")) {
                    for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                        a.setHealth(a.getMaxHealth());
                    }
                    p.sendMessage(ChatColor.GREEN + "Healed " + ChatColor.GRAY + "All players");
                }else if (args[0].equalsIgnoreCase("help")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c---&e---&2--&b--&9-&7[&6Help menu: HealAll&7]&9-&b--&2--&e---&c---"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/healall &8- &7Heals all players"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/healall players &8- &7Heals all players"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/healall entities &8- &7Heals all players and mobs"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/healall all &8- &7Heals all players and mobs"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c---&e---&2--&b--&9-&7[                     ]&9-&b--&2--&e---&c---"));
                }else if (args[0].equalsIgnoreCase("entities")) {
                    p.sendMessage(ChatColor.RED + "Feature still being constructed!");
                    p.sendMessage(ChatColor.GREEN + "Killed " + ChatColor.GRAY + " All players in spectator");
                }else if (args[0].equalsIgnoreCase("all")) {
                    p.sendMessage(ChatColor.RED + "Feature still being constructed!");
                    for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                        a.setHealth(a.getMaxHealth());
                        p.sendMessage(ChatColor.GREEN + "Healed " + ChatColor.GRAY + "All players");
                    }
                }
            }
        }
        return true;
    }

    public void heal(Entity e) {
        //e.setHealth(e.getMaxHealth());
    }

}
