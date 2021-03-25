package de.Venrux.spigot.VNPC.commands;

import de.Venrux.spigot.VNPC.listener.NPC;
import de.Venrux.spigot.VNPC.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_VNPC implements CommandExecutor {

    public static String skin;

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("vnpc")) {
            if(!(cs instanceof Player)){
                cs.sendMessage(Main.noCS);
            } else {
                Player p = (Player) cs;
                if (p.hasPermission("Venrux.NPC")) {
                    if (args.length == 0) {
                        p.sendMessage(Main.Prefix + "§cNutze: /vnpc create <Bridge, MLGRush, BedWars, BuildFFA, Hilfe, Event, Shop> <Skin> <Servername, Name>");
                    }
                    if (args.length == 1) {
                        if(args[0].equalsIgnoreCase("create")){
                            p.sendMessage(Main.Prefix + "§cNutze: /vnpc create <Bridge, MLGRush, BedWars, BuildFFA, Hilfe, Event, Shop> <Skin> <Servername, Name>");
                        }
                    }
                    if (args.length == 2) {
                        p.sendMessage(Main.Prefix + "§cNutze: /vnpc create <Bridge, MLGRush, BedWars, BuildFFA, Hilfe, Event, Shop> <Skin> <Servername, Name>");
                    }
                    if (args.length == 3) {
                        if (args[2].equalsIgnoreCase(args[2])) {
                            p.sendMessage(Main.Prefix + "§cNutze: /vnpc create <Bridge, MLGRush, BedWars, BuildFFA, Hilfe, Event, Shop> <Skin> <Servername, Name>");
                        }
                    }
                    if (args.length == 4) {
                        if(args[3].equalsIgnoreCase(args[3])){
                            NPC.createNPC(p, args[2], args[3]);
                        }
                    }
                } else{
                    p.sendMessage(Main.noPerms);
                }
            }
        }
        return false;
    }
}
