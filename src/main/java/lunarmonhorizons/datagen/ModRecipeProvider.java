package lunarmonhorizons.datagen;

import lunarmonhorizons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PRISON_BOTTLE)
                .define('F', ModItems.PRISON_BOTTLE_FRAGMENT)
                .define('E', Items.ENDER_EYE)
                .pattern("FFF")
                .pattern("FEF")
                .pattern("FFF")
                .unlockedBy("has_fragment",
                        has(ModItems.PRISON_BOTTLE_FRAGMENT))
                .save(exporter);
    }
}
