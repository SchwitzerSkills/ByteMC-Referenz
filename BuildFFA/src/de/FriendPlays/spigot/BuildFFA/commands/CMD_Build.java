package de.FriendPlays.spigot.BuildFFA.commands;

import de.FriendPlays.spigot.BuildFFA.listeners.JoinItemslistener;
import de.FriendPlays.spigot.BuildFFA.main.Main;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Build implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = (Player)cs;
        if (cmd.getName().equalsIgnoreCase("build")) {
            if (p.hasPermission("BuildFFA.build")) {
                if(!Main.build.contains(p)){
                    Main.build.add(p);
                    p.setGameMode(GameMode.CREATIVE);
                    p.getInventory().clear();
                    p.getInventory().setHelmet(null);
                    p.getInventory().setChestplate(null);
                    p.getInventory().setLeggings(null);
                    p.getInventory().setBoots(null);
                    p.sendMessage(Main.ChatPrefix + "§aDu kannst nun bauen");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                } else if(Main.build.contains(p)){
                    Main.build.remove(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.getInventory().clear();
                    JoinItemslistener.items2(p);
                    p.sendMessage(Main.ChatPrefix + "§cDu kannst nun nicht mehr bauen");
                    p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);
                }
            } else {
                p.sendMessage(Main.NoPermsPrefix);
            }
        }
        return false;
    }
}
