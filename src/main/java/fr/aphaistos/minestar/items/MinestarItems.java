package fr.aphaistos.minestar.items;

import fr.aphaistos.minestar.MinestarMod;
import fr.aphaistos.minestar.blocks.MinestarBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MinestarItems {
	private MinestarItems() {}
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinestarMod.MODID);
	
	public static final RegistryObject<Item> EEEEEE = ITEMS.register("eeeeee", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).fireResistant().stacksTo(911)));
	
	public static final void regiterBlockItems() {
		for (var object : MinestarBlocks.BLOCKS.getEntries()) {
			ITEMS.register(object.getId().getPath(), () -> new BlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
		}
	}
	
}