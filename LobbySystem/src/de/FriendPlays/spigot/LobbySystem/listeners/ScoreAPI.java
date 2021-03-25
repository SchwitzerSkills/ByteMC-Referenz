package de.FriendPlays.spigot.LobbySystem.listeners;

import de.FriendPlays.spigot.LobbySystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import ru.tehkode.permissions.bukkit.PermissionsEx;

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
        obj.getScore("§8➔ §e" + Bukkit.getServer().getServerName()).setScore(10);
        obj.getScore("                  ").setScore(9);
        obj.getScore("§8•§7● §7Rank").setScore(8);
        obj.getScore("        ").setScore(6);
        obj.getScore("§8•§7● §7Online").setScore(5);
        obj.getScore("§8➔ §e" + Bukkit.getOnlinePlayers().size()).setScore(4);
        obj.getScore("").setScore(3);
        obj.getScore("§8•§7● §7TeamSpeak").setScore(2);
        obj.getScore("§8➔ §9FriendPlays.de").setScore(1);

        if(PermissionsEx.getUser(p).inGroup("Owner")){
            obj.getScore("§8➔ §4Owner").setScore(7);
        } else if(PermissionsEx.getUser(p).inGroup("Admin")){
            obj.getScore("§8➔ §4Admin").setScore(7);
        } else if(PermissionsEx.getUser(p).inGroup("Developer")){
            obj.getScore("§8➔ §bDeveloper").setScore(7);
        } else if(PermissionsEx.getUser(p).inGroup("Moderator")){
            obj.getScore("§8➔ §cModerator").setScore(7);
        } else if(PermissionsEx.getUser(p).inGroup("Builder")){
            obj.getScore("§8➔ §aBuilder").setScore(7);
        } else if(PermissionsEx.getUser(p).inGroup("Supporter")){
            obj.getScore("§8➔ §eSupporter").setScore(7);
        } else if(PermissionsEx.getUser(p).inGroup("Youtuber")){
            obj.getScore("§8➔ §5Youtuber").setScore(7);
        } else if(PermissionsEx.getUser(p).inGroup("Premium+")){
            obj.getScore("§8➔ §ePremium+").setScore(7);
        } else if(PermissionsEx.getUser(p).inGroup("Premium")){
            obj.getScore("§8➔ §6Premium").setScore(7);
        } else {
            obj.getScore("§8➔ §7Spieler").setScore(7);
        }
        Team owner = getTeam(sb, "0000Owner", "§4Owner §8| §4", "§4");
        Team admin = getTeam(sb, "0001Admin", "§4Admin §8| §4", "§4");
        Team dev = getTeam(sb, "00002Dev", "§bDev §8| §b", "§b");
        Team mod = getTeam(sb, "00003Mod", "§cMod §8| §c", "§c");
        Team builder = getTeam(sb, "0004B", "§aB §8| §a", "§a");
        Team sup = getTeam(sb, "0005Sup", "§eSup §8| §e", "§e");
        Team youtuber = getTeam(sb, "0006YT", "§5YT §8| §5", "§5");
        Team premiump = getTeam(sb, "0007P+", "§eP+ §8| §e", "§e");
        Team premium = getTeam(sb, "0008Premium", "§6P §8| §6", "§6");
        Team spieler = getTeam(sb, "0009Spieler", "§7Spieler §8| §7", "§7");
        for(Player on : Bukkit.getOnlinePlayers()){
            if(PermissionsEx.getUser(on).inGroup("Owner")){
                owner.addPlayer(on);
            } else if(PermissionsEx.getUser(on).inGroup("Admin")){
                admin.addPlayer(on);
            } else if(PermissionsEx.getUser(on).inGroup("Developer")){
                dev.addPlayer(on);
            } else if(PermissionsEx.getUser(on).inGroup("Moderator")){
                mod.addPlayer(on);
            } else if(PermissionsEx.getUser(on).inGroup("Builder")){
                builder.addPlayer(on);
            } else if(PermissionsEx.getUser(on).inGroup("Supporter")){
                sup.addPlayer(on);
            } else if(PermissionsEx.getUser(on).inGroup("Youtuber")){
                youtuber.addPlayer(on);
            } else if(PermissionsEx.getUser(on).inGroup("Premium+")){
                premiump.addPlayer(on);
            } else if(PermissionsEx.getUser(on).inGroup("Premium")){
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
            Team admin = getTeam(sb, "0001Admin", "§4Admin §8| §4", "§4");
            Team dev = getTeam(sb, "00002Dev", "§bDev §8| §b", "§b");
            Team mod = getTeam(sb, "00003Mod", "§cMod §8| §c", "§c");
            Team builder = getTeam(sb, "0004B", "§aB §8| §a", "§a");
            Team sup = getTeam(sb, "0005Sup", "§eSup §8| §e", "§e");
            Team youtuber = getTeam(sb, "0006YT", "§5YT §8| §5", "§5");
            Team premiump = getTeam(sb, "0007P+", "§eP+ §8| §e", "§e");
            Team premium = getTeam(sb, "0008Premium", "§6P §8| §6", "§6");
            Team spieler = getTeam(sb, "0009Spieler", "§7Spieler §8| §7", "§7");
            for(Player on : Bukkit.getOnlinePlayers()) {
                if (PermissionsEx.getUser(on).inGroup("Owner")) {
                    owner.addPlayer(on);
                } else if (PermissionsEx.getUser(on).inGroup("Admin")) {
                    admin.addPlayer(on);
                } else if (PermissionsEx.getUser(on).inGroup("Developer")) {
                    dev.addPlayer(on);
                } else if (PermissionsEx.getUser(on).inGroup("Moderator")) {
                    mod.addPlayer(on);
                } else if (PermissionsEx.getUser(on).inGroup("Builder")) {
                    builder.addPlayer(on);
                } else if (PermissionsEx.getUser(on).inGroup("Supporter")) {
                    sup.addPlayer(on);
                } else if (PermissionsEx.getUser(on).inGroup("Youtuber")) {
                    youtuber.addPlayer(on);
                } else if (PermissionsEx.getUser(on).inGroup("Premium+")) {
                    premiump.addPlayer(on);
                } else if (PermissionsEx.getUser(on).inGroup("Premium")) {
                    premium.addPlayer(on);
                } else {
                    spieler.addPlayer(on);
                }
            }
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



