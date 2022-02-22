package me.toxicminty.healthplus;

import me.toxicminty.healthplus.Commands.*;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("<HealthPlus> (:) Plugin starting up...");
        // RegisterCMDs
        getCommand("heal").setExecutor(new HealCMD());
        getCommand("feed").setExecutor(new FeedCMD());
        getCommand("doublehealth").setExecutor(new DoubleHealthCMD());
        getCommand("resethealth").setExecutor(new ResetHealthCMD());
        getCommand("feal").setExecutor(new FealCMD());
        getCommand("die").setExecutor(new DieCMD());
        getCommand("healall").setExecutor(new HealAllCMD());
        getCommand("killall").setExecutor(new KillAllCMD());
        getCommand("gethealth").setExecutor(new GetHealthCMD());
        getCommand("getmaxhealth").setExecutor(new GetMaxHealthCMD());
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().stream().filter(it -> it.hasPermission("healthplus.admin")).forEach(Main.this::sendMsg);
            }
        }.runTaskLater(this, 60L);
    }

    public void sendMsg(Player p) {
        TextComponent msg = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&8[&6HealthPlus&8] &7- &4Check the inspiration for this project here"));

        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to see inspiration!")));
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.spigotmc.org/resources/healthplus.93253/"));

        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6HealthPlus&8] &7- &4HealthPlus v&6" + getDescription().getVersion() + " &4Loaded"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6HealthPlus&8] &7- &4Made by &6ToxicMinty&4!"));
        p.spigot().sendMessage(msg);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("<HealthPlus> (!) Plugin shutting down!!");
    }
}
