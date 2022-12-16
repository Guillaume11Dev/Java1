package com.guillaume.mc1;

import com.guillaume.mc1.Task.TimerTask;
import com.guillaume.mc1.commands.CommandEC;
import com.guillaume.mc1.commands.CommandSpawn;
import com.guillaume.mc1.commands.CommandTest;
import com.guillaume.mc1.commands.OpenScoreboardCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public final class Mc1 extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Le plugin viens de s'allumer ! ");
        getCommand("test").setExecutor(new CommandTest());
        getCommand("alert").setExecutor(new CommandTest());
        getCommand("spawn").setExecutor(new CommandSpawn());
        getCommand("ec").setExecutor(new CommandEC());
        getCommand("sb").setExecutor(new OpenScoreboardCommand());
        getServer().getPluginManager().registerEvents(new MonPluginListeners(),this);

        TimerTask task = new TimerTask();
        task.runTaskTimer(this, 0, 20);
    }



    @Override
    public void onDisable() {
        System.out.println("Le plugin viens de s'éteindre");

    }
}


