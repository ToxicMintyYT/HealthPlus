package me.toxicminty.healthplus.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DoubleHealthCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                p.setMaxHealth(p.getMaxHealth() * 2);
                p.setHealth(p.getMaxHealth());
                p.sendMessage(ChatColor.GREEN + "Doubled" + ChatColor.GRAY + " Your " + ChatColor.GREEN + "Health");
            }else {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    t.setMaxHealth(t.getMaxHealth() * 2);
                    t.setHealth(t.getMaxHealth());
                    p.sendMessage(ChatColor.GREEN + "Doubled" + ChatColor.GRAY + t.getPlayerListName() + ChatColor.GREEN + "'s Health");
                }else {
                    p.sendMessage(ChatColor.RED + "That player either isn't online or doesn't exist!");
                }
            }
        }
        return true;
    }
}
