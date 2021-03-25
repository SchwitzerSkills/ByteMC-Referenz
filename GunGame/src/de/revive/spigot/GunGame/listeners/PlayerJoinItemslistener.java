package de.revive.spigot.GunGame.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoinItemslistener implements Listener {

    public static void items(Player p){

        ItemStack i1 = new ItemStack(Material.WOOD_AXE);
        ItemMeta m1 = i1.getItemMeta();
        i1.setItemMeta(m1);

        p.getInventory().setItem(0, i1);
    }

}
