package de.revive.spigot.GunGame.listeners;

import de.revive.spigot.GunGame.commands.Command_setloc;
import de.revive.spigot.GunGame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerKilllistener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(p.isDead()){

        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
            Player p = e.getEntity();
            Player k = e.getEntity().getKiller();

            e.setDroppedExp(0);
            e.getDrops().clear();

            PlayerJoinItemslistener.items(p);

            p.spigot().respawn();

        PlayerJoinItemslistener.items(p);

            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), () -> {
                p.teleport((Location) Command_setloc.cfg.get("Spawn", p.getLocation()));
                PlayerJoinItemslistener.items(p);
                Bukkit.getScheduler().cancelAllTasks();
            }, 0L, 20L);
            if (e.getDeathMessage().contains(p.getName() + " died")) {
                p.sendMessage(Main.Prefix + "§7Du bist §cgestorben");
                e.setDeathMessage(null);
                e.getDrops().clear();
                PlayerJoinItemslistener.items(p);
            }
            if (e.getDeathMessage().contains(p.getName() + " was slain by " + k.getName())) {
                e.setDeathMessage(Main.Prefix + "§7Der Spieler §c" + p.getName() + "§7 wurde von §a" + k.getName() + "§7 getötet");
                e.getDrops().clear();
                PlayerJoinItemslistener.items(p);
            }

            p.giveExpLevels(-1);
            k.giveExpLevels(1);

            k.setHealth(20);

            if (k != p) {

                k.playSound(k.getLocation(), Sound.LEVEL_UP, 10, 10);
                if (p.getLevel() == 0) {
                    p.getInventory().clear();
                    p.getInventory().setHelmet(null);
                    p.getInventory().setChestplate(null);
                    p.getInventory().setLeggings(null);
                    p.getInventory().setBoots(null);

                    ItemStack i1 = new ItemStack(Material.WOOD_AXE);
                    ItemMeta m1 = i1.getItemMeta();
                    i1.setItemMeta(m1);

                    p.getInventory().setItem(0, i1);
                }
            } else if (p.getLevel() == 1) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 2) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                p.getInventory().setHelmet(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 3) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 4) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 5) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 6) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_AXE);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 7) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 8) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 9) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 10) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 11) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 12) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_AXE);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 13) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 14) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 15) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 16) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 17) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 18) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_AXE);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 19) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 20) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 21) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 22) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 23) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 24) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_AXE);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 25) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 26) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 27) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 28) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 29) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 30) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_AXE);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 31) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 32) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 33) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 34) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 35) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 36) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_AXE);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 37) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 38) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 39) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 40) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 41) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 42) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_AXE);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 43) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 44) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 45) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 46) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 47) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 48) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_AXE);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 49) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 49) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 50) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 51) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 52) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 53) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_AXE);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 54) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 55) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 56) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 57) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 58) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 6) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 7) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 8) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 9) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 10) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 11) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 12) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_AXE);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 13) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 14) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 15) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 16) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 17) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 18) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 19) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 20) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 21) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 22) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 23) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 24) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_AXE);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 25) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 26) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 27) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 28) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 29) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 30) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 31) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 32) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 33) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 34) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 35) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 36) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_AXE);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 37) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 38) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 39) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 40) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 41) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 42) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 43) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 44) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 45) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 46) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 47) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 48) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_AXE);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 49) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 49) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 50) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 51) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 52) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 53) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 54) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 55) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 56) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 57) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 58) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        }
        if (k.getLevel() == 0) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_AXE);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 1) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 2) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 3) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 4) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 5) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 6) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 7) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 8) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 9) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 10) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 11) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 12) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_AXE);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 13) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 14) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 15) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 16) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 17) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 18) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 19) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 20) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 21) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 22) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 23) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 24) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_AXE);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 25) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 26) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 27) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 28) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 29) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 30) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 31) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 32) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 33) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 34) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 35) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 36) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_AXE);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 37) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 38) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 39) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 40) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 41) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 42) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 43) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 44) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 45) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 46) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 47) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.IRON_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 48) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_AXE);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 49) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 49) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.IRON_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 50) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 51) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 52) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 53) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_AXE);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 54) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 55) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 56) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 57) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        } else if (k.getLevel() == 58) {
            k.getInventory().clear();
            k.getInventory().setHelmet(null);
            k.getInventory().setChestplate(null);
            k.getInventory().setLeggings(null);
            k.getInventory().setBoots(null);

            ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta m1 = i1.getItemMeta();
            m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta m2 = i2.getItemMeta();
            m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta m3 = i3.getItemMeta();
            m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta m4 = i4.getItemMeta();
            m4.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta m5 = i5.getItemMeta();
            m5.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
            i5.setItemMeta(m5);

            k.getInventory().setLeggings(i5);
            k.getInventory().setBoots(i4);
            k.getInventory().setHelmet(i3);
            k.getInventory().setChestplate(i2);
            k.getInventory().setItem(0, i1);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void PlayerMove(PlayerMoveEvent ev) {
        Player p = ev.getPlayer();
        if (p.getLocation().getBlock().getTypeId() == 9) {
            ((CraftPlayer) p).setHealth(0);
            p.spigot().respawn();

            p.teleport((Location) Command_setloc.cfg.get("Spawn", p.getLocation()));

            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1, 1));

            if (p.getLevel() == 0) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_AXE);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 1) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 2) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                p.getInventory().setHelmet(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 3) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 4) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 5) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 6) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_AXE);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 7) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 8) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 9) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 10) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 11) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.WOOD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 12) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_AXE);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 13) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 14) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 15) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 16) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 17) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 18) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_AXE);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 19) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 20) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 21) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 22) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 23) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.GOLD_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 24) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_AXE);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 25) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 26) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.GOLD_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 27) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.GOLD_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 28) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.GOLD_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 29) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 30) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_AXE);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 31) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 32) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 33) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 34) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 35) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 36) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_AXE);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 37) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 38) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 39) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.CHAINMAIL_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 40) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 41) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 42) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_AXE);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 43) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 44) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 45) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 46) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 47) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 48) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_AXE);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 49) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 49) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.IRON_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 50) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 51) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 52) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 53) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_AXE);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 54) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 55) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 56) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 57) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            } else if (p.getLevel() == 58) {
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);

                ItemStack i1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta m2 = i2.getItemMeta();
                m2.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta m3 = i3.getItemMeta();
                m3.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta m4 = i4.getItemMeta();
                m4.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta m5 = i5.getItemMeta();
                m5.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                i5.setItemMeta(m5);

                p.getInventory().setLeggings(i5);
                p.getInventory().setBoots(i4);
                p.getInventory().setHelmet(i3);
                p.getInventory().setChestplate(i2);
                p.getInventory().setItem(0, i1);
            }
        }
    }

    @EventHandler
    public void onDeaht(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(p.isDead()) {
            if (p.getLevel() == 0) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        p.getInventory().clear();
                        p.getInventory().setHelmet(null);
                        p.getInventory().setChestplate(null);
                        p.getInventory().setLeggings(null);
                        p.getInventory().setBoots(null);

                        ItemStack i1 = new ItemStack(Material.WOOD_AXE);
                        ItemMeta m1 = i1.getItemMeta();
                        i1.setItemMeta(m1);

                        p.getInventory().setItem(0, i1);
                    }
                }.runTaskLater(Main.instance, 0);
            }
        }
    }

}
