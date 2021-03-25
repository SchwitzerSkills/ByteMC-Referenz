package de.FriendPlays.spigot.LobbySystem.listeners;

import de.FriendPlays.spigot.LobbySystem.main.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JoinItemslistener implements Listener {

    HashMap<Player, BukkitRunnable> run = new HashMap<>();

    public static void items(Player p){
        if (p.hasPermission("Lobby.Youtuber")) {
            ItemStack i1 = new ItemStack(Material.WATCH);
            ItemMeta m1 = i1.getItemMeta();
            m1.setDisplayName("§cNavigator §8● §8(§7Rechtsklick§8)");
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.BLAZE_ROD);
            ItemMeta m2 = i2.getItemMeta();
            m2.setDisplayName("§eSpieler-Verstecken §8● §8(§7Rechtsklick§8)");
            i2.setItemMeta(m2);

            ItemStack i3 = new ItemStack(Material.TNT);
            ItemMeta m3 = i3.getItemMeta();
            m3.setDisplayName("§4SilentHub §8● §8(§7Rechtsklick§8)");
            i3.setItemMeta(m3);

            ItemStack i4 = new ItemStack(Material.EYE_OF_ENDER);
            ItemMeta m4 = i4.getItemMeta();
            m4.setDisplayName("§3Schutzschild §8● §8(§7Rechtsklick§8)");
            i4.setItemMeta(m4);

            ItemStack i5 = new ItemStack(Material.CHEST);
            ItemMeta m5 = i5.getItemMeta();
            m5.setDisplayName("§aGadgets §8● §8(§7Rechtsklick§8)");
            i5.setItemMeta(m5);

            ItemStack i6 = new ItemStack(Material.FEATHER);
            ItemMeta m6 = i6.getItemMeta();
            m6.setDisplayName("§2Flug-Feder §8● §8(§7Rechtsklick§8)");
            i6.setItemMeta(m6);

            p.getInventory().setItem(0, i1);
            p.getInventory().setItem(1, i2);
            p.getInventory().setItem(3, i3);
            p.getInventory().setItem(5, i4);
            p.getInventory().setItem(8, i5);
            p.getInventory().setItem(7, i6);
        } else {
            ItemStack i1 = new ItemStack(Material.WATCH);
            ItemMeta m1 = i1.getItemMeta();
            m1.setDisplayName("§cNavigator §8● §8(§7Rechtsklick§8)");
            i1.setItemMeta(m1);

            ItemStack i2 = new ItemStack(Material.BLAZE_ROD);
            ItemMeta m2 = i2.getItemMeta();
            m2.setDisplayName("§eSpieler-Verstecken §8● §8(§7Rechtsklick§8)");
            i2.setItemMeta(m2);

            ItemStack i5 = new ItemStack(Material.CHEST);
            ItemMeta m5 = i5.getItemMeta();
            m5.setDisplayName("§aGadgets §8● §8(§7Rechtsklick§8)");
            i5.setItemMeta(m5);

            ItemStack i6 = new ItemStack(Material.FEATHER);
            ItemMeta m6 = i6.getItemMeta();
            m6.setDisplayName("§2Flug-Feder §8● §8(§7Rechtsklick§8)");
            i6.setItemMeta(m6);

            p.getInventory().setItem(0, i1);
            p.getInventory().setItem(1, i2);
            p.getInventory().setItem(8, i5);
            p.getInventory().setItem(7, i6);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        try{
        if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNavigator §8● §8(§7Rechtsklick§8)")){
            if(e.getItem().getType() == Material.WATCH) {
                Inventory inv = Bukkit.createInventory(null, 9 * 5, "§cSpielModis");

                ItemStack i1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta m1 = i1.getItemMeta();
                m1.setDisplayName("§8» §aAmong Us");
                m1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.MAGMA_CREAM);
                ItemMeta m2 = i2.getItemMeta();
                m2.setDisplayName("§8» §6Spawn");
                i2.setItemMeta(m2);

                Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                    inv.setItem(20, i1);
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10, 10);
                    Bukkit.getScheduler().cancelAllTasks();
                                Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                                    inv.setItem(22, i2);
                                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10, 10);
                                    Bukkit.getScheduler().cancelAllTasks();
                                }, 5, 0);
                            }, 5, 0);

                p.openInventory(inv);

            }
            }
        } catch (Exception e1){

        }
    }

    @EventHandler
    public void onInteract2(PlayerInteractEvent e){
        Player p = e.getPlayer();
        try{
        if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eSpieler-Verstecken §8● §8(§7Rechtsklick§8)")){
            if(e.getItem().getType() == Material.BLAZE_ROD) {
                Inventory inv = Bukkit.createInventory(null, 9, "§eSpieler-Verstecken");

                ItemStack i1 = new ItemStack(Material.INK_SACK, 1, (byte) 10);
                ItemMeta m1 = i1.getItemMeta();
                m1.setDisplayName("§aAlle Spieler");
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.INK_SACK, 1, (byte) 1);
                ItemMeta m2 = i2.getItemMeta();
                m2.setDisplayName("§cKeine Spieler");
                i2.setItemMeta(m2);

                inv.setItem(6, i2);
                inv.setItem(2, i1);

                p.openInventory(inv);
            }
            }
        } catch (Exception e1){

        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aSkyWars")) {
                if (e.getCurrentItem().getType() == Material.GRASS) {
                    p.closeInventory();
                    p.setVelocity(new Vector(0.0, 0.3, 0.0).multiply(3D));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 50, 100));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 100));
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                        p.teleport((Location) Main.cfg.get("SkyWars", p.getLocation()));
                        Bukkit.getScheduler().cancelAllTasks();
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 10);
                    }, 15, 0);
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Spawn")) {
                if (e.getCurrentItem().getType() == Material.MAGMA_CREAM) {
                    p.closeInventory();
                    p.setVelocity(new Vector(0.0, 0.3, 0.0).multiply(3D));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 50, 100));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 100));
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                        p.teleport((Location) Main.cfg.get("Spawn", p.getLocation()));
                        Bukkit.getScheduler().cancelAllTasks();
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 10);
                    }, 15, 0);
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cBedWars")) {
                if (e.getCurrentItem().getType() == Material.BED) {
                    p.closeInventory();
                    p.setVelocity(new Vector(0.0, 0.3, 0.0).multiply(3D));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 50, 100));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 100));
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                        p.teleport((Location) Main.cfg.get("BedWars", p.getLocation()));
                        Bukkit.getScheduler().cancelAllTasks();
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 10);
                    }, 15, 0);
                }
            }
        } catch (Exception e1){
        }
    }

    @EventHandler
    public void onClick2(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAlle Spieler")) {
                if (e.getCurrentItem().getType() == Material.INK_SACK) {
                    Main.hide.remove(p);
                    for (Player on : Bukkit.getOnlinePlayers()) {
                        on.showPlayer(p);
                        p.showPlayer(on);
                    }
                    p.sendMessage(Main.ChatPrefix + "§7Du siehst nun §aalle Spieler");
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cKeine Spieler")) {
                if (e.getCurrentItem().getType() == Material.INK_SACK) {
                    Main.hide.add(p);
                    for (Player on : Bukkit.getOnlinePlayers()) {
                        on.hidePlayer(p);
                        p.hidePlayer(on);
                    }
                    p.sendMessage(Main.ChatPrefix + "§7Du siehst nun §ckeine Spieler");
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                }
            }
        } catch (Exception e1){

        }
    }

    @EventHandler
    public void onInteract3(PlayerInteractEvent e){
        Player p = e.getPlayer();
        try{
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4SilentHub §8● §8(§7Rechtsklick§8)")) {
            if (e.getItem().getType() == Material.TNT) {
                if(!Main.hide.contains(p)){
                    Main.hide.add(p);
                    for(Player on : Bukkit.getOnlinePlayers()){
                        on.hidePlayer(p);
                        p.hidePlayer(on);
                    }
                    p.sendMessage(Main.ChatPrefix + "§7Du hast die §cSilentHub §abetreten");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                } else if(Main.hide.contains(p)) {
                    Main.hide.remove(p);
                    for (Player on : Bukkit.getOnlinePlayers()) {
                        on.showPlayer(p);
                        p.showPlayer(on);
                    }
                    p.sendMessage(Main.ChatPrefix + "§7Du hast die §cSilentHub verlassen");
                    p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);
                }
                }
            }
        } catch (Exception e1){

        }
    }

    @EventHandler
    public void onInteract4(PlayerInteractEvent e){
        Player p = e.getPlayer();
        try{
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Schutzschild §8● §8(§7Rechtsklick§8)")) {
            if(e.getItem().getType() == Material.EYE_OF_ENDER){
                e.setUseInteractedBlock(Event.Result.DENY);
                e.setUseItemInHand(Event.Result.DENY);

                if(run.containsKey(p)){
                    p.sendMessage(Main.ChatPrefix + "§7Du hast das §3Schutzschild §cdeaktiviert");
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 10);
                    run.get(p).cancel();
                    run.remove(p);
                } else if(!run.containsKey(p)) {
                    run.put(p, new BukkitRunnable() {
                        @Override
                        public void run() {
                            p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 3);
                        }
                    });
                    run.get(p).runTaskTimer(Main.instance, 20, 20);
                    p.sendMessage(Main.ChatPrefix + "§7Du hast das §3Schutzschild §aaktiviert");
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 10);
                }
                }
            }
        } catch (Exception e1){

        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        if(run.containsKey(e.getPlayer())){
            run.get(e.getPlayer()).cancel();
            run.remove(e.getPlayer());
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        for(Player players : run.keySet()){
            if(p != players){
                if(p.getLocation().distance(players.getLocation()) <= 5){

                    double Ax = p.getLocation().getX();
                    double Ay = p.getLocation().getY();
                    double Az = p.getLocation().getZ();

                    double Bx = players.getLocation().getX();
                    double By = players.getLocation().getY();
                    double Bz = players.getLocation().getZ();

                    double x = Ax - Bx;
                    double y = Ay - By;
                    double z = Az - Bz;
                    Vector v = new Vector(x, y, z).normalize().multiply(2D).setY(0.3D);
                    p.setVelocity(v);
                }
            }
        }

        if(run.containsKey(p)){
        for(Entity entity : p.getNearbyEntities(5, 5, 5)){
            if(entity instanceof Player){
                Player target = (Player) entity;
                if(p != target) {

                    double Ax = p.getLocation().getX();
                    double Ay = p.getLocation().getY();
                    double Az = p.getLocation().getZ();

                    double Bx = target.getLocation().getX();
                    double By = target.getLocation().getY();
                    double Bz = target.getLocation().getZ();

                    double x = Bx - Ax;
                    double y = By - Ay;
                    double z = Bz - Az;
                    Vector v = new Vector(x, y, z).normalize().multiply(2D).setY(0.3D);
                    target.setVelocity(v);
                }
                }
            }
        }

    }

    @EventHandler
    public void onInteract5(PlayerInteractEvent e){
        Player p = e.getPlayer();
        try{
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGadgets §8● §8(§7Rechtsklick§8)")) {
            if (e.getItem().getType() == Material.CHEST) {
                Inventory inv = Bukkit.createInventory(null, 9 * 4, "§aGadgets");

                ItemStack i1 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta m1 = (LeatherArmorMeta) i1.getItemMeta();
                m1.setDisplayName("§cLove Boots");
                m1.setColor(Color.RED);
                i1.setItemMeta(m1);

                ItemStack i2 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta m2 = (LeatherArmorMeta) i2.getItemMeta();
                m2.setDisplayName("§5Ender Boots");
                m2.setColor(Color.PURPLE);
                i2.setItemMeta(m2);

                ItemStack i3 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta m3 = (LeatherArmorMeta) i3.getItemMeta();
                m3.setDisplayName("§aVillager Boots");
                m3.setColor(Color.GREEN);
                i3.setItemMeta(m3);

                ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta m4 = (LeatherArmorMeta) i4.getItemMeta();
                m4.setDisplayName("§3Crit Boots");
                m4.setColor(Color.AQUA);
                i4.setItemMeta(m4);

                ItemStack i5 = new ItemStack(Material.BARRIER);
                ItemMeta m5 = i5.getItemMeta();
                m5.setDisplayName("§cAlle Gadgets entfernen");
                i5.setItemMeta(m5);

                inv.setItem(27, i5);
                inv.setItem(16, i4);
                inv.setItem(14, i3);
                inv.setItem(12, i2);
                inv.setItem(10, i1);

                p.openInventory(inv);
            }
        }
        } catch (Exception e1){

        }
    }

    @EventHandler
    public void onClick3(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cLove Boots")) {
                if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
                    p.closeInventory();
                    p.sendMessage(Main.ChatPrefix + "§7Du hast die §cLove Boots §aausgewählt");

                    ItemStack i1 = new ItemStack(Material.LEATHER_BOOTS);
                    LeatherArmorMeta m1 = (LeatherArmorMeta) i1.getItemMeta();
                    m1.setDisplayName("§cLove Boots");
                    m1.setColor(Color.RED);
                    i1.setItemMeta(m1);

                    p.getInventory().setBoots(i1);

                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);

                    Main.love.add(p);
                    Main.ender.remove(p);
                    Main.crit.remove(p);
                    Main.villager.remove(p);
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Ender Boots")) {
                if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
                    p.closeInventory();
                    p.sendMessage(Main.ChatPrefix + "§7Du hast die §5Ender Boots §aausgewählt");

                    ItemStack i2 = new ItemStack(Material.LEATHER_BOOTS);
                    LeatherArmorMeta m2 = (LeatherArmorMeta) i2.getItemMeta();
                    m2.setDisplayName("§5Ender Boots");
                    m2.setColor(Color.PURPLE);
                    i2.setItemMeta(m2);

                    p.getInventory().setBoots(i2);

                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);

                    Main.ender.add(p);
                    Main.love.remove(p);
                    Main.villager.remove(p);
                    Main.crit.remove(p);
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVillager Boots")) {
                if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
                    p.closeInventory();
                    p.sendMessage(Main.ChatPrefix + "§7Du hast die §aVillager Boots §aausgewählt");

                    ItemStack i3 = new ItemStack(Material.LEATHER_BOOTS);
                    LeatherArmorMeta m3 = (LeatherArmorMeta) i3.getItemMeta();
                    m3.setDisplayName("§aVillager Boots");
                    m3.setColor(Color.GREEN);
                    i3.setItemMeta(m3);

                    p.getInventory().setBoots(i3);

                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);

                    Main.villager.add(p);
                    Main.love.remove(p);
                    Main.ender.remove(p);
                    Main.crit.remove(p);
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Crit Boots")) {
                if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
                    p.closeInventory();
                    p.sendMessage(Main.ChatPrefix + "§7Du hast die §3Crit Boots §aausgewählt");

                    ItemStack i4 = new ItemStack(Material.LEATHER_BOOTS);
                    LeatherArmorMeta m4 = (LeatherArmorMeta) i4.getItemMeta();
                    m4.setDisplayName("§3Crit Boots");
                    m4.setColor(Color.AQUA);
                    i4.setItemMeta(m4);

                    p.getInventory().setBoots(i4);

                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);

                    Main.crit.add(p);
                    Main.love.remove(p);
                    Main.ender.remove(p);
                    Main.villager.remove(p);
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAlle Gadgets entfernen")) {
                if (e.getCurrentItem().getType() == Material.BARRIER) {
                    p.closeInventory();
                    p.sendMessage(Main.ChatPrefix + "§7Du hast die §cGadgets entfernt");

                    p.getInventory().setBoots(null);

                    p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);

                    Main.crit.remove(p);
                    Main.love.remove(p);
                    Main.ender.remove(p);
                    Main.villager.remove(p);
                }
            }
        } catch (Exception e1){

        }
    }

    @EventHandler
    public void onMove1(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(Main.love.contains(p)){
            p.playEffect(p.getLocation(), Effect.HEART, 10);
        } else if(Main.ender.contains(p)){
            p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 10);
        } else if(Main.crit.contains(p)){
            p.playEffect(p.getLocation(), Effect.CRIT, 10);
        } else if(Main.villager.contains(p)){
            p.playEffect(p.getLocation(), Effect.HAPPY_VILLAGER, 10);
        }
    }

    @EventHandler
    public void onFly(PlayerInteractEvent e){
        Player p = e.getPlayer();
        try{
        if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Flug-Feder §8● §8(§7Rechtsklick§8)")){
            if(e.getItem().getType() == Material.FEATHER){
                if(!Main.fly.contains(p)) {
                    Main.fly.add(p);
                    p.setAllowFlight(true);
                    p.sendMessage(Main.ChatPrefix + "§7Du kannst nun §afliegen");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
            } else if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Flug-Feder §8● §8(§7Rechtsklick§8)")){
                if(e.getItem().getType() == Material.FEATHER) {
                    if (Main.fly.contains(p)) {
                        Main.fly.remove(p);
                        p.setAllowFlight(false);
                        p.sendMessage(Main.ChatPrefix + "§7Du kannst nun nicht mehr §cfliegen");
                        p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);
                    }
                }
                }
                }
            }
        } catch (Exception e1){

        }
    }
}
