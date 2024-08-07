package dev.twme.dspaddonnethernowater.listener;

import dev.twme.debugstickpro.blockdatautil.SubBlockData;
import dev.twme.debugstickpro.events.CopyModeChangingBlockEvent;
import dev.twme.dspaddonnethernowater.DSP_Addon_Nether_No_Water;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

public class CopyModeChangingBlockListener implements Listener {
    private static final DSP_Addon_Nether_No_Water plugin = DSP_Addon_Nether_No_Water.getInstance();

    @EventHandler
    public void onCopyModeChangingBlock(CopyModeChangingBlockEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        List<SubBlockData> subBlockData = event.getNewBlockData();

        if (world.getEnvironment() != World.Environment.NETHER) {
            return;
        }

        if (player.hasPermission("dspaddonnethernowater.pass" + world.getName())) {
            return;
        }

        if (player.hasPermission("dspaddonnethernowater.pass.*")) {
            return;
        }

        for (SubBlockData data : subBlockData) {
            if (data.name().equals("WaterloggedData")) {
                subBlockData.remove(data);
                break;
            }
        }

        event.setNewBlockData(subBlockData);
    }
}
