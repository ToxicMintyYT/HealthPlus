package me.toxicminty.healthplus.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetMaxHealthCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage(ChatColor.GREEN + "Your max health is " + ChatColor.GRAY + p.getMaxHealth());
            }else {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    p.sendMessage(ChatColor.GRAY + t.getPlayerListName() + "'s" + ChatColor.GREEN + " max health is " + ChatColor.GRAY + t.getMaxHealth());
                }else {
                    p.sendMessage(ChatColor.RED + "That player either isn't online or doesn't exist!");
                }
            }
        }
        return true;
    }
}
