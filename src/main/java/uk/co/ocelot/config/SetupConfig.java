package uk.co.ocelot.config;

import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.List;

public class SetupConfig {

    private List<String> missingPlugins = new ArrayList<>();

    public List<String> getRequiredPlugins(PluginManager pluginManager) {
        if (!pluginManager.isPluginEnabled("HolographicDisplays")) {
            missingPlugins.add("HolographicDisplays");
        }
        if (!pluginManager.isPluginEnabled("Vault")) {
            missingPlugins.add("Vault");
        }
        if (!pluginManager.isPluginEnabled("ProtocolLib")) {
            missingPlugins.add("ProtocolLib");
        }
        return missingPlugins;
    }

}
