package de.Venrux.spigot.VNPC.listener;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if (NPC.getNPC() == null)
            return;
        if(NPC.getNPC().isEmpty())
            return;
        NPC.addJoinPacket(e.getPlayer());

        PacketReader reader = new PacketReader();
        reader.inject(e.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        PacketReader reader = new PacketReader();
        reader.uninject(e.getPlayer());
    }

}
