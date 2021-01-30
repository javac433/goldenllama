package me.javac.llama;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.javac.llama.SpawnLlama;

public class SpawnLlamaHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("goldenllama.spawn")) {
            SpawnLlama.spawnLlama();
            return true;
        }

        return false;
    }
}
