package com.guillaume.mc1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {




        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("test")){
                sender.sendMessage(ChatColor.RED+"Bravo tu as réussi   §ele test ");
                return  true;

            }
            if (cmd.getName().equalsIgnoreCase("alert")){

                //alerte --> aucun argument
                if (args.length == 0){
                    player.sendMessage("la commande est : /alerte <message>");
                }
                //alerte <texte texte texte>
                if (args.length >= 1){
                    StringBuilder bc = new StringBuilder();
                    for (String part : args){
                        bc.append(part + " ");
                    }
                Bukkit.broadcastMessage("[" + player.getName() + "]" + bc.toString());

                }

                return  true;

            }
        }

        return false;
    }
}
