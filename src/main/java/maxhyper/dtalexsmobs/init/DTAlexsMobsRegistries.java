package maxhyper.dtalexsmobs.init;

import com.ferreusveritas.dynamictrees.api.registry.TypeRegistryEvent;
import com.ferreusveritas.dynamictrees.systems.fruit.Fruit;
import com.ferreusveritas.dynamictrees.systems.genfeature.GenFeature;
import com.ferreusveritas.dynamictrees.util.CommonVoxelShapes;
import maxhyper.dtalexsmobs.DynamicTreesAlexsMobs;
import maxhyper.dtalexsmobs.blocks.BananaSuckerBlock;
import maxhyper.dtalexsmobs.blocks.OffsetFruit;
import maxhyper.dtalexsmobs.genfeatures.DTAlexsMobsGenFeatures;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DTAlexsMobsRegistries {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DynamicTreesAlexsMobs.MOD_ID);

    public static final RegistryObject<Block> BANANA_SUCKER_BLOCK = BLOCKS.register("banana_sucker", BananaSuckerBlock::new);

    public static final VoxelShape BANANA_SAPLING_SHAPE = Shapes.box(
            0.375f, 0.0f, 0.375f,
            0.625f, 0.9375f, 0.625f);

    public static void setup() {
        CommonVoxelShapes.SHAPES.put(DynamicTreesAlexsMobs.location("banana_sapling").toString(), BANANA_SAPLING_SHAPE);
    }

    @SubscribeEvent
    public static void registerFruitType(final TypeRegistryEvent<Fruit> event) {
        event.registerType(DynamicTreesAlexsMobs.location("offset_down"), OffsetFruit.TYPE);
    }
    @SubscribeEvent
    public static void onGenFeatureRegistry (final com.ferreusveritas.dynamictrees.api.registry.RegistryEvent<GenFeature> event) {
        DTAlexsMobsGenFeatures.register(event.getRegistry());
    }

}
