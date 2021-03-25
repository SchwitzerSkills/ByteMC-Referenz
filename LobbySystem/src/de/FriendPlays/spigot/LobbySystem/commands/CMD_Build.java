package de.FriendPlays.spigot.LobbySystem.commands;

import de.FriendPlays.spigot.LobbySystem.listeners.JoinItemslistener;
import de.FriendPlays.spigot.LobbySystem.main.Main;
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
            if (p.hasPermission("Lobby.build")) {
                if(!Main.build.contains(p)){
                    Main.build.add(p);
                    p.sendMessage(Main.ChatPrefix + "§aDu kannst nun bauen");
                    p.setGameMode(GameMode.CREATIVE);
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
                    p.getInventory().clear();
                } else if(Main.build.contains(p)){
                    Main.build.remove(p);
                    p.sendMessage(Main.ChatPrefix + "§cDu kannst nun nicht mehr bauen");
                    p.setGameMode(GameMode.ADVENTURE);
                    p.getInventory().clear();
                    JoinItemslistener.items(p);
                    p.playSound(p.getLocation(), Sound.BAT_DEATH, 10, 10);
                }
            } else {
                p.sendMessage(Main.NoPermsPrefix);
            }
        }
        return false;
    }
}
