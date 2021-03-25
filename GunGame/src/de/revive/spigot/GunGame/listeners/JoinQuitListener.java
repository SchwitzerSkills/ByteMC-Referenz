package de.revive.spigot.GunGame.listeners;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import de.revive.spigot.GunGame.commands.Command_setloc;
import de.revive.spigot.GunGame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        ScoreAPI.setScoreboard(p);

        p.getInventory().clear();
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);

        PlayerJoinItemslistener.items(p);

        p.sendMessage(Main.Prefix + "§8[§7Max 3 Spieler pro Team§8] §cmit mehr Spieler wird mit einem §4§lBANN §cbestraft");

        p.setLevel(0);

        p.setExp(0);

        p.setHealth(20);
        p.setFoodLevel(20);

        e.setJoinMessage(null);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), () -> {
        }, 0L, 0L);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), () -> {
            p.teleport((Location) Command_setloc.cfg.get("Spawn", p.getLocation()));
            Bukkit.getScheduler().cancelAllTasks();
        }, 0, 0);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        e.setQuitMessage(null);
    }

    @EventHandler
    public void onJoin2(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()) {
            p.teleport((Location) Command_setloc.cfg.get("Spawn", p.getLocation()));
        }
    }

}
