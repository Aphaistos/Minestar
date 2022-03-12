package fr.aphaistos.minestar.blocks.entity;

import fr.aphaistos.minestar.MinestarMod;
import fr.aphaistos.minestar.blocks.MinestarBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MinestarBlockEntities {
	private MinestarBlockEntities() {}
	
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MinestarMod.MODID);
	
	public static final RegistryObject<BlockEntityType<NasaWorkbenchBlockEntity>> NASA_WORKBENCH = BLOCK_ENTITIES.register("nasa_workbench", 
			() -> BlockEntityType.Builder.of(NasaWorkbenchBlockEntity::new, MinestarBlocks.NASA_WORKBENCH.get()).build(null));
    public static final RegistryObject<BlockEntityType<EnergyGeneratorBlockEntity>> ENERGY_GENERATOR = BLOCK_ENTITIES.register("energy_generator", 
    		() -> BlockEntityType.Builder.of(EnergyGeneratorBlockEntity::new, MinestarBlocks.ENERGY_GENERATOR.get()).build(null));
}