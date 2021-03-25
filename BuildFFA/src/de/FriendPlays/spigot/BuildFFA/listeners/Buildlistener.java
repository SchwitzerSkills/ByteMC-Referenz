package de.FriendPlays.spigot.BuildFFA.listeners;

import de.FriendPlays.spigot.BuildFFA.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Buildlistener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(p.getLocation().getY() > 201 || p.getLocation().getY() > 200 || p.getLocation().getY() > 190 || p.getLocation().getY() > 189){
            p.sendMessage(Main.ChatPrefix + "§cDa kannst du keine Blöcke platzieren");
            if(!Main.build.contains(p)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(!Main.build.contains(p)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(!Main.build.contains(p)){
            e.setCancelled(true);
        }
    }

     @EventHandler
    public void onPickUp(PlayerPickupItemEvent e){
        Player p = e.getPlayer();
        if(!Main.build.contains(p)){
            e.setCancelled(true);
        }
     }

     @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if(!Main.build.contains(p)){
            e.setCancelled(true);
        }
     }

     @EventHandler
    public void onDamage(EntityDamageEvent e){
        try{
        Player p = (Player) e.getEntity();
         if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
             if(!Main.build.contains(p)) {
                 e.setCancelled(true);
             }
             }
         } catch (Exception e1){

        }
     }

     @EventHandler
    public void onDamage2(EntityDamageEvent e){
        try{
        Player p = (Player) e.getEntity();
        if(p.getLocation().getY() > 198 && p.getLocation().getY() > 199) {
            e.setCancelled(true);
        }
        }catch (Exception e1){

        }
     }

}
