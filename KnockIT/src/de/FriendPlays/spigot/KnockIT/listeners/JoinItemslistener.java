package de.FriendPlays.spigot.KnockIT.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinItemslistener implements Listener {

    public static void items(Player p){
        ItemStack i1 = new ItemStack(Material.STICK);
        ItemMeta m1 = i1.getItemMeta();
        m1.addEnchant(Enchantment.KNOCKBACK, 2, true);
        m1.setDisplayName("§cKnüppel");
        i1.setItemMeta(m1);

        p.getInventory().setItem(0, i1);
    }

}
