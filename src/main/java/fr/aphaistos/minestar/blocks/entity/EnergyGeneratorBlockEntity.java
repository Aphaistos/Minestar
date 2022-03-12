package fr.aphaistos.minestar.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.energy.CapabilityEnergy;

public class EnergyGeneratorBlockEntity extends BlockEntity implements BlockEntityTicker<EnergyGeneratorBlockEntity> {

	public EnergyGeneratorBlockEntity(BlockPos pos, BlockState state) {
		super(MinestarBlockEntities.ENERGY_GENERATOR.get(), pos, state);
	}

	public void tick() {
		for (final var direction : Direction.values()) {
			final BlockEntity be = this.level.getBlockEntity(this.worldPosition.relative(direction));
			if (be == null) {
				continue;
			}

			be.getCapability(CapabilityEnergy.ENERGY, direction.getOpposite()).ifPresent(storage -> {
				if (be != this && storage.getEnergyStored() < storage.getMaxEnergyStored()) {
					storage.receiveEnergy(5, false);
				}
			});
		}
	}

	@Override
	public void tick(Level level, BlockPos pos, BlockState state, EnergyGeneratorBlockEntity be) {
		be.tick();
	}

}