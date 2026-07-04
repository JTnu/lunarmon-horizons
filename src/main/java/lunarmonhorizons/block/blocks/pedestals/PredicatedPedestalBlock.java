package lunarmonhorizons.block.blocks.pedestals;

import net.minecraft.world.item.Item;

public abstract class PredicatedPedestalBlock extends AbstractPedestalBlock {

    protected final Item requiredItem;

    public PredicatedPedestalBlock(Properties properties, Item requiredItem) {
        super(properties);
        this.requiredItem = requiredItem;
    }

    public Item getRequiredItem(){
        return requiredItem;
    }

}
