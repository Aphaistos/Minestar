package fr.aphaistos.minestar.container;

import fr.aphaistos.minestar.MinestarMod;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MineStarContainers {
	private MineStarContainers() {}
	
	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MinestarMod.MODID);
	
	public static final RegistryObject<MenuType<RocketAssemblerContainer>> ROCKET_ASSEMBLER = CONTAINERS.register("rocket_assembler", 
			()-> new MenuType<>(RocketAssemblerContainer::new));
	
}