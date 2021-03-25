package de.FriendPlays.spigot.BuildFFA.main;

import de.FriendPlays.spigot.BuildFFA.commands.CMD_Build;
import de.FriendPlays.spigot.BuildFFA.commands.CMD_Gm;
import de.FriendPlays.spigot.BuildFFA.commands.CMD_setloc;
import de.FriendPlays.spigot.BuildFFA.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static String ScorePrefix = "§6•§e● §eBuildFFA";
    public static String ChatPrefix = "§6•§e● §eBuildFFA§8▐ §7";
    public static String NoPermsPrefix = "§6•§e● §eBuildFFA§8▐ §cDu hast keine Rechte auf diesen Befehl!";

    public static File file = new File("plugins/BuildFFA/locations.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static ArrayList<Player> rusher = new ArrayList<>();
    public static ArrayList<Player> standard = new ArrayList<>();
    public static ArrayList<Player> build = new ArrayList<>();

    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(Main.ChatPrefix + "§aDu hast das BuildFFA aktiviert");

        registerListeners();
        registerCommands();

        try{
            cfg.load(file);
        } catch (Exception e1){
        }

    }

    @Override
    public void onDisable() {
        instance = null;
        Bukkit.getConsoleSender().sendMessage(Main.ChatPrefix + "§cDu hast das BuildFFA deaktiviert");
    }

    public void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinQuitlistener(), this);
        pm.registerEvents(new InGameSettingslistener(), this);
        pm.registerEvents(new Buildlistener(), this);
        pm.registerEvents(new ScoreAPISettingslistener(), this);
        pm.registerEvents(new JoinItemslistener(), this);
    }

    public void registerCommands(){
        getCommand("build").setExecutor(new CMD_Build());
        getCommand("setloc").setExecutor(new CMD_setloc());
        getCommand("gm").setExecutor(new CMD_Gm());
    }
}
