package de.FriendPlays.spigot.BuildFFA.commands;

import de.FriendPlays.spigot.BuildFFA.main.Main;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Gm implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = (Player)cs;
        if (cmd.getName().equalsIgnoreCase("gm")) {
            if (p.hasPermission("BuildFFA.gm")) {
                if (args.length == 0) {
                    p.sendMessage(Main.ChatPrefix + "§cNutze: /gm <0,1,2,3>");
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Main.ChatPrefix + "§7Du wurdest in GameMode §a" + p.getGameMode() + "§7 gesetzt");
                        p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                    } else if (args[0].equalsIgnoreCase("1")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Main.ChatPrefix + "§7Du wurdest in GameMode §a" + p.getGameMode() + "§7 gesetzt");
                        p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                    } else if (args[0].equalsIgnoreCase("2")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Main.ChatPrefix + "§7Du wurdest in GameMode §a" + p.getGameMode() + "§7 gesetzt");
                        p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                    } else if (args[0].equalsIgnoreCase("3")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(Main.ChatPrefix + "§7Du wurdest in GameMode §a" + p.getGameMode() + "§7 gesetzt");
                        p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                    }
                }
            } else {
                p.sendMessage(Main.NoPermsPrefix);
            }
        }
        return false;
    }
}
