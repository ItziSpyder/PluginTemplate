package io.github.itzispyder.plugintemplate.gui;

import io.github.itzispyder.pdk.plugin.gui.CustomGui;
import io.github.itzispyder.pdk.utils.ServerUtils;
import io.github.itzispyder.plugintemplate.PluginTemplate;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ExampleGUI {

    public static final CustomGui GUI = CustomGui.create()
            .title("&6Super Epik Title")
            .size(27)
            .onClose(e -> e.getPlayer().sendMessage("e"))
            .defineMain(e -> {
                e.setCancelled(true);
            })
            .define(11, new ItemStack(Material.BARRIER), e -> {
                ServerUtils.dispatchf(PluginTemplate.class,"kill %s", e.getWhoClicked().getUniqueId());
            })
            .define(13, new ItemStack(Material.GREEN_WOOL), e -> {
                e.getWhoClicked().sendMessage("EeeeeEEE");
                e.getWhoClicked().closeInventory();
            })
            .define(15, new ItemStack(Material.DIAMOND), e -> {
                e.getWhoClicked().getInventory().addItem(e.getCurrentItem().clone());
                e.getWhoClicked().closeInventory();
            })
            .build();

    public static void openFor(Player player) {
        player.openInventory(GUI.getInventory());
    }
}
