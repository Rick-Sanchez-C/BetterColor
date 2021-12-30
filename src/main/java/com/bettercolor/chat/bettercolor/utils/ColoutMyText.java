package com.bettercolor.chat.bettercolor.utils;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import net.md_5.bungee.api.ChatColor;
import org.mineacademy.chatcontrol.lib.remain.CompChatColor;

import java.awt.*;

import java.util.UUID;

public class ColoutMyText  {
    public static String ColourMyText (String txt, String hex1, String hex2, String deco){

        int l = txt.length();
        String output = "";
        Color C1 = Color.decode(hex1);
        Color C2 = Color.decode(hex2);
        Color CX;
        CompChatColor decoration;
        if(l<100) {
            for (int i = 0; i < l; i++) {
                int r = (C1.getRed() + (((C2.getRed() - C1.getRed()) / l) * i));
                int g = (C1.getGreen() + (((C2.getGreen() - C1.getGreen()) / l) * i));
                int b = (C1.getBlue() + (((C2.getBlue() - C1.getBlue()) / l) * i));
                CX = new Color(r, g, b);
                if (deco != null) {
                    decoration = CompChatColor.of(deco);
                    output = output + ChatColor.of(CX) + decoration + txt.charAt(i);
                } else {
                    output = output + ChatColor.of(CX) + txt.charAt(i);
                }

            }
        }else{
            String[] divido;
            int d = l/100;

            Iterable<String> result = Splitter.fixedLength(d).split(txt);
            divido = Iterables.toArray(result, String.class);
            l = divido.length;
            for (int i = 0; i < l; i++) {
                int r = (C1.getRed() + (((C2.getRed() - C1.getRed()) / l) * i));
                int g = (C1.getGreen() + (((C2.getGreen() - C1.getGreen()) / l) * i));
                int b = (C1.getBlue() + (((C2.getBlue() - C1.getBlue()) / l) * i));
                CX = new Color(r, g, b);
                if (deco != null) {
                    decoration = CompChatColor.of(deco);
                    output = output + ChatColor.of(CX) + decoration + divido[i];
                } else {
                    output = output + ChatColor.of(CX) + divido[i];
                }

            }
        }
        return output;
    }
}
