package io.github.itzispyder.plugintemplate.events;

import io.github.itzispyder.pdk.events.CustomListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class ExampleListener implements CustomListener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        info(player, "&eThis server uses PDK!");
    }
}
