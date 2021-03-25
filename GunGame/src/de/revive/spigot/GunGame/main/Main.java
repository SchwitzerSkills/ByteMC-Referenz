package de.revive.spigot.GunGame.main;

import de.revive.spigot.GunGame.commands.Command_Gm;
import de.revive.spigot.GunGame.commands.Command_build;
import de.revive.spigot.GunGame.commands.Command_setloc;
import de.revive.spigot.GunGame.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static String ScorePrefix = "§4•§c● §cGunGame";
    public static String Prefix = "§4•§c● §cGunGame§8▐ §7";

    public static Main instance;

    public static ArrayList<Player> build = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§aDu hast das GunGame aktiviert");

        registerListeners();

        registerCommands();

        World w = Bukkit.getWorld("world");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
            w.setDifficulty(Difficulty.PEACEFUL);
            w.setTime(1000);
        }, 0, 0);

        try {
            Command_setloc.cfg.load(Command_setloc.file);
        } catch (Exception e1){
        }

    }

    @Override
    public void onDisable() {
        instance = null;
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§cDu hast das GunGame deaktiviert");
    }

    public void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerKilllistener(), this);
        pm.registerEvents(new JoinQuitListener(), this);
        pm.registerEvents(new PlayerJoinItemslistener(), this);
        pm.registerEvents(new WeatherChangelistener(), this);
        pm.registerEvents(new Foodlistener(), this);
        pm.registerEvents(new Buildlistener(), this);
        pm.registerEvents(new EntitySpawnlistener(), this);
        pm.registerEvents(new ScoreAPISettingslistener(), this);
    }

    public void registerCommands(){
    getCommand("build").setExecutor(new Command_build());
    getCommand("gm").setExecutor(new Command_Gm());
    getCommand("setloc").setExecutor(new Command_setloc());
    }

}
