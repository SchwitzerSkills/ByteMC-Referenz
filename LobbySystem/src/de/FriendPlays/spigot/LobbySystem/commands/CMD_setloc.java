package de.FriendPlays.spigot.LobbySystem.commands;

import de.FriendPlays.spigot.LobbySystem.main.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_setloc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = (Player)cs;
        if (cmd.getName().equalsIgnoreCase("setloc")) {
            if (p.hasPermission("Lobby.setloc")) {
                if (args.length == 0) {
                    p.sendMessage(Main.ChatPrefix + "§cNutze: /setloc <Spawn, Amongus>");
                } else if (args[0].equalsIgnoreCase("Spawn")) {
                    Main.cfg.set("Spawn", p.getLocation());
                    p.sendMessage(Main.ChatPrefix + "§aDu hast den Spawn §8[§cSpawn§8] §agesetzt");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
                    try {
                        Main.cfg.save(Main.file);
                    } catch (Exception e1){
                        p.sendMessage(Main.ChatPrefix + "§cEs ist ein Fehler aufgetreten! Bitte reloade den Server");
                    }
                } else if (args[0].equalsIgnoreCase("Amongus")) {
                    Main.cfg.set("Amongus", p.getLocation());
                    p.sendMessage(Main.ChatPrefix + "§aDu hast den Spawn §8[§cAmongus§8] §agesetzt");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
                    try {
                        Main.cfg.save(Main.file);
                    } catch (Exception e1) {
                        p.sendMessage(Main.ChatPrefix + "§cEs ist ein Fehler aufgetreten! Bitte reloade den Server");
                    }
                }
            } else {
                p.sendMessage(Main.NoPermsPrefix);
            }
        }
        return false;
    }
}
