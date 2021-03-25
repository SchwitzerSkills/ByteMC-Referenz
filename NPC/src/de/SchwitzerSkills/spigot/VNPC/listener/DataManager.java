package de.Venrux.spigot.VNPC.listener;

import de.Venrux.spigot.VNPC.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class DataManager {

    private Main plugin;
    private FileConfiguration dataconfig = null;
    private File configFile = null;

    public DataManager(Main plugin) {
        this.plugin = plugin;
    }

    public void reloadConfig(){
        if (this.configFile == null) {
            this.configFile = new File(this.plugin.getDataFolder(), "data.yml");

            this.dataconfig = YamlConfiguration.loadConfiguration(this.configFile);

            InputStream defaultStream = this.plugin.getResource("data.yml");
            if (defaultStream != null) {
                YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
                this.dataconfig.setDefaults(defaultConfig);
            }
        }
    }

    public FileConfiguration getConfig(){
        if (this.dataconfig == null)
            reloadConfig();

            return this.dataconfig;
        }

        public void saveConfig() {
            if (this.dataconfig == null || this.configFile == null)
                return;

            try {
                this.getConfig().save(this.configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void saveDefaultConfig(){
            if (this.configFile == null) {
                this.configFile = new File(this.plugin.getDataFolder(), "data.yml");

                if(!this.configFile.exists()){
                    this.plugin.saveResource("data.yml", false);
                }
            }
        }

}
