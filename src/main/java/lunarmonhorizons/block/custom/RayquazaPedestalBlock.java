package lunarmonhorizons.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class RayquazaPedestalBlock extends PedestalBlock {

    public static final MapCodec<RayquazaPedestalBlock> CODEC =
            simpleCodec(RayquazaPedestalBlock::new);

    public RayquazaPedestalBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends PedestalBlock> codec() {
        return CODEC;
    }

    @Override
    protected Component getTooltip() {
        return Component.translatable(
                "tooltip.lunarmon-horizons.rayquaza_pedestal"
        );
    }
}