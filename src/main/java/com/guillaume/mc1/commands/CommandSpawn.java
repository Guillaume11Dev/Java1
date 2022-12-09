package com.guillaume.mc1.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){

            Random random = new Random();
            Player player =(Player) sender;
            Location ploc = player.getLocation();

            Location spawn = new Location(player.getWorld(), ploc.getX(), ploc.getY() + random.nextInt(50), ploc.getZ() + random.nextInt(50), 1.8f , 7.4f);
            player.sendMessage("§eVous venez d'être tp au spawn");
            player.teleport(spawn);
        }

        return false;
    }
}

