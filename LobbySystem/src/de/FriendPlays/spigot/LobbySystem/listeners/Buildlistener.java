package de.FriendPlays.spigot.LobbySystem.listeners;

import de.FriendPlays.spigot.LobbySystem.main.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Buildlistener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(!Main.build.contains(p)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (!Main.build.contains(p)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (!Main.build.contains(p)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (!Main.build.contains(p)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try{
        if (!Main.build.contains(p)) {
            e.setCancelled(true);
        }
        } catch (Exception e1){
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        try{
        Player p = (Player) e.getEntity();
        if(e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if (!Main.build.contains(p)) {
                e.setCancelled(true);
            }
        }
        } catch (Exception e1){

        }
    }

    @EventHandler
    public void onInteract1(PlayerInteractAtEntityEvent e){
        Player p = e.getPlayer();
       if(e.getRightClicked().getType() == EntityType.ARMOR_STAND){
           if(!Main.build.contains(p)) {
               e.setCancelled(true);
           }
       }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            Block b = e.getClickedBlock();
            if (b.getType() == Material.CHEST) {
                if(!Main.build.contains(p)) {
                    e.setCancelled(true);
                }
            }
        }
    }

}
