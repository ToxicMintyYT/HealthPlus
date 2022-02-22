package me.toxicminty.healthplus.Commands;

import me.toxicminty.healthplus.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetHealthCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                p.setMaxHealth(20);
                p.setHealth(20);
                p.sendMessage(ChatColor.GREEN + "Reset " + ChatColor.GRAY + "Your" + ChatColor.GREEN + " Health");
            }else {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    t.setMaxHealth(20);
                    t.setHealth(20);
                    p.sendMessage(ChatColor.GREEN + "Reset " + ChatColor.GRAY + t.getPlayerListName() + ChatColor.GREEN + " Health");
                }else {
                    p.sendMessage(ChatColor.RED + "That player either isn't online or doesn't exist!");
                }
            }
        }
        return true;
    }
}
