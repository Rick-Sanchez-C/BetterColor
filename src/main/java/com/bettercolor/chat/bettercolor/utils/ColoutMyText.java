package com.bettercolor.chat.bettercolor.utils;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;

import java.util.UUID;

public class ColoutMyText  {
    public static String ColourMyText (String txt, String hex1, String hex2){
        int l = txt.length();
        String output = "";
        Color C1 = Color.decode(hex1);
        Color C2 = Color.decode(hex2);
        Color CX;
        for (int i = 0; i < l; i++) {
            int r = (C1.getRed() + (((C2.getRed() - C1.getRed()) / l) * i));
            int g = (C1.getGreen() + (((C2.getGreen() - C1.getGreen()) / l) * i));
            int b = (C1.getBlue() + (((C2.getBlue() - C1.getBlue()) / l) * i));
            CX = new Color(r, g, b);
            output = output + ChatColor.of(CX) + txt.charAt(i);
        }
        return output;
    }
}
