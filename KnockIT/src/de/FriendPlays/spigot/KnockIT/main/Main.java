package de.FriendPlays.spigot.KnockIT.main;

import de.FriendPlays.spigot.KnockIT.commands.CMD_build;
import de.FriendPlays.spigot.KnockIT.commands.CMD_setloc;
import de.FriendPlays.spigot.KnockIT.listeners.Buildlistener;
import de.FriendPlays.spigot.KnockIT.listeners.InGameSettingslistener;
import de.FriendPlays.spigot.KnockIT.listeners.JoinQuitlistener;
import de.FriendPlays.spigot.KnockIT.listeners.ScoreAPISettingslistener;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static String ChatPrefix = "§2•§a● §aKnockIT§8▐ §7";
    public static String NoPermsPrefix = "§2•§a● §aKnockIT§8▐ §cDu hast keine Rechte für diesen Befehl!";
    public static String ScorePrefix = "§2•§a● §aKnockIT";

    public static File file = new File("plugins/KnockIT/Location.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static ArrayList<Player> build = new ArrayList<>();

    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(Main.ChatPrefix + "§aDu hast das KnockIT Plugin aktiviert");

        registerListeners();

        registerCommands();

        World w = Bukkit.getWorld("world");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
            w.setTime(1000);
            w.setDifficulty(Difficulty.PEACEFUL);
        }, 0, 0);

        try{
            cfg.load(file);
        } catch (Exception e1){
        }

    }

    @Override
    public void onDisable() {
        instance = null;
        Bukkit.getConsoleSender().sendMessage(Main.ChatPrefix + "§cDu hast das KnockIT Plugin deaktiviert");
    }

    public void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinQuitlistener(), this);
        pm.registerEvents(new Buildlistener(), this);
        pm.registerEvents(new InGameSettingslistener(), this);
        pm.registerEvents(new ScoreAPISettingslistener(), this);
    }

    public void registerCommands(){
        getCommand("build").setExecutor(new CMD_build());
        getCommand("setloc").setExecutor(new CMD_setloc());
    }

}
