package com.bettercolor.chat.bettercolor.listener;
import com.bettercolor.chat.bettercolor.utils.ColoutMyText;
import com.bettercolor.chat.bettercolor.utils.GeneralUtils;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.mineacademy.chatcontrol.api.ChatControlAPI;

import java.util.UUID;
public class listenchat implements Listener {
    @EventHandler
    public void onEvent(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        if (player.hasPermission("chatcontrol.command.color")) {
            PersistentDataContainer data = player.getPersistentDataContainer();
            String G1 = data.get(new NamespacedKey(NamespacedKey.MINECRAFT, "gradient1"), PersistentDataType.STRING);
            String G2 = data.get(new NamespacedKey(NamespacedKey.MINECRAFT, "gradient2"), PersistentDataType.STRING);
            String message = e.getMessage();
            UUID uuid = player.getUniqueId();
            /** Check default colour.
             if ((boolean) configUtils.getSetting("default-color-enabled")) {
             generalUtils.checkDefault(uuid);
             }**/

            // If their message contains &, check they have permissions for it, or strip the colour.
            if (!player.hasPermission("chatcolor.use-color-codes")) {
                // A player reported using '&&a' for example, would bypass this. So, loop until it's not different.
                while (GeneralUtils.isDifferentWhenColourised(message)) {
                    // Strip the colour from the message.
                    message = org.bukkit.ChatColor.stripColor(GeneralUtils.colourise(message));
                }
            }
            if (!ChatControlAPI.getPlayerCache(player).hasChatColor() && !ChatControlAPI.getPlayerCache(player).hasChatDecoration()) {
                e.setMessage(ColoutMyText.ColourMyText(message, G1, G2));
            }
        }

    }
}
