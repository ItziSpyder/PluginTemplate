package io.github.itzispyder.plugintemplate.items.custom;

import io.github.itzispyder.pdk.plugin.builders.ItemBuilder;
import io.github.itzispyder.pdk.plugin.items.CustomItem;
import io.github.itzispyder.pdk.utils.raytracers.BlockDisplayRaytracer;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class FireballItem extends CustomItem {

    public FireballItem() {
        super("fireball");
    }

    @Override
    public void buildItem(ItemBuilder b) {
        b.material(Material.FIRE_CHARGE);
        b.name("&6Fireball");
        b.lore("&7- Right click to shoot");
    }

    @Override
    public void onInteract(Player player, Action action, ItemStack item, PlayerInteractEvent e) {
        e.setCancelled(true);
        item.setAmount(item.getAmount() - 1);

        BlockDisplayRaytracer.trace(Material.ORANGE_CONCRETE, player.getEyeLocation(), player.getLocation().getDirection(), 0.05, 128, 20);
        player.getWorld().spawn(player.getEyeLocation(), Fireball.class, fireball -> {
            fireball.setVelocity(player.getLocation().getDirection().normalize().multiply(0.1));
            fireball.setShooter(player);
        });
    }
}
