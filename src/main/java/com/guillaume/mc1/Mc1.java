package com.guillaume.mc1;

import com.guillaume.mc1.commands.CommandSpawn;
import com.guillaume.mc1.commands.CommandTest;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mc1 extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Le plugin viens de s'allumer ! ");
        getCommand("test").setExecutor(new CommandTest());
        getCommand("alert").setExecutor(new CommandTest());
        getCommand("spawn").setExecutor(new CommandSpawn());
        getServer().getPluginManager().registerEvents(new MonPluginListeners(),this);
    }

    @Override
    public void onDisable() {
        System.out.println("Le plugin viens de s'éteindre");


    }
}
