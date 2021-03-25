package de.FriendPlays.spigot.BuildFFA.listeners;

import de.FriendPlays.spigot.BuildFFA.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinItemslistener implements Listener {

    public static void items(Player p){
        ItemStack i1 = new ItemStack(Material.IRON_SWORD);
        ItemMeta m1 = i1.getItemMeta();
        m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        i1.setItemMeta(m1);

        ItemStack i2 = new ItemStack(Material.FISHING_ROD);
        ItemMeta m2 = i2.getItemMeta();
        i2.setItemMeta(m2);

        ItemStack i3 = new ItemStack(Material.SANDSTONE, 64);
        ItemMeta m3 = i3.getItemMeta();
        i3.setItemMeta(m3);

        ItemStack i4 = new ItemStack(Material.IRON_HELMET);
        ItemMeta m4 = i4.getItemMeta();
        m4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        i4.setItemMeta(m4);

        ItemStack i5 = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta m5 = i5.getItemMeta();
        m5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        i5.setItemMeta(m5);

        ItemStack i6 = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta m6 = i6.getItemMeta();
        m6.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        i6.setItemMeta(m6);

        ItemStack i7 = new ItemStack(Material.IRON_BOOTS);
        ItemMeta m7 = i7.getItemMeta();
        m7.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        i7.setItemMeta(m7);


        p.getInventory().setHelmet(i4);
        p.getInventory().setChestplate(i5);
        p.getInventory().setLeggings(i6);
        p.getInventory().setBoots(i7);
        p.getInventory().setItem(0, i1);
        p.getInventory().setItem(1, i2);
        p.getInventory().setItem(2, i3);
        p.getInventory().setItem(3, i3);
        p.getInventory().setItem(4, i3);
    }

    public static void items2(Player p){
        ItemStack i1 = new ItemStack(Material.ENDER_CHEST);
        ItemMeta m1 = i1.getItemMeta();
        m1.setDisplayName("§8» §cKits");
        i1.setItemMeta(m1);

        p.getInventory().setItem(4, i1);
    }

    public static void items3(Player p){
        ItemStack i1 = new ItemStack(Material.STICK);
        ItemMeta m1 = i1.getItemMeta();
        m1.addEnchant(Enchantment.KNOCKBACK, 1, true);
        i1.setItemMeta(m1);

        ItemStack i3 = new ItemStack(Material.SANDSTONE, 64);
        ItemMeta m3 = i3.getItemMeta();
        i3.setItemMeta(m3);

        ItemStack i4 = new ItemStack(Material.IRON_HELMET);
        ItemMeta m4 = i4.getItemMeta();
        m4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        i4.setItemMeta(m4);

        ItemStack i5 = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta m5 = i5.getItemMeta();
        m5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        i5.setItemMeta(m5);

        ItemStack i6 = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta m6 = i6.getItemMeta();
        m6.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        i6.setItemMeta(m6);

        ItemStack i7 = new ItemStack(Material.IRON_BOOTS);
        ItemMeta m7 = i7.getItemMeta();
        m7.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        i7.setItemMeta(m7);


        p.getInventory().setHelmet(i4);
        p.getInventory().setChestplate(i5);
        p.getInventory().setLeggings(i6);
        p.getInventory().setBoots(i7);
        p.getInventory().setItem(0, i1);
        p.getInventory().setItem(1, i3);
        p.getInventory().setItem(2, i3);
        p.getInventory().setItem(3, i3);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cKits")){
            if(e.getItem().getType() == Material.ENDER_CHEST){
                if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    Inventory inv = Bukkit.createInventory(null, 9, "§8» §cKits");

                    ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                    ItemMeta m1 = i1.getItemMeta();
                    m1.setDisplayName("§8» §cStandard Kit");
                    i1.setItemMeta(m1);

                    ItemStack i2 = new ItemStack(Material.STICK);
                    ItemMeta m2 = i2.getItemMeta();
                    m2.setDisplayName("§8» §cRusher Kit");
                    i2.setItemMeta(m2);

                    inv.setItem(0, i1);
                    inv.setItem(1, i2);

                    p.openInventory(inv);
                }
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cStandard Kit")){
            if(e.getCurrentItem().getType() == Material.IRON_SWORD){
                p.closeInventory();
                Main.standard.add(p);
                Main.rusher.remove(p);
                p.sendMessage(Main.ChatPrefix + "§7Du hast das Kit §cStandard §aausgewählt");
                ScoreAPI.setScoreboard(p);
            }
        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cRusher Kit")){
            if(e.getCurrentItem().getType() == Material.STICK){
                p.closeInventory();
                Main.rusher.add(p);
                Main.standard.remove(p);
                p.sendMessage(Main.ChatPrefix + "§7Du hast das Kit §cRusher §aausgewählt");
                ScoreAPI.setScoreboard(p);
            }
        }
    }

}
