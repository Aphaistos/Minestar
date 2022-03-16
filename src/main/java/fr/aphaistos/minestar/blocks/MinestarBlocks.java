package fr.aphaistos.minestar.blocks;

import fr.aphaistos.minestar.MinestarMod;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MinestarBlocks {
	private MinestarBlocks() {}
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MinestarMod.MODID);
	
	public static final RegistryObject<Block> ROCKET_ASSEMBLER = BLOCKS.register("rocket_assembler",
			() -> new RocketAssemblerBlock(BlockBehaviour.Properties.of(Material.STONE, DyeColor.BLACK).requiresCorrectToolForDrops().noOcclusion().strength(1.8F)));
    public static final RegistryObject<EnergyGeneratorBlock> ENERGY_GENERATOR = BLOCKS.register("energy_generator",
            () -> new EnergyGeneratorBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
}