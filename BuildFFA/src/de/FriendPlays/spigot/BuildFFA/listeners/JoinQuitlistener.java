package de.FriendPlays.spigot.BuildFFA.listeners;

import de.FriendPlays.spigot.BuildFFA.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitlistener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        e.setJoinMessage(Main.ChatPrefix + "§a§o" + p.getName() + "§7 hat das Spiel §abetreten");

        Main.standard.add(p);

        ScoreAPI.setScoreboard(p);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        JoinItemslistener.items2(p);

        p.setMaxHealth(20);
        p.setHealth(20);
        p.setExp(0);
        p.setLevel(0);

        if(!Main.file.exists()){
            p.sendMessage(Main.ChatPrefix + "§cBitte setzte in Spawn!");
            p.sendMessage(Main.ChatPrefix + "§cHöhe zum sterben: 40Y");
            p.sendMessage(Main.ChatPrefix + "§cHöhe zum nicht bauen: 100Y");
        } else {
            p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
        }
        for(Player on : Bukkit.getOnlinePlayers()) {
            ScoreAPI.setScoreboard(on);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(Main.ChatPrefix + "§c§o" + p.getName() + "§7 hat das Spiel §cverlassen");
    }

    @EventHandler
    public void onJoin2(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()){
            p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
        }
    }

}
