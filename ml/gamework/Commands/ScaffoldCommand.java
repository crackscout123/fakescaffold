package ml.gamework.Commands;

import ml.gamework.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScaffoldCommand implements CommandExecutor{


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            if(commandSender.hasPermission("fakescaffold.use")){
                if(strings.length == 0){
                    if(Utils.Scaffold.containsKey(commandSender)){
                        Utils.Scaffold.remove(commandSender);
                        commandSender.sendMessage("§c>> §bScaffoldWalk deactivated!");
                    }else{
                        Utils.Scaffold.put((Player)commandSender, true);
                        commandSender.sendMessage("§c>> §bScaffoldWalk activated!");
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
