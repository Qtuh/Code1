package ru.s0two.getexp.S0two;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class getexp extends JavaPlugin {
    public static getexp plugin;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Event(), this);
        plugin = this;
    }
}
