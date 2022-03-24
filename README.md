# Code1
package bwp.getexp;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;


public class PickUpEvent implements Listener {
    @EventHandler
    public void OnPickUpItem(PlayerPickupItemEvent e) {
        Material type = e.getItem().getItemStack().getType();
        int amount = e.getItem().getItemStack().getAmount();
        switch (type) {
            case CLAY_BRICK: {
                e.getPlayer().setLevel(e.getPlayer().getLevel() + 2 * amount);
                //e.getPlayer().spigot().sendMessage(ChatMessageType.CHAT, TextComponent.fromLegacyText(ChatColor.GOLD + "+" + 2 * amount + " ресурсов"));
                break;
            }
            case IRON_INGOT: {
                e.getPlayer().setLevel(e.getPlayer().getLevel() + 25 * amount);
                break;
            }
            case GOLD_INGOT: {
                e.getPlayer().setLevel(e.getPlayer().getLevel() + 50 * amount);
                break;
            }
            default: {
                return;
            }
        }
        e.getPlayer().getInventory().remove(Material.CLAY_BRICK);
        //e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        e.setCancelled(true);
    }
}
