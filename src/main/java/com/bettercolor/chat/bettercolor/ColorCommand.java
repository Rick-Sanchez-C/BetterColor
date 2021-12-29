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
import org.mineacademy.chatcontrol.ChatControl;
import org.mineacademy.chatcontrol.api.ChatControlAPI;
import org.mineacademy.chatcontrol.lib.Common;
import org.mineacademy.chatcontrol.lib.remain.CompChatColor;
import org.mineacademy.chatcontrol.model.Colors;
import org.mineacademy.chatcontrol.settings.Lang;
import com.bettercolor.chat.bettercolor.utils.GeneralUtils;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ColorCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //max input 256
        Player player = (Player) sender;
        String decorationName = args.length == 3 ? args[2] : "";
        CompChatColor decoration;
        if (player.hasPermission("chatcontrol.command.color")) {
            if (args.length >= 2 && args.length < 4) {
                if (GeneralUtils.isValidHexColour(args[0]) && GeneralUtils.isValidHexColour(args[1])) {
                    if (args.length ==3){
                        try {
                            decoration = CompChatColor.of(decorationName);
                            PersistentDataContainer data = player.getPersistentDataContainer();
                            data.set(new NamespacedKey(NamespacedKey.MINECRAFT, "decoration"), PersistentDataType.STRING,decorationName);

                            String G3 = data.get(new NamespacedKey(NamespacedKey.MINECRAFT, "decoration"), PersistentDataType.STRING);
                            player.sendMessage(decoration + "Y la decoracion " + G3);
                        } catch (IllegalArgumentException var10) {
                            player.sendMessage("§4§l Utiliza dos colores hexadecimales  §6§l/gradient #000000 #FFFFFF");
                            player.sendMessage("§4§l O utiliza dos colores y una decoración  §6§l/gradient #000000 #FFFFFF BOLD");
                            return true;
                        }
                    }else{
                        PersistentDataContainer data = player.getPersistentDataContainer();
                        data.set(new NamespacedKey(NamespacedKey.MINECRAFT, "decoration"), PersistentDataType.STRING, "");
                    }
                    ChatControlAPI.getPlayerCache(player).setChatColor((CompChatColor) null);

                    ChatControlAPI.getPlayerCache(player).setChatDecoration((CompChatColor) null);
                    ChatControlAPI.getPlayerCache(player).save();

                    PersistentDataContainer data = player.getPersistentDataContainer();
                    data.set(new NamespacedKey(NamespacedKey.MINECRAFT, "gradient1"), PersistentDataType.STRING, args[0]);
                    data.set(new NamespacedKey(NamespacedKey.MINECRAFT, "gradient2"), PersistentDataType.STRING, args[1]);

                    String G1 = data.get(new NamespacedKey(NamespacedKey.MINECRAFT, "gradient1"), PersistentDataType.STRING);
                    String G2 = data.get(new NamespacedKey(NamespacedKey.MINECRAFT, "gradient2"), PersistentDataType.STRING);

                    player.sendMessage(ChatColor.of(Color.decode(G1)) + "Tu degradado empieza con el color " + G1);
                    player.sendMessage(ChatColor.of(Color.decode(G2)) + "Y termina con el color " + G2);

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
