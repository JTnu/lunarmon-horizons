package lunarmonhorizons.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class RayquazaPedestalBlock extends PedestalBlock {

    public static final MapCodec<RayquazaPedestalBlock> CODEC =
            simpleCodec(RayquazaPedestalBlock::new);

    public RayquazaPedestalBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends PedestalBlock> codec() {
        return CODEC;
    }

    @Override
    protected Component getTooltip() {
        return Component.translatable(
                "tooltip.lunarmon-horizons.rayquaza_pedestal"
        );
    }
}