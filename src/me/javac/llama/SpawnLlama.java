package me.javac.llama;

import org.bukkit.*;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Llama;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class SpawnLlama {
    // TODO: локация почему-то рандомная не берется

    private static Random random;

    private static World world = Bukkit.getWorld("world");
    private static Location location = new Location(world, Math.round(Math.random() * 1000), Math.round(Math.random() * 80), Math.round(Math.random() * 1000));

    private static Location checkBlockUnderLlama() {
        if (location.getBlock().getType() == Material.WATER || location.getBlock().getType() == Material.LAVA) {
            return new Location(Bukkit.getWorld("world"), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000), Math.round(Math.random() * 1000));
        }
        else return location;

        // TODO: написать проверку на то, чтобы лама не спавнилась в блоках, в воде, в лаве
    }

    private static int playersNear;

    private static final String message = ChatColor.translateAlternateColorCodes('&', "&6&lЗолотая лама появилась на " + String.valueOf(location.getX()) + " "  + "" +
            " " + String.valueOf(location.getY()) + " " + String.valueOf(location.getZ()));

    public static boolean spawnLlama() {
        Location currLoc = checkBlockUnderLlama();
        Llama llama = (Llama) world.spawnEntity(currLoc, EntityType.LLAMA);
        llama.setCustomName("Llammie");
        // TODO: сделать ламу неубиваемой - КАК???
        llama.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000000.0D);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "bc " + message);
        return true;
    }
}
