package de.FriendPlays.spigot.BuildFFA.listeners;

import de.FriendPlays.spigot.BuildFFA.main.Main;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Sandstone;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Score;
import org.bukkit.util.Vector;

import java.io.IOException;
import java.util.HashMap;

public class InGameSettingslistener implements Listener {

    public static int count;

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (e.getBlock().getType() == Material.SANDSTONE) {
            if (Main.standard.contains(p)) {
                ItemStack i3 = new ItemStack(Material.SANDSTONE, 64);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                p.getInventory().setItem(2, i3);
                p.getInventory().setItem(3, i3);
                p.getInventory().setItem(4, i3);

            } else if (Main.rusher.contains(p)) {
                ItemStack i3 = new ItemStack(Material.SANDSTONE, 64);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                p.getInventory().setItem(1, i3);
                p.getInventory().setItem(2, i3);
                p.getInventory().setItem(3, i3);
            }
            new BukkitRunnable() {

                @Override

                public void run() {

                    e.getBlock().setType(Material.AIR);

                }

            }.runTaskLater(Main.instance, 100);
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
    public void onDamage(EntityDamageEvent e) {
        Player p = (Player) e.getEntity();
        try{
        if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
            p.setHealth(0);
        }
        } catch (Exception e1){

        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        try{
           count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                        p.spigot().respawn();
                        e.getDrops().clear();
                    }, 0, 0);
           p.getInventory().clear();
           p.getInventory().setArmorContents(null);
            JoinItemslistener.items2(p);
                p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
                p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);
            JoinItemslistener.items2(p);
            e.getDrops().clear();
        } catch (Exception e1){
        }
    }

    @EventHandler
    public void onDeath2(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player k = e.getEntity().getKiller();
        if(p.getWorld().getName().equalsIgnoreCase("world")){
        if (p != k) {
            if (e.getDeathMessage().contains(p.getName() + " died")) {
                e.setDeathMessage(null);
                p.sendMessage(Main.ChatPrefix + "§7Du bist §cgestorben");
            }
            if (e.getDeathMessage().contains(p.getName() + " was slain by " + k.getName())) {
                e.setDeathMessage(null);
                p.sendMessage(Main.ChatPrefix + "§7Du wurdest von §c" + k.getName() + "§7 getötet");
                k.sendMessage(Main.ChatPrefix + "§7Du hast §a" + p.getName() + "§7 getötet");
                k.playSound(k.getLocation(), Sound.NOTE_PLING, 10, 10);
                k.setHealth(20);
            }
        }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(Main.file.exists()) {
            if (p.getLocation().getY() < 90) {
                    p.setHealth(0);
            }
        } else if(!Main.file.exists()) {

        }
    }

    @EventHandler
    public void onMove2(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (p.getLocation().getY() < 196 && p.getLocation().getY() > 195) {
            if(Main.standard.contains(p)) {
                p.getInventory().clear();
                JoinItemslistener.items(p);
            } else if(Main.rusher.contains(p)) {
                p.getInventory().clear();
                JoinItemslistener.items3(p);
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onDeath3(PlayerDeathEvent e){
        new BukkitRunnable() {
            @Override
            public void run() {
                e.getDrops().clear();
            }
        }.runTaskLater(Main.instance, 0L);
    }

    @EventHandler
    public void onDreath4(PlayerDeathEvent e){
        new BukkitRunnable() {
            @Override
            public void run() {
                e.getDrops().clear();
            }
        }.runTaskLater(Main.instance, 40L);
    }

}
