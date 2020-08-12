package uk.co.ocelot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.ocelot.config.SetupConfig;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SuperRaidsBase extends JavaPlugin {

    private static final String PLUGIN_NAME = "SuperRaidsBase";
    private static final String LOG_PREFIX = PLUGIN_NAME + " | Logging | ";
    private final Logger LOGGER = Bukkit.getLogger();
    private final SetupConfig setupConfig = new SetupConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return super.onCommand(sender, command, label, args);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        LOGGER.log(Level.INFO, (LOG_PREFIX + "Loaded"));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        LOGGER.log(Level.INFO, (LOG_PREFIX + "Disabled"));
    }

    @Override
    public void onEnable() {
        super.onEnable();
        if (!setupConfig.getRequiredPlugins(Bukkit.getPluginManager()).isEmpty()){
            getLogger().severe(PLUGIN_NAME + "HolographicDisplays is not installed or not enabled.");
            getLogger().severe(PLUGIN_NAME + "This plugin will be disabled");
            this.setEnabled(false);
        }else{
            LOGGER.log(Level.INFO, (LOG_PREFIX + "Enabled"));
        }
    }
}
