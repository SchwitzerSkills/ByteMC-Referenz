package de.revive.spigot.GunGame.listeners;

import de.revive.spigot.GunGame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreAPISettingslistener implements Listener {


    @EventHandler
    public void onPlayer(PlayerJoinEvent e){
        for(Player on : Bukkit.getOnlinePlayers()) {
            ScoreAPI.setScoreboard(on);
        }
    }

    @EventHandler
    public void onPlayer1(PlayerQuitEvent e){
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player on : Bukkit.getOnlinePlayers()) {
                    ScoreAPI.setScoreboard(on);
                    Bukkit.getScheduler().cancelAllTasks();
                }
            }
        }.runTaskTimer(Main.instance, 0, 20);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String message = e.getMessage().replace("%", "%%");
        if(p.hasPermission("GunGame.Owner")){
            e.setFormat("§4Owner §8× §4" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Admin")){
            e.setFormat("§4Admin §8× §4" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.TeamLeitung")){
            e.setFormat("§cTeam-Leitung §8× §c" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Developer")){
            e.setFormat("§bDeveloper §8× §b" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Moderator")){
            e.setFormat("§cModerator §8× §c" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Builder")){
            e.setFormat("§aBuilder §8× §a" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Supporter")){
            e.setFormat("§eSupporter §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.TDeveloper")){
            e.setFormat("§bTest-Developer §8× §b" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.TSupporter")){
            e.setFormat("§eTest-Supporter §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.TBuilder")){
            e.setFormat("§aTest-Builder §8× §a" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Youtuber")){
            e.setFormat("§5Youtuber §8× §5" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Premium+")){
            e.setFormat("§ePremium+ §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Friend")){
            e.setFormat("§eFriend §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Griefer")){
            e.setFormat("§4Griefer §8× §4" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Titan")){
            e.setFormat("§9Titan §8× §9" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Legend")){
            e.setFormat("§cLegend §8× §c" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Ultra")){
            e.setFormat("§bUltra §8× §b" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("GunGame.Premium")){
            e.setFormat("§6Premium §8× §6" + p.getName() + "§8: §7" + message);
        } else {
            e.setFormat("§7Spieler §8× §7" + p.getName() + "§8: §7" + message);
        }
    }

}
