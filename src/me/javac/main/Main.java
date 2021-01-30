package me.javac.main;

import me.javac.llama.SpawnLlamaHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("[GoldenLlama] Created instance!");
        getCommand("spawnllama").setExecutor(new SpawnLlamaHandler());
    }

    @Override
    public void onDisable() {
        getLogger().info("[GoldenLlama] Removed instance!");
    }
}
