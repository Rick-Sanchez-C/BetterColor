package com.bettercolor.chat.bettercolor;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.bettercolor.chat.bettercolor.listener.listenchat;

import javax.xml.stream.events.Namespace;

public final class Bettercolor extends JavaPlugin {



    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("gradient").setExecutor(new ColorCommand());
        PluginManager manager = this.getServer().getPluginManager();
        manager.registerEvents(new listenchat(), this);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
