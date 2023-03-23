package jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.events;

import jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.BKSMM;
import jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.client.models.TokiniumSlimeEntityModel;
import jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod.client.renderer.TokiniumSlimeEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BKSMM.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(BKSMM.TOKINIUM_SLIME_ENTITY.get(), TokiniumSlimeEntityRenderer::new);
    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(TokiniumSlimeEntityModel.LAYER_LOCATION, TokiniumSlimeEntityModel::createBodyLayer);
    }
}
