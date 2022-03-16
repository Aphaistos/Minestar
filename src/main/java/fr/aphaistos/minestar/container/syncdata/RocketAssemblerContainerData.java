package fr.aphaistos.minestar.container.syncdata;

import fr.aphaistos.minestar.blocks.entity.RocketAssemblerBlockEntity;
import net.minecraft.world.inventory.SimpleContainerData;

public class RocketAssemblerContainerData extends SimpleContainerData {
	private final RocketAssemblerBlockEntity blockEntity;
	
	public RocketAssemblerContainerData(RocketAssemblerBlockEntity blockEntity, int amount) {
		super(amount);
		this.blockEntity = blockEntity;
	}
	
	@Override
	public int get(int key) {
		return switch(key) {
			case 0 -> this.blockEntity.getProgress();
			case 1 -> this.blockEntity.getEnergy();
			case 2 -> this.blockEntity.energyStorage.getMaxEnergyStored();
			default -> throw new IllegalArgumentException("Unable to get key: '" + key + "' for block entity: '"
				+ this.blockEntity + "' at pos: '" + this.blockEntity + this.blockEntity.getBlockPos() + "'");
		};
	}
	
	@Override
	public void set(int key, int value) {
		switch(key) {
			case 0 -> this.blockEntity.setProgress(value);
			case 1 -> this.blockEntity.energyStorage.setEnergy(value);
			default -> throw new IllegalArgumentException("Unable to get key: '" + key + "' for block entity: '"
			+ this.blockEntity + "' at pos: '" + this.blockEntity + this.blockEntity.getBlockPos() + "'");
		};
	}

}
