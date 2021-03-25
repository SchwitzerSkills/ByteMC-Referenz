package de.FriendPlays.spigot.LobbySystem.listeners;

import de.FriendPlays.spigot.LobbySystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.scheduler.BukkitRunnable;
import ru.tehkode.permissions.bukkit.PermissionsEx;

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
        if(PermissionsEx.getUser(p).inGroup("Owner")){
            e.setFormat("§4Owner §8| §4" + p.getName() + "§8» §7" + message);
        } else if(PermissionsEx.getUser(p).inGroup("Admin")){
            e.setFormat("§4Admin §8| §4" + p.getName() + "§8» §7" + message);
        } else if(PermissionsEx.getUser(p).inGroup("Developer")){
            e.setFormat("§bDeveloper §8| §b" + p.getName() + "§8» §7" + message);
        } else if(PermissionsEx.getUser(p).inGroup("Moderator")){
            e.setFormat("§cModerator §8| §c" + p.getName() + "§8» §7" + message);
        } else if(PermissionsEx.getUser(p).inGroup("Builder")){
            e.setFormat("§aBuilder §8| §a" + p.getName() + "§8» §7" + message);
        } else if(PermissionsEx.getUser(p).inGroup("Supporter")){
            e.setFormat("§eSupporter §8| §e" + p.getName() + "§8» §7" + message);
        } else if(PermissionsEx.getUser(p).inGroup("Youtuber")){
            e.setFormat("§5Youtuber §8| §5" + p.getName() + "§8» §7" + message);
        } else if(PermissionsEx.getUser(p).inGroup("Premium+")){
            e.setFormat("§ePremium+ §8| §e" + p.getName() + "§8» §7" + message);
        } else if(PermissionsEx.getUser(p).inGroup("Premium")){
            e.setFormat("§6Premium §8| §6" + p.getName() + "§8» §7" + message);
        } else {
            e.setFormat("§7Spieler §8| §7" + p.getName() + "§8» §7" + message);
        }
    }

}
