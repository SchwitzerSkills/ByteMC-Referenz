package de.revive.spigot.GunGame.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawnlistener implements Listener {

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        e.setCancelled(true);
    }

}
