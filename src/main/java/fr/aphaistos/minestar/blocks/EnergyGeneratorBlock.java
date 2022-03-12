package fr.aphaistos.minestar.blocks;

import fr.aphaistos.minestar.blocks.entity.EnergyGeneratorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyGeneratorBlock extends Block implements EntityBlock {

	public EnergyGeneratorBlock(Properties props) {
		super(props);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos ops, BlockState state) {
		return new EnergyGeneratorBlockEntity(ops, state);
	}
	
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
        BlockEntityType<T> type) {
        return level.isClientSide ? null
            : (level0, pos, state0, blockEntity) -> ((EnergyGeneratorBlockEntity) blockEntity).tick();
    }

}
