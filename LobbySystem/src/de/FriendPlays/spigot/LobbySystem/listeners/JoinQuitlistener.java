package de.FriendPlays.spigot.LobbySystem.listeners;

import de.FriendPlays.spigot.LobbySystem.main.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class JoinQuitlistener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

            p.getInventory().clear();
            p.getInventory().setBoots(null);

            Main.hide.remove(p);
            Main.build.remove(p);
            p.removePotionEffect(PotionEffectType.BLINDNESS);
            p.removePotionEffect(PotionEffectType.SLOW);

            p.setGameMode(GameMode.ADVENTURE);

            ScoreAPI.setScoreboard(p);

            JoinItemslistener.items(p);

            p.getWorld().setPVP(false);
            p.setMaxHealth(2);
            p.setHealth(2);
            p.setLevel(2020);
            p.setFoodLevel(20);
            p.setExp(0);

            e.setJoinMessage(null);

            if (!Main.file.exists()) {
                p.sendMessage(Main.ChatPrefix + "§cBitte setzte als erstes in Spawn!");
            } else {
                p.setVelocity(new Vector(0.0, 0.2, 0.0).multiply(3D));
                p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
            }
        }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();

        e.setQuitMessage(null);

        ScoreAPI.setScoreboard(p);
    }

    @EventHandler
    public void onfirstJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(p.hasPlayedBefore()) return;
        Bukkit.broadcastMessage(Main.ChatPrefix + "§7Der Spieler §c" + p.getName() + "§7 ist neu auf dem Netzwerk");
        p.setVelocity(new Vector(0.0, 0.2, 0.0).multiply(3D));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
            p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
            Bukkit.getScheduler().cancelAllTasks();
        }, 0, 0);
    }

}
