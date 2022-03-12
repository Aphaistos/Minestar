package fr.aphaistos.minestar.container;

import fr.aphaistos.minestar.blocks.MinestarBlocks;
import fr.aphaistos.minestar.blocks.entity.NasaWorkbenchBlockEntity;
import fr.aphaistos.minestar.container.syncdata.NasaWorkbenchContainerData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class NasaWorkbenchContainer extends AbstractContainerMenu {

	private static NasaWorkbenchBlockEntity blockEntity;
	private final ContainerLevelAccess containerAccess;
	public final ContainerData data;

	// Client Constructor
	public NasaWorkbenchContainer(int id, Inventory playerInventory) {
		this(id, playerInventory, new ItemStackHandler(14), BlockPos.ZERO, new SimpleContainerData(3));
	}

	// Server Constructor
	public NasaWorkbenchContainer(int id, Inventory playerInventory, IItemHandler slots, BlockPos pos, ContainerData data) {
		super(MineStarContainers.NASA_WORKBENCH.get(), id);
		this.containerAccess = ContainerLevelAccess.create(playerInventory.player.level, pos);
		this.data = data;
		final int slotSize = 18, startX = 8, startY = 142, hotbarY = 200;
		
		addSlot(new SlotItemHandler(slots, 0, 55, 17));
		for (int row = 0; row < 3; row++) {
			for(int column = 0; column < 2; column++) {
				addSlot(new SlotItemHandler(slots, 1 + (column + row), 46 + column * slotSize, 35 + row * slotSize));
			}
		}
		addSlot(new SlotItemHandler(slots, 8, 35, 89));
		addSlot(new SlotItemHandler(slots, 9, 35, 107));
		addSlot(new SlotItemHandler(slots, 10, 75, 89));
		addSlot(new SlotItemHandler(slots, 11, 75, 107));
		addSlot(new SlotItemHandler(slots, 12, 55, 107));
		
		addSlot(new SlotItemHandler(slots, 13, 124, 53));

		// Player Inventory
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				addSlot(new Slot(playerInventory, 9 + row * 9 + column, startX + column * slotSize,
						startY + row * slotSize));
			}
			
		}
		
		for (int column = 0; column < 9; column++) {
			addSlot(new Slot(playerInventory, column, startX + column * slotSize, hotbarY));
		}
		
		addDataSlots(data);
	}

	@Override
	public boolean stillValid(Player player) {
		return stillValid(containerAccess, player, MinestarBlocks.NASA_WORKBENCH.get());
	}

	public static MenuConstructor getServerContainer(NasaWorkbenchBlockEntity nasaWorkbench, BlockPos pos) {
		return (id, playerInv, player) -> new NasaWorkbenchContainer(id, playerInv, nasaWorkbench.inventory, pos, new NasaWorkbenchContainerData(nasaWorkbench, 3));
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		var retStack = ItemStack.EMPTY;
		final Slot slot = getSlot(index);
		if (slot.hasItem()) {
			final ItemStack stack = slot.getItem();
			retStack = stack.copy();

			if (index < 14) {
				if (!moveItemStackTo(stack, 14, this.slots.size(), true))
					return ItemStack.EMPTY;
			} else if (!moveItemStackTo(stack, 0, 14, false))
				return ItemStack.EMPTY;

			if (stack.isEmpty()) slot.set(ItemStack.EMPTY);
			else slot.setChanged();

			/*if (stack.getCount() == retStack.getCount())
				return ItemStack.EMPTY;

			slot.onTake(player, stack);*/
		}

		return retStack;
	}
	
	public int getEnergy() {
		return this.data.get(1);
	}
	
	public int getMaxEnergy() {
		return this.data.get(2);
	}

}