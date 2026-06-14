package net.noist.jeg.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;

/**
 * Хелпер для полублоков в JEG.
 * Предоставляет фикс для рендера.
 */
public class GlassSlabBlock extends SlabBlock {

    public GlassSlabBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentState, Direction side) {
        if (adjacentState.getBlock() instanceof GlassSlabBlock) {
            SlabType ownType = state.getValue(SlabBlock.TYPE);
            SlabType adjacentType = adjacentState.getValue(SlabBlock.TYPE);

            if (ownType == SlabType.DOUBLE || adjacentType == SlabType.DOUBLE) {
                return false;
            }
            return true;
        }
        return adjacentState.is(Blocks.GLASS) ||
                adjacentState.is(Blocks.GLASS_PANE) ||
                super.skipRendering(state, adjacentState, side);
    }
}
