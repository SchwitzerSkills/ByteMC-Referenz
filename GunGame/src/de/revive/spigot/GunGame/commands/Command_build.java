package de.revive.spigot.GunGame.commands;

import de.revive.spigot.GunGame.listeners.PlayerJoinItemslistener;
import de.revive.spigot.GunGame.main.Main;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_build implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cmd.getName().equalsIgnoreCase("build")){
            if(p.hasPermission("GunGame.build")){
                if(!Main.build.contains(p)){
                        Main.build.add(p);
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Main.Prefix + "§aDu kannst nun bauen");
                        p.getInventory().clear();
                        p.getInventory().setHelmet(null);
                        p.getInventory().setChestplate(null);
                        p.getInventory().setLeggings(null);
                        p.getInventory().setBoots(null);
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 10);
                } else if(Main.build.contains(p)){
                        Main.build.remove(p);
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Main.Prefix + "§cDu kannst nun nicht mehr bauen");
                        p.getInventory().clear();
                        p.getInventory().setHelmet(null);
                        p.getInventory().setChestplate(null);
                        p.getInventory().setLeggings(null);
                        p.getInventory().setBoots(null);
                    p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);

                    PlayerJoinItemslistener.items(p);
                    }
                }
            } else{
                p.sendMessage(Main.Prefix + "§cDu hast keine Rechte");
            }
        return false;
    }
}
