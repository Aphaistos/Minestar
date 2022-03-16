package fr.aphaistos.minestar.blocks.entity;

import fr.aphaistos.minestar.MinestarMod;
import fr.aphaistos.minestar.blocks.entity.util.RFEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;

public class RocketAssemblerBlockEntity extends InventoryBlockEntity implements BlockEntityTicker<RocketAssemblerBlockEntity> {
	public static final Component TITLE = new TranslatableComponent(
	        "container." + MinestarMod.MODID + ".nasa_workbench");
	protected static final int INVENTORY_SIZE = 14;
	public final RFEnergyStorage energyStorage;
	
	private int capacity = 5000, maxReceived = 100000;
    private int progress;
	private LazyOptional<RFEnergyStorage> energy;
	
	public RocketAssemblerBlockEntity(BlockPos pos, BlockState state) {
		super(MinestarBlockEntities.ROCKET_ASSEMBLER.get(), pos, state, INVENTORY_SIZE);
		this.energyStorage = createEnergyStorage();
		this.energy = LazyOptional.of(() -> this.energyStorage);
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return cap == CapabilityEnergy.ENERGY ? this.energy.cast() : super.getCapability(cap, side);
	}
	
	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		this.energy.invalidate();
	}
	
	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		this.progress = tag.getInt("Progress");
		this.energyStorage.setEnergy(tag.getInt("Energy"));
	}
	
	public int getEnergy() {
		return this.energyStorage.getEnergyStored();
	}
	
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
    public int getProgress() {
        return this.progress;
    }
	
	@Override
	public void tick() {
//		if(this.getEnergy() >= 1) {
//			if(this.progress >= 10) {
//				if(getEnergy() >= 25) {
//					this.energyStorage.setEnergy(this.energyStorage.getEnergyStored() - 25);
//					setProgress(0);
//				}
//			} else {	
//				this.progress++;
//			}
////			System.out.println(getEnergy() + "/" + this.energyStorage.getMaxEnergyStored());
//		}
		
		super.tick();
	}
	
	@Override
	public void tick(Level level, BlockPos pos, BlockState state, RocketAssemblerBlockEntity blockEntity) {
		blockEntity.tick();
	}
	
	@Override
	public void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		tag.putInt("Progress", this.progress);
		tag.putInt("Energy", this.energyStorage.getEnergyStored());
	}
	
	private RFEnergyStorage createEnergyStorage() {
		return new RFEnergyStorage(this, this.capacity, this.maxReceived, 0, 0);
	}

}