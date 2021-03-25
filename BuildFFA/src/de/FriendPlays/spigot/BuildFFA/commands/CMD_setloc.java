package de.FriendPlays.spigot.BuildFFA.commands;

import de.FriendPlays.spigot.BuildFFA.main.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_setloc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = (Player) cs;
        if (cmd.getName().equalsIgnoreCase("setloc")) {
            if (p.hasPermission("BuildFFA.setloc")) {
                if (args.length == 0) {
                    p.sendMessage(Main.ChatPrefix + "§cNutze: /setloc <Spawn>");
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("Spawn")) {
                        Main.cfg.set("Spawn", p.getLocation());
                        p.sendMessage(Main.ChatPrefix + "§aDu hast den Spawn §8[§cSpawn§8] §agesetzt");
                        p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                        try {
                            Main.cfg.save(Main.file);
                        } catch (Exception e1) {
                        }
                    }
                }
                } else {
                    p.sendMessage(Main.NoPermsPrefix);
            }
        }
        return false;
    }
}
