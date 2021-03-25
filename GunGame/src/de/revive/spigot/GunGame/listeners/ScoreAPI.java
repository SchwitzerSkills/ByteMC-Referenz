package de.revive.spigot.GunGame.listeners;

import de.revive.spigot.GunGame.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreAPI {

    public static void setScoreboard(Player p){
        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.getObjective("aaa");
        if(obj == null){
            obj = sb.registerNewObjective("aaa", "bbb");
        }

        obj.setDisplayName(Main.ScorePrefix);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        obj.getScore("§8").setScore(12);
        obj.getScore("§8•§7● §7Server").setScore(11);
        obj.getScore("§8» §e" + Bukkit.getServer().getServerName()).setScore(10);
        obj.getScore("                  ").setScore(9);
        obj.getScore("§8•§7● §7Map").setScore(8);
        obj.getScore("§8» §e" + p.getWorld().getName()).setScore(7);
        obj.getScore("        ").setScore(6);
        obj.getScore("§8•§7● §7Online").setScore(5);
        obj.getScore("§8» §e" + Bukkit.getOnlinePlayers().size()).setScore(4);
        obj.getScore("").setScore(3);
        obj.getScore("§8•§7● §7TeamSpeak").setScore(2);
        obj.getScore("§8» §9FriendPlays.de").setScore(1);

        Team owner = getTeam(sb, "0000Owner", "§4Owner §8× §4", "§4");
        Team admin = getTeam(sb, "0001Admin", "§4Admin §8× §4", "§4");
        Team teamleitung = getTeam(sb, "0002Leitung", "§cTeam §8× §c", "§c");
        Team dev = getTeam(sb, "0003Dev", "§bDev §8× §b", "§b");
        Team mod = getTeam(sb, "0004Mod", "§cMod §8× §c", "§c");
        Team builder = getTeam(sb, "0005B", "§aBuilder §8× §a", "§a");
        Team sup = getTeam(sb, "0006Sup", "§eSup §8× §e", "§e");
        Team tdev = getTeam(sb, "0007TDev", "§bT-Dev §8× §b", "§b");
        Team tsup = getTeam(sb, "0008TSup", "§eT-Sup §8× §e", "§e");
        Team tbuilder = getTeam(sb, "0009TB", "§aT-B §8× §a", "§a");
        Team youtuber = getTeam(sb, "0010YT", "§5YT §8× §5", "§5");
        Team premiump = getTeam(sb, "0011P+", "§ePremi+ §8× §e", "§e");
        Team griefer = getTeam(sb, "0012Gr", "§4Griefer §8× §4", "§4");
        Team friend = getTeam(sb, "0013Fr", "§eFriend §8× §e", "§e");
        Team titan = getTeam(sb, "00014Titan", "§9Titan §8× §9", "§9");
        Team legend = getTeam(sb, "0015lege", "§cLegend §8× §c", "§c");
        Team ultra = getTeam(sb, "0016Ultra", "§bUltra §8× §b", "§b");
        Team premium = getTeam(sb, "0017Premium", "§6Premium §8× §6", "§6");
        Team spieler = getTeam(sb, "0018Spieler", "§7Spieler §8× §7", "§7");
        for(Player on : Bukkit.getOnlinePlayers()){
            if(on.hasPermission("GunGame.Owner")){
                owner.addPlayer(on);
            } else if(on.hasPermission("GunGame.Admin")){
                admin.addPlayer(on);
            } else if(on.hasPermission("GunGame.TeamLeitung")){
                teamleitung.addPlayer(on);
            } else if(on.hasPermission("GunGame.Developer")){
                dev.addPlayer(on);
            } else if(on.hasPermission("GunGame.Moderator")){
                mod.addPlayer(on);
            } else if(on.hasPermission("GunGame.Builder")){
                builder.addPlayer(on);
            } else if(on.hasPermission("GunGame.Supporter")){
                sup.addPlayer(on);
            } else if(on.hasPermission("GunGame.TDeveloper")){
                tdev.addPlayer(on);
            } else if(on.hasPermission("GunGame.TSupporter")){
                tsup.addPlayer(on);
            } else if(on.hasPermission("GunGame.TBuilder")){
                tbuilder.addPlayer(on);
            } else if(on.hasPermission("GunGame.Youtuber")){
                youtuber.addPlayer(on);
            } else if(on.hasPermission("GunGame.Premium+")){
                premiump.addPlayer(on);
            } else if(on.hasPermission("GunGame.Friend")){
                friend.addPlayer(on);
            } else if(on.hasPermission("GunGame.Griefer")){
                griefer.addPlayer(on);
            } else if(on.hasPermission("GunGame.Titan")){
                titan.addPlayer(on);
            } else if(on.hasPermission("GunGame.Legend")){
                legend.addPlayer(on);
            } else if(on.hasPermission("GunGame.Ultra")){
                ultra.addPlayer(on);
            } else if(on.hasPermission("GunGame.Premium")){
                premium.addPlayer(on);
            } else {
                spieler.addPlayer(on);
            }
            p.setScoreboard(sb);
        }
    }

    public static void updateScoreboard(Player p){
        if(p.getScoreboard() == null){
            setScoreboard(p);
            Scoreboard sb = p.getScoreboard();
            Objective obj = sb.getObjective("aaa");
            Team owner = getTeam(sb, "0000Owner", "§4Owner §8| §4", "§4");
            Team admin = getTeam(sb, "0000Admin", "§4Admin §8| §4", "§4");
            Team dev = getTeam(sb, "00001Dev", "§bDev §8| §b", "§b");
            Team mod = getTeam(sb, "00002Mod", "§cMod §8| §c", "§c");
            Team builder = getTeam(sb, "0003B", "§aB §8| §a", "§a");
            Team sup = getTeam(sb, "0004Sup", "§eSup §8| §e", "§e");
            Team youtuber = getTeam(sb, "0005YT", "§5YT §8| §5", "§5");
            Team premiump = getTeam(sb, "0006P+", "§eP+ §8| §e", "§e");
            Team premium = getTeam(sb, "0007Premium", "§6P §8| §6", "§6");
            Team spieler = getTeam(sb, "0008Spieler", "§7Spieler §8| §7", "§7");
        }
    }
    public static Team getTeam(Scoreboard sb, String Team, String prefix, String suffix){
        Team team = sb.getTeam(Team);
        if(team == null){
            team = sb.registerNewTeam(Team);
        }
        team.setPrefix(prefix);
        team.setSuffix(suffix);
        team.setAllowFriendlyFire(true);
        team.setCanSeeFriendlyInvisibles(true);
        return team;
    }

    public static String updateTeam(Scoreboard sb, String Team, String prefix, String suffix, ChatColor entry){
        Team team = sb.getTeam(Team);
        if(team == null){
            team = sb.registerNewTeam(Team);
        }
        team.setPrefix(prefix);
        team.setSuffix(suffix);
        team.addEntry(entry.toString());
        return entry.toString();
    }

    public static void startScheduler(){
    }

}
