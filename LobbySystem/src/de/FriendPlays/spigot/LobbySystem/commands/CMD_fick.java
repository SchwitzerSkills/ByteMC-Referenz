package de.FriendPlays.spigot.LobbySystem.commands;

import de.FriendPlays.spigot.LobbySystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.util.Vector;

public class CMD_fick implements CommandExecutor {

    public static int count;

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fick")) {
            if(!(cs instanceof Player)){
                cs.sendMessage("§cDu musst ein Spieler sein!");
            } else {
                Player p = (Player) cs;
                if (args.length == 0) {
                    p.sendMessage(Main.ChatPrefix + "§cNutze: /fick <Player>");
                }
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                        double Ax = p.getLocation().getX();
                        double Ay = p.getLocation().getY();
                        double Az = p.getLocation().getZ();

                        double Bx = target.getLocation().getX();
                        double By = target.getLocation().getY();
                        double Bz = target.getLocation().getZ();

                        double x = Bx - Ax;
                        double y = By - Ay;
                        double z = Bz - Az;
                        Vector v = new Vector(x, y, z).normalize().multiply(2D).setY(0.3D);
                        target.setVelocity(v);
                        for(Player on : Bukkit.getOnlinePlayers()){
                            on.playSound(on.getLocation(), Sound.VILLAGER_DEATH, 10, 10);
                            on.sendMessage(Main.ChatPrefix + "§7Der Spieler §c" + target.getName() + "§7 Erzeugt gerade ein Kind");
                        }
                        Bukkit.getScheduler().cancelTask(count);
                        count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                            target.setVelocity(v);
                            for(Player on : Bukkit.getOnlinePlayers()){
                                on.playSound(on.getLocation(), Sound.VILLAGER_DEATH, 10, 10);
                                on.sendMessage(Main.ChatPrefix + "§7Der Spieler §c" + target.getName() + "§7 Erzeugt gerade ein Kind");
                            }
                            Bukkit.getScheduler().cancelTask(count);
                            count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                                target.setVelocity(v);
                                for(Player on : Bukkit.getOnlinePlayers()){
                                    on.playSound(on.getLocation(), Sound.VILLAGER_DEATH, 10, 10);
                                    on.sendMessage(Main.ChatPrefix + "§7Der Spieler §c" + target.getName() + "§7 Erzeugt gerade ein Kind");
                                }
                                Bukkit.getScheduler().cancelTask(count);
                                for(Player on : Bukkit.getOnlinePlayers()){
                                    on.sendMessage(Main.ChatPrefix + "§7Der Spieler §c" + target.getName() + "§7 hat gerade ein Kind erzeugt");
                                }
                                Villager vill = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                                vill.setCustomName("§c" + target.getName());
                                vill.setBaby();
                                vill.setAgeLock(false);
                            }, 0, 40);
                        }, 0, 40);
                    }, 0, 40);
                }
            }
        }
        return false;
    }
}
