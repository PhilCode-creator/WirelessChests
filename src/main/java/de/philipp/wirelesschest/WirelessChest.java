package de.philipp.wirelesschest;

import de.philipp.wirelesschest.command.Command_LinkChest;
import org.bukkit.plugin.java.JavaPlugin;

public class WirelessChest extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("linkchest").setExecutor(new Command_LinkChest());
        System.out.println("------------------");
        System.out.println("ChatFilter von CuzImPhilipp");
        System.out.println("Aktiviert");
        System.out.println("------------------");
    }

    @Override
    public void onDisable() {
        System.out.println("------------------");
        System.out.println("ChatFilter von CuzImPhilipp");
        System.out.println("Deaktiviert");
        System.out.println("------------------");    }
}
