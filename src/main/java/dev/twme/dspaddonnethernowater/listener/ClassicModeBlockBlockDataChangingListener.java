package dev.twme.dspaddonnethernowater.listener;

import dev.twme.debugstickpro.events.ClassicModeBlockBlockDataChangingEvent;
import dev.twme.dspaddonnethernowater.DSP_Addon_Nether_No_Water;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ClassicModeBlockBlockDataChangingListener implements Listener {
    private static final DSP_Addon_Nether_No_Water plugin = DSP_Addon_Nether_No_Water.getInstance();

    @EventHandler
    public void onClassicModeBlockBlockDataChangingEvent(ClassicModeBlockBlockDataChangingEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        BlockData oldData = event.getOldBlockData();
        BlockData newData = event.getNewBlockData();

        if (world.getEnvironment() != World.Environment.NETHER) {
            return;
        }

        if (!(oldData instanceof Waterlogged)) {
            return;
        }

        if (player.hasPermission("dspaddonnethernowater.pass" + world.getName())) {
            return;
        }

        if (player.hasPermission("dspaddonnethernowater.pass.*")) {
            return;
        }

        if (((Waterlogged) newData).isWaterlogged()) {
            event.setCancelled(true);
        }
    }
}
