package lunarmonhorizons;

import lunarmonhorizons.block.entity.ModBlockEntities;
import lunarmonhorizons.block.entity.renderer.PedestalBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class LunarMonHorizonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockEntityRenderers.register(
                ModBlockEntities.PEDESTAL_BE,
                PedestalBlockEntityRenderer::new
        );

        BlockEntityRenderers.register(
                ModBlockEntities.SPAWNING_PEDESTAL_BE,
                PedestalBlockEntityRenderer::new
        );

    }
}
