package com.eerussianguy.beneath.client.screen;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class BeneathScreen extends Screen
{
    public BeneathScreen(Component title)
    {
        super(title);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers)
    {
        if (super.keyPressed(keyCode, scanCode, modifiers))
            return true;
        assert minecraft != null;
        if (minecraft.options.keyInventory.isActiveAndMatches(InputConstants.getKey(keyCode, scanCode)))
        {
            minecraft.setScreen(null);
            return true;
        }
        return false;
    }

    protected void drawCenteredLine(GuiGraphics graphics, MutableComponent text, int x, int y)
    {
        final int dx = (256 - this.font.width(text)) / 2;
        graphics.drawString(this.font, text, x + dx, y, 4210752, false);
    }

}
