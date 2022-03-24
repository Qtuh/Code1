package bedwars.samopisppuie;

import bedwars.samopisppuie.command.PPUIEcommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EventListener;

public final class SamopisPPUIE extends JavaPlugin {

    private static SamopisPPUIE instance;

    @Override
    public void onEnable() {
        instance=this;
        new PPUIEcommand();
        Bukkit.getPluginManager().registerEvents(new PickUpEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SamopisPPUIE getInstance() {
        return instance;
    }

}
