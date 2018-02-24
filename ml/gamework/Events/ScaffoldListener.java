package ml.gamework.Events;

import ml.gamework.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ScaffoldListener implements Listener {

    @EventHandler
    public void onScaffoldWalk(PlayerMoveEvent e){
        Player player = e.getPlayer();
        Location loc = e.getPlayer().getLocation().clone().subtract(0, 1, 0);
        Block b = loc.getBlock();
        if(!Utils.Scaffold.containsKey(player)){
            return;
        }else{
           if(b.getType() == Material.AIR){
               b.setType(Material.SANDSTONE);
           }
        }
    }

}
