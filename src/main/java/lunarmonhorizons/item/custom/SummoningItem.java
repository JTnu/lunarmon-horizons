package lunarmonhorizons.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SummoningItem extends Item {

    public final Component info;

    public SummoningItem(Properties properties, Component info) {
        super(properties);
        this.info = info;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            list.add(info);
        } else {
            list.add(Component.translatable(
                    "tooltip.lunarmonhorizons.hold_shift"
            ));
        }
    }

}
