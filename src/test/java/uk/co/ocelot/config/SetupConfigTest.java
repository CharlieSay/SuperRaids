package uk.co.ocelot.config;

import org.bukkit.plugin.PluginManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SetupConfigTest {

    private SetupConfig setupConfig;
    private PluginManager pluginManager;

    @Before
    public void setUp(){
        setupConfig = new SetupConfig();
        pluginManager = mock(PluginManager.class);
    }

    @Test
    public void shouldReturnThreeStrings_whenThreePluginsMissingFromRequired(){
        final String HOLOGRAPHIC_DISPLAYS = "HolographicDisplays";
        final String VAULT = "Vault";
        final String PROTOCOL_LIB = "ProtocolLib";

        when(pluginManager.isPluginEnabled(HOLOGRAPHIC_DISPLAYS)).thenReturn(false);
        when(pluginManager.isPluginEnabled(VAULT)).thenReturn(false);
        when(pluginManager.isPluginEnabled(PROTOCOL_LIB)).thenReturn(false);

        List<String> missingPlugins = setupConfig.getRequiredPlugins(pluginManager);

        assertThat(missingPlugins).hasSize(3);
        assertThat(missingPlugins).containsAll(Arrays.asList(HOLOGRAPHIC_DISPLAYS,VAULT,PROTOCOL_LIB));
    }

    @Test
    public void shouldReturnEmptyArray_whenThreePluginsAreEnabled(){
        final String HOLOGRAPHIC_DISPLAYS = "HolographicDisplays";
        final String VAULT = "Vault";
        final String PROTOCOL_LIB = "ProtocolLib";

        when(pluginManager.isPluginEnabled(HOLOGRAPHIC_DISPLAYS)).thenReturn(true);
        when(pluginManager.isPluginEnabled(VAULT)).thenReturn(true);
        when(pluginManager.isPluginEnabled(PROTOCOL_LIB)).thenReturn(true);

        List<String> missingPlugins = setupConfig.getRequiredPlugins(pluginManager);

        assertThat(missingPlugins).isEmpty();
        assertThat(missingPlugins).doesNotContainAnyElementsOf(Arrays.asList(HOLOGRAPHIC_DISPLAYS,VAULT,PROTOCOL_LIB));
    }

}