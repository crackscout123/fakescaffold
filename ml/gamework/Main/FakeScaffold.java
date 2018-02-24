package ml.gamework.Main;

import ml.gamework.Commands.ScaffoldCommand;
import ml.gamework.Events.ScaffoldListener;
import ml.gamework.Update;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FakeScaffold extends JavaPlugin {

    @Override
    public void onEnable() {
        new Update().checkUpdate(52982, "FakeScaffold", "enUS");
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ScaffoldListener(), this);
        getCommand("scaffold").setExecutor(new ScaffoldCommand());
    }
}
