package de.revive.spigot.GunGame.commands;

import de.revive.spigot.GunGame.main.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Command_setloc implements CommandExecutor {

    public static File file = new File("plugins/GunGame/location.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cmd.getName().equalsIgnoreCase("setloc")){
            if(p.hasPermission("GunGame.setloc")){
                if (args.length == 0) {
                    p.sendMessage(Main.Prefix + "§cNutze: /setloc <Spawn>");
                }
                if (args.length == 1) {
                    if(args[0].equalsIgnoreCase("Spawn")){
                        cfg.set("Spawn", p.getLocation());
                        p.sendMessage(Main.Prefix + "§7Du hast die §cLocation §7von §aSpawn §7gesetzt");
                        p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                        try {
                            cfg.save(file);
                        } catch (Exception e1){
                        }
                    }
                }
            } else{
                p.sendMessage(Main.Prefix + "§cDu hast keine Rechte");
            }
        }
        return false;
    }
}
