package de.FriendPlays.spigot.LobbySystem.listeners;

import de.FriendPlays.spigot.LobbySystem.main.Main;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class InGameSettingslistener implements Listener {

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        if(e.getEntity().getType() == EntityType.COW){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.SHEEP){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.PIG){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.ZOMBIE){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.CREEPER){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.SPIDER){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.SLIME){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.CHICKEN){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.SKELETON){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.ENDERMAN){
            e.setCancelled(true);
        } else if(e.getEntity().getType() == EntityType.SQUID){
            e.setCancelled(true);
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
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(p.getLocation().getBlock().getType() == Material.GOLD_PLATE){
            if(p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.REDSTONE_BLOCK){
                Vector v = p.getLocation().getDirection().multiply(3D).setY(1);
                p.setVelocity(v);
                p.playEffect(p.getLocation(), Effect.MAGIC_CRIT, 1);
                p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 10, 10);
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        try {
            if(e.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.VOID) {
                Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                    p.spigot().respawn();
                    p.setExp(0);
                    p.setLevel(2020);
                    p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
                    p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 40));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 40));
                    Bukkit.getScheduler().cancelAllTasks();
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                        JoinItemslistener.items(p);
                        p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                        Bukkit.getScheduler().cancelAllTasks();
                    }, 20, 20);
                }, 0, 0);
            }
        } catch (Exception e1){
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        try {
        Player p = (Player) e.getEntity();
            if(e.getCause() == EntityDamageEvent.DamageCause.VOID) {
                p.setHealth(0);
            }
        } catch (Exception e1){

        }
    }

}
