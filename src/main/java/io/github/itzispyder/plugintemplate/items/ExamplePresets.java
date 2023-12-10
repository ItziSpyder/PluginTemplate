package io.github.itzispyder.plugintemplate.items;

import io.github.itzispyder.pdk.plugin.builders.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class ExamplePresets {

    public static final ItemStack EXAMPLE = ItemBuilder.create()
            .material(Material.DIAMOND)
            .count(1)
            .name("&ePDK!")
            .lore("&7- Download at GitHub")
            .lore("&7- https://github.com/itzispyder/pdk")
            .enchant(Enchantment.MENDING, 1)
            .flag(ItemFlag.HIDE_ENCHANTS)
            .unbreakable(true)
            .build();

}
