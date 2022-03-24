package bedwars.samopisppuie;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickUpEvent implements Listener {
    @EventHandler
    public void onPickUpItem(PlayerPickupItemEvent e) {
        Material type = e.getItem().getItemStack().getType();
        int amount = e.getItem().getItemStack().getAmount();
        switch (type) {
            case BRICK: {
                e.getPlayer().setLevel(e.getPlayer().getLevel() + 2 * amount);
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.YELLOW + "+" + 2 * amount + " ресурсов"));
                break;
            }
            case IRON_INGOT: {
                e.getPlayer().setLevel(e.getPlayer().getLevel() + 25 * amount);
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.YELLOW + "+" + 25 * amount + " ресурсов"));
                break;
            }
            case GOLD_INGOT: {
                e.getPlayer().setLevel(e.getPlayer().getLevel() + 50 * amount);
                e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.YELLOW + "+" + 50 * amount + " ресурсов"));
                break;
            }
            default: {
                return;
            }
        }
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        e.setCancelled(true);
        e.getItem().remove();
    }
}
