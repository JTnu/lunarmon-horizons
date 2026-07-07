package lunarmonhorizons.block.blocks.pedestals.basic;

import com.mojang.serialization.MapCodec;
import lunarmonhorizons.block.blocks.pedestals.AbstractPedestalBlock;

public class BasicPedestalBlock extends AbstractPedestalBlock {

    public static final MapCodec<BasicPedestalBlock> CODEC = simpleCodec(BasicPedestalBlock::new);

    public BasicPedestalBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<BasicPedestalBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean dropsInventoryOnBreak() {
        return true;
    }
}
