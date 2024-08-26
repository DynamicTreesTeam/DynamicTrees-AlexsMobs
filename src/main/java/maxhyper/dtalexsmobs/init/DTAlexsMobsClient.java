package maxhyper.dtalexsmobs.init;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public class DTAlexsMobsClient {

    public static void setup (){
        registerRenderLayers();
    }

    private static void registerRenderLayers() {
        ItemBlockRenderTypes.setRenderLayer(DTAlexsMobsRegistries.BANANA_SUCKER_BLOCK.get(), RenderType.cutout());
    }

}
