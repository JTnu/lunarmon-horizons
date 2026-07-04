package lunarmonhorizons.block.entities.renderer;

import lunarmonhorizons.block.entities.pedestals.AbstractPedestalBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class PedestalBlockEntityRenderer implements BlockEntityRenderer<AbstractPedestalBlockEntity> {

    public PedestalBlockEntityRenderer(BlockEntityRendererProvider.Context context) { }

    @Override
    public void render(AbstractPedestalBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource buffer,
                       int packedLight, int packedOverlay) {

        ItemStack stack = entity.getItem();
        if (stack.isEmpty()) return;

        Level level = entity.getLevel();
        if (level == null) return;

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        float time = level.getGameTime() + partialTick;

        double bob = Math.sin(time / 8.0) * 0.08;

        float angle = time * 4.0F;

        poseStack.pushPose();

        poseStack.translate(0.5f, 1.20f + bob, 0.5f);

        poseStack.mulPose(Axis.XP.rotationDegrees(10.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(5.0F));

        poseStack.mulPose(Axis.YP.rotationDegrees(angle));

        poseStack.scale(0.45F, 0.45F, 0.45F);

        itemRenderer.renderStatic(
                stack,
                ItemDisplayContext.FIXED, // better than GROUND for displays
                getLight(level, entity.getBlockPos()),
                packedOverlay,
                poseStack,
                buffer,
                level,
                1
        );

        poseStack.popPose();
    }

    private int getLight(Level level, BlockPos pos) {
        int block = level.getBrightness(LightLayer.BLOCK, pos);
        int sky = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(block, sky);
    }
}