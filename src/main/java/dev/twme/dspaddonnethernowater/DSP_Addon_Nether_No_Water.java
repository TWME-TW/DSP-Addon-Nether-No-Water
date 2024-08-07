package dev.twme.dspaddonnethernowater;

import dev.twme.dspaddonnethernowater.listener.ClassicModeBlockBlockDataChangingListener;
import dev.twme.dspaddonnethernowater.listener.CopyModeChangingBlockListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DSP_Addon_Nether_No_Water extends JavaPlugin {

    private static DSP_Addon_Nether_No_Water instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getServer().getPluginManager().registerEvents(new ClassicModeBlockBlockDataChangingListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CopyModeChangingBlockListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static DSP_Addon_Nether_No_Water getInstance() {
        return instance;
    }
}
