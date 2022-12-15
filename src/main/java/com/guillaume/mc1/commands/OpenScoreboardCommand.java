package com.guillaume.mc1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class OpenScoreboardCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

      if (sender instanceof Player p){

          ScoreboardManager manager = Bukkit.getScoreboardManager();
          Scoreboard scoreboard = manager.getNewScoreboard();

          Objective objective = scoreboard.registerNewObjective("test", Criteria.DUMMY, ChatColor.BLUE + "Scoreboard Title", RenderType.INTEGER);
          objective.setDisplaySlot(DisplaySlot.SIDEBAR);

          Score score = objective.getScore(ChatColor.GOLD + "Money: $" + ChatColor.GREEN + 1);
          score.setScore(3);

          p.setScoreboard(scoreboard);
      }

        return true;
    }
}
