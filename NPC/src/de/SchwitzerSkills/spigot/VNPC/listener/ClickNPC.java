package de.Venrux.spigot.VNPC.listener;

import de.DeinePlugins.spigot.CoinsAPI.CoinSystem;
import de.Venrux.spigot.VNPC.main.Main;
import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.api.player.PermissionProvider;
import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.bridge.internal.util.CloudPermissble;
import de.dytanic.cloudnet.bridge.internal.util.CloudPlayerCommandSender;
import de.dytanic.cloudnet.lib.DefaultType;
import de.dytanic.cloudnet.lib.player.CloudPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClickNPC implements Listener {

    @EventHandler
    public void onClick(RightClickNPC e) {
        Player p = e.getPlayer();
        if (e.getNpc().getName().equalsIgnoreCase("§8» §cBridge")) {
            if(!CloudAPI.getInstance().getServerGroup("Bridge").isMaintenance()) {
                Inventory inv = Bukkit.createInventory(null, 9 * 3, "§8» §cBridge §8» §7Server");

                ItemStack i1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemMeta m1 = i1.getItemMeta();
                m1.setDisplayName("§c");
                i1.setItemMeta(m1);

                ItemStack i3 = new ItemStack(Material.NETHER_STAR, CloudAPI.getInstance().getServerInfo("Bridge-1").getOnlineCount());
                ItemMeta m3 = i3.getItemMeta();
                m3.setDisplayName("§cBridge-1");
                i3.setItemMeta(m3);

                inv.setItem(0, i1);
                inv.setItem(1, i1);
                inv.setItem(2, i1);
                inv.setItem(3, i1);
                inv.setItem(5, i1);
                inv.setItem(6, i1);
                inv.setItem(7, i1);
                inv.setItem(8, i1);

                inv.setItem(18, i1);
                inv.setItem(19, i1);
                inv.setItem(20, i1);
                inv.setItem(21, i1);
                inv.setItem(22, i1);
                inv.setItem(23, i1);
                inv.setItem(24, i1);
                inv.setItem(25, i1);
                inv.setItem(26, i1);

                inv.setItem(4, i1);

                inv.addItem(i3);

                p.openInventory(inv);

                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 10, 10);
            } else if(CloudAPI.getInstance().getServerGroup("Bridge").isMaintenance()) {
                p.sendMessage(Main.Prefix + "§cDieser Spielmodus ist derzeit in Wartungen!");
                p.playSound(p.getLocation(), Sound.ITEM_BREAK, 10, 10);
            }
        } else if (e.getNpc().getName().equalsIgnoreCase("§8» §cHilfe")) {
            p.sendMessage(Main.Prefix + "§7Herzlich Wilkommen auf Server.de!\n" + Main.Prefix + "§7Wir sind ein §aTrainings §9Netzwerk\n" + Main.Prefix + "§7Wir bieten die SpielModis§8: §cBuildFFA, BedWars, MLGRush, Bridge\n" + Main.Prefix + "§7Weitere Hilfe bekommst du auf unserem TeamSpeak§8: §9Server.de\n" + Main.Prefix + "§7Wir wünschen dir viel Spaß auf unseren Netzwerk! :)");
            p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
        }
    }

    @EventHandler
    public void NPC(RightClickNPC e) {
        Player p = e.getPlayer();
        if (e.getNpc().getName().equalsIgnoreCase("§8» §cMLGRush")) {
            if(!CloudAPI.getInstance().getServerGroup("MLGRush").isMaintenance()) {
                Inventory inv = Bukkit.createInventory(null, 9 * 3, "§8» §cMLGRush §8» §7Server");

                ItemStack i1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemMeta m1 = i1.getItemMeta();
                m1.setDisplayName("§c");
                i1.setItemMeta(m1);

                ItemStack i3 = new ItemStack(Material.NETHER_STAR, CloudAPI.getInstance().getServerInfo("MLGRush-1").getOnlineCount());
                ItemMeta m3 = i3.getItemMeta();
                m3.setDisplayName("§cMLGRush-1");
                i3.setItemMeta(m3);

                inv.setItem(0, i1);
                inv.setItem(1, i1);
                inv.setItem(2, i1);
                inv.setItem(3, i1);
                inv.setItem(5, i1);
                inv.setItem(6, i1);
                inv.setItem(7, i1);
                inv.setItem(8, i1);

                inv.setItem(18, i1);
                inv.setItem(19, i1);
                inv.setItem(20, i1);
                inv.setItem(21, i1);
                inv.setItem(22, i1);
                inv.setItem(23, i1);
                inv.setItem(24, i1);
                inv.setItem(25, i1);
                inv.setItem(26, i1);

                inv.setItem(4, i1);

                inv.addItem(i3);

                p.openInventory(inv);

                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 10, 10);
            } else if(CloudAPI.getInstance().getServerGroup("MLGRush").isMaintenance()) {
                p.sendMessage(Main.Prefix + "§cDieser Spielmodus ist derzeit in Wartungen!");
                p.playSound(p.getLocation(), Sound.ITEM_BREAK, 10, 10);
            }
            }
    }

    @EventHandler
    public void onNPC1(RightClickNPC e) {
        Player p = e.getPlayer();
        if (e.getNpc().getName().equalsIgnoreCase("§8» §cBedWars")) {
            if(!CloudAPI.getInstance().getServerGroup("BedWars-8x1").isMaintenance()
            && !CloudAPI.getInstance().getServerGroup("BedWars-4x2").isMaintenance()) {
                Inventory inv = Bukkit.createInventory(null, 9 * 3, "§8» §cBedWars §8» §7Server");

                ItemStack i1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemMeta m1 = i1.getItemMeta();
                m1.setDisplayName("§c");
                i1.setItemMeta(m1);

                inv.setItem(0, i1);
                inv.setItem(1, i1);
                inv.setItem(2, i1);
                inv.setItem(3, i1);
                inv.setItem(5, i1);
                inv.setItem(6, i1);
                inv.setItem(7, i1);
                inv.setItem(8, i1);

                inv.setItem(18, i1);
                inv.setItem(19, i1);
                inv.setItem(20, i1);
                inv.setItem(21, i1);
                inv.setItem(22, i1);
                inv.setItem(23, i1);
                inv.setItem(24, i1);
                inv.setItem(25, i1);
                inv.setItem(26, i1);

                inv.setItem(4, i1);

                inv.addItem(createCustomItem(Material.NETHER_STAR, CloudAPI.getInstance().getServerInfo("BedWars-4x2-1").getOnlineCount(), (short) 0, "§cBedWars-4x2-1"));
                inv.addItem(createCustomItem(Material.NETHER_STAR, CloudAPI.getInstance().getServerInfo("BedWars-4x2-2").getOnlineCount(), (short) 0, "§cBedWars-4x2-2"));
                inv.addItem(createCustomItem(Material.NETHER_STAR, CloudAPI.getInstance().getServerInfo("BedWars-8x1-1").getOnlineCount(), (short) 0, "§cBedWars-8x1-1"));
                inv.addItem(createCustomItem(Material.NETHER_STAR, CloudAPI.getInstance().getServerInfo("BedWars-8x1-2").getOnlineCount(), (short) 0, "§cBedWars-8x1-2"));

                p.openInventory(inv);

                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 10, 10);
            } else if(CloudAPI.getInstance().getServerGroup("BedWars-8x1").isMaintenance()
                    && CloudAPI.getInstance().getServerGroup("BedWars-4x2").isMaintenance()) {
                p.sendMessage(Main.Prefix + "§cDieser Spielmodus ist derzeit in Wartungen!");
                p.playSound(p.getLocation(), Sound.ITEM_BREAK, 10, 10);
            }
        }
    }

    @EventHandler
    public void onNCP2(RightClickNPC e) {
        Player p = e.getPlayer();
        if (e.getNpc().getName().equalsIgnoreCase("§8» §cBuildFFA")) {
            if(!CloudAPI.getInstance().getServerGroup("BuildFFA").isMaintenance()) {
                Inventory inv = Bukkit.createInventory(null, 9 * 3, "§8» §cBuildFFA §8» §7Server");

                ItemStack i1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemMeta m1 = i1.getItemMeta();
                m1.setDisplayName("§c");
                i1.setItemMeta(m1);

                inv.setItem(0, i1);
                inv.setItem(1, i1);
                inv.setItem(2, i1);
                inv.setItem(3, i1);
                inv.setItem(5, i1);
                inv.setItem(6, i1);
                inv.setItem(7, i1);
                inv.setItem(8, i1);

                inv.setItem(18, i1);
                inv.setItem(19, i1);
                inv.setItem(20, i1);
                inv.setItem(21, i1);
                inv.setItem(22, i1);
                inv.setItem(23, i1);
                inv.setItem(24, i1);
                inv.setItem(25, i1);
                inv.setItem(26, i1);

                inv.setItem(4, i1);

                inv.setItem(9, createCustomItem(Material.NETHER_STAR, CloudAPI.getInstance().getServerInfo("BuildFFA-1").getOnlineCount(), (short) 0, "§cBuildFFA-1"));
                inv.addItem(createCustomItem(Material.NETHER_STAR, CloudAPI.getInstance().getServerInfo("BuildFFA-2").getOnlineCount(), (short) 0, "§cBuildFFA-2"));

                p.openInventory(inv);

                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 10, 10);
            } else if(CloudAPI.getInstance().getServerGroup("BuildFFA").isMaintenance()) {
                p.sendMessage(Main.Prefix + "§cDieser Spielmodus ist derzeit in Wartungen!");
                p.playSound(p.getLocation(), Sound.ITEM_BREAK, 10, 10);
            }
        }
    }

    @EventHandler
    public void NCP3(RightClickNPC e) {
        Player p = e.getPlayer();
        if (e.getNpc().getName().equalsIgnoreCase("§8» §cEvent")) {
            if(!CloudAPI.getInstance().getServerGroup("Event").isMaintenance()) {
                Inventory inv = Bukkit.createInventory(null, 9 * 3, "§8» §cEvent §8» §7Server");

                ItemStack i1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemMeta m1 = i1.getItemMeta();
                m1.setDisplayName("§c");
                i1.setItemMeta(m1);

                inv.setItem(0, i1);
                inv.setItem(1, i1);
                inv.setItem(2, i1);
                inv.setItem(3, i1);
                inv.setItem(5, i1);
                inv.setItem(6, i1);
                inv.setItem(7, i1);
                inv.setItem(8, i1);

                inv.setItem(18, i1);
                inv.setItem(19, i1);
                inv.setItem(20, i1);
                inv.setItem(21, i1);
                inv.setItem(22, i1);
                inv.setItem(23, i1);
                inv.setItem(24, i1);
                inv.setItem(25, i1);
                inv.setItem(26, i1);

                inv.setItem(4, i1);

                inv.addItem(createCustomItem(Material.NETHER_STAR, CloudAPI.getInstance().getServerInfo("Event-1").getOnlineCount(), (short) 0, "§cEvent-1"));

                p.openInventory(inv);

                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 10, 10);
            } else if(CloudAPI.getInstance().getServerGroup("Event").isMaintenance()){
                p.sendMessage(Main.Prefix + "§cEs gibt aktuell kein Event");
                p.playSound(p.getLocation(), Sound.ITEM_BREAK, 10, 10);
            }
        }
    }

    @EventHandler
    public void onNPC5(RightClickNPC e){
        Player p = e.getPlayer();
        if(e.getNpc().getName().equalsIgnoreCase("§8» §cShop")){
            Inventory inv = Bukkit.createInventory(null, 9*3, "§8» §cShop");
                ItemStack i1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemMeta m1 = i1.getItemMeta();
                m1.setDisplayName("§c");
                i1.setItemMeta(m1);

                inv.setItem(0, i1);
                inv.setItem(1, i1);
                inv.setItem(2, i1);
                inv.setItem(3, i1);
                inv.setItem(5, i1);
                inv.setItem(6, i1);
                inv.setItem(7, i1);
                inv.setItem(8, i1);

                inv.setItem(18, i1);
                inv.setItem(19, i1);
                inv.setItem(20, i1);
                inv.setItem(21, i1);
                inv.setItem(22, i1);
                inv.setItem(23, i1);
                inv.setItem(24, i1);
                inv.setItem(25, i1);
                inv.setItem(26, i1);
                inv.setItem(4, i1);

                inv.setItem(11, createCustomItem(Material.BOOK, 1, (short) 0, "§6Premium §710 Tage", "§a5.000 §cCoins"));
                inv.setItem(13, createCustomItem(Material.BOOK, 1, (short) 0, "§6Premium §730 Tage", "§a10.000 §cCoins"));
                inv.setItem(15, createCustomItem(Material.BOOK, 1, (short) 0, "§dVIP §710 Tage", "§a15.000 §cCoins"));

                p.openInventory(inv);
            }
        }

    public static ItemStack createCustomItem(Material customMaterial, Integer customAmount, Short customSubId, String customDisplayName, String... customSubtitle) {

        ItemStack customItemStack = new ItemStack(customMaterial, customAmount, customSubId);
        ItemMeta customItemMeta = customItemStack.getItemMeta();
        customItemMeta.setDisplayName(customDisplayName);
        List<String> customLore = new ArrayList<String>();
        for (String customSubtitle1 : customSubtitle) {
            customLore.add(customSubtitle1);
        }
        customItemMeta.setLore(customLore);
        customItemStack.setItemMeta(customItemMeta);

        return customItemStack;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().getName().equalsIgnoreCase("§8» §cBuildFFA §8» §7Server")) {
            e.setCancelled(true);
        } else if (e.getInventory().getName().equalsIgnoreCase("§8» §cBedWars §8» §7Server")) {
            e.setCancelled(true);
        } else if (e.getInventory().getName().equalsIgnoreCase("§8» §cBuildFFA §8» §7Server")) {
            e.setCancelled(true);
        } else if (e.getInventory().getName().equalsIgnoreCase("§8» §cMLGRush §8» §7Server")) {
            e.setCancelled(true);
        } else if (e.getInventory().getName().equalsIgnoreCase("§8» §cBridge §8» §7Server")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick2(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBridge-1")) {
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(stream);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF("Bridge-1");
                } catch (Exception e1) {
                }
                p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", stream.toByteArray());
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cMLGRush-1")) {
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(stream);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF("MLGRush-1");
                } catch (Exception e1) {
                }
                p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", stream.toByteArray());
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBedWars-4x2-1")) {
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(stream);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF("BedWars-4x2-1");
                } catch (Exception e1) {
                }
                p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", stream.toByteArray());
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBedWars-4x2-2")) {
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(stream);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF("BedWars-4x2-2");
                } catch (Exception e1) {
                }
                p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", stream.toByteArray());
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBedWars-8x1-1")) {
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(stream);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF("BedWars-8x1-1");
                } catch (Exception e1) {
                }
                p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", stream.toByteArray());
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBedWars-8x1-2")) {
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(stream);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF("BedWars-8x1-2");
                } catch (Exception e1) {
                }
                p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", stream.toByteArray());
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBuildFFA-1")) {
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(stream);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF("BuildFFA-1");
                } catch (Exception e1) {
                }
                p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", stream.toByteArray());
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBuildFFA-2")) {
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(stream);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF("BuildFFA-2");
                } catch (Exception e1) {
                }
                p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", stream.toByteArray());
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cEvent-1")) {
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(stream);

                try {
                    out.writeUTF("Connect");
                    out.writeUTF("Event-1");
                } catch (Exception e1) {
                }
                p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", stream.toByteArray());
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Premium §710 Tage")) {
            if (e.getCurrentItem().getType() == Material.BOOK) {
                if(!PermissionProvider.isInGroup("VIP", CloudAPI.getInstance().getOfflinePlayer(p.getUniqueId()))) {
                    if (CoinSystem.getInstance().getCoinManager().hasCoinsRemove(p, 5000, Main.Prefix + "§cDu hast nicht genügend Coins!", Main.Prefix + "§7Du hast nun den §6Premium §aRang §7für 10 Tage\n§cBitte rejoinen")) {
                        PermissionProvider.setPlayerGroup(CloudAPI.getInstance().getOfflinePlayer(p.getUniqueId()), "Premium", PermissionProvider.calculateDays(10));
                        PermissionProvider.updatePlayer(CloudAPI.getInstance().getOfflinePlayer(p.getUniqueId()));
                        p.closeInventory();
                    } else {
                        p.closeInventory();
                    }
                } else {
                    p.closeInventory();
                    p.sendMessage(Main.Prefix + "§cDu hast schon einen höheren Rang als §6Premium");
                }
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Premium §730 Tage")) {
            if (e.getCurrentItem().getType() == Material.BOOK) {
                if(!PermissionProvider.isInGroup("VIP", CloudAPI.getInstance().getOfflinePlayer(p.getUniqueId()))) {
                    if (CoinSystem.getInstance().getCoinManager().hasCoinsRemove(p, 10000, Main.Prefix + "§cDu hast nicht genügend Coins!", Main.Prefix + "§7Du hast nun den §6Premium §aRang §7für 30 Tage\n§cBitte rejoinen")) {
                        PermissionProvider.setPlayerGroup(CloudAPI.getInstance().getOfflinePlayer(p.getUniqueId()), "Premium", PermissionProvider.calculateDays(30));
                        PermissionProvider.updatePlayer(CloudAPI.getInstance().getOfflinePlayer(p.getUniqueId()));
                        p.closeInventory();
                    } else {
                        p.closeInventory();
                    }
                } else {
                    p.closeInventory();
                    p.sendMessage(Main.Prefix + "§cDu hast schon einen höheren Rang als §6Premium");
                }
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dVIP §710 Tage")) {
            if (e.getCurrentItem().getType() == Material.BOOK) {
                if(CoinSystem.getInstance().getCoinManager().hasCoinsRemove(p, 15000, Main.Prefix + "§cDu hast nicht genügend Coins!", Main.Prefix + "§7Du hast nun den §dVIP §aRang §7für 10 Tage\n§cBitte rejoinen")){
                    PermissionProvider.setPlayerGroup(CloudAPI.getInstance().getOfflinePlayer(p.getUniqueId()), "VIP", PermissionProvider.calculateDays(10));
                    PermissionProvider.updatePlayer(CloudAPI.getInstance().getOfflinePlayer(p.getUniqueId()));
                    p.closeInventory();
                } else {
                    p.closeInventory();
                }
            }
        }
    }
}
