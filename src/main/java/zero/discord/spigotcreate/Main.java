package zero.discord.spigotcreate;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import zero.discord.spigotcreate.utils.CustomConfigManager;

import java.util.List;

public final class Main extends JavaPlugin {
    public static List<CustomConfigManager> CustomConfigs;

    public static Main Instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getScheduler().cancelTasks(this);

        for(CustomConfigManager ccm : CustomConfigs) {
            ccm.saveConfig();
        }
    }
}
