package me.toxicminty.healthplus.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillAllCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                    a.setHealth(0);
                    p.sendMessage(ChatColor.GREEN + "Killed " + ChatColor.GRAY + "All players:");
                    p.sendMessage(ChatColor.GRAY + a.getDisplayName());
                }
            }else if (args[0].equalsIgnoreCase("help")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c---&e---&2--&b--&9-&7[&6Help menu: KillAll&7]&9-&b--&2--&e---&c---"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/healall all &8- &7Kills all players"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/healall survival &8- &7Kills all players in survival"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/healall creative &8- &7Kills all players in creative"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/healall adventure &8- &7Kills all players in adventure"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/healall spectator &8- &7Kills all players in spectator"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c---&e---&2--&b--&9-&7[                     ]&9-&b--&2--&e---&c---"));
            }else if (args[0].equalsIgnoreCase("survival")) {
                Bukkit.getOnlinePlayers().stream().filter(it -> it.getGameMode() == GameMode.SURVIVAL).forEach(this::kill);
                p.sendMessage(ChatColor.GREEN + "Killed " + ChatColor.GRAY + " All players in survival");
            }else if (args[0].equalsIgnoreCase("creative")) {
                Bukkit.getOnlinePlayers().stream().filter(it -> it.getGameMode() == GameMode.CREATIVE).forEach(this::kill);
                p.sendMessage(ChatColor.GREEN + "Killed " + ChatColor.GRAY + " All players in creative");
            }else if (args[0].equalsIgnoreCase("adventure")) {
                Bukkit.getOnlinePlayers().stream().filter(it -> it.getGameMode() == GameMode.ADVENTURE).forEach(this::kill);
                p.sendMessage(ChatColor.GREEN + "Killed " + ChatColor.GRAY + " All players in adventure");
            }else if (args[0].equalsIgnoreCase("spectator")) {
                Bukkit.getOnlinePlayers().stream().filter(it -> it.getGameMode() == GameMode.SPECTATOR).forEach(this::kill);
                p.sendMessage(ChatColor.GREEN + "Killed " + ChatColor.GRAY + " All players in spectator");
            }
        }
        return true;
    }

    public void kill(Player p) {
        p.setHealth(0);
    }
}
