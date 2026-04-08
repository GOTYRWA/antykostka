package com.antykostka;

import net.minecraft.client.Minecraft;
import net.minecraft.client.keybinding.KeyBinding;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Antykostka.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AntykostkaClient {
    public static final String MOD_ID = "antykostka";

    private static final KeyBinding keybindJ = new KeyBinding("key.antykostka.j", GLFW.GLFW_KEY_J, "key.categories.antykostka");
    private static final KeyBinding keybindN = new KeyBinding("key.antykostka.n", GLFW.GLFW_KEY_N, "key.categories.antykostka");

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Register keybinds
        net.minecraftforge.fml.client.registry.ClientRegistry.registerKeyBinding(keybindJ);
        net.minecraftforge.fml.client.registry.ClientRegistry.registerKeyBinding(keybindN);

        // Register hotbar keybinds 1-9
        for (int i = 1; i <= 9; i++) {
            KeyBinding hotbarKeybind = new KeyBinding("key.hotbar." + i, GLFW.GLFW_KEY_1 + (i - 1), "key.categories.inventory");
            net.minecraftforge.fml.client.registry.ClientRegistry.registerKeyBinding(hotbarKeybind);
        }
    }
}