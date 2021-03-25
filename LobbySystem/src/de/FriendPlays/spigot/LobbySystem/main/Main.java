package de.FriendPlays.spigot.LobbySystem.main;

import de.FriendPlays.spigot.LobbySystem.commands.CMD_Build;
import de.FriendPlays.spigot.LobbySystem.commands.CMD_Gm;
import de.FriendPlays.spigot.LobbySystem.commands.CMD_fick;
import de.FriendPlays.spigot.LobbySystem.commands.CMD_setloc;
import de.FriendPlays.spigot.LobbySystem.listeners.*;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main extends JavaPlugin {

    public static String ChatPrefix = "§6•§e● §eFriendPlays.de§8▐ §7";
    public static String NoPermsPrefix = "§6•§e● §eFriendPlays.de§8▐ §cDu hast keine Rechte für diesen Befehl!";
    public static String ScorePrefix = "§6•§e● §eFriendPlays";

    public static File file = new File("plugins/LobbySystem/Location.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static Main instance;

    public static ArrayList<Player> build = new ArrayList<>();
    public static ArrayList<Player> hide = new ArrayList<>();
    public static ArrayList<Player> love = new ArrayList<>();
    public static ArrayList<Player> ender = new ArrayList<>();
    public static ArrayList<Player> villager= new ArrayList<>();
    public static ArrayList<Player> crit = new ArrayList<>();
    public static ArrayList<Player> fly = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(Main.ChatPrefix + "§aDas LobbySystem wurde aktiviert");

        registerListeners();

        registerCommands();

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        World w = Bukkit.getWorld("world");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
            w.setTime(1000);
            w.setDifficulty(Difficulty.PEACEFUL);
            w.setWeatherDuration(0);
        }, 0, 0);

        try {
            cfg.load(file);
        } catch (Exception e1){
            Bukkit.getConsoleSender().sendMessage(Main.ChatPrefix + "§cEs ist beim Laden von der Location.yml ein Fehler aufgetreten!");
        }
    }

    @Override
    public void onDisable() {
        instance = null;
        Bukkit.getConsoleSender().sendMessage(Main.ChatPrefix + "§cDas LobbySystem wurde deaktiviert");
    }

    public void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinQuitlistener(), this);
        pm.registerEvents(new InGameSettingslistener(), this);
        pm.registerEvents(new Buildlistener(), this);
        pm.registerEvents(new JoinItemslistener(), this);
        pm.registerEvents(new ScoreAPISettingslistener(), this);
        pm.registerEvents(new InventoryOpenandCloselistener(), this);
    }

    public void registerCommands(){
        getCommand("build").setExecutor(new CMD_Build());
        getCommand("setloc").setExecutor(new CMD_setloc());
        getCommand("gm").setExecutor(new CMD_Gm());
        getCommand("fick").setExecutor(new CMD_fick());
    }

}
