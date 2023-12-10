package io.github.itzispyder.plugintemplate;

import io.github.itzispyder.pdk.PDK;
import io.github.itzispyder.plugintemplate.commands.ExampleCommand;
import io.github.itzispyder.plugintemplate.events.ExampleListener;
import io.github.itzispyder.plugintemplate.items.custom.FireballItem;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginTemplate extends JavaPlugin {

    @Override
    public void onEnable() { // when plugin starts up
        PDK.init(this);
        init();
    }

    @Override
    public void onDisable() { // when plugin shuts down

    }

    public void init() {
        initConfig();
        initCommands();
        initItems();
        initListeners();
    }

    public void initCommands() { // don't forget to add commands to src/main/resources/plugin.yml!
        new ExampleCommand().register(PluginTemplate.class);
    }

    public void initItems() {
        new FireballItem().register();
    }

    public void initListeners() {
        new ExampleListener().register(PluginTemplate.class);
    }

    public void initConfig() {
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
    }
}
