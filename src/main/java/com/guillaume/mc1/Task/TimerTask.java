package com.guillaume.mc1.Task;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerTask extends BukkitRunnable {

    private  int timer = 10;


    @Override
    public void run() {

        Bukkit.broadcastMessage("Lancement du jeu" + timer + "s");

        if (timer ==0){
            Bukkit.broadcastMessage("Lancement du jeu");
            cancel();

        }
        timer--;
    }
}
