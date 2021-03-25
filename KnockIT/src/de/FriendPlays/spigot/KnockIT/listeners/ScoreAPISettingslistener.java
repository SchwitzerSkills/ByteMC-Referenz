package de.FriendPlays.spigot.KnockIT.listeners;

import de.FriendPlays.spigot.KnockIT.main.Main;
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
        if(p.hasPermission("KnockIT.Owner")){
            e.setFormat("§4Owner §8× §4" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Admin")){
            e.setFormat("§4Admin §8× §4" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.TeamLeitung")){
            e.setFormat("§cTeam-Leitung §8× §c" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Developer")){
            e.setFormat("§bDeveloper §8× §b" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Moderator")){
            e.setFormat("§cModerator §8× §c" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Builder")){
            e.setFormat("§aBuilder §8× §a" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Supporter")){
            e.setFormat("§eSupporter §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.TDeveloper")){
            e.setFormat("§bTest-Developer §8× §b" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.TSupporter")){
            e.setFormat("§eTest-Supporter §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.TBuilder")){
            e.setFormat("§aTest-Builder §8× §a" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Youtuber")){
            e.setFormat("§5Youtuber §8× §5" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Premium+")){
            e.setFormat("§ePremium+ §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Friend")){
            e.setFormat("§eFriend §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Griefer")){
            e.setFormat("§4Griefer §8× §4" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Titan")){
            e.setFormat("§9Titan §8× §9" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Legend")){
            e.setFormat("§cLegend §8× §c" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Ultra")){
            e.setFormat("§bUltra §8× §b" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("KnockIT.Premium")){
            e.setFormat("§6Premium §8× §6" + p.getName() + "§8: §7" + message);
        } else {
            e.setFormat("§7Spieler §8× §7" + p.getName() + "§8: §7" + message);
        }
    }

}
