package io.github.itzispyder.plugintemplate.commands;

import io.github.itzispyder.pdk.commands.Args;
import io.github.itzispyder.pdk.commands.CommandRegistry;
import io.github.itzispyder.pdk.commands.CustomCommand;
import io.github.itzispyder.pdk.commands.Permission;
import io.github.itzispyder.pdk.commands.completions.CompletionBuilder;
import io.github.itzispyder.pdk.plugin.items.CustomItem;
import io.github.itzispyder.plugintemplate.gui.ExampleGUI;
import io.github.itzispyder.plugintemplate.items.custom.FireballItem;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandRegistry(value = "example", usage = "/example", permission = @Permission("commands.example"))
public class ExampleCommand implements CustomCommand {

    @Override
    public void dispatchCommand(CommandSender sender, Args args) {
        switch (args.get(0).toString()) {
            case "gui" -> {
                ExampleGUI.openFor((Player) sender);
            }
            case "hi" -> {
                info(sender, "&aHello!");
            }
            case "fireball" -> {
                ((Player) sender).getInventory().addItem(CustomItem.get(FireballItem.class).getItem());
            }
        }
    }

    @Override
    public void dispatchCompletions(CompletionBuilder b) {
        b.then(b.arg("gui", "hi", "fireball") // this is a tree data structure
                .then(b.arg("this-does-nothing")
                        .then(b.arg("this-also-does-nothing")))
                .then(b.arg("this-does-another-nothing")));
    }
}
