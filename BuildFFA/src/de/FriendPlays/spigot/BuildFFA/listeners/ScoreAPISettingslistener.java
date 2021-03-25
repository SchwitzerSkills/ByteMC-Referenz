package de.FriendPlays.spigot.BuildFFA.listeners;

import de.FriendPlays.spigot.BuildFFA.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ScoreAPISettingslistener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String message = e.getMessage().replace("%", "%%");
        if(p.hasPermission("BuildFFA.Owner")){
            e.setFormat("§4Owner §8× §4" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Admin")){
            e.setFormat("§4Admin §8× §4" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.TeamLeitung")){
            e.setFormat("§cTeam-Leitung §8× §c" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Developer")){
            e.setFormat("§bDeveloper §8× §b" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Moderator")){
            e.setFormat("§cModerator §8× §c" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Builder")){
            e.setFormat("§aBuilder §8× §a" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Supporter")){
            e.setFormat("§eSupporter §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.TDeveloper")){
            e.setFormat("§bTest-Developer §8× §b" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.TSupporter")){
            e.setFormat("§eTest-Supporter §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.TBuilder")){
            e.setFormat("§aTest-Builder §8× §a" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Youtuber")){
            e.setFormat("§5Youtuber §8× §5" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Premium+")){
            e.setFormat("§ePremium+ §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Friend")){
            e.setFormat("§eFriend §8× §e" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Griefer")){
            e.setFormat("§4Griefer §8× §4" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Titan")){
            e.setFormat("§9Titan §8× §9" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Legend")){
            e.setFormat("§cLegend §8× §c" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Ultra")){
            e.setFormat("§bUltra §8× §b" + p.getName() + "§8: §7" + message);
        } else if(p.hasPermission("BuildFFA.Premium")){
            e.setFormat("§6Premium §8× §6" + p.getName() + "§8: §7" + message);
        } else {
            e.setFormat("§7Spieler §8× §7" + p.getName() + "§8: §7" + message);
        }
    }

}
