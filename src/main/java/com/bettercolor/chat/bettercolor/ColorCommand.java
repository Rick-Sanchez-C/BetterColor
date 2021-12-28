package com.bettercolor.chat.bettercolor;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import com.bettercolor.chat.bettercolor.utils.ColoutMyText;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.mineacademy.chatcontrol.api.ChatControlAPI;
import org.mineacademy.chatcontrol.lib.remain.CompChatColor;
import org.mineacademy.chatcontrol.settings.Lang;
import com.bettercolor.chat.bettercolor.utils.GeneralUtils;

import java.awt.*;
import java.lang.reflect.Array;

public class ColorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //max input 256
        Player player = (Player) sender;
        if (player.hasPermission("chatcontrol.command.color")) {
            if (args.length == 2) {
                if (GeneralUtils.isValidHexColour(args[0]) && GeneralUtils.isValidHexColour(args[1])) {
                    ChatControlAPI.getPlayerCache(player).setChatColor((CompChatColor) null);
                    ChatControlAPI.getPlayerCache(player).setChatDecoration((CompChatColor) null);

                    PersistentDataContainer data = player.getPersistentDataContainer();
                    data.set(new NamespacedKey(NamespacedKey.MINECRAFT, "gradient1"), PersistentDataType.STRING, args[0]);
                    data.set(new NamespacedKey(NamespacedKey.MINECRAFT, "gradient2"), PersistentDataType.STRING, args[1]);
                    String G1 = data.get(new NamespacedKey(NamespacedKey.MINECRAFT, "gradient1"), PersistentDataType.STRING);
                    String G2 = data.get(new NamespacedKey(NamespacedKey.MINECRAFT, "gradient2"), PersistentDataType.STRING);
                    player.sendMessage(ChatColor.of(Color.decode(G1)) + "Tu degradado empieza con el color" + G1);
                    player.sendMessage(ChatColor.of(Color.decode(G2)) + "Y termina con el color" + G2);
                } else {
                    player.sendMessage("§4§l Utiliza dos colores hexadecimales  §6§l/gradient #000000 #FFFFFF");
                    return true;
                }

            } else {
                player.sendMessage("§4§l Utiliza dos colores hexadecimales §6§l/gradient #000000 #FFFFFF");
            }

            return true;
        }
        return true;
    }
}
