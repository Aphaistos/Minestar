package fr.aphaistos.minestar;

import fr.aphaistos.minestar.blocks.MinestarBlocks;
import fr.aphaistos.minestar.blocks.entity.MinestarBlockEntities;
import fr.aphaistos.minestar.container.MineStarContainers;
import fr.aphaistos.minestar.items.MinestarItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MinestarMod.MODID)
public class MinestarMod {
	public static final String MODID = "minestar";
	
	public MinestarMod() {
		var eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::setup);
		
		MinestarBlocks.BLOCKS.register(eventBus);
		MinestarBlockEntities.BLOCK_ENTITIES.register(eventBus);
		MinestarItems.regiterBlockItems();
		MinestarItems.ITEMS.register(eventBus);
		MineStarContainers.CONTAINERS.register(eventBus);
	}

	private void setup(final FMLCommonSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(MinestarBlocks.ROCKET_ASSEMBLER.get(), RenderType.cutoutMipped());
	}

}