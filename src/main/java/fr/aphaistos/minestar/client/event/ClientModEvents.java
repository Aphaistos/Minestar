package fr.aphaistos.minestar.client.event;

import fr.aphaistos.minestar.MinestarMod;
import fr.aphaistos.minestar.client.screen.NasaWorkbenchScreen;
import fr.aphaistos.minestar.container.MineStarContainers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MinestarMod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
	private ClientModEvents() {}
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		MenuScreens.register(MineStarContainers.NASA_WORKBENCH.get(), NasaWorkbenchScreen::new);
	}	
}
