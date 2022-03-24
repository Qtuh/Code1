package ru.s0two.getexp.S0two;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Event implements Listener {

    @EventHandler
    public void onPickUpItem(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();
        Material type = Material.valueOf(e.getItem().getItemStack().getType().name());
        int amount = e.getItem().getItemStack().getAmount();

        if (!(type.equals(Material.CLAY_BRICK) || type.equals(Material.IRON_INGOT) || type.equals(Material.GOLD_INGOT)))
            return;

        if (type.equals(Material.CLAY_BRICK)) {
            player.setLevel(player.getLevel() + 2 * amount);
            player.sendMessage(ChatColor.YELLOW + "+" + 2 * amount + " ресурсов");
        } if (type.equals(Material.IRON_INGOT)) {
            player.setLevel(player.getLevel() + 25 * amount);
            player.sendMessage(ChatColor.YELLOW + "+" + 25 * amount + " ресурсов");
        } if (type.equals(Material.GOLD_INGOT)) {
            player.setLevel(player.getLevel() + 50 * amount);
            player.sendMessage(ChatColor.YELLOW + "+" + 50 * amount + " ресурсов");
        }

        e.getItem().remove();
        e.setCancelled(true);
    }
}
