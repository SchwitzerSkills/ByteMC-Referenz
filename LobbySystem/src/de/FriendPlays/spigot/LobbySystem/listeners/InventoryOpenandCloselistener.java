package de.FriendPlays.spigot.LobbySystem.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryOpenandCloselistener implements Listener {

    @EventHandler
    public void onOpen(InventoryOpenEvent e){
        Player p = (Player) e.getPlayer();
        if(!(p.getInventory().getType() == InventoryType.PLAYER)) {
        } else {
            p.getInventory().clear();
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();
        JoinItemslistener.items(p);
    }

}
