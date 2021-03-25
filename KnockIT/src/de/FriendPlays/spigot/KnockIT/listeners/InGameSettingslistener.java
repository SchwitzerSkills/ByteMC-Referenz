package de.FriendPlays.spigot.KnockIT.listeners;

import de.FriendPlays.spigot.KnockIT.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class InGameSettingslistener implements Listener {


    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
            p.spigot().respawn();
            p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
            p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);
        new BukkitRunnable() {
            @Override
            public void run() {
                p.spigot().respawn();
            }
        }.runTaskLater(Main.instance, 0);
    }

    @EventHandler
    public void onDeath2(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player k = e.getEntity().getKiller();
        if (p != k) {
            if(e.getDeathMessage().contains(p.getName() + " died")){
                p.sendMessage(Main.ChatPrefix + "§7Du bist §cgestorben");
                e.setDeathMessage(null);
                e.getDrops().clear();
                JoinItemslistener.items(p);
            }
            if(e.getDeathMessage().contains(p.getName() + " was slain by " + k.getName())){
                e.setDeathMessage(Main.ChatPrefix + "§7Der Spieler §c" + p.getName() + "§7 wurde von §a" + k.getName() + "§7 getötet");
                e.getDrops().clear();
                JoinItemslistener.items(p);
            }
        }
    }

    @EventHandler
    public void onEntity(EntityDamageEvent e){
        try{
        Player p = (Player) e.getEntity();
        if (p.getLocation().getY() > 46 || p.getLocation().getY() == 46) {
            e.setCancelled(true);
        } else if (p.getLocation().getY() > 45 || p.getLocation().getY() == 45) {
            e.setCancelled(true);
        } else if (p.getLocation().getY() > 44 || p.getLocation().getY() == 44) {
            e.setCancelled(true);
        } else if (p.getLocation().getY() > 47 || p.getLocation().getY() == 47) {
            e.setCancelled(true);
        } else if (p.getLocation().getY() > 48 || p.getLocation().getY() == 48) {
            e.setCancelled(true);
        } else if (p.getLocation().getY() > 49 || p.getLocation().getY() == 49) {
            e.setCancelled(true);
        }
        } catch (Exception e1){

        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(p.getLocation().getY() < 14){
            p.setHealth(0);
        }
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        if(e.getEntity().getType() == EntityType.SHEEP){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.COW){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.PIG){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.CHICKEN){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.CREEPER){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.ZOMBIE){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.SPIDER){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.ENDERMAN){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.SQUID){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage1(EntityDamageEvent e){
        Player p = (Player) e.getEntity();
        new BukkitRunnable() {
            @Override
            public void run() {
                p.setHealth(20);
            }
        }.runTaskLater(Main.instance, 0L);
    }

}


