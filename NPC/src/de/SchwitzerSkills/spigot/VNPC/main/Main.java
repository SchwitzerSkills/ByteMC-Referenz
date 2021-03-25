package de.Venrux.spigot.VNPC.main;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.Venrux.spigot.VNPC.listener.ClickNPC;
import de.Venrux.spigot.VNPC.listener.Join;
import de.Venrux.spigot.VNPC.listener.NPC;
import de.Venrux.spigot.VNPC.listener.PacketReader;
import de.Venrux.spigot.VNPC.commands.CMD_VNPC;
import de.Venrux.spigot.VNPC.listener.*;
import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.CloudServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;


public class Main extends JavaPlugin implements Listener {

    private static int count;

    public static String Prefix = "§8[§cProxy§8] §7";
    public static String noCS = "§cDu musst ein Spieler sein!";
    public static String noPerms = Prefix + "§cDu hast keine Rechte!";

    public static Main instance;

    public static DataManager data;

    @Override
    public void onEnable() {
        instance = this;
        data = new DataManager(this);
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§aDu hast das NPC Plugin aktiviert");

        if(data.getConfig().contains("data"))
            loadNPC();

        registerCommands();
        registerListeners();

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        Bukkit.getPluginManager().registerEvents(this, this);

        if(!Bukkit.getOnlinePlayers().isEmpty())
            for(Player on : Bukkit.getOnlinePlayers()){
                PacketReader reader = new PacketReader();
                reader.inject(on);
            }

    }

    @Override
    public void onDisable() {
        instance = null;
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§cDu hast das NPC Plugin deaktiviert");

            for(Player on : Bukkit.getOnlinePlayers()){
                PacketReader reader = new PacketReader();
                reader.uninject(on);
            }
    }

    public void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ClickNPC(), this);
        pm.registerEvents(new Join(), this);
    }

    public void registerCommands(){
        getCommand("vnpc").setExecutor(new CMD_VNPC());
    }

    public static FileConfiguration getData(){
        return data.getConfig();
    }

    public static void saveData(){
        data.saveConfig();
    }

    public void loadNPC(){
        FileConfiguration file = data.getConfig();
        data.getConfig().getConfigurationSection("data").getKeys(false).forEach(npc -> {
            Location loc = new Location(Bukkit.getWorld(file.getString("data." + npc + ".world")), file.getInt("data." + npc + ".x"), file.getInt("data." + npc + ".y"),
                    file.getInt("data." + npc + ".z"));
            loc.setPitch((float) file.getDouble("data." + npc + ".p"));
            loc.setYaw((float) file.getDouble("data." + npc + ".yaw"));

            String name = file.getString("data." + npc + ".name");
            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), name);
            gameProfile.getProperties().put("textures",new Property("textures", file.getString("data." + npc + ".text"), file.getString("data." + npc + ".signature")));
            NPC.loadNPC(loc, gameProfile);
        });
    }

}
