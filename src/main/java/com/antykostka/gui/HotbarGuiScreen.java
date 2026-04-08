package com.antykostka.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.StringTextComponent;

public class HotbarGuiScreen extends Screen {
    public HotbarGuiScreen() {
        super(new StringTextComponent("Hotbar Display"));
    }

    @Override
    protected void init() {
        // Initialize GUI components, if necessary
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        // Clear the screen
        RenderSystem.clearColor(0, 0, 0, 0);
        RenderSystem.clear(16384);

        // Draw hotbar display
        drawString(this.font, "Hotbar Display", width / 2 - 50, height / 2 - 10);
        super.render(mouseX, mouseY, partialTicks);
    }
}