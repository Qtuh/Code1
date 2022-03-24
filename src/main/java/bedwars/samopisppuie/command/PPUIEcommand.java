package bedwars.samopisppuie.command;

import bedwars.samopisppuie.SamopisPPUIE;
import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class PPUIEcommand extends AbstractCommand {
    public PPUIEcommand() {
        super("ppuie");
    }
    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        if(args.length==0) {
            sender.sendMessage("/" + label + " reload - Перезагрузить плагин.");
            return;
        }
        if(args[0].equalsIgnoreCase("reload")) {
            if(!sender.hasPermission("ppuie.reload")) {
                sender.sendMessage(ChatColor.RED + "У вас нет прав.");
                return;
            }

            SamopisPPUIE.getInstance().reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Плагин PPUIE перезагружен.");
            return;
        }
        sender.sendMessage(ChatColor.GRAY + "Неизвестная команда: /" + label + " " + args[0]);
    }

    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        if(args.length==1) return Lists.newArrayList("reload");
        return Lists.newArrayList();
    }
}
