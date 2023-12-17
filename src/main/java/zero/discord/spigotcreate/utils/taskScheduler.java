package zero.discord.spigotcreate.utils;

import org.bukkit.Bukkit;
import zero.discord.spigotcreate.Main;

public class taskScheduler {
    public static void runAllTasks(){
        configSavingTask();
    }

    // Periodically save all config files
    private static void configSavingTask (){
        Bukkit.getScheduler().runTaskTimer(Main.Instance, () -> {
            for(CustomConfigManager ccm : Main.CustomConfigs) {
                ccm.saveConfig();
            }
        }, 0, 20L * 60);
    }
}
