package de.FriendPlays.spigot.KnockIT.commands;

import de.FriendPlays.spigot.KnockIT.listeners.JoinItemslistener;
import de.FriendPlays.spigot.KnockIT.main.Main;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_build implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = (Player)cs;
        if (cmd.getName().equalsIgnoreCase("build")) {
            if (p.hasPermission("KnockIT.build")) {
                if(!Main.build.contains(p)){
                    Main.build.add(p);
                    p.sendMessage(Main.ChatPrefix + "§aDu kannst nun bauen");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                    p.getInventory().clear();
                    p.setGameMode(GameMode.CREATIVE);
                } else if(Main.build.contains(p)){
                    Main.build.remove(p);
                    p.getInventory().clear();
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(Main.ChatPrefix + "§cDu kannst nun nicht mehr bauen");
                    p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);
                    JoinItemslistener.items(p);
                }
            } else {
                p.sendMessage(Main.NoPermsPrefix);
            }
        }
        return false;
    }
}
