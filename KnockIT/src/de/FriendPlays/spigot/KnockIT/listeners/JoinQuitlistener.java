package de.FriendPlays.spigot.KnockIT.listeners;

import de.FriendPlays.spigot.KnockIT.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitlistener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        p.getInventory().clear();

        e.setJoinMessage(null);

        JoinItemslistener.items(p);

        p.setLevel(0);
        p.setExp(0);
        p.setFoodLevel(20);
        p.setMaxHealth(20);
        p.setHealth(20);

        if (!Main.file.exists()) {
            p.sendMessage(Main.ChatPrefix + "§cBitte setzte den Spawn!");
            p.sendMessage(Main.ChatPrefix + "§cKein Schlagen: 100Y");
            p.sendMessage(Main.ChatPrefix + "§cHight: 40Y");
        } else {
            p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
        }
        for(Player on : Bukkit.getOnlinePlayers()){
            ScoreAPI.setScoreboard(on);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        e.setQuitMessage(null);
    }

    @EventHandler
    public void onJoin2(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()){
            p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (p.getWorld().getName().equalsIgnoreCase("world")) {
            p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 10);
        }
    }

}
